grammar myCompiler;

options {
   language = Java;
}

@header {
    // import packages here.
    import java.util.HashMap;
    import java.util.ArrayList;
}

@members {
    boolean TRACEON = false;

    // Type information.
    public enum Type{
       ERR, BOOL, INT, FLOAT, CHAR, CONST_INT, VOID, STRING, CONST_FLOAT;
    }

    // This structure is used to record the information of a variable or a constant.
    class tVar {
	   int   varIndex; // temporary variable's index. Ex: t1, t2, ..., etc.
	   int   iValue;   // value of constant integer. Ex: 123.
	   float fValue;   // value of constant floating point. Ex: 2.314.
	};

    class Info {
       Type theType;  // type information.
       tVar theVar;
	   
	   Info() {
         theType = Type.ERR;
		   theVar = new tVar();
	   }
    };

	
    // ============================================
    // Create a symbol table.
	// ArrayList is easy to extend to add more info. into symbol table.
	//
	// The structure of symbol table:
	// <variable ID, [Type, [varIndex or iValue, or fValue]]>
	//    - type: the variable type   (please check "enum Type")
	//    - varIndex: the variable's index, ex: t1, t2, ...
	//    - iValue: value of integer constant.
	//    - fValue: value of floating-point constant.
    // ============================================

    HashMap<String, Info> symtab = new HashMap<String, Info>();

    // labelCount is used to represent temporary label.
    // The first index is 0.
    int labelCount = 0;
	
    // varCount is used to represent temporary variables.
    // The first index is 0.
    int varCount = 1;

    // Record all assembly instructions.
    List<String> TextCode = new ArrayList<String>();
    List<String> Print_str = new ArrayList<String>();


    /*
     * Output prologue.
     */
    void prologue()
    {
       TextCode.add("; === prologue ====");
       TextCode.add("declare dso_local i32 @printf(i8*, ...)\n");
       TextCode.add("declare dso_local i32 @scanf(i8*, ...)\n");
	   TextCode.add("define dso_local i32 @main()");
	   TextCode.add("{");
    }
    
	
    /*
     * Output epilogue.
     */
    void epilogue()
    {
       /* handle epilogue */
       TextCode.add("\n; === epilogue ===");
	   TextCode.add("ret i32 0");
       TextCode.add("}");
    }
    
    
    /* Generate a new label */
    String newLabel()
    {
       labelCount ++;
       return (new String("L")) + Integer.toString(labelCount);
    } 
    
    
    public List<String> getTextCode()
    {
       return TextCode;
    }
    public List<String> getPrint_str()
    {
       return Print_str;
    }
}

program: (INT|VOID) MAIN '(' ')'
        {
           /* Output function prologue */
           prologue();
        }

        '{' 
           statements
        '}'
        {
	   if (TRACEON)
	      System.out.println("VOID MAIN () {declarations statements}");

           /* output function epilogue */	  
           epilogue();
        }
        ;
//include
include_lib:HASH INCLUDE '<'lIBRARY'>' 
            {if (TRACEON) System.out.println("include_lib:HASH INCLUDE <LIBRARY>");};




type
returns [Type attr_type]
    : INT { if (TRACEON) System.out.println("type: INT"); $attr_type=Type.INT; }
    | CHAR { if (TRACEON) System.out.println("type: CHAR"); $attr_type=Type.CHAR; }
    | FLOAT {if (TRACEON) System.out.println("type: FLOAT"); $attr_type=Type.FLOAT; }
    | VOID {if (TRACEON) System.out.println("type: VOID"); $attr_type=Type.VOID; }
	;


statements:statement statements
          |
          ;


statement: 
   flow
   |assign ';' 
   |func_call';'
   ;


assign: type? Identifier assign_or_declare[$Identifier.text, $Identifier.getLine(),$type.attr_type]

   ;

