grammar myparser;

options {
   language = Java;
}

@header {
    // import packages here.
}

@members {
    boolean TRACEON = true;
}
//程式的入口點，定義了程式的主要結構
program:include_lib* type MAIN '(' ')' '{' statements '}'               
        {if (TRACEON) System.out.println("program:include_lib* type MAIN ( ) { statements } ");};
//include
include_lib:HASH INCLUDE '<'lIBRARY'>'
            {if (TRACEON) System.out.println("include_lib:HASH INCLUDE <LIBRARY>");};

//定義了變量的聲明。它可以是一系列類型（type）和標識符（Identifier）的組合，以分號結尾。
/*declarations:type Identifier 
             { if (TRACEON) System.out.println("declarations: type Identifier"); }
           | { if (TRACEON) System.out.println("declarations: ");} ;*/

// 定義了變量的數據類型
type:INT { if (TRACEON) System.out.println("type: INT"); }
   | FLOAT {if (TRACEON) System.out.println("type: FLOAT"); }
   | CHAR {if (TRACEON) System.out.println("type: CHAR"); }
   | DOUBLE {if (TRACEON) System.out.println("type: DOUBLE"); }
   | VOID {if (TRACEON) System.out.println("type: VOID");};

//定義了語句的組合，可以是一系列語句的序列。
statements:statement statements  { if (TRACEON) System.out.println("statements:statement statements"); }
        |                       { if (TRACEON) System.out.println("statements:"); };

//定義了算術表達式的語法，包括加法和減法操作。
arith_expression: multExpr( '+' multExpr| '-' multExpr)*  { if (TRACEON) System.out.println("arith_expression: multExpr( + multExpr| - multExpr)*"); };

//定義了乘法表達式的語法，包括乘法和除法操作。
multExpr: signExpr( '*' signExpr| '/' signExpr)* 
        { if (TRACEON) System.out.println("signExpr( * signExpr| / signExpr)* "); };

//基本表達式或一個負號加上一個基本表達式
signExpr: double_add_sub| '-' double_add_sub 
        { if (TRACEON) System.out.println("signExpr: double_add_sub| - double_add_sub "); };

//double add sub  只有後綴可以
double_add_sub : primaryExpr('--'|'++')? 
        { if (TRACEON) System.out.println("double_add_sub : primaryExpr('--'|'++')? "); };  

//可以是整數常量（Integer_constant）、浮點數常量（Floating_point_constant）、
//      標識符（Identifier）、或者括號中的算術表達式。
primaryExpr: Integer_constant                   { if (TRACEON) System.out.println("primaryExpr: Integer_constant"); }
           | Floating_point_constant            { if (TRACEON) System.out.println("primaryExpr: Floating_point_constant"); }
           | Identifier                         { if (TRACEON) System.out.println("primaryExpr: Identifier"); }
	   | '(' arith_expression ')'           { if (TRACEON) System.out.println("primaryExpr: (arith_expression )"); }
           ;
//比較運算
compare_expression: Identifier relate_op ( Identifier | Integer_constant | Floating_point_constant) 
                { if (TRACEON) System.out.println("compare_expression: Identifier relate_op ( Identifier | Integer_constant | Floating_point_constant) "); };

//定義了語句的形式，可以是賦值語句或者if語句
statement: flow                 { if (TRACEON) System.out.println("statement: flow "); }
         | assign ';'           { if (TRACEON) System.out.println("statement: assign ;  "); }
         | func_call ';'        { if (TRACEON) System.out.println("statement: func_call ; "); };

//assign
assign:(INT|FLOAT|DOUBLE|SHORT) Identifier ('=' arith_expression)?    { if (TRACEON) System.out.println("assign:(INT|FLOAT|DOUBLE|SHORT) Identifier (= arith_expression)?"); }
        | Identifier assign_op arith_expression                       { if (TRACEON) System.out.println("assign: Identifier assign_op arith_expression"); }
       | CHAR char_or_string                                          { if (TRACEON) System.out.println("assign:CHAR char_or_string"); } ;

char_or_string: Identifier'['(arith_expression)?']' '=' String_s        { if (TRACEON) System.out.println("char_or_string: Identifier[(arith_expression)?] = String_s "); }
                | Identifier '=' Charliteral                            { if (TRACEON) System.out.println("char_or_string: Identifier '=' Charliteral "); };

//flow
flow: IF'(' (arith_expression | compare_expression) ')' if_then_statements                      { if (TRACEON) System.out.println("flow: IF( (arith_expression | compare_expression) ) if_then_statements  "); }
        |WHILE'(' (arith_expression | compare_expression)')' while_statement                    { if (TRACEON) System.out.println("flow: WHILE( (arith_expression | compare_expression)) while_statement"); }
        |FOR'(' assign ';' compare_expression ';' arith_expression ')' '{' statements '}'       { if (TRACEON) System.out.println("flow: FOR( assign ; compare_expression ; arith_expression ) { statements }"); }
        |(BREAK|CONTINUE) ';'                                                                   { if (TRACEON) System.out.println("flow: (BREAK|CONTINUE) ; "); };

//定義了if語句的結構，可以是單個語句或者一系列語句的區塊
if_then_statements: statement                           { if (TRACEON) System.out.println("if_then_statement : statement "); }
                | '{' statements '}'only_if_or_else     { if (TRACEON) System.out.println("if_then_statement : { statements } only_if_or_else"); };

//only if or if _else
only_if_or_else:ELSE middle_else        { if (TRACEON) System.out.println("only_if_or_else :ELSE middle_else"); }
                |                       { if (TRACEON) System.out.println("only_if_or_else :"); };

//分辨 else OR else if
middle_else: IF'('  (arith_expression | compare_expression)')' if_then_statements       { if (TRACEON) System.out.println("middle_else: IF'('  (arith_expression | compare_expression)')' if_then_statements"); }
        | last_else_statements                                                          { if (TRACEON) System.out.println("middle_else: last_else_statements "); } ;
//FINAL_ELSE
last_else_statements: '{' statements'}' { if (TRACEON) System.out.println("last_else_statements: { statements}"); };
//While_statement
while_statement:statement  { if (TRACEON) System.out.println("while_statement: statement"); }
        |'{' statements '}'{ if (TRACEON) System.out.println("while_statement: {statements}"); };

//data_read_write
func_call: PRINTF'(' '"' (print_get_var)* ')'           { if (TRACEON) System.out.println("PRINTF( '\"' (print_get_var)* )   "); }
        | SCANF '(' '"'  (scanf_get_var)* ')'           { if (TRACEON) System.out.println("SCANF ( '\"' (scanf_get_var)* )   "); }
        | RETURN (arith_expression|String_s|Charliteral){ if (TRACEON) System.out.println("RETURN (arith_expression|String_s|Charliteral)"); };

//get_var
scanf_get_var: '%'('d'|'f') scanf_get_var ',' '&'Identifier             { if (TRACEON) System.out.println("scanf_get_var: '\%'(d|f) scanf_get_var , &Identifier "); }|'"'  { if (TRACEON) System.out.println("scanf_get_var: '\"'"); };
print_get_var:  '%'('d'|'f')  print_get_var ','Identifier               { if (TRACEON) System.out.println("print_get_var:  '\%'(d|f)  print_get_var ,Identifier "); }|'"'  { if (TRACEON) System.out.println("print_get_var: '\"'"); };

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
COMMENT:'/*' .* '*/' {$channel=HIDDEN;};
