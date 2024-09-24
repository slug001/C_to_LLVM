grammar myChecker;

@header {
    // import packages here.
    import java.util.HashMap;
}

@members {
    boolean TRACEON = false;
    HashMap<String,TypeInfo> symtab = new HashMap<String,TypeInfo>();

    public enum TypeInfo {
        Integer,
		Float,
		Char,
		Double,
		Short,
		Boolean,
		String,
		Void,
		Unknown,
		No_Exist,
		Error
    }
      
}

//程式的入口點，定義了程式的主要結構
program:include_lib* type MAIN '(' ')' '{' statements '}'               
        {if (TRACEON) System.out.println("program:include_lib* type MAIN ( ) { statements } ");};
//include
include_lib:HASH INCLUDE '<'lIBRARY'>' 
            {if (TRACEON) System.out.println("include_lib:HASH INCLUDE <LIBRARY>");};


// 定義了變量的數據類型
type returns [TypeInfo typeInfo]
	:INT { if (TRACEON) System.out.println("type: INT")		; typeInfo= TypeInfo.Integer;}
   | FLOAT {if (TRACEON) System.out.println("type: FLOAT")	; typeInfo= TypeInfo.Float;}
   | CHAR {if (TRACEON) System.out.println("type: CHAR")	; typeInfo= TypeInfo.Char;}
   | DOUBLE {if (TRACEON) System.out.println("type: DOUBLE"); typeInfo= TypeInfo.Double;}
   | VOID {if (TRACEON) System.out.println("type: VOID")	; typeInfo= TypeInfo.Void;};

//定義了語句的組合，可以是一系列語句的序列。
statements:statement statements  { if (TRACEON) System.out.println("statements:statement statements"); }
        |                       { if (TRACEON) System.out.println("statements:"); };

//定義了算術表達式的語法，包括加法和減法操作。
arith_expression returns [TypeInfo typeInfo]
	:a = multExpr {$typeInfo = $a.typeInfo;}
	( '+' b= multExpr
	{
		if($a.typeInfo!=$b.typeInfo){
			System.out.println("Error! "+$a.start.getLine()+
			": Type mismatch for the operator '+'in an expression.");
			$typeInfo = TypeInfo.Error;
		}
	}
	| '-' c= multExpr
	{
		if($a.typeInfo!=$c.typeInfo){
			System.out.println("Error! "+$a.start.getLine()+
			": Type mismatch for the operator '-' in an expression.");
			$typeInfo = TypeInfo.Error;
		}
	}
	)*  
	{ if (TRACEON) System.out.println("arith_expression: multExpr( + multExpr| - multExpr)*"); };

//定義了乘法表達式的語法，包括乘法和除法操作。
multExpr returns [TypeInfo typeInfo]
	: a= signExpr {$typeInfo = $a.typeInfo; }
	( '*' b= signExpr
	{
		if($a.typeInfo!= $b.typeInfo){
			System.out.println("Error! "+$a.start.getLine()+
			": Type mismatch for the operator '*' in an expression.");
			$typeInfo = TypeInfo.Error;
		 }
	}
	| '/' c= signExpr
	{
		if($a.typeInfo!= $c.typeInfo){
			System.out.println("Error! "+$a.start.getLine()+
			": Type mismatch for the operator '/' in an expression.");
			$typeInfo = TypeInfo.Error;
		 }
	}
	)* 
    { if (TRACEON) System.out.println("signExpr( * signExpr| / signExpr)* "); };

//基本表達式或一個負號加上一個基本表達式
signExpr returns [TypeInfo typeInfo]
	: 		a=double_add_sub {$typeInfo = $a.typeInfo; }
	| '-' 	b=double_add_sub {$typeInfo = $b.typeInfo; }
        { if (TRACEON) System.out.println("signExpr: double_add_sub| - double_add_sub "); };

//double add sub  只有後綴可以
double_add_sub returns [TypeInfo typeInfo]
	: a= primaryExpr
	{$typeInfo = $a.typeInfo;}
	('--'
	{
		if($typeInfo != TypeInfo.Integer){
			System.out.println("Error! "+$double_add_sub.start.getLine()+": -- need Integer type primaryExpr.");
			$typeInfo=TypeInfo.Error;
		}
	}
	|'++'
	{
		if($typeInfo != TypeInfo.Integer){
			System.out.println("Error! "+$double_add_sub.start.getLine()+": ++ need Integer type primaryExpr.");
			$typeInfo=TypeInfo.Error;
		}
	}
	)?  
	{ if (TRACEON) System.out.println("double_add_sub : primaryExpr('--'|'++')? "); };  