assign_or_declare [String Id, int gline, Type attr_type]:
   '=' arith_expression
   {  //assign
      Info theRHS = $arith_expression.theInfo;
		Info theLHS = symtab.get($Id); 
		   
      if ((theLHS.theType == Type.INT) &&
            (theRHS.theType == Type.INT)) {		   
            // issue store insruction.
            // Ex: store i32 \%tx, i32* \%ty
            TextCode.add("store i32 \%t" + theRHS.theVar.varIndex + ", i32* \%t" + theLHS.theVar.varIndex + ", align 4");
		} else if ((theLHS.theType == Type.INT) &&
				(theRHS.theType == Type.CONST_INT)) {
            // issue store insruction.
            // Ex: store i32 value, i32* \%ty
            TextCode.add("store i32 " + theRHS.theVar.iValue + ", i32* \%t" + theLHS.theVar.varIndex + ", align 4");				
		}else if ((theLHS.theType == Type.FLOAT) &&
				(theRHS.theType == Type.FLOAT)) {
            TextCode.add("store float \%t" + theRHS.theVar.varIndex + ", float* \%t" + theLHS.theVar.varIndex + ", align 4");
      }else if ((theLHS.theType == Type.FLOAT) &&
				(theRHS.theType == Type.CONST_FLOAT)) {
            String floatBits = "0x" + Long.toHexString(Double.doubleToRawLongBits(theRHS.theVar.fValue));
            TextCode.add("store float " + floatBits + ", float* \%t" + theLHS.theVar.varIndex + ", align 4");				
		}
	}
   |
   {  //declare
      if (symtab.containsKey($Id)) {
         // variable re-declared.
         System.out.println("Type Error: " + 
            $gline + ": Redeclared identifier.");
         System.exit(0);
      }
      /* Add ID and its info into the symbol table. */
	      Info the_entry = new Info();
		   the_entry.theType = $attr_type;
		   the_entry.theVar.varIndex = varCount;
		   varCount ++;
		   symtab.put($Id, the_entry);

         // issue the instruction.
		   // Ex: \%a = alloca i32, align 4

         switch($attr_type){
            case INT:
               TextCode.add("\%t" + the_entry.theVar.varIndex + " = alloca i32, align 4");
               break;
            case FLOAT: 
               TextCode.add("\%t" + the_entry.theVar.varIndex + " = alloca float, align 4");
               break;
            case CHAR:
               TextCode.add("\%t" + the_entry.theVar.varIndex + " = alloca i8, align 1");
               break;
         }
   }
   ;
		   
			   
