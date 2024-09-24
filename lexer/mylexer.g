lexer grammar mylexer;

options {
  language = Java;
}

//INCLUDE_LIB : '#'(WS)*'include'(WS)*'<'(LETTER | '.')+'>';
//PRINTF: 'printf''(' (.)*  ',' (.)* ')';
//MAIN_FUNC: INT_TYPE WS MAIN L_PAREM R_PAREM L_BRACE (NEW_LINE | .)+ R_BRACE;
//Func:(INT_TYPE|CHAR_TYPE|VOID_TYPE|FLOAT_TYPE) WS ID L_BRACE R_BRACE ;

/*----------------------*/
/*   Reserved Keywords  */
/*----------------------*/
INT_TYPE  : 'integer' | 'int';
CHAR_TYPE : 'char';
VOID_TYPE : 'void';
FLOAT_TYPE: 'float';
DOUBLE_TYPE: 'double';
SHORT_TYPE: 'short';
SIGNED: 'signed';
UNSIGNED: 'unsigned';
CONST: 'const';
MAIN: 'main';
RETURN: 'return';
TYPE: 'typedef';

//flow control
IF: 'if';
ELSE: 'else';
WHILE: 'while';
BREAK: 'break';
CONTINUE: 'continue';
SWITCH: 'switch';
CASE: 'case';
FOR: 'for';

//function
PRINTF: 'printf';
SCANF: 'scanf';


/*----------------------*/
/*  Compound Operators  */
/*----------------------*/
//relational operator
EQ_OP : '==';
LE_OP : '<=';
GE_OP : '>=';
NE_OP : '!=';
LARGER: '>';
SMALLER: '<';

//unary operator
PP_OP : '++';
MM_OP : '--'; 

//Bitwise operator
RSHIFT_OP : '<<';
LSHIFT_OP : '>>';
BITAND: '&';
BITOR: '|';
BITNOT: '~';

//arithmetic operator
ADD: '+';
SUB:'-';
MUL: '*';
DIV: '/';
MOD: '%';

//assignment operator
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


/*----flow control----*/
//IFEL_stste:IF L_PAREM .+ R_PAREM L_BRACE .+ R_BRACE (ELIF L_PAREM .+ R_PAREM L_BRACE .+ R_BRACE)+ (ELSE L_BRACE .* R_BRACE)?;
//IF_state:IF L_PAREM .+ R_PAREM L_BRACE .+ R_BRACE;




STRING: String;
CHAR: '\''(.)'\'';
DEC_NUM : ('0' | ('1'..'9')(DIGIT)*);

ID : (LETTER)(LETTER | DIGIT)*;

FLOAT_NUM: FLOAT_NUM1 | FLOAT_NUM2 | FLOAT_NUM3;
fragment FLOAT_NUM1: (DIGIT)+'.'(DIGIT)*;
fragment FLOAT_NUM2: '.'(DIGIT)+;
fragment FLOAT_NUM3: (DIGIT)+;
 

/* Comments */
COMMENT1 : '//'(.)*'\n';
COMMENT2 : '/*' (options{greedy=false;}: .)* '*/';


NEW_LINE: '\n';

fragment LETTER : 'a'..'z' | 'A'..'Z' | '_';
fragment DIGIT : '0'..'9';
fragment String: '"'(.)*'"';


WS  : (' '|'\r'|'\t')+
    ;