//可以是整數常量（Integer_constant）、浮點數常量（Floating_point_constant）、
//      標識符（Identifier）、或者括號中的算術表達式。
primaryExpr returns [TypeInfo typeInfo]
	: Integer_constant                   { $typeInfo = TypeInfo.Integer 			; if (TRACEON) System.out.println("primaryExpr: Integer_constant"); }
    | Floating_point_constant            { $typeInfo = TypeInfo.Float 				; if (TRACEON) System.out.println("primaryExpr: Floating_point_constant"); }
    | Identifier                         
	{
		if(symtab.containsKey($Identifier.text)){	//確認是否存在
			$typeInfo = symtab.get($Identifier.text);
			if($typeInfo!=TypeInfo.Integer && $typeInfo!=TypeInfo.Float){		//確認格式是不是int float
				System.out.println("Error! "+$primaryExpr.start.getLine()+": ID not Int or Float.");
				$typeInfo =TypeInfo.Error;
			}
		}else{
			System.out.println("Error! "+ $primaryExpr.start.getLine()+": Undeclared identifier.");
		}
		; if (TRACEON) System.out.println("primaryExpr: Identifier"); 
	}
	| '(' arith_expression ')'           { $typeInfo = $arith_expression.typeInfo 	;if (TRACEON) System.out.println("primaryExpr: (arith_expression )"); }
    ;
//比較運算
compare_expression returns [TypeInfo typeInfo]
	:  a=Identifier relate_op 
	{ //先確認是否有定義過了
		$typeInfo=TypeInfo.Boolean;	//初始化
		if(! symtab.containsKey($a.text)){
			System.out.println("Error! "+$compare_expression.start.getLine()+": Undeclared identifier.");
			$typeInfo=TypeInfo.Error;
		}
	}
	//接著對資料型態做比較
	( b=Identifier 
	{	//確認ID定義過
		if(! symtab.containsKey($b.text)){
			System.out.println("Error! "+$compare_expression.start.getLine()+": Undeclared identifier.");
			$typeInfo=TypeInfo.Error;
		}
		//ID type check
		if(symtab.get($a.text) != symtab.get($b.text)){
			System.out.println("Error! "+$compare_expression.start.getLine()
			+": Type mismatch for the two silde in compare_expression.");
			$typeInfo=TypeInfo.Error;
		}
	}
	| c=Integer_constant 
	{
		if(symtab.get($a.text) != TypeInfo.Integer){
			System.out.println("Error! "+$compare_expression.start.getLine()
			+": Type mismatch for the two silde in compare_expression.");
			$typeInfo=TypeInfo.Error;
		}
	}
	| d=Floating_point_constant
	{
		if(symtab.get($a.text) != TypeInfo.Float){
			System.out.println("Error! "+$compare_expression.start.getLine()
			+": Type mismatch for the two silde in compare_expression.");
			$typeInfo=TypeInfo.Error;
		}
	}
	)
    { if (TRACEON) System.out.println("compare_expression: Identifier relate_op ( Identifier | Integer_constant | Floating_point_constant) "); };

//定義了語句的形式，可以是賦值語句或者if語句
statement: flow                 { if (TRACEON) System.out.println("statement: flow "); }
         | assign ';'           { if (TRACEON) System.out.println("statement: assign ;  "); }
         | func_call ';'        { if (TRACEON) System.out.println("statement: func_call ; "); };