arith_expression
returns [Info theInfo]
@init {theInfo = new Info();}
   : a=multExpr { $theInfo=$a.theInfo; }
   ( '+' b=multExpr
   {
      // We need to do type checking first.
      if($b.theInfo.theType != $theInfo.theType){
         int get=0;
         //如果是一個int 一個const_int 可以執行
         if(!(($b.theInfo.theType==Type.INT || $b.theInfo.theType==Type.CONST_INT) 
            && ($theInfo.theType==Type.INT||$theInfo.theType==Type.CONST_INT))){
            get=get+1;
         }
         //如果是一個float 一個const_float 可以執行
         if(!(($b.theInfo.theType==Type.FLOAT || $b.theInfo.theType==Type.CONST_FLOAT) 
            && ($theInfo.theType==Type.FLOAT||$theInfo.theType==Type.CONST_FLOAT))){
            get=get+1;
         }
         if(get==2){
            System.out.println("Error! "+$a.start.getLine()+
			   ": Type mismatch for the operator '+' in an expression.");
            System.exit(0);
         }
      }

      int change =1;			  
      // code generation.					   
      if (($a.theInfo.theType == Type.INT) &&
         ($b.theInfo.theType == Type.INT)) {
         TextCode.add("\%t" + varCount + " = add nsw i32 \%t" + $theInfo.theVar.varIndex + ", \%t" + $b.theInfo.theVar.varIndex);
			$theInfo.theType =Type.INT;
      } else if (($a.theInfo.theType == Type.INT) &&
		   ($b.theInfo.theType == Type.CONST_INT)) {
         TextCode.add("\%t" + varCount + " = add nsw i32 \%t" + $theInfo.theVar.varIndex + ", " + $b.theInfo.theVar.iValue);
			$theInfo.theType =Type.INT;	   
      }else if (($a.theInfo.theType == Type.CONST_INT) &&
		   ($b.theInfo.theType == Type.INT)){
         TextCode.add("\%t" + varCount + " = add nsw i32 " + $theInfo.theVar.iValue + ", \%t" + $b.theInfo.theVar.varIndex);
			$theInfo.theType =Type.INT;		   
      }else if (($a.theInfo.theType == Type.CONST_INT) &&
		   ($b.theInfo.theType == Type.CONST_INT)){
         $theInfo.theVar.iValue = $theInfo.theVar.iValue + $b.theInfo.theVar.iValue;
         change =0;
      }else if (($a.theInfo.theType == Type.FLOAT) &&
         ($b.theInfo.theType == Type.FLOAT)) {  //float
         TextCode.add("\%t" + varCount + " = fadd float \%t" + $theInfo.theVar.varIndex + ", \%t" + $b.theInfo.theVar.varIndex);
			$theInfo.theType =Type.FLOAT;
      } else if (($a.theInfo.theType == Type.FLOAT) &&
		   ($b.theInfo.theType == Type.CONST_FLOAT)) {
         int varindex = $theInfo.theVar.varIndex;
         TextCode.add("\%t" + varCount + " = fpext float \%t"+varindex+" to double");
         varindex = varCount++;
         TextCode.add("\%t" + varCount + " = fadd double \%t" + varindex + ", " + $b.theInfo.theVar.fValue);
         varindex = varCount++;
         TextCode.add("\%t" + varCount + " = fptrunc double \%t" + varindex +" to float");
			$theInfo.theType =Type.FLOAT;	   
      }else if (($a.theInfo.theType == Type.CONST_FLOAT) &&
		   ($b.theInfo.theType == Type.FLOAT)){
         int varindex = $b.theInfo.theVar.varIndex;
         TextCode.add("\%t" + varCount + " = fpext float \%t"+varindex+" to double");
         varindex = varCount++;
         TextCode.add("\%t" + varCount + " = fadd double " + $theInfo.theVar.fValue + ", \%t" + varindex);
         varindex = varCount++;
         TextCode.add("\%t" + varCount + " = fptrunc double \%t" + varindex +" to float");
			$theInfo.theType =Type.FLOAT;	   
      }else if (($a.theInfo.theType == Type.CONST_FLOAT) &&
		   ($b.theInfo.theType == Type.CONST_FLOAT)){
         $theInfo.theVar.fValue = $theInfo.theVar.fValue + $b.theInfo.theVar.fValue;
         change =0;
      }

      //把TYPE改掉
      /*if ((  $theInfo.theType != Type.CONST_INT ||   $theInfo.theType != Type.CONST_FLOAT)&&
          ($b.theInfo.theType != Type.CONST_INT || $b.theInfo.theType != Type.CONST_FLOAT)) {
          $theInfo.theVar.varIndex = varCount;
          varCount++;
      }*/
      //把TYPE改掉
      if (change==1) {
          $theInfo.theVar.varIndex = varCount;
          varCount++;
      }
   }
   | '-' c=multExpr
   {
      // We need to do type checking first.
      if($c.theInfo.theType != $theInfo.theType){
         int get=0;
         //如果是一個int 一個const_int 可以執行
         if(!(($c.theInfo.theType==Type.INT || $c.theInfo.theType==Type.CONST_INT) 
            && ($theInfo.theType==Type.INT||$theInfo.theType==Type.CONST_INT))){
            get=get+1;
         }
         //如果是一個float 一個const_float 可以執行
         if(!(($c.theInfo.theType==Type.FLOAT || $c.theInfo.theType==Type.CONST_FLOAT) 
            && ($theInfo.theType==Type.FLOAT||$theInfo.theType==Type.CONST_FLOAT))){
            get=get+1;
         }
         if(get==2){
            System.out.println("Error! "+$a.start.getLine()+
			   ": Type mismatch for the operator '-' in an expression.");
            System.exit(0);
         }
      }
					  
      int change =1;	
      // code generation.					   
      if (($a.theInfo.theType == Type.INT) &&
         ($c.theInfo.theType == Type.INT)) {
         TextCode.add("\%t" + varCount + " = sub nsw i32 \%t" + $theInfo.theVar.varIndex + ", \%t" + $c.theInfo.theVar.varIndex);
			$theInfo.theType =Type.INT;
      } else if (($a.theInfo.theType == Type.INT) &&
		   ($c.theInfo.theType == Type.CONST_INT)) {
         TextCode.add("\%t" + varCount + " = sub nsw i32 \%t" + $theInfo.theVar.varIndex + ", " + $c.theInfo.theVar.iValue);
			$theInfo.theType =Type.INT;
      }else if (($a.theInfo.theType == Type.CONST_INT) &&
		   ($c.theInfo.theType == Type.INT)){
         TextCode.add("\%t" + varCount + " = sub nsw i32 " + $theInfo.theVar.iValue + ", \%t" + $c.theInfo.theVar.varIndex);
			$theInfo.theType =Type.INT;
      }else if (($a.theInfo.theType == Type.CONST_INT) &&
		   ($c.theInfo.theType == Type.CONST_INT)){
         $theInfo.theVar.iValue = $theInfo.theVar.iValue - $c.theInfo.theVar.iValue;
         change =0;	
      }else if (($a.theInfo.theType == Type.FLOAT) &&
         ($c.theInfo.theType == Type.FLOAT)) {     //FLOAT
         TextCode.add("\%t" + varCount + " = fsub float \%t" + $theInfo.theVar.varIndex + ", \%t" + $c.theInfo.theVar.varIndex);
			$theInfo.theType =Type.FLOAT;
      } else if (($a.theInfo.theType == Type.FLOAT) &&
		   ($c.theInfo.theType == Type.CONST_FLOAT)) {
         int varindex = $theInfo.theVar.varIndex;
         TextCode.add("\%t" + varCount + " = fpext float \%t"+varindex+" to double");
         varindex = varCount++;
         TextCode.add("\%t" + varCount + " = fsub double \%t" + varindex + ", " + $c.theInfo.theVar.fValue);
         varindex = varCount++;
         TextCode.add("\%t" + varCount + " = fptrunc double \%t" + varindex +" to float");
			$theInfo.theType =Type.FLOAT;
      }else if (($a.theInfo.theType == Type.CONST_FLOAT) &&
		   ($c.theInfo.theType == Type.FLOAT)){
         int varindex = $c.theInfo.theVar.varIndex;
         TextCode.add("\%t" + varCount + " = fpext float \%t"+varindex+" to double");
         varindex = varCount++;
         TextCode.add("\%t" + varCount + " = fsub double " + $theInfo.theVar.fValue + ", \%t" + varindex);
         varindex = varCount++;
         TextCode.add("\%t" + varCount + " = fptrunc double \%t" + varindex +" to float");
			$theInfo.theType =Type.FLOAT;	
      }else if (($a.theInfo.theType == Type.CONST_FLOAT) &&
		   ($c.theInfo.theType == Type.CONST_FLOAT)){
         $theInfo.theVar.fValue = $theInfo.theVar.fValue - $c.theInfo.theVar.fValue;
         change =0;	
      }

      if (change == 1) {
          $theInfo.theVar.varIndex = varCount;
          varCount++;
      }
   }
   )*
   ;

multExpr
returns [Info theInfo]
@init {$theInfo = new Info();}
   : 
   a=signExpr { $theInfo=$a.theInfo; }
   ( '*' b=signExpr
   {
      if($b.theInfo.theType != $theInfo.theType){
         int get=0;
         //如果是一個int 一個const_int 可以執行
         if(!(($b.theInfo.theType==Type.INT || $b.theInfo.theType==Type.CONST_INT) 
            && ($theInfo.theType==Type.INT||$theInfo.theType==Type.CONST_INT))){
            get=get+1;
         }
         //如果是一個float 一個const_float 可以執行
         if(!(($b.theInfo.theType==Type.FLOAT || $b.theInfo.theType==Type.CONST_FLOAT) 
            && ($theInfo.theType==Type.FLOAT||$theInfo.theType==Type.CONST_FLOAT))){
            get=get+1;
         }
         if(get==2){
            System.out.println("Error! "+$a.start.getLine()+
			   ": Type mismatch for the operator '*' in an expression.");
            System.exit(0);
         }
      }

      int change =1;	
      // 生成乘法操作的LLVM IR指令
      //更新theInfo.theVar.iValue
      if (($theInfo.theType == Type.INT) && ($b.theInfo.theType == Type.INT)) {
         TextCode.add("\%t" + varCount + " = mul nsw i32 \%t" + $theInfo.theVar.varIndex + ", \%t" + $b.theInfo.theVar.varIndex);
         $theInfo.theType =Type.INT;
      }else if(($theInfo.theType == Type.INT) && ($b.theInfo.theType == Type.CONST_INT)){
         TextCode.add("\%t" + varCount + " = mul nsw i32 \%t" + $theInfo.theVar.varIndex + ", " + $b.theInfo.theVar.iValue);
         $theInfo.theType =Type.INT;
      }else if(($theInfo.theType == Type.CONST_INT) && ($b.theInfo.theType == Type.INT)){
         TextCode.add("\%t" + varCount + " = mul nsw i32 " + $theInfo.theVar.iValue + ", \%t" + $b.theInfo.theVar.varIndex);
         $theInfo.theType =Type.INT;
      }else if(($theInfo.theType == Type.CONST_INT) && ($b.theInfo.theType == Type.CONST_INT)){
         $theInfo.theVar.iValue = $theInfo.theVar.iValue * $b.theInfo.theVar.iValue;
         change =0;	
      } else if (($theInfo.theType == Type.FLOAT) && ($b.theInfo.theType == Type.FLOAT)) {//float處理
         TextCode.add("\%t" + varCount + " = fmul float \%t" + $theInfo.theVar.varIndex + ", \%t" + $b.theInfo.theVar.varIndex);
         $theInfo.theType =Type.FLOAT;
      }else if(($theInfo.theType == Type.FLOAT) && ($b.theInfo.theType == Type.CONST_FLOAT)){
         int varindex = $theInfo.theVar.varIndex;
         TextCode.add("\%t" + varCount + " = fpext float \%t"+varindex+" to double");
         varindex = varCount++;
         TextCode.add("\%t" + varCount + " = fmul double \%t" + varindex + ", " + $b.theInfo.theVar.fValue);
         varindex = varCount++;
         TextCode.add("\%t" + varCount + " = fptrunc double \%t" + varindex +" to float");
			$theInfo.theType =Type.FLOAT;
      }else if(($theInfo.theType == Type.CONST_FLOAT) && ($b.theInfo.theType == Type.FLOAT)){
         int varindex = $b.theInfo.theVar.varIndex;
         TextCode.add("\%t" + varCount + " = fpext float \%t"+varindex+" to double");
         varindex = varCount++;
         TextCode.add("\%t" + varCount + " = fmul double " + $theInfo.theVar.fValue + ", \%t" + varindex);
         varindex = varCount++;
         TextCode.add("\%t" + varCount + " = fptrunc double \%t" + varindex +" to float");
			$theInfo.theType =Type.FLOAT;	
      }else if(($theInfo.theType == Type.CONST_FLOAT) && ($b.theInfo.theType == Type.CONST_FLOAT)){
         $theInfo.theVar.fValue = $theInfo.theVar.fValue * $b.theInfo.theVar.fValue;
         change =0;	
      }


      //把TYPE改掉
      if (change == 1) {
          $theInfo.theVar.varIndex = varCount;
          varCount++;
      }

   }
   | '/' c=signExpr
   {
      if($c.theInfo.theType != $theInfo.theType){
         int get=0;
         //如果是一個int 一個const_int 可以執行
         if(!(($c.theInfo.theType==Type.INT || $c.theInfo.theType==Type.CONST_INT) 
            && ($theInfo.theType==Type.INT||$theInfo.theType==Type.CONST_INT))){
            get=get+1;
         }
         //如果是一個float 一個const_float 可以執行
         if(!(($c.theInfo.theType==Type.FLOAT || $c.theInfo.theType==Type.CONST_FLOAT) 
            && ($theInfo.theType==Type.FLOAT||$theInfo.theType==Type.CONST_FLOAT))){
            get=get+1;
         }
         if(get==2){
            System.out.println("Error! "+$a.start.getLine()+
			   ": Type mismatch for the operator '/' in an expression.");
            System.exit(0);
         }
      }

      int change =1;	
      // 生成除法操作的LLVM IR指令
      if (($theInfo.theType == Type.INT) && ($c.theInfo.theType == Type.INT)) {
         TextCode.add("\%t" + varCount + " = sdiv i32 \%t" + $theInfo.theVar.varIndex + ", \%t" + $c.theInfo.theVar.varIndex);
         $theInfo.theType =Type.INT;
      }else if(($theInfo.theType == Type.INT) && ($c.theInfo.theType == Type.CONST_INT)){
         TextCode.add("\%t" + varCount + " = sdiv i32 \%t" + $theInfo.theVar.varIndex + ", " + $c.theInfo.theVar.iValue);
         $theInfo.theType =Type.INT;
      }else if(($theInfo.theType == Type.CONST_INT) && ($c.theInfo.theType == Type.INT)){
         TextCode.add("\%t" + varCount + " = sdiv i32 " + $theInfo.theVar.iValue + ", \%t" + $c.theInfo.theVar.varIndex);
         $theInfo.theType =Type.INT;
      }else if(($theInfo.theType == Type.CONST_INT) && ($c.theInfo.theType == Type.CONST_INT)){
         $theInfo.theVar.iValue = $theInfo.theVar.iValue / $c.theInfo.theVar.iValue;
         change =0;	
      }else if (($theInfo.theType == Type.FLOAT) && ($c.theInfo.theType == Type.FLOAT)) {    //float
         TextCode.add("\%t" + varCount + " = fdiv float \%t" + $theInfo.theVar.varIndex + ", \%t" + $c.theInfo.theVar.varIndex);
         $theInfo.theType =Type.FLOAT;
      }else if(($theInfo.theType == Type.FLOAT) && ($c.theInfo.theType == Type.CONST_FLOAT)){
         int varindex = $theInfo.theVar.varIndex;
         TextCode.add("\%t" + varCount + " = fpext float \%t"+varindex+" to double");
         varindex = varCount++;
         TextCode.add("\%t" + varCount + " = fdiv double \%t" + varindex + ", " + $c.theInfo.theVar.fValue);
         varindex = varCount++;
         TextCode.add("\%t" + varCount + " = fptrunc double \%t" + varindex +" to float");
			$theInfo.theType =Type.FLOAT;
         //TextCode.add("\%t" + varCount + " = fdiv float \%t" + $theInfo.theVar.varIndex + ", " + $c.theInfo.theVar.fValue);
         //$theInfo.theType =Type.FLOAT;
      }else if(($theInfo.theType == Type.CONST_FLOAT) && ($c.theInfo.theType == Type.FLOAT)){
         int varindex = $c.theInfo.theVar.varIndex;
         TextCode.add("\%t" + varCount + " = fpext float \%t"+varindex+" to double");
         varindex = varCount++;
         TextCode.add("\%t" + varCount + " = fdiv double " + $theInfo.theVar.fValue + ", \%t" + varindex);
         varindex = varCount++;
         TextCode.add("\%t" + varCount + " = fptrunc double \%t" + varindex +" to float");
			$theInfo.theType =Type.FLOAT;	
         //TextCode.add("\%t" + varCount + " = fdiv float " + $theInfo.theVar.fValue + ", \%t" + $c.theInfo.theVar.varIndex);
         //$theInfo.theType =Type.FLOAT;
      }else if(($theInfo.theType == Type.CONST_FLOAT) && ($c.theInfo.theType == Type.CONST_FLOAT)){
         $theInfo.theVar.fValue = $theInfo.theVar.fValue / $c.theInfo.theVar.fValue;
         change =0;	
      }

      if ( change == 1	) {
          $theInfo.theVar.varIndex = varCount;
          varCount++;
      }
   }
	)*
	;