//assign
assign returns [TypeInfo typeInfo]
	:(INT {$typeInfo=TypeInfo.Integer;}|FLOAT {$typeInfo=TypeInfo.Float;}|DOUBLE {$typeInfo=TypeInfo.Double;}|SHORT {$typeInfo=TypeInfo.Short;}) 
	Identifier //先檢查ID有沒有用過
	{ 
		if(symtab.containsKey($Identifier.text)){
			System.out.println("Error! "+ $assign.start.getLine() +": Redeclared identifier.");
			$typeInfo= TypeInfo.Error;
		}
	}
	('=' a= arith_expression	//再檢查assign的值和type是否相等
	{
		if( !symtab.containsKey($Identifier.text)){	//沒有被重複定義再來考慮兩邊的type
			if($typeInfo != $a.typeInfo){
				System.out.println("Error! "+ $assign.start.getLine() + ": Type mismatch in assign .");
				$typeInfo= TypeInfo.Error;
			}
		}	
	}
	)?    
	{ //如果沒有用過+兩邊type正常的話加入symtab
		if($typeInfo != TypeInfo.Error){
			symtab.put($Identifier.text, $typeInfo);
		} 
		if (TRACEON) System.out.println("assign:(INT|FLOAT|DOUBLE|SHORT) Identifier (= arith_expression)?"); 
	}
    | Identifier assign_op b=arith_expression  //= += -= *= /=  一樣確認兩邊資料型態是否相等                  
	{ 
		if(symtab.containsKey($Identifier.text)){	//檢查ID是否存在 有的話設定回傳的typeInfo
			$typeInfo = symtab.get($Identifier.text);
			//接著檢查此時assign兩邊的資料型態是否相等
			if($typeInfo!= $b.typeInfo){
				System.out.println("Error! "+ $assign.start.getLine() + 
				": Type mismatch for the two silde in an assignment statement.");
				$typeInfo=TypeInfo.Error;
			}
		}else{		//不存在的話 Error
			System.out.println("Error! "+$assign.start.getLine()+": Undeclared identifier.");
			$typeInfo= TypeInfo.Error;
		}
		if (TRACEON) System.out.println("assign: Identifier assign_op arith_expression"); 
	}
    | CHAR d = char_or_string 
	{
		$typeInfo=$d.typeInfo;
		if (TRACEON) System.out.println("assign:CHAR char_or_string"); 
	} ;

//因為不能被定義兩次所以要注意先檢查symtab
char_or_string returns[TypeInfo typeInfo]
	: Identifier'['( a = arith_expression)?']' '='
	{	//確認ID是否使用過 + arith_expression是不是整數型態
		$typeInfo=TypeInfo.String; 		//先預設為String
		if(symtab.containsKey($Identifier.text)){
			System.out.println("Error! "+ $char_or_string.start.getLine()+": Redeclared identifier.");
			$typeInfo = TypeInfo.Error;
		}
		if($a.typeInfo != TypeInfo.Integer){
			System.out.println("Error! " +$char_or_string.start.getLine()+": String length is not Integer.");
			$typeInfo=TypeInfo.Error;
		}
	} 
	(String_s
	{
		if($typeInfo!=TypeInfo.Error){
			symtab.put($Identifier.text, $typeInfo);
		}
	}
	|(Charliteral|Integer_constant|Floating_point_constant)//型態錯誤
	{
		System.out.println("Error! "+ $char_or_string.start.getLine()+ ": Type mismatch for the two silde in string assign.");
		$typeInfo=TypeInfo.String;
	}
	)        
	{ if (TRACEON) System.out.println("char_or_string: Identifier[(arith_expression)?] = String_s "); }
    | Identifier '=' 
	(Charliteral 
	{
		if(symtab.containsKey($Identifier.text)){	//檢查是否使用過
			System.out.println("Error! "+ $char_or_string.start.getLine()+": Redeclared identifier.");
			$typeInfo = TypeInfo.Error;
		}else{		//加入table
			$typeInfo = TypeInfo.Char;
			symtab.put($Identifier.text, $typeInfo);
		}
	}
	| (String_s|Integer_constant|Floating_point_constant) //型態錯誤
	{
		System.out.println("Error! "+$char_or_string.start.getLine()+": Type mismatch for the two silde in char assign.");
		$typeInfo=TypeInfo.Error;
	}
	)   
	{ if (TRACEON) System.out.println("char_or_string: Identifier '=' Charliteral "); };