signExpr
returns [Info theInfo]
@init {$theInfo = new Info();}
   :     a=primaryExpr { $theInfo=$a.theInfo; } 
   | '-' b=primaryExpr { $theInfo=$b.theInfo; }
   {
      if($theInfo.theType != Type.INT && $theInfo.theType != Type.CONST_INT && $theInfo.theType != Type.FLOAT && $theInfo.theType != Type.CONST_FLOAT){
         System.out.println("Type Error: " + 
               $signExpr.start.getLine() + ": '-' can only be applied to int or const int or float or const float types.");
             System.exit(0);
      }
      //產生負號
      if ($theInfo.theType == Type.INT) {
         TextCode.add("\%t" + varCount + " = sub nsw i32 0, \%t" + $theInfo.theVar.varIndex);
      } else if ($theInfo.theType == Type.FLOAT) {
         TextCode.add("\%t" + varCount + " = fsub float 0.0, \%t" + $theInfo.theVar.varIndex);
      }else if($theInfo.theType == Type.CONST_INT){
         $theInfo.theVar.iValue = -1*$theInfo.theVar.iValue;
         //TextCode.add("\%t" + varCount + " = sub nsw i32 0, " + $theInfo.theVar.iValue);
      }else if($theInfo.theType == Type.CONST_FLOAT){
         $theInfo.theVar.fValue = -1*$theInfo.theVar.fValue;
         //TextCode.add("\%t" + varCount + " = fsub nsw float 0.0, " + $theInfo.theVar.iValue);
      }

      if(($theInfo.theType == Type.INT) || ($theInfo.theType == Type.FLOAT)){
         $theInfo.theVar.varIndex = varCount;
         varCount++;
      }
   }
	;


primaryExpr
returns [Info theInfo]
@init {theInfo = new Info();}
   : Integer_constant
	{
      $theInfo.theType = Type.CONST_INT;
		$theInfo.theVar.iValue = Integer.parseInt($Integer_constant.text);
   }
   | Floating_point_constant
   {
      $theInfo.theType = Type.CONST_FLOAT;
		$theInfo.theVar.fValue = Float.parseFloat($Floating_point_constant.text);
   }
   | Identifier
   {
      //未宣告報錯
      if(!symtab.containsKey($Identifier.text)){
          System.out.println("Type Error: " + 
            $Identifier.getLine() + ": Undeclare.");
         System.exit(0);
      }
      // get type information from symtab.

      Type the_type = symtab.get($Identifier.text).theType;
		$theInfo.theType = the_type;

      
      // get variable index from symtab.
      int vIndex = symtab.get($Identifier.text).theVar.varIndex;
				
      switch (the_type) {
         case INT: 
				TextCode.add("\%t" + varCount + " = load i32, i32* \%t" + vIndex + ", align 4");
				$theInfo.theVar.varIndex = varCount;
				varCount ++;
            break;
         case FLOAT:
            TextCode.add("\%t" + varCount + " = load float, float* \%t" + vIndex + ", align 4");
            $theInfo.theVar.varIndex = varCount;
				varCount ++;
            break;
         case CHAR:
            System.out.println("Type Error: " + 
            $Identifier.getLine() + ": Type error in arith_expression only use int and float type identifier.");
            System.exit(0);
            break;
      }
   }
	//| '&' Identifier
	| '(' arith_expression ')'
   {
      $theInfo = $arith_expression.theInfo;
   }
   ;

flow returns[Info theInfo, String LEnd]
@init {$theInfo = new Info();$LEnd=newLabel();} 
   :
   if_statement[$LEnd] 
   |
   while_stat
   |
   for_stat
   ;

for_stat returns[String loopL,String condL,String tailL,String endL]
   :
   {
      $loopL = newLabel();
      $condL = newLabel();
      $tailL = newLabel();
      $endL =  newLabel();
   }
   FOR'('h=assign
   {//先初始化
      TextCode.add("br label \%" + $condL);
      TextCode.add($condL + ":");
   }
   ';'g=compare_expression
   {
      TextCode.add("br i1  \%t"+$g.theInfo.theVar.varIndex +", label \%" + $loopL + ", label \%" + $endL); 
      TextCode.add($tailL + ":");
   }
   ';'i=assign')'
   { //tail結束要回 cond
      TextCode.add("br label \%" + $condL);
   }
   {//開始執行loop
      TextCode.add($loopL + ":");
   }
   '{' statements '}'
   {//執行完處理後半部分 回tailL
      TextCode.add("br label \%" + $tailL);
      TextCode.add($endL + ":");
   }
   ;