//flow
flow returns [TypeInfo typeInfo]
	: IF'(' ((arith_expression|String_s|Charliteral) 
	{	//輸入的型態錯誤的話 type Error
		System.out.println("Error! "+$flow.start.getLine()+": if condition section type error.");
		$typeInfo=TypeInfo.Error;
	} 
	| d = compare_expression
	{	//輸入type正確 type Void
		if($d.typeInfo != TypeInfo.Error){
			$typeInfo=TypeInfo.Void;
		}else{
			System.out.println("Error! "+$flow.start.getLine()+": if condition section compare error.");
			$typeInfo=TypeInfo.Error;
		}
	}
	) ')'
	e = if_then_statements                  
	{ //如果在之後的else if出問題 typeInfo也要改成Error
		$typeInfo= $e.typeInfo;
		if (TRACEON) System.out.println("flow: IF( (arith_expression | compare_expression) ) if_then_statements  "); 
	}
    |WHILE'(' ((arith_expression|String_s|Charliteral) 
	{	//輸入的型態錯誤的話 type Error, 正確 type Void
		System.out.println("Error! "+$flow.start.getLine()+": while condition section type error.");
		$typeInfo=TypeInfo.Error;
	}
	| f = compare_expression
	{
		if($f.typeInfo != TypeInfo.Error){
			$typeInfo=TypeInfo.Void;
		}else{
			System.out.println("Error! "+$flow.start.getLine()+": while condition section compare error.");
			$typeInfo=TypeInfo.Error;
		}
	}
	)')' while_statement                    
	{ if (TRACEON) System.out.println("flow: WHILE( (arith_expression | compare_expression)) while_statement"); }
    |FOR'(' h = assign ';'
	{
		$typeInfo=TypeInfo.Void;  //先初始化
		if($h.typeInfo == TypeInfo.Error){ 		// assign錯誤
			System.out.println("Error! "+$flow.start.getLine()+": for init section error.");
			$typeInfo = TypeInfo.Error;
		}
	} 
	((arith_expression|String_s|Charliteral)
	{	//輸入的型態錯誤的話 type Error, 正確 type Void
		System.out.println("Error! "+$flow.start.getLine()+": for loop condition section type error.");
		$typeInfo=TypeInfo.Error;
	}
	| g = compare_expression
	{	//compare_expression錯誤
		if($g.typeInfo == TypeInfo.Error){
			System.out.println("Error! "+$flow.start.getLine()+": for loop condition section compare error.");
			$typeInfo=TypeInfo.Error;
		}
	}
	)
	';' i = arith_expression ')' 
	{
		if($i.typeInfo == TypeInfo.Error){		//arith_expression 錯誤
			System.out.println("Error! "+$flow.start.getLine()+": for loop increase section error.");
			$typeInfo = TypeInfo.Error;
		}
	}
	'{' statements '}'       
	{ if (TRACEON) System.out.println("flow: FOR( assign ; compare_expression ; arith_expression ) { statements }"); }
    |(BREAK|CONTINUE) ';'                                                                   
	{ if (TRACEON) System.out.println("flow: (BREAK|CONTINUE) ; "); };

//定義了if語句的結構，可以是單個語句或者一系列語句的區塊
if_then_statements returns[TypeInfo typeInfo]
	: statement                           
	{ 
		$typeInfo = TypeInfo.Void;
		if (TRACEON) System.out.println("if_then_statement : statement "); 
	}
    | '{' statements '}' a = only_if_or_else     
	{ 
		$typeInfo = $a.typeInfo;
		if (TRACEON) System.out.println("if_then_statement : { statements } only_if_or_else"); 
	};

//only if or if _else
only_if_or_else returns[TypeInfo typeInfo]
	:ELSE  a = middle_else        
	{ 
		$typeInfo = $a.typeInfo;
		if (TRACEON) System.out.println("only_if_or_else :ELSE middle_else"); 
	}
    |
	{ 
		$typeInfo = TypeInfo.Void;
		if (TRACEON) System.out.println("only_if_or_else :"); 
	};

//分辨 else OR else if
middle_else returns[TypeInfo typeInfo]
	: IF'('  ((arith_expression|String_s|Charliteral) 
	{	//輸入的型態錯誤的話 type Error, 正確 type Void
		System.out.println("Error! "+$middle_else.start.getLine()+": else if condition section type error.");
		$typeInfo=TypeInfo.Error;
	} 
	| d= compare_expression
	{
		if($d.typeInfo != TypeInfo.Error){
			$typeInfo=TypeInfo.Void;
		}else{
			System.out.println("Error! "+$middle_else.start.getLine()+": middle else condition section compare error.");
			$typeInfo=TypeInfo.Error;
		}
	}
	)')' if_then_statements       
	{ if (TRACEON) System.out.println("middle_else: IF'('  (arith_expression | compare_expression)')' if_then_statements"); }
    | last_else_statements
	{
		$typeInfo=TypeInfo.Void;
	}                                                          
	{ if (TRACEON) System.out.println("middle_else: last_else_statements "); } ;