while_stat returns[String startLabel, String trueLabel, String endLabel]
   :
   {
      $startLabel = newLabel();
      $trueLabel = newLabel();
      $endLabel = newLabel();
      TextCode.add("br label \%" + $startLabel);
      TextCode.add($startLabel+':');
   }
   WHILE'('a=compare_expression')'
   {
      if ($a.theInfo.theType != Type.BOOL) {
         System.out.println("Error! " + $a.start.getLine() + ": Condition in WHILE statement must be a boolean expression.");
         System.exit(0);
      }
      TextCode.add("br i1 \%t" + $a.theInfo.theVar.varIndex + ", label \%" + $trueLabel + ", label \%" + $endLabel);
      TextCode.add($trueLabel + ":");
   }

   (b=statement
   {
      TextCode.add("br label \%" + $startLabel);
      TextCode.add($endLabel + ":");
   }

   |'{'c=statements'}'
   {
      TextCode.add("br label \%" + $startLabel);
      TextCode.add($endLabel + ":");
   }

   )
   ;
if_statement [String LEnd] returns [String LTrue, String LFalse]
    : IF '(' a=compare_expression')' {
        if ($a.theInfo.theType != Type.BOOL) {
            System.out.println("Error! " + $a.start.getLine() + ": Not boolean in condition.");
        } else {
            $LTrue = newLabel();
            $LFalse = newLabel();
            TextCode.add("br i1 \%t" + $a.theInfo.theVar.varIndex + ", label \%" + $LTrue + ", label \%" + $LFalse);
            TextCode.add($LTrue + ":");
        }
    } (statement | '{'statements'}')//block_statement
        ( (ELSE)=> {
            TextCode.add("br label \%" + $LEnd);
            TextCode.add($LFalse + ":");
        } ELSE else_statement {
            TextCode.add("br label \%" + $LEnd);
            TextCode.add($LEnd + ":");
        }
        | {
            TextCode.add("br label \%" + $LFalse);
            TextCode.add($LFalse + ":");
        })
    ;
else_statement returns [String LEnd]
@init{$LEnd =newLabel();}
    :
    (IF)=> if_statement[$LEnd]
    |(statement | '{'statements'}')//block_statement
        {if (TRACEON) System.out.println("ELSE ...");}
    ;


compare_expression returns[Info theInfo]
@init {$theInfo = new Info();}  
   :
   a =Identifier relate_op
   {//先確認是否有定義過了
      $theInfo.theType = Type.BOOL;   //初始化
      if(! symtab.containsKey($a.text)){
			System.out.println("Error! "+$compare_expression.start.getLine()+": Undeclared identifier.");
			System.exit(0);
		}
   }
   (b=Identifier
   {
      //確認ID定義過
		if(! symtab.containsKey($b.text)){
			System.out.println("Error! "+$compare_expression.start.getLine()+": Undeclared identifier.");
			System.exit(0);
		}
      //id type check
      Type typeA = symtab.get($a.text).theType;
      Type typeB = symtab.get($b.text).theType;
      if(typeA !=typeB){
         if(typeA!= typeB){
            System.out.println("Error! "+$relate_op.start.getLine()+
			   ": Type mismatch for the relate_op in an expression.");
            System.exit(0);
         }
      }
      String op = "==";
      switch($relate_op.text){
         case "==":
            op = "eq";
            break;
         case "<=":
            op = "sle";
            break;
         case ">=":
            op = "sge";
            break;
         case "!=":
            op = "ne";
            break;
         case ">":
            op = "sgt";
            break;
         case "<":
            op = "slt";
            break;
         default:
            System.out.println("Error! Unknown relation operator.");
            System.exit(0);
      }
      if(typeA==Type.INT&& typeB==Type.INT){
         int varIndexA = symtab.get($a.text).theVar.varIndex;
         int varIndexB = symtab.get($b.text).theVar.varIndex;
         TextCode.add("\%t"+ varCount + "= load i32, i32* \%t"+varIndexA+", align 4");
         //symtab.get($a.text).theVar.varIndex = varCount; 
         varIndexA = varCount;
         varCount++;
         TextCode.add("\%t"+ varCount + "= load i32, i32* \%t"+varIndexB+", align 4");
         //symtab.get($b.text).theVar.varIndex = varCount; 
         varIndexB = varCount;
         varCount++;
         TextCode.add("\%t" + varCount + " = icmp " + op + " i32 \%t" + varIndexA + ", \%t" + varIndexB);
         $theInfo.theVar.varIndex= varCount;
         varCount++;
      }

   }
   |c=Integer_constant
   {
      Type typeA = symtab.get($a.text).theType;
      if(typeA != Type.INT){
         System.out.println("Error! "+$relate_op.start.getLine()+
			": Type mismatch for the relate_op in an expression.");
         System.exit(0);
      }
      String op = "==";
      switch($relate_op.text){
         case "==":
            op = "eq";
            break;
         case "<=":
            op = "sle";
            break;
         case ">=":
            op = "sge";
            break;
         case "!=":
            op = "ne";
            break;
         case ">":
            op = "sgt";
            break;
         case "<":
            op = "slt";
            break;
         default:
            System.out.println("Error! Unknown relation operator.");
            System.exit(0);
      }
      int varIndexA = symtab.get($a.text).theVar.varIndex;
      int constValueC = Integer.parseInt($c.text);
      TextCode.add("\%t"+ varCount + "= load i32, i32* \%t"+varIndexA+", align 4");
      //symtab.get($a.text).theVar.varIndex = varCount; 
      varIndexA = varCount;
      varCount++;
      TextCode.add("\%t" + varCount + " = icmp " + op + " i32 \%t" + varIndexA + ", " + constValueC);
      $theInfo.theVar.varIndex= varCount;
      varCount++;
   }
   )
   ;