//FINAL_ELSE
last_else_statements: '{' statements'}' { if (TRACEON) System.out.println("last_else_statements: { statements}"); };

//While_statement
while_statement:statement  { if (TRACEON) System.out.println("while_statement: statement"); }
        |'{' statements '}'{ if (TRACEON) System.out.println("while_statement: {statements}"); };



//data_read_write
func_call: PRINTF'(' '"' print_ ')'           { if (TRACEON) System.out.println("PRINTF( '\"' (print_get_var)* )   "); }
        | SCANF '(' '"'  (scanf_)* ')'           { if (TRACEON) System.out.println("SCANF ( '\"' (scanf_get_var)* )   "); }
        | RETURN (arith_expression|String_s|Charliteral){ if (TRACEON) System.out.println("RETURN (arith_expression|String_s|Charliteral)"); };

//print 1 var
print_ returns [TypeInfo typeInfo]
	:
	'%'a=('d'|'f'|'c'|'s') '%'b=('d'|'f'|'c'|'s')'"' ',' c=Identifier','d=Identifier 
	{
		$typeInfo = TypeInfo.Void;  //初始化
		if(!symtab.containsKey($c.text)){//先確認 C,D 是否已經定義過
			System.out.println("Error! "+$print_.start.getLine()+": printf first var undeclared identifier.");
			$typeInfo = TypeInfo.Error;
		}
		if(!symtab.containsKey($d.text)){
			System.out.println("Error! "+$print_.start.getLine()+": printf second var undeclared identifier.");
			$typeInfo = TypeInfo.Error;
		}
		switch($a.getText()){	//檢查id type 是否正確
			case "d":
				if(symtab.get($c.text) != TypeInfo.Integer){
					$typeInfo = TypeInfo.Error;
					System.out.println("Error! "+$print_.start.getLine()+": first var type is wrong, need integer.");
				}
				break;  
		 	case "f":
				if(symtab.get($c.text) != TypeInfo.Float){
					$typeInfo = TypeInfo.Error;
					System.out.println("Error! "+$print_.start.getLine()+": first var type is wrong, need float.");
				}
				break; 
			case "c":
				if(symtab.get($c.text) != TypeInfo.Char){
					$typeInfo = TypeInfo.Error;
					System.out.println("Error! "+$print_.start.getLine()+": first var type is wrong, need char.");
				}
				break;
			case "s":
				if(symtab.get($c.text) != TypeInfo.String){
					$typeInfo = TypeInfo.Error;
					System.out.println("Error! "+$print_.start.getLine()+": first var type is wrong, need string.");
				}
				break;
		}
		switch($b.getText()){	//檢查id type 是否正確
			case "d":
				if(symtab.get($d.text) != TypeInfo.Integer){
					$typeInfo = TypeInfo.Error;
					System.out.println("Error! "+$print_.start.getLine()+": second var type is wrong, need integer.");
				}
				break;  
		 	case "f":
				if(symtab.get($d.text) != TypeInfo.Float){
					$typeInfo = TypeInfo.Error;
					System.out.println("Error! "+$print_.start.getLine()+": second var type is wrong, need float.");
				}
				break; 
			case "c":
				if(symtab.get($d.text) != TypeInfo.Char){
					$typeInfo = TypeInfo.Error;
					System.out.println("Error! "+$print_.start.getLine()+": second var type is wrong, need char.");
				}
				break;
			case "s":
				if(symtab.get($d.text) != TypeInfo.String){
					$typeInfo = TypeInfo.Error;
					System.out.println("Error! "+$print_.start.getLine()+": second var type is wrong, need string.");
				}
				break;
		}
	}
	|'%'e=('d'|'f'|'c'|'s')'"' ',' f=Identifier
	{
		$typeInfo = TypeInfo.Void;  //初始化
		if(!symtab.containsKey($f.text)){//先確認 f 是否已經定義過
			System.out.println("Error! "+$print_.start.getLine()+": printf first var undeclared identifier.");
			$typeInfo = TypeInfo.Error;
		}
		switch($e.getText()){	//檢查id type 是否正確
			case "d":
				if(symtab.get($f.text) != TypeInfo.Integer){
					$typeInfo = TypeInfo.Error;
					System.out.println("Error! "+$print_.start.getLine()+": first var type is wrong, need integer.");
				}
				break;  
		 	case "f":
				if(symtab.get($f.text) != TypeInfo.Float){
					$typeInfo = TypeInfo.Error;
					System.out.println("Error! "+$print_.start.getLine()+": first var type is wrong, need float.");
				}
				break; 
			case "c":
				if(symtab.get($f.text) != TypeInfo.Char){
					$typeInfo = TypeInfo.Error;
					System.out.println("Error! "+$print_.start.getLine()+": first var type is wrong, need char.");
				}
				break;
			case "s":
				if(symtab.get($f.text) != TypeInfo.String){
					$typeInfo = TypeInfo.Error;
					System.out.println("Error! "+$print_.start.getLine()+": first var type is wrong, need string.");
				}
				break;
		}
	}
	;

scanf_ returns[TypeInfo typeInfo] 
	:
	'%'a=('d'|'f'|'c'|'s') '%'b=('d'|'f'|'c'|'s')'"' ',''&' c=Identifier',' '&' d=Identifier
	{
		$typeInfo = TypeInfo.Void;  //初始化
		if(!symtab.containsKey($c.text)){//先確認 C,D 是否已經定義過
			System.out.println("Error! "+$scanf_.start.getLine()+": printf first var undeclared identifier.");
			$typeInfo = TypeInfo.Error;
		}
		if(!symtab.containsKey($d.text)){
			System.out.println("Error! "+$scanf_.start.getLine()+": printf second var undeclared identifier.");
			$typeInfo = TypeInfo.Error;
		}
		switch($a.getText()){	//檢查id type 是否正確
			case "d":
				if(symtab.get($c.text) != TypeInfo.Integer){
					$typeInfo = TypeInfo.Error;
					System.out.println("Error! "+$scanf_.start.getLine()+": first var type is wrong, need integer.");
				}
				break;  
		 	case "f":
				if(symtab.get($c.text) != TypeInfo.Float){
					$typeInfo = TypeInfo.Error;
					System.out.println("Error! "+$scanf_.start.getLine()+": first var type is wrong, need float.");
				}
				break; 
			case "c":
				if(symtab.get($c.text) != TypeInfo.Char){
					$typeInfo = TypeInfo.Error;
					System.out.println("Error! "+$scanf_.start.getLine()+": first var type is wrong, need char.");
				}
				break;
			case "s":
				if(symtab.get($c.text) != TypeInfo.String){
					$typeInfo = TypeInfo.Error;
					System.out.println("Error! "+$scanf_.start.getLine()+": first var type is wrong, need string.");
				}
				break;
		}
		switch($b.getText()){	//檢查id type 是否正確
			case "d":
				if(symtab.get($d.text) != TypeInfo.Integer){
					$typeInfo = TypeInfo.Error;
					System.out.println("Error! "+$scanf_.start.getLine()+": second var type is wrong, need integer.");
				}
				break;  
		 	case "f":
				if(symtab.get($d.text) != TypeInfo.Float){
					$typeInfo = TypeInfo.Error;
					System.out.println("Error! "+$scanf_.start.getLine()+": second var type is wrong, need float.");
				}
				break; 
			case "c":
				if(symtab.get($d.text) != TypeInfo.Char){
					$typeInfo = TypeInfo.Error;
					System.out.println("Error! "+$scanf_.start.getLine()+": second var type is wrong, need char.");
				}
				break;
			case "s":
				if(symtab.get($d.text) != TypeInfo.String){
					$typeInfo = TypeInfo.Error;
					System.out.println("Error! "+$scanf_.start.getLine()+": second var type is wrong, need string.");
				}
				break;
		}
	}
	|'%'e=('d'|'f'|'c'|'s')'"' ',' f=Identifier
	{
		$typeInfo = TypeInfo.Void;  //初始化
		if(!symtab.containsKey($f.text)){//先確認 f 是否已經定義過
			System.out.println("Error! "+$scanf_.start.getLine()+": printf first var undeclared identifier.");
			$typeInfo = TypeInfo.Error;
		}
		switch($e.getText()){	//檢查id type 是否正確
			case "d":
				if(symtab.get($f.text) != TypeInfo.Integer){
					$typeInfo = TypeInfo.Error;
					System.out.println("Error! "+$scanf_.start.getLine()+": first var type is wrong, need integer.");
				}
				break;  
		 	case "f":
				if(symtab.get($f.text) != TypeInfo.Float){
					$typeInfo = TypeInfo.Error;
					System.out.println("Error! "+$scanf_.start.getLine()+": first var type is wrong, need float.");
				}
				break; 
			case "c":
				if(symtab.get($f.text) != TypeInfo.Char){
					$typeInfo = TypeInfo.Error;
					System.out.println("Error! "+$scanf_.start.getLine()+": first var type is wrong, need char.");
				}
				break;
			case "s":
				if(symtab.get($f.text) != TypeInfo.String){
					$typeInfo = TypeInfo.Error;
					System.out.println("Error! "+$scanf_.start.getLine()+": first var type is wrong, need string.");
				}
				break;
		}
	}
	;