func_call
returns [Info theInfo]
@init {$theInfo = new Info();}
   :
   PRINTF'('s=STRING_LITERAL(','a=arith_expression)?')'
   {
      // LLVM IR code generation for printf
      String formatStr = $s.text.substring(1, $s.text.length()-1 );
      long count = $s.text.chars().filter(ch -> ch =='\\').count();
      long formatStrLength = formatStr.length()-count+1;
      int formatStrIndex = varCount;
      varCount++;

      // Declare and initialize the format string
      Print_str.add("@.str" + formatStrIndex + " = private unnamed_addr constant [" 
                   + formatStrLength + " x i8] c\"" + formatStr.replace("\\n", "\\0A") + "\\00\", align 1");
      if(a!=null){
         //先確認 type 目前只INT,FLOAT可以用
         if($a.theInfo.theType != Type.INT && $a.theInfo.theType != Type.FLOAT){
            System.out.println("Error! "+$func_call.start.getLine()+
		   	   ": Type mismatch for the printf only INT and FLOAT legal.");
            System.exit(0);
         }


         int exprIndex=$a.theInfo.theVar.varIndex;
         if($a.theInfo.theType ==Type.INT){
            TextCode.add("\%t" + varCount + " = call i32 (i8*, ...) @printf(i8* noundef getelementptr inbounds (["
                         + formatStrLength + " x i8], ["
                         + formatStrLength + " x i8]* @.str" + formatStrIndex + ", i64 0, i64 0), i32 noundef \%t"
                         + exprIndex + ")");
         }else if($a.theInfo.theType == Type.FLOAT){
            TextCode.add("\%t" + varCount + " = fpext float \%t" + exprIndex + " to double");
            int doubleExprIndex = varCount;
            varCount++;
            TextCode.add("\%t" + varCount + " = call i32 (i8*, ...) @printf(i8* noundef getelementptr inbounds (["
                         + formatStrLength + " x i8], ["
                         + formatStrLength + " x i8]* @.str" + formatStrIndex + ", i64 0, i64 0), double noundef \%t"
                         + doubleExprIndex + ")");
         }
       
      }else {
         // No arithmetic expression, just print the string
         TextCode.add("\%t" + varCount + " = call i32 (i8*, ...) @printf(i8* noundef getelementptr inbounds (["
                      + formatStrLength + " x i8], ["
                      + formatStrLength + " x i8]* @.str" + formatStrIndex + ", i64 0, i64 0))");
      }
      varCount++;

   }
   |SCANF'(' s=STRING_LITERAL',''&'id=Identifier')'
   {
      //先確認 type 目前只INT可以用
      if(symtab.get($id.text).theType != Type.INT){
         System.out.println("Error! "+$func_call.start.getLine()+
			   ": Type mismatch for the scanf only INT legal.");
            System.exit(0);
      }
      String formatStr = $s.text.substring(1, $s.text.length()-1 );
      long count = $s.text.chars().filter(ch -> ch =='\\').count();
      long formatStrLength = formatStr.length()-count+1;
      int formatStrIndex = varCount;
      varCount++;

      // Declare and initialize the format string
      Print_str.add("@.str" + formatStrIndex + " = private unnamed_addr constant [" 
                   + formatStrLength + " x i8] c\"" + formatStr.replace("\\n", "\\0A") + "\\00\", align 1");
      int varIndex = symtab.get($id.text).theVar.varIndex;
      TextCode.add("\%t" + varCount + " = call i32 (i8*, ...) @scanf(i8* noundef getelementptr inbounds (["
                   + formatStrLength + " x i8], ["
                   + formatStrLength + " x i8]* @.str" + formatStrIndex + ", i64 0, i64 0), i32* noundef \%t"
                   + varIndex + ")");
      varCount++;

   }
   |RETURN (arith_expression)
   ;



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

STRING_LITERAL
    :  '"' ( EscapeSequence | ~('\\'|'"') )* '"'
    ;

WS:( ' ' | '\t' | '\r' | '\n' ) {$channel=HIDDEN;};
COMMENT1: '//'(.)*'\n'{$channel=HIDDEN;};
COMMENT2:'/*' .* '*/' {$channel=HIDDEN;};


fragment
EscapeSequence
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
    ;