//get_var
scanf_get_var: 
	'%'('d'|'f') scanf_get_var ',' '&'Identifier             
	{ if (TRACEON) System.out.println("scanf_get_var: '\%'(d|f) scanf_get_var , &Identifier "); }
	|'"'  { if (TRACEON) System.out.println("scanf_get_var: '\"'"); };
print_get_var:  
	'%'('d'|'f')  print_get_var ','Identifier 
	{ if (TRACEON) System.out.println("print_get_var:  '\%'(d|f)  print_get_var ,Identifier "); }
	|'"'  { if (TRACEON) System.out.println("print_get_var: '\"'"); };

/* description of the tokens */
/*----------------------*/
/*   Reserved Keywords  */
/*----------------------*/
//TYPE :(INT|CHAR|VOID|FLOAT|DOUBLE);
INT  : 'integer' | 'int';
CHAR : 'char';
VOID : 'void';
FLOAT: 'float';
DOUBLE: 'double';
SHORT: 'short';


MAIN: 'main';
RETURN: 'return';
INCLUDE: 'include';

//flow control
IF: 'if';
ELSE: 'else';
WHILE: 'while';
BREAK: 'break';
CONTINUE: 'continue';
FOR: 'for';

//function
PRINTF: 'printf';
SCANF: 'scanf';


/*----------------------*/
/*  Compound Operators  */
/*----------------------*/
//relational operator
relate_op: (EQ_OP|LE_OP|GE_OP|NE_OP| LARGER|SMALLER) { if (TRACEON) System.out.println("relate_op: (EQ_OP|LE_OP|GE_OP|NE_OP| LARGER|SMALLER)"); };
EQ_OP : '==';
LE_OP : '<=';
GE_OP : '>=';
NE_OP : '!=';
LARGER: '>';
SMALLER: '<';

//unary operator
PP_OP : '++';
MM_OP : '--'; 

//arithmetic operator
ADD: '+';
SUB:'-';
MUL: '*';
DIV: '/';
MOD: '%';

//assignment operator
assign_op:(ASSIGN|ADD_ASSIGN| SUB_ASSIGN| MUL_ASSIGN | DIV_ASSIGN)  { if (TRACEON) System.out.println("assign_op:(ASSIGN|ADD_ASSIGN| SUB_ASSIGN| MUL_ASSIGN | DIV_ASSIGN)"); };
ASSIGN: '=';
ADD_ASSIGN: '+=';
SUB_ASSIGN: '-=';
MUL_ASSIGN: '*=';
DIV_ASSIGN: '/=';

//logical operator
AND: '&&';
OR: '||';
NOT: '!';

END: EOF;


/*------Punctuation------*/
Semicolon: ';';
L_PAREN: '(';
R_PAREN: ')';
L_BRACKET: '[';
R_BRACKET: ']';
L_BRACE: '{';
R_BRACE: '}';
HASH: '#';
COMMA: ',';
DOT: '.';
UNDERSCORE:'_';
COLON: ':';


lIBRARY : Identifier'.'Identifier  { if (TRACEON) System.out.println("lIBRARY : Identifier'.'Identifier "); };
Identifier:('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;
Integer_constant:'0'..'9'+;
Floating_point_constant:'0'..'9'+ '.' '0'..'9'+;
Charliteral:'\'' ('a'..'z'|'A'..'Z'|'_') '\'' ;
String_s :'\"'  ('a'..'z'|'A'..'Z'|'0'..'9'|'_')* '\"';

WS:( ' ' | '\t' | '\r' | '\n' ) {$channel=HIDDEN;};
COMMENT1: '//'(.)*'\n'{$channel=HIDDEN;};
COMMENT2:'/*' .* '*/' {$channel=HIDDEN;};

