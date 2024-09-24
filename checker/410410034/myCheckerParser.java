// $ANTLR 3.5.3 myChecker.g 2024-05-03 23:14:48

    // import packages here.
    import java.util.HashMap;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class myCheckerParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ADD", "ADD_ASSIGN", "AND", "ASSIGN", 
		"BREAK", "CHAR", "COLON", "COMMA", "COMMENT1", "COMMENT2", "CONTINUE", 
		"Charliteral", "DIV", "DIV_ASSIGN", "DOT", "DOUBLE", "ELSE", "END", "EQ_OP", 
		"FLOAT", "FOR", "Floating_point_constant", "GE_OP", "HASH", "IF", "INCLUDE", 
		"INT", "Identifier", "Integer_constant", "LARGER", "LE_OP", "L_BRACE", 
		"L_BRACKET", "L_PAREN", "MAIN", "MM_OP", "MOD", "MUL", "MUL_ASSIGN", "NE_OP", 
		"NOT", "OR", "PP_OP", "PRINTF", "RETURN", "R_BRACE", "R_BRACKET", "R_PAREN", 
		"SCANF", "SHORT", "SMALLER", "SUB", "SUB_ASSIGN", "Semicolon", "String_s", 
		"UNDERSCORE", "VOID", "WHILE", "WS", "'\"'", "'&'", "'c'", "'d'", "'f'", 
		"'s'"
	};
	public static final int EOF=-1;
	public static final int T__63=63;
	public static final int T__64=64;
	public static final int T__65=65;
	public static final int T__66=66;
	public static final int T__67=67;
	public static final int T__68=68;
	public static final int ADD=4;
	public static final int ADD_ASSIGN=5;
	public static final int AND=6;
	public static final int ASSIGN=7;
	public static final int BREAK=8;
	public static final int CHAR=9;
	public static final int COLON=10;
	public static final int COMMA=11;
	public static final int COMMENT1=12;
	public static final int COMMENT2=13;
	public static final int CONTINUE=14;
	public static final int Charliteral=15;
	public static final int DIV=16;
	public static final int DIV_ASSIGN=17;
	public static final int DOT=18;
	public static final int DOUBLE=19;
	public static final int ELSE=20;
	public static final int END=21;
	public static final int EQ_OP=22;
	public static final int FLOAT=23;
	public static final int FOR=24;
	public static final int Floating_point_constant=25;
	public static final int GE_OP=26;
	public static final int HASH=27;
	public static final int IF=28;
	public static final int INCLUDE=29;
	public static final int INT=30;
	public static final int Identifier=31;
	public static final int Integer_constant=32;
	public static final int LARGER=33;
	public static final int LE_OP=34;
	public static final int L_BRACE=35;
	public static final int L_BRACKET=36;
	public static final int L_PAREN=37;
	public static final int MAIN=38;
	public static final int MM_OP=39;
	public static final int MOD=40;
	public static final int MUL=41;
	public static final int MUL_ASSIGN=42;
	public static final int NE_OP=43;
	public static final int NOT=44;
	public static final int OR=45;
	public static final int PP_OP=46;
	public static final int PRINTF=47;
	public static final int RETURN=48;
	public static final int R_BRACE=49;
	public static final int R_BRACKET=50;
	public static final int R_PAREN=51;
	public static final int SCANF=52;
	public static final int SHORT=53;
	public static final int SMALLER=54;
	public static final int SUB=55;
	public static final int SUB_ASSIGN=56;
	public static final int Semicolon=57;
	public static final int String_s=58;
	public static final int UNDERSCORE=59;
	public static final int VOID=60;
	public static final int WHILE=61;
	public static final int WS=62;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public myCheckerParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public myCheckerParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return myCheckerParser.tokenNames; }
	@Override public String getGrammarFileName() { return "myChecker.g"; }


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
	      



	// $ANTLR start "program"
	// myChecker.g:29:1: program : ( include_lib )* type MAIN '(' ')' '{' statements '}' ;
	public final void program() throws RecognitionException {
		try {
			// myChecker.g:29:8: ( ( include_lib )* type MAIN '(' ')' '{' statements '}' )
			// myChecker.g:29:9: ( include_lib )* type MAIN '(' ')' '{' statements '}'
			{
			// myChecker.g:29:9: ( include_lib )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==HASH) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// myChecker.g:29:9: include_lib
					{
					pushFollow(FOLLOW_include_lib_in_program21);
					include_lib();
					state._fsp--;

					}
					break;

				default :
					break loop1;
				}
			}

			pushFollow(FOLLOW_type_in_program24);
			type();
			state._fsp--;

			match(input,MAIN,FOLLOW_MAIN_in_program26); 
			match(input,L_PAREN,FOLLOW_L_PAREN_in_program28); 
			match(input,R_PAREN,FOLLOW_R_PAREN_in_program30); 
			match(input,L_BRACE,FOLLOW_L_BRACE_in_program32); 
			pushFollow(FOLLOW_statements_in_program34);
			statements();
			state._fsp--;

			match(input,R_BRACE,FOLLOW_R_BRACE_in_program36); 
			if (TRACEON) System.out.println("program:include_lib* type MAIN ( ) { statements } ");
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "program"



	// $ANTLR start "include_lib"
	// myChecker.g:32:1: include_lib : HASH INCLUDE '<' lIBRARY '>' ;
	public final void include_lib() throws RecognitionException {
		try {
			// myChecker.g:32:12: ( HASH INCLUDE '<' lIBRARY '>' )
			// myChecker.g:32:13: HASH INCLUDE '<' lIBRARY '>'
			{
			match(input,HASH,FOLLOW_HASH_in_include_lib67); 
			match(input,INCLUDE,FOLLOW_INCLUDE_in_include_lib69); 
			match(input,SMALLER,FOLLOW_SMALLER_in_include_lib71); 
			pushFollow(FOLLOW_lIBRARY_in_include_lib72);
			lIBRARY();
			state._fsp--;

			match(input,LARGER,FOLLOW_LARGER_in_include_lib73); 
			if (TRACEON) System.out.println("include_lib:HASH INCLUDE <LIBRARY>");
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "include_lib"



	// $ANTLR start "type"
	// myChecker.g:37:1: type returns [TypeInfo typeInfo] : ( INT | FLOAT | CHAR | DOUBLE | VOID );
	public final TypeInfo type() throws RecognitionException {
		TypeInfo typeInfo = null;


		try {
			// myChecker.g:38:2: ( INT | FLOAT | CHAR | DOUBLE | VOID )
			int alt2=5;
			switch ( input.LA(1) ) {
			case INT:
				{
				alt2=1;
				}
				break;
			case FLOAT:
				{
				alt2=2;
				}
				break;
			case CHAR:
				{
				alt2=3;
				}
				break;
			case DOUBLE:
				{
				alt2=4;
				}
				break;
			case VOID:
				{
				alt2=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}
			switch (alt2) {
				case 1 :
					// myChecker.g:38:3: INT
					{
					match(input,INT,FOLLOW_INT_in_type102); 
					 if (TRACEON) System.out.println("type: INT")		; typeInfo= TypeInfo.Integer;
					}
					break;
				case 2 :
					// myChecker.g:39:6: FLOAT
					{
					match(input,FLOAT,FOLLOW_FLOAT_in_type111); 
					if (TRACEON) System.out.println("type: FLOAT")	; typeInfo= TypeInfo.Float;
					}
					break;
				case 3 :
					// myChecker.g:40:6: CHAR
					{
					match(input,CHAR,FOLLOW_CHAR_in_type120); 
					if (TRACEON) System.out.println("type: CHAR")	; typeInfo= TypeInfo.Char;
					}
					break;
				case 4 :
					// myChecker.g:41:6: DOUBLE
					{
					match(input,DOUBLE,FOLLOW_DOUBLE_in_type129); 
					if (TRACEON) System.out.println("type: DOUBLE"); typeInfo= TypeInfo.Double;
					}
					break;
				case 5 :
					// myChecker.g:42:6: VOID
					{
					match(input,VOID,FOLLOW_VOID_in_type138); 
					if (TRACEON) System.out.println("type: VOID")	; typeInfo= TypeInfo.Void;
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return typeInfo;
	}
	// $ANTLR end "type"



	// $ANTLR start "statements"
	// myChecker.g:45:1: statements : ( statement statements |);
	public final void statements() throws RecognitionException {
		try {
			// myChecker.g:45:11: ( statement statements |)
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( ((LA3_0 >= BREAK && LA3_0 <= CHAR)||LA3_0==CONTINUE||LA3_0==DOUBLE||(LA3_0 >= FLOAT && LA3_0 <= FOR)||LA3_0==IF||(LA3_0 >= INT && LA3_0 <= Identifier)||(LA3_0 >= PRINTF && LA3_0 <= RETURN)||(LA3_0 >= SCANF && LA3_0 <= SHORT)||LA3_0==WHILE) ) {
				alt3=1;
			}
			else if ( (LA3_0==R_BRACE) ) {
				alt3=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// myChecker.g:45:12: statement statements
					{
					pushFollow(FOLLOW_statement_in_statements147);
					statement();
					state._fsp--;

					pushFollow(FOLLOW_statements_in_statements149);
					statements();
					state._fsp--;

					 if (TRACEON) System.out.println("statements:statement statements"); 
					}
					break;
				case 2 :
					// myChecker.g:46:33: 
					{
					 if (TRACEON) System.out.println("statements:"); 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "statements"



	// $ANTLR start "arith_expression"
	// myChecker.g:49:1: arith_expression returns [TypeInfo typeInfo] : a= multExpr ( '+' b= multExpr | '-' c= multExpr )* ;
	public final TypeInfo arith_expression() throws RecognitionException {
		TypeInfo typeInfo = null;


		ParserRuleReturnScope a =null;
		ParserRuleReturnScope b =null;
		ParserRuleReturnScope c =null;

		try {
			// myChecker.g:50:2: (a= multExpr ( '+' b= multExpr | '-' c= multExpr )* )
			// myChecker.g:50:3: a= multExpr ( '+' b= multExpr | '-' c= multExpr )*
			{
			pushFollow(FOLLOW_multExpr_in_arith_expression203);
			a=multExpr();
			state._fsp--;

			typeInfo = (a!=null?((myCheckerParser.multExpr_return)a).typeInfo:null);
			// myChecker.g:51:2: ( '+' b= multExpr | '-' c= multExpr )*
			loop4:
			while (true) {
				int alt4=3;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==ADD) ) {
					alt4=1;
				}
				else if ( (LA4_0==SUB) ) {
					alt4=2;
				}

				switch (alt4) {
				case 1 :
					// myChecker.g:51:4: '+' b= multExpr
					{
					match(input,ADD,FOLLOW_ADD_in_arith_expression210); 
					pushFollow(FOLLOW_multExpr_in_arith_expression215);
					b=multExpr();
					state._fsp--;


							if((a!=null?((myCheckerParser.multExpr_return)a).typeInfo:null)!=(b!=null?((myCheckerParser.multExpr_return)b).typeInfo:null)){
								System.out.println("Error! "+(a!=null?(a.start):null).getLine()+
								": Type mismatch for the operator '+'in an expression.");
								typeInfo = TypeInfo.Error;
							}
						
					}
					break;
				case 2 :
					// myChecker.g:59:4: '-' c= multExpr
					{
					match(input,SUB,FOLLOW_SUB_in_arith_expression223); 
					pushFollow(FOLLOW_multExpr_in_arith_expression228);
					c=multExpr();
					state._fsp--;


							if((a!=null?((myCheckerParser.multExpr_return)a).typeInfo:null)!=(c!=null?((myCheckerParser.multExpr_return)c).typeInfo:null)){
								System.out.println("Error! "+(a!=null?(a.start):null).getLine()+
								": Type mismatch for the operator '-' in an expression.");
								typeInfo = TypeInfo.Error;
							}
						
					}
					break;

				default :
					break loop4;
				}
			}

			 if (TRACEON) System.out.println("arith_expression: multExpr( + multExpr| - multExpr)*"); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return typeInfo;
	}
	// $ANTLR end "arith_expression"


	public static class multExpr_return extends ParserRuleReturnScope {
		public TypeInfo typeInfo;
	};


	// $ANTLR start "multExpr"
	// myChecker.g:71:1: multExpr returns [TypeInfo typeInfo] : a= signExpr ( '*' b= signExpr | '/' c= signExpr )* ;
	public final myCheckerParser.multExpr_return multExpr() throws RecognitionException {
		myCheckerParser.multExpr_return retval = new myCheckerParser.multExpr_return();
		retval.start = input.LT(1);

		ParserRuleReturnScope a =null;
		ParserRuleReturnScope b =null;
		ParserRuleReturnScope c =null;

		try {
			// myChecker.g:72:2: (a= signExpr ( '*' b= signExpr | '/' c= signExpr )* )
			// myChecker.g:72:4: a= signExpr ( '*' b= signExpr | '/' c= signExpr )*
			{
			pushFollow(FOLLOW_signExpr_in_multExpr257);
			a=signExpr();
			state._fsp--;

			retval.typeInfo = (a!=null?((myCheckerParser.signExpr_return)a).typeInfo:null); 
			// myChecker.g:73:2: ( '*' b= signExpr | '/' c= signExpr )*
			loop5:
			while (true) {
				int alt5=3;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==MUL) ) {
					alt5=1;
				}
				else if ( (LA5_0==DIV) ) {
					alt5=2;
				}

				switch (alt5) {
				case 1 :
					// myChecker.g:73:4: '*' b= signExpr
					{
					match(input,MUL,FOLLOW_MUL_in_multExpr264); 
					pushFollow(FOLLOW_signExpr_in_multExpr269);
					b=signExpr();
					state._fsp--;


							if((a!=null?((myCheckerParser.signExpr_return)a).typeInfo:null)!= (b!=null?((myCheckerParser.signExpr_return)b).typeInfo:null)){
								System.out.println("Error! "+(a!=null?(a.start):null).getLine()+
								": Type mismatch for the operator '*' in an expression.");
								retval.typeInfo = TypeInfo.Error;
							 }
						
					}
					break;
				case 2 :
					// myChecker.g:81:4: '/' c= signExpr
					{
					match(input,DIV,FOLLOW_DIV_in_multExpr277); 
					pushFollow(FOLLOW_signExpr_in_multExpr282);
					c=signExpr();
					state._fsp--;


							if((a!=null?((myCheckerParser.signExpr_return)a).typeInfo:null)!= (c!=null?((myCheckerParser.signExpr_return)c).typeInfo:null)){
								System.out.println("Error! "+(a!=null?(a.start):null).getLine()+
								": Type mismatch for the operator '/' in an expression.");
								retval.typeInfo = TypeInfo.Error;
							 }
						
					}
					break;

				default :
					break loop5;
				}
			}

			 if (TRACEON) System.out.println("signExpr( * signExpr| / signExpr)* "); 
			}

			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "multExpr"


	public static class signExpr_return extends ParserRuleReturnScope {
		public TypeInfo typeInfo;
	};


	// $ANTLR start "signExpr"
	// myChecker.g:93:1: signExpr returns [TypeInfo typeInfo] : (a= double_add_sub | '-' b= double_add_sub );
	public final myCheckerParser.signExpr_return signExpr() throws RecognitionException {
		myCheckerParser.signExpr_return retval = new myCheckerParser.signExpr_return();
		retval.start = input.LT(1);

		ParserRuleReturnScope a =null;
		ParserRuleReturnScope b =null;

		try {
			// myChecker.g:94:2: (a= double_add_sub | '-' b= double_add_sub )
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==Floating_point_constant||(LA6_0 >= Identifier && LA6_0 <= Integer_constant)||LA6_0==L_PAREN) ) {
				alt6=1;
			}
			else if ( (LA6_0==SUB) ) {
				alt6=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}

			switch (alt6) {
				case 1 :
					// myChecker.g:94:6: a= double_add_sub
					{
					pushFollow(FOLLOW_double_add_sub_in_signExpr314);
					a=double_add_sub();
					state._fsp--;

					retval.typeInfo = (a!=null?((myCheckerParser.double_add_sub_return)a).typeInfo:null); 
					}
					break;
				case 2 :
					// myChecker.g:95:4: '-' b= double_add_sub
					{
					match(input,SUB,FOLLOW_SUB_in_signExpr321); 
					pushFollow(FOLLOW_double_add_sub_in_signExpr326);
					b=double_add_sub();
					state._fsp--;

					retval.typeInfo = (b!=null?((myCheckerParser.double_add_sub_return)b).typeInfo:null); 
					 if (TRACEON) System.out.println("signExpr: double_add_sub| - double_add_sub "); 
					}
					break;

			}
			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "signExpr"


	public static class double_add_sub_return extends ParserRuleReturnScope {
		public TypeInfo typeInfo;
	};


	// $ANTLR start "double_add_sub"
	// myChecker.g:99:1: double_add_sub returns [TypeInfo typeInfo] : a= primaryExpr ( '--' | '++' )? ;
	public final myCheckerParser.double_add_sub_return double_add_sub() throws RecognitionException {
		myCheckerParser.double_add_sub_return retval = new myCheckerParser.double_add_sub_return();
		retval.start = input.LT(1);

		ParserRuleReturnScope a =null;

		try {
			// myChecker.g:100:2: (a= primaryExpr ( '--' | '++' )? )
			// myChecker.g:100:4: a= primaryExpr ( '--' | '++' )?
			{
			pushFollow(FOLLOW_primaryExpr_in_double_add_sub355);
			a=primaryExpr();
			state._fsp--;

			retval.typeInfo = (a!=null?((myCheckerParser.primaryExpr_return)a).typeInfo:null);
			// myChecker.g:102:2: ( '--' | '++' )?
			int alt7=3;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==MM_OP) ) {
				alt7=1;
			}
			else if ( (LA7_0==PP_OP) ) {
				alt7=2;
			}
			switch (alt7) {
				case 1 :
					// myChecker.g:102:3: '--'
					{
					match(input,MM_OP,FOLLOW_MM_OP_in_double_add_sub362); 

							if(retval.typeInfo != TypeInfo.Integer){
								System.out.println("Error! "+(retval.start).getLine()+": -- need Integer type primaryExpr.");
								retval.typeInfo =TypeInfo.Error;
							}
						
					}
					break;
				case 2 :
					// myChecker.g:109:3: '++'
					{
					match(input,PP_OP,FOLLOW_PP_OP_in_double_add_sub369); 

							if(retval.typeInfo != TypeInfo.Integer){
								System.out.println("Error! "+(retval.start).getLine()+": ++ need Integer type primaryExpr.");
								retval.typeInfo =TypeInfo.Error;
							}
						
					}
					break;

			}

			 if (TRACEON) System.out.println("double_add_sub : primaryExpr('--'|'++')? "); 
			}

			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "double_add_sub"


	public static class primaryExpr_return extends ParserRuleReturnScope {
		public TypeInfo typeInfo;
	};


	// $ANTLR start "primaryExpr"
	// myChecker.g:121:1: primaryExpr returns [TypeInfo typeInfo] : ( Integer_constant | Floating_point_constant | Identifier | '(' arith_expression ')' );
	public final myCheckerParser.primaryExpr_return primaryExpr() throws RecognitionException {
		myCheckerParser.primaryExpr_return retval = new myCheckerParser.primaryExpr_return();
		retval.start = input.LT(1);

		Token Identifier1=null;
		TypeInfo arith_expression2 =null;

		try {
			// myChecker.g:122:2: ( Integer_constant | Floating_point_constant | Identifier | '(' arith_expression ')' )
			int alt8=4;
			switch ( input.LA(1) ) {
			case Integer_constant:
				{
				alt8=1;
				}
				break;
			case Floating_point_constant:
				{
				alt8=2;
				}
				break;
			case Identifier:
				{
				alt8=3;
				}
				break;
			case L_PAREN:
				{
				alt8=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}
			switch (alt8) {
				case 1 :
					// myChecker.g:122:4: Integer_constant
					{
					match(input,Integer_constant,FOLLOW_Integer_constant_in_primaryExpr398); 
					 retval.typeInfo = TypeInfo.Integer 			; if (TRACEON) System.out.println("primaryExpr: Integer_constant"); 
					}
					break;
				case 2 :
					// myChecker.g:123:7: Floating_point_constant
					{
					match(input,Floating_point_constant,FOLLOW_Floating_point_constant_in_primaryExpr426); 
					 retval.typeInfo = TypeInfo.Float 				; if (TRACEON) System.out.println("primaryExpr: Floating_point_constant"); 
					}
					break;
				case 3 :
					// myChecker.g:124:7: Identifier
					{
					Identifier1=(Token)match(input,Identifier,FOLLOW_Identifier_in_primaryExpr447); 

							if(symtab.containsKey((Identifier1!=null?Identifier1.getText():null))){	//確認是否存在
								retval.typeInfo = symtab.get((Identifier1!=null?Identifier1.getText():null));
								if(retval.typeInfo!=TypeInfo.Integer && retval.typeInfo!=TypeInfo.Float){		//確認格式是不是int float
									System.out.println("Error! "+(retval.start).getLine()+": ID not Int or Float.");
									retval.typeInfo =TypeInfo.Error;
								}
							}else{
								System.out.println("Error! "+ (retval.start).getLine()+": Undeclared identifier.");
							}
							; if (TRACEON) System.out.println("primaryExpr: Identifier"); 
						
					}
					break;
				case 4 :
					// myChecker.g:137:4: '(' arith_expression ')'
					{
					match(input,L_PAREN,FOLLOW_L_PAREN_in_primaryExpr480); 
					pushFollow(FOLLOW_arith_expression_in_primaryExpr482);
					arith_expression2=arith_expression();
					state._fsp--;

					match(input,R_PAREN,FOLLOW_R_PAREN_in_primaryExpr484); 
					 retval.typeInfo = arith_expression2 	;if (TRACEON) System.out.println("primaryExpr: (arith_expression )"); 
					}
					break;

			}
			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "primaryExpr"


	public static class compare_expression_return extends ParserRuleReturnScope {
		public TypeInfo typeInfo;
	};


	// $ANTLR start "compare_expression"
	// myChecker.g:140:1: compare_expression returns [TypeInfo typeInfo] : a= Identifier relate_op (b= Identifier |c= Integer_constant |d= Floating_point_constant ) ;
	public final myCheckerParser.compare_expression_return compare_expression() throws RecognitionException {
		myCheckerParser.compare_expression_return retval = new myCheckerParser.compare_expression_return();
		retval.start = input.LT(1);

		Token a=null;
		Token b=null;
		Token c=null;
		Token d=null;

		try {
			// myChecker.g:141:2: (a= Identifier relate_op (b= Identifier |c= Integer_constant |d= Floating_point_constant ) )
			// myChecker.g:141:5: a= Identifier relate_op (b= Identifier |c= Integer_constant |d= Floating_point_constant )
			{
			a=(Token)match(input,Identifier,FOLLOW_Identifier_in_compare_expression517); 
			pushFollow(FOLLOW_relate_op_in_compare_expression519);
			relate_op();
			state._fsp--;

			 //先確認是否有定義過了
					retval.typeInfo =TypeInfo.Boolean;	//初始化
					if(! symtab.containsKey((a!=null?a.getText():null))){
						System.out.println("Error! "+(retval.start).getLine()+": Undeclared identifier.");
						retval.typeInfo =TypeInfo.Error;
					}
				
			// myChecker.g:150:2: (b= Identifier |c= Integer_constant |d= Floating_point_constant )
			int alt9=3;
			switch ( input.LA(1) ) {
			case Identifier:
				{
				alt9=1;
				}
				break;
			case Integer_constant:
				{
				alt9=2;
				}
				break;
			case Floating_point_constant:
				{
				alt9=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}
			switch (alt9) {
				case 1 :
					// myChecker.g:150:4: b= Identifier
					{
					b=(Token)match(input,Identifier,FOLLOW_Identifier_in_compare_expression532); 
						//確認ID定義過
							if(! symtab.containsKey((b!=null?b.getText():null))){
								System.out.println("Error! "+(retval.start).getLine()+": Undeclared identifier.");
								retval.typeInfo =TypeInfo.Error;
							}
							//ID type check
							if(symtab.get((a!=null?a.getText():null)) != symtab.get((b!=null?b.getText():null))){
								System.out.println("Error! "+(retval.start).getLine()
								+": Type mismatch for the two silde in compare_expression.");
								retval.typeInfo =TypeInfo.Error;
							}
						
					}
					break;
				case 2 :
					// myChecker.g:163:4: c= Integer_constant
					{
					c=(Token)match(input,Integer_constant,FOLLOW_Integer_constant_in_compare_expression543); 

							if(symtab.get((a!=null?a.getText():null)) != TypeInfo.Integer){
								System.out.println("Error! "+(retval.start).getLine()
								+": Type mismatch for the two silde in compare_expression.");
								retval.typeInfo =TypeInfo.Error;
							}
						
					}
					break;
				case 3 :
					// myChecker.g:171:4: d= Floating_point_constant
					{
					d=(Token)match(input,Floating_point_constant,FOLLOW_Floating_point_constant_in_compare_expression554); 

							if(symtab.get((a!=null?a.getText():null)) != TypeInfo.Float){
								System.out.println("Error! "+(retval.start).getLine()
								+": Type mismatch for the two silde in compare_expression.");
								retval.typeInfo =TypeInfo.Error;
							}
						
					}
					break;

			}

			 if (TRACEON) System.out.println("compare_expression: Identifier relate_op ( Identifier | Integer_constant | Floating_point_constant) "); 
			}

			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "compare_expression"



	// $ANTLR start "statement"
	// myChecker.g:183:1: statement : ( flow | assign ';' | func_call ';' );
	public final void statement() throws RecognitionException {
		try {
			// myChecker.g:183:10: ( flow | assign ';' | func_call ';' )
			int alt10=3;
			switch ( input.LA(1) ) {
			case BREAK:
			case CONTINUE:
			case FOR:
			case IF:
			case WHILE:
				{
				alt10=1;
				}
				break;
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case Identifier:
			case SHORT:
				{
				alt10=2;
				}
				break;
			case PRINTF:
			case RETURN:
			case SCANF:
				{
				alt10=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}
			switch (alt10) {
				case 1 :
					// myChecker.g:183:12: flow
					{
					pushFollow(FOLLOW_flow_in_statement574);
					flow();
					state._fsp--;

					 if (TRACEON) System.out.println("statement: flow "); 
					}
					break;
				case 2 :
					// myChecker.g:184:12: assign ';'
					{
					pushFollow(FOLLOW_assign_in_statement605);
					assign();
					state._fsp--;

					match(input,Semicolon,FOLLOW_Semicolon_in_statement607); 
					 if (TRACEON) System.out.println("statement: assign ;  "); 
					}
					break;
				case 3 :
					// myChecker.g:185:12: func_call ';'
					{
					pushFollow(FOLLOW_func_call_in_statement632);
					func_call();
					state._fsp--;

					match(input,Semicolon,FOLLOW_Semicolon_in_statement634); 
					 if (TRACEON) System.out.println("statement: func_call ; "); 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "statement"


	public static class assign_return extends ParserRuleReturnScope {
		public TypeInfo typeInfo;
	};


	// $ANTLR start "assign"
	// myChecker.g:188:1: assign returns [TypeInfo typeInfo] : ( ( INT | FLOAT | DOUBLE | SHORT ) Identifier ( '=' a= arith_expression )? | Identifier assign_op b= arith_expression | CHAR d= char_or_string );
	public final myCheckerParser.assign_return assign() throws RecognitionException {
		myCheckerParser.assign_return retval = new myCheckerParser.assign_return();
		retval.start = input.LT(1);

		Token Identifier3=null;
		Token Identifier4=null;
		TypeInfo a =null;
		TypeInfo b =null;
		ParserRuleReturnScope d =null;

		try {
			// myChecker.g:189:2: ( ( INT | FLOAT | DOUBLE | SHORT ) Identifier ( '=' a= arith_expression )? | Identifier assign_op b= arith_expression | CHAR d= char_or_string )
			int alt13=3;
			switch ( input.LA(1) ) {
			case DOUBLE:
			case FLOAT:
			case INT:
			case SHORT:
				{
				alt13=1;
				}
				break;
			case Identifier:
				{
				alt13=2;
				}
				break;
			case CHAR:
				{
				alt13=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 13, 0, input);
				throw nvae;
			}
			switch (alt13) {
				case 1 :
					// myChecker.g:189:3: ( INT | FLOAT | DOUBLE | SHORT ) Identifier ( '=' a= arith_expression )?
					{
					// myChecker.g:189:3: ( INT | FLOAT | DOUBLE | SHORT )
					int alt11=4;
					switch ( input.LA(1) ) {
					case INT:
						{
						alt11=1;
						}
						break;
					case FLOAT:
						{
						alt11=2;
						}
						break;
					case DOUBLE:
						{
						alt11=3;
						}
						break;
					case SHORT:
						{
						alt11=4;
						}
						break;
					default:
						NoViableAltException nvae =
							new NoViableAltException("", 11, 0, input);
						throw nvae;
					}
					switch (alt11) {
						case 1 :
							// myChecker.g:189:4: INT
							{
							match(input,INT,FOLLOW_INT_in_assign657); 
							retval.typeInfo =TypeInfo.Integer;
							}
							break;
						case 2 :
							// myChecker.g:189:38: FLOAT
							{
							match(input,FLOAT,FOLLOW_FLOAT_in_assign661); 
							retval.typeInfo =TypeInfo.Float;
							}
							break;
						case 3 :
							// myChecker.g:189:72: DOUBLE
							{
							match(input,DOUBLE,FOLLOW_DOUBLE_in_assign665); 
							retval.typeInfo =TypeInfo.Double;
							}
							break;
						case 4 :
							// myChecker.g:189:108: SHORT
							{
							match(input,SHORT,FOLLOW_SHORT_in_assign669); 
							retval.typeInfo =TypeInfo.Short;
							}
							break;

					}

					Identifier3=(Token)match(input,Identifier,FOLLOW_Identifier_in_assign676); 
					 
							if(symtab.containsKey((Identifier3!=null?Identifier3.getText():null))){
								System.out.println("Error! "+ (retval.start).getLine() +": Redeclared identifier.");
								retval.typeInfo = TypeInfo.Error;
							}
						
					// myChecker.g:197:2: ( '=' a= arith_expression )?
					int alt12=2;
					int LA12_0 = input.LA(1);
					if ( (LA12_0==ASSIGN) ) {
						alt12=1;
					}
					switch (alt12) {
						case 1 :
							// myChecker.g:197:3: '=' a= arith_expression
							{
							match(input,ASSIGN,FOLLOW_ASSIGN_in_assign684); 
							pushFollow(FOLLOW_arith_expression_in_assign689);
							a=arith_expression();
							state._fsp--;


									if( !symtab.containsKey((Identifier3!=null?Identifier3.getText():null))){	//沒有被重複定義再來考慮兩邊的type
										if(retval.typeInfo != a){
											System.out.println("Error! "+ (retval.start).getLine() + ": Type mismatch in assign .");
											retval.typeInfo = TypeInfo.Error;
										}
									}	
								
							}
							break;

					}

					 //如果沒有用過+兩邊type正常的話加入symtab
							if(retval.typeInfo != TypeInfo.Error){
								symtab.put((Identifier3!=null?Identifier3.getText():null), retval.typeInfo);
							} 
							if (TRACEON) System.out.println("assign:(INT|FLOAT|DOUBLE|SHORT) Identifier (= arith_expression)?"); 
						
					}
					break;
				case 2 :
					// myChecker.g:213:7: Identifier assign_op b= arith_expression
					{
					Identifier4=(Token)match(input,Identifier,FOLLOW_Identifier_in_assign712); 
					pushFollow(FOLLOW_assign_op_in_assign714);
					assign_op();
					state._fsp--;

					pushFollow(FOLLOW_arith_expression_in_assign718);
					b=arith_expression();
					state._fsp--;

					 
							if(symtab.containsKey((Identifier4!=null?Identifier4.getText():null))){	//檢查ID是否存在 有的話設定回傳的typeInfo
								retval.typeInfo = symtab.get((Identifier4!=null?Identifier4.getText():null));
								//接著檢查此時assign兩邊的資料型態是否相等
								if(retval.typeInfo!= b){
									System.out.println("Error! "+ (retval.start).getLine() + 
									": Type mismatch for the two silde in an assignment statement.");
									retval.typeInfo =TypeInfo.Error;
								}
							}else{		//不存在的話 Error
								System.out.println("Error! "+(retval.start).getLine()+": Undeclared identifier.");
								retval.typeInfo = TypeInfo.Error;
							}
							if (TRACEON) System.out.println("assign: Identifier assign_op arith_expression"); 
						
					}
					break;
				case 3 :
					// myChecker.g:229:7: CHAR d= char_or_string
					{
					match(input,CHAR,FOLLOW_CHAR_in_assign731); 
					pushFollow(FOLLOW_char_or_string_in_assign737);
					d=char_or_string();
					state._fsp--;


							retval.typeInfo =(d!=null?((myCheckerParser.char_or_string_return)d).typeInfo:null);
							if (TRACEON) System.out.println("assign:CHAR char_or_string"); 
						
					}
					break;

			}
			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "assign"


	public static class char_or_string_return extends ParserRuleReturnScope {
		public TypeInfo typeInfo;
	};


	// $ANTLR start "char_or_string"
	// myChecker.g:236:1: char_or_string returns [TypeInfo typeInfo] : ( Identifier '[' (a= arith_expression )? ']' '=' ( String_s | ( Charliteral | Integer_constant | Floating_point_constant ) ) | Identifier '=' ( Charliteral | ( String_s | Integer_constant | Floating_point_constant ) ) );
	public final myCheckerParser.char_or_string_return char_or_string() throws RecognitionException {
		myCheckerParser.char_or_string_return retval = new myCheckerParser.char_or_string_return();
		retval.start = input.LT(1);

		Token Identifier5=null;
		Token Identifier6=null;
		TypeInfo a =null;

		try {
			// myChecker.g:237:2: ( Identifier '[' (a= arith_expression )? ']' '=' ( String_s | ( Charliteral | Integer_constant | Floating_point_constant ) ) | Identifier '=' ( Charliteral | ( String_s | Integer_constant | Floating_point_constant ) ) )
			int alt17=2;
			int LA17_0 = input.LA(1);
			if ( (LA17_0==Identifier) ) {
				int LA17_1 = input.LA(2);
				if ( (LA17_1==L_BRACKET) ) {
					alt17=1;
				}
				else if ( (LA17_1==ASSIGN) ) {
					alt17=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 17, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 17, 0, input);
				throw nvae;
			}

			switch (alt17) {
				case 1 :
					// myChecker.g:237:4: Identifier '[' (a= arith_expression )? ']' '=' ( String_s | ( Charliteral | Integer_constant | Floating_point_constant ) )
					{
					Identifier5=(Token)match(input,Identifier,FOLLOW_Identifier_in_char_or_string755); 
					match(input,L_BRACKET,FOLLOW_L_BRACKET_in_char_or_string756); 
					// myChecker.g:237:17: (a= arith_expression )?
					int alt14=2;
					int LA14_0 = input.LA(1);
					if ( (LA14_0==Floating_point_constant||(LA14_0 >= Identifier && LA14_0 <= Integer_constant)||LA14_0==L_PAREN||LA14_0==SUB) ) {
						alt14=1;
					}
					switch (alt14) {
						case 1 :
							// myChecker.g:237:19: a= arith_expression
							{
							pushFollow(FOLLOW_arith_expression_in_char_or_string763);
							a=arith_expression();
							state._fsp--;

							}
							break;

					}

					match(input,R_BRACKET,FOLLOW_R_BRACKET_in_char_or_string766); 
					match(input,ASSIGN,FOLLOW_ASSIGN_in_char_or_string768); 
						//確認ID是否使用過 + arith_expression是不是整數型態
							retval.typeInfo =TypeInfo.String; 		//先預設為String
							if(symtab.containsKey((Identifier5!=null?Identifier5.getText():null))){
								System.out.println("Error! "+ (retval.start).getLine()+": Redeclared identifier.");
								retval.typeInfo = TypeInfo.Error;
							}
							if(a != TypeInfo.Integer){
								System.out.println("Error! " +(retval.start).getLine()+": String length is not Integer.");
								retval.typeInfo =TypeInfo.Error;
							}
						
					// myChecker.g:249:2: ( String_s | ( Charliteral | Integer_constant | Floating_point_constant ) )
					int alt15=2;
					int LA15_0 = input.LA(1);
					if ( (LA15_0==String_s) ) {
						alt15=1;
					}
					else if ( (LA15_0==Charliteral||LA15_0==Floating_point_constant||LA15_0==Integer_constant) ) {
						alt15=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 15, 0, input);
						throw nvae;
					}

					switch (alt15) {
						case 1 :
							// myChecker.g:249:3: String_s
							{
							match(input,String_s,FOLLOW_String_s_in_char_or_string776); 

									if(retval.typeInfo!=TypeInfo.Error){
										symtab.put((Identifier5!=null?Identifier5.getText():null), retval.typeInfo);
									}
								
							}
							break;
						case 2 :
							// myChecker.g:255:3: ( Charliteral | Integer_constant | Floating_point_constant )
							{
							if ( input.LA(1)==Charliteral||input.LA(1)==Floating_point_constant||input.LA(1)==Integer_constant ) {
								input.consume();
								state.errorRecovery=false;
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								throw mse;
							}

									System.out.println("Error! "+ (retval.start).getLine()+ ": Type mismatch for the two silde in string assign.");
									retval.typeInfo =TypeInfo.String;
								
							}
							break;

					}

					 if (TRACEON) System.out.println("char_or_string: Identifier[(arith_expression)?] = String_s "); 
					}
					break;
				case 2 :
					// myChecker.g:262:7: Identifier '=' ( Charliteral | ( String_s | Integer_constant | Floating_point_constant ) )
					{
					Identifier6=(Token)match(input,Identifier,FOLLOW_Identifier_in_char_or_string814); 
					match(input,ASSIGN,FOLLOW_ASSIGN_in_char_or_string816); 
					// myChecker.g:263:2: ( Charliteral | ( String_s | Integer_constant | Floating_point_constant ) )
					int alt16=2;
					int LA16_0 = input.LA(1);
					if ( (LA16_0==Charliteral) ) {
						alt16=1;
					}
					else if ( (LA16_0==Floating_point_constant||LA16_0==Integer_constant||LA16_0==String_s) ) {
						alt16=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 16, 0, input);
						throw nvae;
					}

					switch (alt16) {
						case 1 :
							// myChecker.g:263:3: Charliteral
							{
							match(input,Charliteral,FOLLOW_Charliteral_in_char_or_string821); 

									if(symtab.containsKey((Identifier6!=null?Identifier6.getText():null))){	//檢查是否使用過
										System.out.println("Error! "+ (retval.start).getLine()+": Redeclared identifier.");
										retval.typeInfo = TypeInfo.Error;
									}else{		//加入table
										retval.typeInfo = TypeInfo.Char;
										symtab.put((Identifier6!=null?Identifier6.getText():null), retval.typeInfo);
									}
								
							}
							break;
						case 2 :
							// myChecker.g:273:4: ( String_s | Integer_constant | Floating_point_constant )
							{
							if ( input.LA(1)==Floating_point_constant||input.LA(1)==Integer_constant||input.LA(1)==String_s ) {
								input.consume();
								state.errorRecovery=false;
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								throw mse;
							}

									System.out.println("Error! "+(retval.start).getLine()+": Type mismatch for the two silde in char assign.");
									retval.typeInfo =TypeInfo.Error;
								
							}
							break;

					}

					 if (TRACEON) System.out.println("char_or_string: Identifier '=' Charliteral "); 
					}
					break;

			}
			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "char_or_string"


	public static class flow_return extends ParserRuleReturnScope {
		public TypeInfo typeInfo;
	};


	// $ANTLR start "flow"
	// myChecker.g:282:1: flow returns [TypeInfo typeInfo] : ( IF '(' ( ( arith_expression | String_s | Charliteral ) |d= compare_expression ) ')' e= if_then_statements | WHILE '(' ( ( arith_expression | String_s | Charliteral ) |f= compare_expression ) ')' while_statement | FOR '(' h= assign ';' ( ( arith_expression | String_s | Charliteral ) |g= compare_expression ) ';' i= arith_expression ')' '{' statements '}' | ( BREAK | CONTINUE ) ';' );
	public final myCheckerParser.flow_return flow() throws RecognitionException {
		myCheckerParser.flow_return retval = new myCheckerParser.flow_return();
		retval.start = input.LT(1);

		ParserRuleReturnScope d =null;
		TypeInfo e =null;
		ParserRuleReturnScope f =null;
		ParserRuleReturnScope h =null;
		ParserRuleReturnScope g =null;
		TypeInfo i =null;

		try {
			// myChecker.g:283:2: ( IF '(' ( ( arith_expression | String_s | Charliteral ) |d= compare_expression ) ')' e= if_then_statements | WHILE '(' ( ( arith_expression | String_s | Charliteral ) |f= compare_expression ) ')' while_statement | FOR '(' h= assign ';' ( ( arith_expression | String_s | Charliteral ) |g= compare_expression ) ';' i= arith_expression ')' '{' statements '}' | ( BREAK | CONTINUE ) ';' )
			int alt24=4;
			switch ( input.LA(1) ) {
			case IF:
				{
				alt24=1;
				}
				break;
			case WHILE:
				{
				alt24=2;
				}
				break;
			case FOR:
				{
				alt24=3;
				}
				break;
			case BREAK:
			case CONTINUE:
				{
				alt24=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 24, 0, input);
				throw nvae;
			}
			switch (alt24) {
				case 1 :
					// myChecker.g:283:4: IF '(' ( ( arith_expression | String_s | Charliteral ) |d= compare_expression ) ')' e= if_then_statements
					{
					match(input,IF,FOLLOW_IF_in_flow863); 
					match(input,L_PAREN,FOLLOW_L_PAREN_in_flow864); 
					// myChecker.g:283:10: ( ( arith_expression | String_s | Charliteral ) |d= compare_expression )
					int alt19=2;
					int LA19_0 = input.LA(1);
					if ( (LA19_0==Charliteral||LA19_0==Floating_point_constant||LA19_0==Integer_constant||LA19_0==L_PAREN||LA19_0==SUB||LA19_0==String_s) ) {
						alt19=1;
					}
					else if ( (LA19_0==Identifier) ) {
						int LA19_2 = input.LA(2);
						if ( (LA19_2==ADD||LA19_2==DIV||LA19_2==MM_OP||LA19_2==MUL||LA19_2==PP_OP||LA19_2==R_PAREN||LA19_2==SUB) ) {
							alt19=1;
						}
						else if ( (LA19_2==EQ_OP||LA19_2==GE_OP||(LA19_2 >= LARGER && LA19_2 <= LE_OP)||LA19_2==NE_OP||LA19_2==SMALLER) ) {
							alt19=2;
						}

						else {
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 19, 2, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 19, 0, input);
						throw nvae;
					}

					switch (alt19) {
						case 1 :
							// myChecker.g:283:11: ( arith_expression | String_s | Charliteral )
							{
							// myChecker.g:283:11: ( arith_expression | String_s | Charliteral )
							int alt18=3;
							switch ( input.LA(1) ) {
							case Floating_point_constant:
							case Identifier:
							case Integer_constant:
							case L_PAREN:
							case SUB:
								{
								alt18=1;
								}
								break;
							case String_s:
								{
								alt18=2;
								}
								break;
							case Charliteral:
								{
								alt18=3;
								}
								break;
							default:
								NoViableAltException nvae =
									new NoViableAltException("", 18, 0, input);
								throw nvae;
							}
							switch (alt18) {
								case 1 :
									// myChecker.g:283:12: arith_expression
									{
									pushFollow(FOLLOW_arith_expression_in_flow868);
									arith_expression();
									state._fsp--;

									}
									break;
								case 2 :
									// myChecker.g:283:29: String_s
									{
									match(input,String_s,FOLLOW_String_s_in_flow870); 
									}
									break;
								case 3 :
									// myChecker.g:283:38: Charliteral
									{
									match(input,Charliteral,FOLLOW_Charliteral_in_flow872); 
									}
									break;

							}

								//輸入的型態錯誤的話 type Error
									System.out.println("Error! "+(retval.start).getLine()+": if condition section type error.");
									retval.typeInfo =TypeInfo.Error;
								
							}
							break;
						case 2 :
							// myChecker.g:288:4: d= compare_expression
							{
							pushFollow(FOLLOW_compare_expression_in_flow887);
							d=compare_expression();
							state._fsp--;

								//輸入type正確 type Void
									if((d!=null?((myCheckerParser.compare_expression_return)d).typeInfo:null) != TypeInfo.Error){
										retval.typeInfo =TypeInfo.Void;
									}else{
										System.out.println("Error! "+(retval.start).getLine()+": if condition section compare error.");
										retval.typeInfo =TypeInfo.Error;
									}
								
							}
							break;

					}

					match(input,R_PAREN,FOLLOW_R_PAREN_in_flow895); 
					pushFollow(FOLLOW_if_then_statements_in_flow902);
					e=if_then_statements();
					state._fsp--;

					 //如果在之後的else if出問題 typeInfo也要改成Error
							retval.typeInfo = e;
							if (TRACEON) System.out.println("flow: IF( (arith_expression | compare_expression) ) if_then_statements  "); 
						
					}
					break;
				case 2 :
					// myChecker.g:303:6: WHILE '(' ( ( arith_expression | String_s | Charliteral ) |f= compare_expression ) ')' while_statement
					{
					match(input,WHILE,FOLLOW_WHILE_in_flow930); 
					match(input,L_PAREN,FOLLOW_L_PAREN_in_flow931); 
					// myChecker.g:303:15: ( ( arith_expression | String_s | Charliteral ) |f= compare_expression )
					int alt21=2;
					int LA21_0 = input.LA(1);
					if ( (LA21_0==Charliteral||LA21_0==Floating_point_constant||LA21_0==Integer_constant||LA21_0==L_PAREN||LA21_0==SUB||LA21_0==String_s) ) {
						alt21=1;
					}
					else if ( (LA21_0==Identifier) ) {
						int LA21_2 = input.LA(2);
						if ( (LA21_2==ADD||LA21_2==DIV||LA21_2==MM_OP||LA21_2==MUL||LA21_2==PP_OP||LA21_2==R_PAREN||LA21_2==SUB) ) {
							alt21=1;
						}
						else if ( (LA21_2==EQ_OP||LA21_2==GE_OP||(LA21_2 >= LARGER && LA21_2 <= LE_OP)||LA21_2==NE_OP||LA21_2==SMALLER) ) {
							alt21=2;
						}

						else {
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 21, 2, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 21, 0, input);
						throw nvae;
					}

					switch (alt21) {
						case 1 :
							// myChecker.g:303:16: ( arith_expression | String_s | Charliteral )
							{
							// myChecker.g:303:16: ( arith_expression | String_s | Charliteral )
							int alt20=3;
							switch ( input.LA(1) ) {
							case Floating_point_constant:
							case Identifier:
							case Integer_constant:
							case L_PAREN:
							case SUB:
								{
								alt20=1;
								}
								break;
							case String_s:
								{
								alt20=2;
								}
								break;
							case Charliteral:
								{
								alt20=3;
								}
								break;
							default:
								NoViableAltException nvae =
									new NoViableAltException("", 20, 0, input);
								throw nvae;
							}
							switch (alt20) {
								case 1 :
									// myChecker.g:303:17: arith_expression
									{
									pushFollow(FOLLOW_arith_expression_in_flow935);
									arith_expression();
									state._fsp--;

									}
									break;
								case 2 :
									// myChecker.g:303:34: String_s
									{
									match(input,String_s,FOLLOW_String_s_in_flow937); 
									}
									break;
								case 3 :
									// myChecker.g:303:43: Charliteral
									{
									match(input,Charliteral,FOLLOW_Charliteral_in_flow939); 
									}
									break;

							}

								//輸入的型態錯誤的話 type Error, 正確 type Void
									System.out.println("Error! "+(retval.start).getLine()+": while condition section type error.");
									retval.typeInfo =TypeInfo.Error;
								
							}
							break;
						case 2 :
							// myChecker.g:308:4: f= compare_expression
							{
							pushFollow(FOLLOW_compare_expression_in_flow953);
							f=compare_expression();
							state._fsp--;


									if((f!=null?((myCheckerParser.compare_expression_return)f).typeInfo:null) != TypeInfo.Error){
										retval.typeInfo =TypeInfo.Void;
									}else{
										System.out.println("Error! "+(retval.start).getLine()+": while condition section compare error.");
										retval.typeInfo =TypeInfo.Error;
									}
								
							}
							break;

					}

					match(input,R_PAREN,FOLLOW_R_PAREN_in_flow960); 
					pushFollow(FOLLOW_while_statement_in_flow962);
					while_statement();
					state._fsp--;

					 if (TRACEON) System.out.println("flow: WHILE( (arith_expression | compare_expression)) while_statement"); 
					}
					break;
				case 3 :
					// myChecker.g:319:6: FOR '(' h= assign ';' ( ( arith_expression | String_s | Charliteral ) |g= compare_expression ) ';' i= arith_expression ')' '{' statements '}'
					{
					match(input,FOR,FOLLOW_FOR_in_flow992); 
					match(input,L_PAREN,FOLLOW_L_PAREN_in_flow993); 
					pushFollow(FOLLOW_assign_in_flow999);
					h=assign();
					state._fsp--;

					match(input,Semicolon,FOLLOW_Semicolon_in_flow1001); 

							retval.typeInfo =TypeInfo.Void;  //先初始化
							if((h!=null?((myCheckerParser.assign_return)h).typeInfo:null) == TypeInfo.Error){ 		// assign錯誤
								System.out.println("Error! "+(retval.start).getLine()+": for init section error.");
								retval.typeInfo = TypeInfo.Error;
							}
						
					// myChecker.g:327:2: ( ( arith_expression | String_s | Charliteral ) |g= compare_expression )
					int alt23=2;
					int LA23_0 = input.LA(1);
					if ( (LA23_0==Charliteral||LA23_0==Floating_point_constant||LA23_0==Integer_constant||LA23_0==L_PAREN||LA23_0==SUB||LA23_0==String_s) ) {
						alt23=1;
					}
					else if ( (LA23_0==Identifier) ) {
						int LA23_2 = input.LA(2);
						if ( (LA23_2==ADD||LA23_2==DIV||LA23_2==MM_OP||LA23_2==MUL||LA23_2==PP_OP||LA23_2==SUB||LA23_2==Semicolon) ) {
							alt23=1;
						}
						else if ( (LA23_2==EQ_OP||LA23_2==GE_OP||(LA23_2 >= LARGER && LA23_2 <= LE_OP)||LA23_2==NE_OP||LA23_2==SMALLER) ) {
							alt23=2;
						}

						else {
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 23, 2, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 23, 0, input);
						throw nvae;
					}

					switch (alt23) {
						case 1 :
							// myChecker.g:327:3: ( arith_expression | String_s | Charliteral )
							{
							// myChecker.g:327:3: ( arith_expression | String_s | Charliteral )
							int alt22=3;
							switch ( input.LA(1) ) {
							case Floating_point_constant:
							case Identifier:
							case Integer_constant:
							case L_PAREN:
							case SUB:
								{
								alt22=1;
								}
								break;
							case String_s:
								{
								alt22=2;
								}
								break;
							case Charliteral:
								{
								alt22=3;
								}
								break;
							default:
								NoViableAltException nvae =
									new NoViableAltException("", 22, 0, input);
								throw nvae;
							}
							switch (alt22) {
								case 1 :
									// myChecker.g:327:4: arith_expression
									{
									pushFollow(FOLLOW_arith_expression_in_flow1010);
									arith_expression();
									state._fsp--;

									}
									break;
								case 2 :
									// myChecker.g:327:21: String_s
									{
									match(input,String_s,FOLLOW_String_s_in_flow1012); 
									}
									break;
								case 3 :
									// myChecker.g:327:30: Charliteral
									{
									match(input,Charliteral,FOLLOW_Charliteral_in_flow1014); 
									}
									break;

							}

								//輸入的型態錯誤的話 type Error, 正確 type Void
									System.out.println("Error! "+(retval.start).getLine()+": for loop condition section type error.");
									retval.typeInfo =TypeInfo.Error;
								
							}
							break;
						case 2 :
							// myChecker.g:332:4: g= compare_expression
							{
							pushFollow(FOLLOW_compare_expression_in_flow1027);
							g=compare_expression();
							state._fsp--;

								//compare_expression錯誤
									if((g!=null?((myCheckerParser.compare_expression_return)g).typeInfo:null) == TypeInfo.Error){
										System.out.println("Error! "+(retval.start).getLine()+": for loop condition section compare error.");
										retval.typeInfo =TypeInfo.Error;
									}
								
							}
							break;

					}

					match(input,Semicolon,FOLLOW_Semicolon_in_flow1036); 
					pushFollow(FOLLOW_arith_expression_in_flow1042);
					i=arith_expression();
					state._fsp--;

					match(input,R_PAREN,FOLLOW_R_PAREN_in_flow1044); 

							if(i == TypeInfo.Error){		//arith_expression 錯誤
								System.out.println("Error! "+(retval.start).getLine()+": for loop increase section error.");
								retval.typeInfo = TypeInfo.Error;
							}
						
					match(input,L_BRACE,FOLLOW_L_BRACE_in_flow1051); 
					pushFollow(FOLLOW_statements_in_flow1053);
					statements();
					state._fsp--;

					match(input,R_BRACE,FOLLOW_R_BRACE_in_flow1055); 
					 if (TRACEON) System.out.println("flow: FOR( assign ; compare_expression ; arith_expression ) { statements }"); 
					}
					break;
				case 4 :
					// myChecker.g:349:6: ( BREAK | CONTINUE ) ';'
					{
					if ( input.LA(1)==BREAK||input.LA(1)==CONTINUE ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					match(input,Semicolon,FOLLOW_Semicolon_in_flow1078); 
					 if (TRACEON) System.out.println("flow: (BREAK|CONTINUE) ; "); 
					}
					break;

			}
			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "flow"



	// $ANTLR start "if_then_statements"
	// myChecker.g:353:1: if_then_statements returns [TypeInfo typeInfo] : ( statement | '{' statements '}' a= only_if_or_else );
	public final TypeInfo if_then_statements() throws RecognitionException {
		TypeInfo typeInfo = null;


		TypeInfo a =null;

		try {
			// myChecker.g:354:2: ( statement | '{' statements '}' a= only_if_or_else )
			int alt25=2;
			int LA25_0 = input.LA(1);
			if ( ((LA25_0 >= BREAK && LA25_0 <= CHAR)||LA25_0==CONTINUE||LA25_0==DOUBLE||(LA25_0 >= FLOAT && LA25_0 <= FOR)||LA25_0==IF||(LA25_0 >= INT && LA25_0 <= Identifier)||(LA25_0 >= PRINTF && LA25_0 <= RETURN)||(LA25_0 >= SCANF && LA25_0 <= SHORT)||LA25_0==WHILE) ) {
				alt25=1;
			}
			else if ( (LA25_0==L_BRACE) ) {
				alt25=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 25, 0, input);
				throw nvae;
			}

			switch (alt25) {
				case 1 :
					// myChecker.g:354:4: statement
					{
					pushFollow(FOLLOW_statement_in_if_then_statements1161);
					statement();
					state._fsp--;

					 
							typeInfo = TypeInfo.Void;
							if (TRACEON) System.out.println("if_then_statement : statement "); 
						
					}
					break;
				case 2 :
					// myChecker.g:359:7: '{' statements '}' a= only_if_or_else
					{
					match(input,L_BRACE,FOLLOW_L_BRACE_in_if_then_statements1199); 
					pushFollow(FOLLOW_statements_in_if_then_statements1201);
					statements();
					state._fsp--;

					match(input,R_BRACE,FOLLOW_R_BRACE_in_if_then_statements1203); 
					pushFollow(FOLLOW_only_if_or_else_in_if_then_statements1209);
					a=only_if_or_else();
					state._fsp--;

					 
							typeInfo = a;
							if (TRACEON) System.out.println("if_then_statement : { statements } only_if_or_else"); 
						
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return typeInfo;
	}
	// $ANTLR end "if_then_statements"



	// $ANTLR start "only_if_or_else"
	// myChecker.g:366:1: only_if_or_else returns [TypeInfo typeInfo] : ( ELSE a= middle_else |);
	public final TypeInfo only_if_or_else() throws RecognitionException {
		TypeInfo typeInfo = null;


		ParserRuleReturnScope a =null;

		try {
			// myChecker.g:367:2: ( ELSE a= middle_else |)
			int alt26=2;
			int LA26_0 = input.LA(1);
			if ( (LA26_0==ELSE) ) {
				alt26=1;
			}
			else if ( ((LA26_0 >= BREAK && LA26_0 <= CHAR)||LA26_0==CONTINUE||LA26_0==DOUBLE||(LA26_0 >= FLOAT && LA26_0 <= FOR)||LA26_0==IF||(LA26_0 >= INT && LA26_0 <= Identifier)||(LA26_0 >= PRINTF && LA26_0 <= R_BRACE)||(LA26_0 >= SCANF && LA26_0 <= SHORT)||LA26_0==WHILE) ) {
				alt26=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 26, 0, input);
				throw nvae;
			}

			switch (alt26) {
				case 1 :
					// myChecker.g:367:3: ELSE a= middle_else
					{
					match(input,ELSE,FOLLOW_ELSE_in_only_if_or_else1229); 
					pushFollow(FOLLOW_middle_else_in_only_if_or_else1236);
					a=middle_else();
					state._fsp--;

					 
							typeInfo = (a!=null?((myCheckerParser.middle_else_return)a).typeInfo:null);
							if (TRACEON) System.out.println("only_if_or_else :ELSE middle_else"); 
						
					}
					break;
				case 2 :
					// myChecker.g:373:2: 
					{
					 
							typeInfo = TypeInfo.Void;
							if (TRACEON) System.out.println("only_if_or_else :"); 
						
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return typeInfo;
	}
	// $ANTLR end "only_if_or_else"


	public static class middle_else_return extends ParserRuleReturnScope {
		public TypeInfo typeInfo;
	};


	// $ANTLR start "middle_else"
	// myChecker.g:379:1: middle_else returns [TypeInfo typeInfo] : ( IF '(' ( ( arith_expression | String_s | Charliteral ) |d= compare_expression ) ')' if_then_statements | last_else_statements );
	public final myCheckerParser.middle_else_return middle_else() throws RecognitionException {
		myCheckerParser.middle_else_return retval = new myCheckerParser.middle_else_return();
		retval.start = input.LT(1);

		ParserRuleReturnScope d =null;

		try {
			// myChecker.g:380:2: ( IF '(' ( ( arith_expression | String_s | Charliteral ) |d= compare_expression ) ')' if_then_statements | last_else_statements )
			int alt29=2;
			int LA29_0 = input.LA(1);
			if ( (LA29_0==IF) ) {
				alt29=1;
			}
			else if ( (LA29_0==L_BRACE) ) {
				alt29=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 29, 0, input);
				throw nvae;
			}

			switch (alt29) {
				case 1 :
					// myChecker.g:380:4: IF '(' ( ( arith_expression | String_s | Charliteral ) |d= compare_expression ) ')' if_then_statements
					{
					match(input,IF,FOLLOW_IF_in_middle_else1269); 
					match(input,L_PAREN,FOLLOW_L_PAREN_in_middle_else1270); 
					// myChecker.g:380:11: ( ( arith_expression | String_s | Charliteral ) |d= compare_expression )
					int alt28=2;
					int LA28_0 = input.LA(1);
					if ( (LA28_0==Charliteral||LA28_0==Floating_point_constant||LA28_0==Integer_constant||LA28_0==L_PAREN||LA28_0==SUB||LA28_0==String_s) ) {
						alt28=1;
					}
					else if ( (LA28_0==Identifier) ) {
						int LA28_2 = input.LA(2);
						if ( (LA28_2==ADD||LA28_2==DIV||LA28_2==MM_OP||LA28_2==MUL||LA28_2==PP_OP||LA28_2==R_PAREN||LA28_2==SUB) ) {
							alt28=1;
						}
						else if ( (LA28_2==EQ_OP||LA28_2==GE_OP||(LA28_2 >= LARGER && LA28_2 <= LE_OP)||LA28_2==NE_OP||LA28_2==SMALLER) ) {
							alt28=2;
						}

						else {
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 28, 2, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 28, 0, input);
						throw nvae;
					}

					switch (alt28) {
						case 1 :
							// myChecker.g:380:12: ( arith_expression | String_s | Charliteral )
							{
							// myChecker.g:380:12: ( arith_expression | String_s | Charliteral )
							int alt27=3;
							switch ( input.LA(1) ) {
							case Floating_point_constant:
							case Identifier:
							case Integer_constant:
							case L_PAREN:
							case SUB:
								{
								alt27=1;
								}
								break;
							case String_s:
								{
								alt27=2;
								}
								break;
							case Charliteral:
								{
								alt27=3;
								}
								break;
							default:
								NoViableAltException nvae =
									new NoViableAltException("", 27, 0, input);
								throw nvae;
							}
							switch (alt27) {
								case 1 :
									// myChecker.g:380:13: arith_expression
									{
									pushFollow(FOLLOW_arith_expression_in_middle_else1275);
									arith_expression();
									state._fsp--;

									}
									break;
								case 2 :
									// myChecker.g:380:30: String_s
									{
									match(input,String_s,FOLLOW_String_s_in_middle_else1277); 
									}
									break;
								case 3 :
									// myChecker.g:380:39: Charliteral
									{
									match(input,Charliteral,FOLLOW_Charliteral_in_middle_else1279); 
									}
									break;

							}

								//輸入的型態錯誤的話 type Error, 正確 type Void
									System.out.println("Error! "+(retval.start).getLine()+": else if condition section type error.");
									retval.typeInfo =TypeInfo.Error;
								
							}
							break;
						case 2 :
							// myChecker.g:385:4: d= compare_expression
							{
							pushFollow(FOLLOW_compare_expression_in_middle_else1293);
							d=compare_expression();
							state._fsp--;


									if((d!=null?((myCheckerParser.compare_expression_return)d).typeInfo:null) != TypeInfo.Error){
										retval.typeInfo =TypeInfo.Void;
									}else{
										System.out.println("Error! "+(retval.start).getLine()+": middle else condition section compare error.");
										retval.typeInfo =TypeInfo.Error;
									}
								
							}
							break;

					}

					match(input,R_PAREN,FOLLOW_R_PAREN_in_middle_else1300); 
					pushFollow(FOLLOW_if_then_statements_in_middle_else1302);
					if_then_statements();
					state._fsp--;

					 if (TRACEON) System.out.println("middle_else: IF'('  (arith_expression | compare_expression)')' if_then_statements"); 
					}
					break;
				case 2 :
					// myChecker.g:396:7: last_else_statements
					{
					pushFollow(FOLLOW_last_else_statements_in_middle_else1320);
					last_else_statements();
					state._fsp--;


							retval.typeInfo =TypeInfo.Void;
						
					 if (TRACEON) System.out.println("middle_else: last_else_statements "); 
					}
					break;

			}
			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "middle_else"



	// $ANTLR start "last_else_statements"
	// myChecker.g:402:1: last_else_statements : '{' statements '}' ;
	public final void last_else_statements() throws RecognitionException {
		try {
			// myChecker.g:402:21: ( '{' statements '}' )
			// myChecker.g:402:23: '{' statements '}'
			{
			match(input,L_BRACE,FOLLOW_L_BRACE_in_last_else_statements1392); 
			pushFollow(FOLLOW_statements_in_last_else_statements1394);
			statements();
			state._fsp--;

			match(input,R_BRACE,FOLLOW_R_BRACE_in_last_else_statements1395); 
			 if (TRACEON) System.out.println("last_else_statements: { statements}"); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "last_else_statements"



	// $ANTLR start "while_statement"
	// myChecker.g:405:1: while_statement : ( statement | '{' statements '}' );
	public final void while_statement() throws RecognitionException {
		try {
			// myChecker.g:405:16: ( statement | '{' statements '}' )
			int alt30=2;
			int LA30_0 = input.LA(1);
			if ( ((LA30_0 >= BREAK && LA30_0 <= CHAR)||LA30_0==CONTINUE||LA30_0==DOUBLE||(LA30_0 >= FLOAT && LA30_0 <= FOR)||LA30_0==IF||(LA30_0 >= INT && LA30_0 <= Identifier)||(LA30_0 >= PRINTF && LA30_0 <= RETURN)||(LA30_0 >= SCANF && LA30_0 <= SHORT)||LA30_0==WHILE) ) {
				alt30=1;
			}
			else if ( (LA30_0==L_BRACE) ) {
				alt30=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 30, 0, input);
				throw nvae;
			}

			switch (alt30) {
				case 1 :
					// myChecker.g:405:17: statement
					{
					pushFollow(FOLLOW_statement_in_while_statement1404);
					statement();
					state._fsp--;

					 if (TRACEON) System.out.println("while_statement: statement"); 
					}
					break;
				case 2 :
					// myChecker.g:406:10: '{' statements '}'
					{
					match(input,L_BRACE,FOLLOW_L_BRACE_in_while_statement1418); 
					pushFollow(FOLLOW_statements_in_while_statement1420);
					statements();
					state._fsp--;

					match(input,R_BRACE,FOLLOW_R_BRACE_in_while_statement1422); 
					 if (TRACEON) System.out.println("while_statement: {statements}"); 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "while_statement"



	// $ANTLR start "func_call"
	// myChecker.g:411:1: func_call : ( PRINTF '(' '\"' print_ ')' | SCANF '(' '\"' ( scanf_ )* ')' | RETURN ( arith_expression | String_s | Charliteral ) );
	public final void func_call() throws RecognitionException {
		try {
			// myChecker.g:411:10: ( PRINTF '(' '\"' print_ ')' | SCANF '(' '\"' ( scanf_ )* ')' | RETURN ( arith_expression | String_s | Charliteral ) )
			int alt33=3;
			switch ( input.LA(1) ) {
			case PRINTF:
				{
				alt33=1;
				}
				break;
			case SCANF:
				{
				alt33=2;
				}
				break;
			case RETURN:
				{
				alt33=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 33, 0, input);
				throw nvae;
			}
			switch (alt33) {
				case 1 :
					// myChecker.g:411:12: PRINTF '(' '\"' print_ ')'
					{
					match(input,PRINTF,FOLLOW_PRINTF_in_func_call1433); 
					match(input,L_PAREN,FOLLOW_L_PAREN_in_func_call1434); 
					match(input,63,FOLLOW_63_in_func_call1436); 
					pushFollow(FOLLOW_print__in_func_call1438);
					print_();
					state._fsp--;

					match(input,R_PAREN,FOLLOW_R_PAREN_in_func_call1440); 
					 if (TRACEON) System.out.println("PRINTF( '\"' (print_get_var)* )   "); 
					}
					break;
				case 2 :
					// myChecker.g:412:11: SCANF '(' '\"' ( scanf_ )* ')'
					{
					match(input,SCANF,FOLLOW_SCANF_in_func_call1464); 
					match(input,L_PAREN,FOLLOW_L_PAREN_in_func_call1466); 
					match(input,63,FOLLOW_63_in_func_call1468); 
					// myChecker.g:412:26: ( scanf_ )*
					loop31:
					while (true) {
						int alt31=2;
						int LA31_0 = input.LA(1);
						if ( (LA31_0==MOD) ) {
							alt31=1;
						}

						switch (alt31) {
						case 1 :
							// myChecker.g:412:27: scanf_
							{
							pushFollow(FOLLOW_scanf__in_func_call1472);
							scanf_();
							state._fsp--;

							}
							break;

						default :
							break loop31;
						}
					}

					match(input,R_PAREN,FOLLOW_R_PAREN_in_func_call1476); 
					 if (TRACEON) System.out.println("SCANF ( '\"' (scanf_get_var)* )   "); 
					}
					break;
				case 3 :
					// myChecker.g:413:11: RETURN ( arith_expression | String_s | Charliteral )
					{
					match(input,RETURN,FOLLOW_RETURN_in_func_call1500); 
					// myChecker.g:413:18: ( arith_expression | String_s | Charliteral )
					int alt32=3;
					switch ( input.LA(1) ) {
					case Floating_point_constant:
					case Identifier:
					case Integer_constant:
					case L_PAREN:
					case SUB:
						{
						alt32=1;
						}
						break;
					case String_s:
						{
						alt32=2;
						}
						break;
					case Charliteral:
						{
						alt32=3;
						}
						break;
					default:
						NoViableAltException nvae =
							new NoViableAltException("", 32, 0, input);
						throw nvae;
					}
					switch (alt32) {
						case 1 :
							// myChecker.g:413:19: arith_expression
							{
							pushFollow(FOLLOW_arith_expression_in_func_call1503);
							arith_expression();
							state._fsp--;

							}
							break;
						case 2 :
							// myChecker.g:413:36: String_s
							{
							match(input,String_s,FOLLOW_String_s_in_func_call1505); 
							}
							break;
						case 3 :
							// myChecker.g:413:45: Charliteral
							{
							match(input,Charliteral,FOLLOW_Charliteral_in_func_call1507); 
							}
							break;

					}

					 if (TRACEON) System.out.println("RETURN (arith_expression|String_s|Charliteral)"); 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "func_call"


	public static class print__return extends ParserRuleReturnScope {
		public TypeInfo typeInfo;
	};


	// $ANTLR start "print_"
	// myChecker.g:416:1: print_ returns [TypeInfo typeInfo] : ( '%' a= ( 'd' | 'f' | 'c' | 's' ) '%' b= ( 'd' | 'f' | 'c' | 's' ) '\"' ',' c= Identifier ',' d= Identifier | '%' e= ( 'd' | 'f' | 'c' | 's' ) '\"' ',' f= Identifier );
	public final myCheckerParser.print__return print_() throws RecognitionException {
		myCheckerParser.print__return retval = new myCheckerParser.print__return();
		retval.start = input.LT(1);

		Token a=null;
		Token b=null;
		Token c=null;
		Token d=null;
		Token e=null;
		Token f=null;

		try {
			// myChecker.g:417:2: ( '%' a= ( 'd' | 'f' | 'c' | 's' ) '%' b= ( 'd' | 'f' | 'c' | 's' ) '\"' ',' c= Identifier ',' d= Identifier | '%' e= ( 'd' | 'f' | 'c' | 's' ) '\"' ',' f= Identifier )
			int alt34=2;
			int LA34_0 = input.LA(1);
			if ( (LA34_0==MOD) ) {
				int LA34_1 = input.LA(2);
				if ( ((LA34_1 >= 65 && LA34_1 <= 68)) ) {
					int LA34_2 = input.LA(3);
					if ( (LA34_2==MOD) ) {
						alt34=1;
					}
					else if ( (LA34_2==63) ) {
						alt34=2;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 34, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 34, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 34, 0, input);
				throw nvae;
			}

			switch (alt34) {
				case 1 :
					// myChecker.g:418:2: '%' a= ( 'd' | 'f' | 'c' | 's' ) '%' b= ( 'd' | 'f' | 'c' | 's' ) '\"' ',' c= Identifier ',' d= Identifier
					{
					match(input,MOD,FOLLOW_MOD_in_print_1524); 
					a=input.LT(1);
					if ( (input.LA(1) >= 65 && input.LA(1) <= 68) ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					match(input,MOD,FOLLOW_MOD_in_print_1537); 
					b=input.LT(1);
					if ( (input.LA(1) >= 65 && input.LA(1) <= 68) ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					match(input,63,FOLLOW_63_in_print_1549); 
					match(input,COMMA,FOLLOW_COMMA_in_print_1551); 
					c=(Token)match(input,Identifier,FOLLOW_Identifier_in_print_1555); 
					match(input,COMMA,FOLLOW_COMMA_in_print_1556); 
					d=(Token)match(input,Identifier,FOLLOW_Identifier_in_print_1559); 

							retval.typeInfo = TypeInfo.Void;  //初始化
							if(!symtab.containsKey((c!=null?c.getText():null))){//先確認 C,D 是否已經定義過
								System.out.println("Error! "+(retval.start).getLine()+": printf first var undeclared identifier.");
								retval.typeInfo = TypeInfo.Error;
							}
							if(!symtab.containsKey((d!=null?d.getText():null))){
								System.out.println("Error! "+(retval.start).getLine()+": printf second var undeclared identifier.");
								retval.typeInfo = TypeInfo.Error;
							}
							switch(a.getText()){	//檢查id type 是否正確
								case "d":
									if(symtab.get((c!=null?c.getText():null)) != TypeInfo.Integer){
										retval.typeInfo = TypeInfo.Error;
										System.out.println("Error! "+(retval.start).getLine()+": first var type is wrong, need integer.");
									}
									break;  
							 	case "f":
									if(symtab.get((c!=null?c.getText():null)) != TypeInfo.Float){
										retval.typeInfo = TypeInfo.Error;
										System.out.println("Error! "+(retval.start).getLine()+": first var type is wrong, need float.");
									}
									break; 
								case "c":
									if(symtab.get((c!=null?c.getText():null)) != TypeInfo.Char){
										retval.typeInfo = TypeInfo.Error;
										System.out.println("Error! "+(retval.start).getLine()+": first var type is wrong, need char.");
									}
									break;
								case "s":
									if(symtab.get((c!=null?c.getText():null)) != TypeInfo.String){
										retval.typeInfo = TypeInfo.Error;
										System.out.println("Error! "+(retval.start).getLine()+": first var type is wrong, need string.");
									}
									break;
							}
							switch(b.getText()){	//檢查id type 是否正確
								case "d":
									if(symtab.get((d!=null?d.getText():null)) != TypeInfo.Integer){
										retval.typeInfo = TypeInfo.Error;
										System.out.println("Error! "+(retval.start).getLine()+": second var type is wrong, need integer.");
									}
									break;  
							 	case "f":
									if(symtab.get((d!=null?d.getText():null)) != TypeInfo.Float){
										retval.typeInfo = TypeInfo.Error;
										System.out.println("Error! "+(retval.start).getLine()+": second var type is wrong, need float.");
									}
									break; 
								case "c":
									if(symtab.get((d!=null?d.getText():null)) != TypeInfo.Char){
										retval.typeInfo = TypeInfo.Error;
										System.out.println("Error! "+(retval.start).getLine()+": second var type is wrong, need char.");
									}
									break;
								case "s":
									if(symtab.get((d!=null?d.getText():null)) != TypeInfo.String){
										retval.typeInfo = TypeInfo.Error;
										System.out.println("Error! "+(retval.start).getLine()+": second var type is wrong, need string.");
									}
									break;
							}
						
					}
					break;
				case 2 :
					// myChecker.g:482:3: '%' e= ( 'd' | 'f' | 'c' | 's' ) '\"' ',' f= Identifier
					{
					match(input,MOD,FOLLOW_MOD_in_print_1567); 
					e=input.LT(1);
					if ( (input.LA(1) >= 65 && input.LA(1) <= 68) ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					match(input,63,FOLLOW_63_in_print_1579); 
					match(input,COMMA,FOLLOW_COMMA_in_print_1581); 
					f=(Token)match(input,Identifier,FOLLOW_Identifier_in_print_1585); 

							retval.typeInfo = TypeInfo.Void;  //初始化
							if(!symtab.containsKey((f!=null?f.getText():null))){//先確認 f 是否已經定義過
								System.out.println("Error! "+(retval.start).getLine()+": printf first var undeclared identifier.");
								retval.typeInfo = TypeInfo.Error;
							}
							switch(e.getText()){	//檢查id type 是否正確
								case "d":
									if(symtab.get((f!=null?f.getText():null)) != TypeInfo.Integer){
										retval.typeInfo = TypeInfo.Error;
										System.out.println("Error! "+(retval.start).getLine()+": first var type is wrong, need integer.");
									}
									break;  
							 	case "f":
									if(symtab.get((f!=null?f.getText():null)) != TypeInfo.Float){
										retval.typeInfo = TypeInfo.Error;
										System.out.println("Error! "+(retval.start).getLine()+": first var type is wrong, need float.");
									}
									break; 
								case "c":
									if(symtab.get((f!=null?f.getText():null)) != TypeInfo.Char){
										retval.typeInfo = TypeInfo.Error;
										System.out.println("Error! "+(retval.start).getLine()+": first var type is wrong, need char.");
									}
									break;
								case "s":
									if(symtab.get((f!=null?f.getText():null)) != TypeInfo.String){
										retval.typeInfo = TypeInfo.Error;
										System.out.println("Error! "+(retval.start).getLine()+": first var type is wrong, need string.");
									}
									break;
							}
						
					}
					break;

			}
			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "print_"


	public static class scanf__return extends ParserRuleReturnScope {
		public TypeInfo typeInfo;
	};


	// $ANTLR start "scanf_"
	// myChecker.g:518:1: scanf_ returns [TypeInfo typeInfo] : ( '%' a= ( 'd' | 'f' | 'c' | 's' ) '%' b= ( 'd' | 'f' | 'c' | 's' ) '\"' ',' '&' c= Identifier ',' '&' d= Identifier | '%' e= ( 'd' | 'f' | 'c' | 's' ) '\"' ',' f= Identifier );
	public final myCheckerParser.scanf__return scanf_() throws RecognitionException {
		myCheckerParser.scanf__return retval = new myCheckerParser.scanf__return();
		retval.start = input.LT(1);

		Token a=null;
		Token b=null;
		Token c=null;
		Token d=null;
		Token e=null;
		Token f=null;

		try {
			// myChecker.g:519:2: ( '%' a= ( 'd' | 'f' | 'c' | 's' ) '%' b= ( 'd' | 'f' | 'c' | 's' ) '\"' ',' '&' c= Identifier ',' '&' d= Identifier | '%' e= ( 'd' | 'f' | 'c' | 's' ) '\"' ',' f= Identifier )
			int alt35=2;
			int LA35_0 = input.LA(1);
			if ( (LA35_0==MOD) ) {
				int LA35_1 = input.LA(2);
				if ( ((LA35_1 >= 65 && LA35_1 <= 68)) ) {
					int LA35_2 = input.LA(3);
					if ( (LA35_2==MOD) ) {
						alt35=1;
					}
					else if ( (LA35_2==63) ) {
						alt35=2;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 35, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 35, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 35, 0, input);
				throw nvae;
			}

			switch (alt35) {
				case 1 :
					// myChecker.g:520:2: '%' a= ( 'd' | 'f' | 'c' | 's' ) '%' b= ( 'd' | 'f' | 'c' | 's' ) '\"' ',' '&' c= Identifier ',' '&' d= Identifier
					{
					match(input,MOD,FOLLOW_MOD_in_scanf_1604); 
					a=input.LT(1);
					if ( (input.LA(1) >= 65 && input.LA(1) <= 68) ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					match(input,MOD,FOLLOW_MOD_in_scanf_1617); 
					b=input.LT(1);
					if ( (input.LA(1) >= 65 && input.LA(1) <= 68) ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					match(input,63,FOLLOW_63_in_scanf_1629); 
					match(input,COMMA,FOLLOW_COMMA_in_scanf_1631); 
					match(input,64,FOLLOW_64_in_scanf_1632); 
					c=(Token)match(input,Identifier,FOLLOW_Identifier_in_scanf_1636); 
					match(input,COMMA,FOLLOW_COMMA_in_scanf_1637); 
					match(input,64,FOLLOW_64_in_scanf_1639); 
					d=(Token)match(input,Identifier,FOLLOW_Identifier_in_scanf_1643); 

							retval.typeInfo = TypeInfo.Void;  //初始化
							if(!symtab.containsKey((c!=null?c.getText():null))){//先確認 C,D 是否已經定義過
								System.out.println("Error! "+(retval.start).getLine()+": printf first var undeclared identifier.");
								retval.typeInfo = TypeInfo.Error;
							}
							if(!symtab.containsKey((d!=null?d.getText():null))){
								System.out.println("Error! "+(retval.start).getLine()+": printf second var undeclared identifier.");
								retval.typeInfo = TypeInfo.Error;
							}
							switch(a.getText()){	//檢查id type 是否正確
								case "d":
									if(symtab.get((c!=null?c.getText():null)) != TypeInfo.Integer){
										retval.typeInfo = TypeInfo.Error;
										System.out.println("Error! "+(retval.start).getLine()+": first var type is wrong, need integer.");
									}
									break;  
							 	case "f":
									if(symtab.get((c!=null?c.getText():null)) != TypeInfo.Float){
										retval.typeInfo = TypeInfo.Error;
										System.out.println("Error! "+(retval.start).getLine()+": first var type is wrong, need float.");
									}
									break; 
								case "c":
									if(symtab.get((c!=null?c.getText():null)) != TypeInfo.Char){
										retval.typeInfo = TypeInfo.Error;
										System.out.println("Error! "+(retval.start).getLine()+": first var type is wrong, need char.");
									}
									break;
								case "s":
									if(symtab.get((c!=null?c.getText():null)) != TypeInfo.String){
										retval.typeInfo = TypeInfo.Error;
										System.out.println("Error! "+(retval.start).getLine()+": first var type is wrong, need string.");
									}
									break;
							}
							switch(b.getText()){	//檢查id type 是否正確
								case "d":
									if(symtab.get((d!=null?d.getText():null)) != TypeInfo.Integer){
										retval.typeInfo = TypeInfo.Error;
										System.out.println("Error! "+(retval.start).getLine()+": second var type is wrong, need integer.");
									}
									break;  
							 	case "f":
									if(symtab.get((d!=null?d.getText():null)) != TypeInfo.Float){
										retval.typeInfo = TypeInfo.Error;
										System.out.println("Error! "+(retval.start).getLine()+": second var type is wrong, need float.");
									}
									break; 
								case "c":
									if(symtab.get((d!=null?d.getText():null)) != TypeInfo.Char){
										retval.typeInfo = TypeInfo.Error;
										System.out.println("Error! "+(retval.start).getLine()+": second var type is wrong, need char.");
									}
									break;
								case "s":
									if(symtab.get((d!=null?d.getText():null)) != TypeInfo.String){
										retval.typeInfo = TypeInfo.Error;
										System.out.println("Error! "+(retval.start).getLine()+": second var type is wrong, need string.");
									}
									break;
							}
						
					}
					break;
				case 2 :
					// myChecker.g:584:3: '%' e= ( 'd' | 'f' | 'c' | 's' ) '\"' ',' f= Identifier
					{
					match(input,MOD,FOLLOW_MOD_in_scanf_1650); 
					e=input.LT(1);
					if ( (input.LA(1) >= 65 && input.LA(1) <= 68) ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					match(input,63,FOLLOW_63_in_scanf_1662); 
					match(input,COMMA,FOLLOW_COMMA_in_scanf_1664); 
					f=(Token)match(input,Identifier,FOLLOW_Identifier_in_scanf_1668); 

							retval.typeInfo = TypeInfo.Void;  //初始化
							if(!symtab.containsKey((f!=null?f.getText():null))){//先確認 f 是否已經定義過
								System.out.println("Error! "+(retval.start).getLine()+": printf first var undeclared identifier.");
								retval.typeInfo = TypeInfo.Error;
							}
							switch(e.getText()){	//檢查id type 是否正確
								case "d":
									if(symtab.get((f!=null?f.getText():null)) != TypeInfo.Integer){
										retval.typeInfo = TypeInfo.Error;
										System.out.println("Error! "+(retval.start).getLine()+": first var type is wrong, need integer.");
									}
									break;  
							 	case "f":
									if(symtab.get((f!=null?f.getText():null)) != TypeInfo.Float){
										retval.typeInfo = TypeInfo.Error;
										System.out.println("Error! "+(retval.start).getLine()+": first var type is wrong, need float.");
									}
									break; 
								case "c":
									if(symtab.get((f!=null?f.getText():null)) != TypeInfo.Char){
										retval.typeInfo = TypeInfo.Error;
										System.out.println("Error! "+(retval.start).getLine()+": first var type is wrong, need char.");
									}
									break;
								case "s":
									if(symtab.get((f!=null?f.getText():null)) != TypeInfo.String){
										retval.typeInfo = TypeInfo.Error;
										System.out.println("Error! "+(retval.start).getLine()+": first var type is wrong, need string.");
									}
									break;
							}
						
					}
					break;

			}
			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "scanf_"



	// $ANTLR start "scanf_get_var"
	// myChecker.g:621:1: scanf_get_var : ( '%' ( 'd' | 'f' ) scanf_get_var ',' '&' Identifier | '\"' );
	public final void scanf_get_var() throws RecognitionException {
		try {
			// myChecker.g:621:14: ( '%' ( 'd' | 'f' ) scanf_get_var ',' '&' Identifier | '\"' )
			int alt36=2;
			int LA36_0 = input.LA(1);
			if ( (LA36_0==MOD) ) {
				alt36=1;
			}
			else if ( (LA36_0==63) ) {
				alt36=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 36, 0, input);
				throw nvae;
			}

			switch (alt36) {
				case 1 :
					// myChecker.g:622:2: '%' ( 'd' | 'f' ) scanf_get_var ',' '&' Identifier
					{
					match(input,MOD,FOLLOW_MOD_in_scanf_get_var1683); 
					if ( (input.LA(1) >= 66 && input.LA(1) <= 67) ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_scanf_get_var_in_scanf_get_var1690);
					scanf_get_var();
					state._fsp--;

					match(input,COMMA,FOLLOW_COMMA_in_scanf_get_var1692); 
					match(input,64,FOLLOW_64_in_scanf_get_var1694); 
					match(input,Identifier,FOLLOW_Identifier_in_scanf_get_var1695); 
					 if (TRACEON) System.out.println("scanf_get_var: '%'(d|f) scanf_get_var , &Identifier "); 
					}
					break;
				case 2 :
					// myChecker.g:624:3: '\"'
					{
					match(input,63,FOLLOW_63_in_scanf_get_var1715); 
					 if (TRACEON) System.out.println("scanf_get_var: '\"'"); 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "scanf_get_var"



	// $ANTLR start "print_get_var"
	// myChecker.g:625:1: print_get_var : ( '%' ( 'd' | 'f' ) print_get_var ',' Identifier | '\"' );
	public final void print_get_var() throws RecognitionException {
		try {
			// myChecker.g:625:14: ( '%' ( 'd' | 'f' ) print_get_var ',' Identifier | '\"' )
			int alt37=2;
			int LA37_0 = input.LA(1);
			if ( (LA37_0==MOD) ) {
				alt37=1;
			}
			else if ( (LA37_0==63) ) {
				alt37=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 37, 0, input);
				throw nvae;
			}

			switch (alt37) {
				case 1 :
					// myChecker.g:626:2: '%' ( 'd' | 'f' ) print_get_var ',' Identifier
					{
					match(input,MOD,FOLLOW_MOD_in_print_get_var1727); 
					if ( (input.LA(1) >= 66 && input.LA(1) <= 67) ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_print_get_var_in_print_get_var1735);
					print_get_var();
					state._fsp--;

					match(input,COMMA,FOLLOW_COMMA_in_print_get_var1737); 
					match(input,Identifier,FOLLOW_Identifier_in_print_get_var1738); 
					 if (TRACEON) System.out.println("print_get_var:  '%'(d|f)  print_get_var ,Identifier "); 
					}
					break;
				case 2 :
					// myChecker.g:628:3: '\"'
					{
					match(input,63,FOLLOW_63_in_print_get_var1746); 
					 if (TRACEON) System.out.println("print_get_var: '\"'"); 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "print_get_var"



	// $ANTLR start "relate_op"
	// myChecker.g:664:1: relate_op : ( EQ_OP | LE_OP | GE_OP | NE_OP | LARGER | SMALLER ) ;
	public final void relate_op() throws RecognitionException {
		try {
			// myChecker.g:664:10: ( ( EQ_OP | LE_OP | GE_OP | NE_OP | LARGER | SMALLER ) )
			// myChecker.g:664:12: ( EQ_OP | LE_OP | GE_OP | NE_OP | LARGER | SMALLER )
			{
			if ( input.LA(1)==EQ_OP||input.LA(1)==GE_OP||(input.LA(1) >= LARGER && input.LA(1) <= LE_OP)||input.LA(1)==NE_OP||input.LA(1)==SMALLER ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			 if (TRACEON) System.out.println("relate_op: (EQ_OP|LE_OP|GE_OP|NE_OP| LARGER|SMALLER)"); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "relate_op"



	// $ANTLR start "assign_op"
	// myChecker.g:684:1: assign_op : ( ASSIGN | ADD_ASSIGN | SUB_ASSIGN | MUL_ASSIGN | DIV_ASSIGN ) ;
	public final void assign_op() throws RecognitionException {
		try {
			// myChecker.g:684:10: ( ( ASSIGN | ADD_ASSIGN | SUB_ASSIGN | MUL_ASSIGN | DIV_ASSIGN ) )
			// myChecker.g:684:11: ( ASSIGN | ADD_ASSIGN | SUB_ASSIGN | MUL_ASSIGN | DIV_ASSIGN )
			{
			if ( input.LA(1)==ADD_ASSIGN||input.LA(1)==ASSIGN||input.LA(1)==DIV_ASSIGN||input.LA(1)==MUL_ASSIGN||input.LA(1)==SUB_ASSIGN ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			 if (TRACEON) System.out.println("assign_op:(ASSIGN|ADD_ASSIGN| SUB_ASSIGN| MUL_ASSIGN | DIV_ASSIGN)"); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "assign_op"



	// $ANTLR start "lIBRARY"
	// myChecker.g:714:1: lIBRARY : Identifier '.' Identifier ;
	public final void lIBRARY() throws RecognitionException {
		try {
			// myChecker.g:714:9: ( Identifier '.' Identifier )
			// myChecker.g:714:11: Identifier '.' Identifier
			{
			match(input,Identifier,FOLLOW_Identifier_in_lIBRARY2158); 
			match(input,DOT,FOLLOW_DOT_in_lIBRARY2159); 
			match(input,Identifier,FOLLOW_Identifier_in_lIBRARY2160); 
			 if (TRACEON) System.out.println("lIBRARY : Identifier'.'Identifier "); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "lIBRARY"

	// Delegated rules



	public static final BitSet FOLLOW_include_lib_in_program21 = new BitSet(new long[]{0x1000000048880200L});
	public static final BitSet FOLLOW_type_in_program24 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_MAIN_in_program26 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_L_PAREN_in_program28 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_R_PAREN_in_program30 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_L_BRACE_in_program32 = new BitSet(new long[]{0x20338000D1884300L});
	public static final BitSet FOLLOW_statements_in_program34 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_R_BRACE_in_program36 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_HASH_in_include_lib67 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_INCLUDE_in_include_lib69 = new BitSet(new long[]{0x0040000000000000L});
	public static final BitSet FOLLOW_SMALLER_in_include_lib71 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_lIBRARY_in_include_lib72 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_LARGER_in_include_lib73 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_type102 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FLOAT_in_type111 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CHAR_in_type120 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOUBLE_in_type129 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VOID_in_type138 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_statement_in_statements147 = new BitSet(new long[]{0x20318000D1884300L});
	public static final BitSet FOLLOW_statements_in_statements149 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_multExpr_in_arith_expression203 = new BitSet(new long[]{0x0080000000000012L});
	public static final BitSet FOLLOW_ADD_in_arith_expression210 = new BitSet(new long[]{0x0080002182000000L});
	public static final BitSet FOLLOW_multExpr_in_arith_expression215 = new BitSet(new long[]{0x0080000000000012L});
	public static final BitSet FOLLOW_SUB_in_arith_expression223 = new BitSet(new long[]{0x0080002182000000L});
	public static final BitSet FOLLOW_multExpr_in_arith_expression228 = new BitSet(new long[]{0x0080000000000012L});
	public static final BitSet FOLLOW_signExpr_in_multExpr257 = new BitSet(new long[]{0x0000020000010002L});
	public static final BitSet FOLLOW_MUL_in_multExpr264 = new BitSet(new long[]{0x0080002182000000L});
	public static final BitSet FOLLOW_signExpr_in_multExpr269 = new BitSet(new long[]{0x0000020000010002L});
	public static final BitSet FOLLOW_DIV_in_multExpr277 = new BitSet(new long[]{0x0080002182000000L});
	public static final BitSet FOLLOW_signExpr_in_multExpr282 = new BitSet(new long[]{0x0000020000010002L});
	public static final BitSet FOLLOW_double_add_sub_in_signExpr314 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SUB_in_signExpr321 = new BitSet(new long[]{0x0000002182000000L});
	public static final BitSet FOLLOW_double_add_sub_in_signExpr326 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primaryExpr_in_double_add_sub355 = new BitSet(new long[]{0x0000408000000002L});
	public static final BitSet FOLLOW_MM_OP_in_double_add_sub362 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PP_OP_in_double_add_sub369 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Integer_constant_in_primaryExpr398 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Floating_point_constant_in_primaryExpr426 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Identifier_in_primaryExpr447 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_L_PAREN_in_primaryExpr480 = new BitSet(new long[]{0x0080002182000000L});
	public static final BitSet FOLLOW_arith_expression_in_primaryExpr482 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_R_PAREN_in_primaryExpr484 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Identifier_in_compare_expression517 = new BitSet(new long[]{0x0040080604400000L});
	public static final BitSet FOLLOW_relate_op_in_compare_expression519 = new BitSet(new long[]{0x0000000182000000L});
	public static final BitSet FOLLOW_Identifier_in_compare_expression532 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Integer_constant_in_compare_expression543 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Floating_point_constant_in_compare_expression554 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_flow_in_statement574 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_assign_in_statement605 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_Semicolon_in_statement607 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_func_call_in_statement632 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_Semicolon_in_statement634 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_assign657 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_FLOAT_in_assign661 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_DOUBLE_in_assign665 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_SHORT_in_assign669 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_Identifier_in_assign676 = new BitSet(new long[]{0x0000000000000082L});
	public static final BitSet FOLLOW_ASSIGN_in_assign684 = new BitSet(new long[]{0x0080002182000000L});
	public static final BitSet FOLLOW_arith_expression_in_assign689 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Identifier_in_assign712 = new BitSet(new long[]{0x01000400000200A0L});
	public static final BitSet FOLLOW_assign_op_in_assign714 = new BitSet(new long[]{0x0080002182000000L});
	public static final BitSet FOLLOW_arith_expression_in_assign718 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CHAR_in_assign731 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_char_or_string_in_assign737 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Identifier_in_char_or_string755 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_L_BRACKET_in_char_or_string756 = new BitSet(new long[]{0x0084002182000000L});
	public static final BitSet FOLLOW_arith_expression_in_char_or_string763 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_R_BRACKET_in_char_or_string766 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_ASSIGN_in_char_or_string768 = new BitSet(new long[]{0x0400000102008000L});
	public static final BitSet FOLLOW_String_s_in_char_or_string776 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_in_char_or_string783 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Identifier_in_char_or_string814 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_ASSIGN_in_char_or_string816 = new BitSet(new long[]{0x0400000102008000L});
	public static final BitSet FOLLOW_Charliteral_in_char_or_string821 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_in_char_or_string830 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_flow863 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_L_PAREN_in_flow864 = new BitSet(new long[]{0x0480002182008000L});
	public static final BitSet FOLLOW_arith_expression_in_flow868 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_String_s_in_flow870 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_Charliteral_in_flow872 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_compare_expression_in_flow887 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_R_PAREN_in_flow895 = new BitSet(new long[]{0x20318008D1884300L});
	public static final BitSet FOLLOW_if_then_statements_in_flow902 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WHILE_in_flow930 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_L_PAREN_in_flow931 = new BitSet(new long[]{0x0480002182008000L});
	public static final BitSet FOLLOW_arith_expression_in_flow935 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_String_s_in_flow937 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_Charliteral_in_flow939 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_compare_expression_in_flow953 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_R_PAREN_in_flow960 = new BitSet(new long[]{0x20318008D1884300L});
	public static final BitSet FOLLOW_while_statement_in_flow962 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FOR_in_flow992 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_L_PAREN_in_flow993 = new BitSet(new long[]{0x00200000C0880200L});
	public static final BitSet FOLLOW_assign_in_flow999 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_Semicolon_in_flow1001 = new BitSet(new long[]{0x0480002182008000L});
	public static final BitSet FOLLOW_arith_expression_in_flow1010 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_String_s_in_flow1012 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_Charliteral_in_flow1014 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_compare_expression_in_flow1027 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_Semicolon_in_flow1036 = new BitSet(new long[]{0x0080002182000000L});
	public static final BitSet FOLLOW_arith_expression_in_flow1042 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_R_PAREN_in_flow1044 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_L_BRACE_in_flow1051 = new BitSet(new long[]{0x20338000D1884300L});
	public static final BitSet FOLLOW_statements_in_flow1053 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_R_BRACE_in_flow1055 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_in_flow1072 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_Semicolon_in_flow1078 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_statement_in_if_then_statements1161 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_L_BRACE_in_if_then_statements1199 = new BitSet(new long[]{0x20338000D1884300L});
	public static final BitSet FOLLOW_statements_in_if_then_statements1201 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_R_BRACE_in_if_then_statements1203 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_only_if_or_else_in_if_then_statements1209 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ELSE_in_only_if_or_else1229 = new BitSet(new long[]{0x0000000810000000L});
	public static final BitSet FOLLOW_middle_else_in_only_if_or_else1236 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_middle_else1269 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_L_PAREN_in_middle_else1270 = new BitSet(new long[]{0x0480002182008000L});
	public static final BitSet FOLLOW_arith_expression_in_middle_else1275 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_String_s_in_middle_else1277 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_Charliteral_in_middle_else1279 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_compare_expression_in_middle_else1293 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_R_PAREN_in_middle_else1300 = new BitSet(new long[]{0x20318008D1884300L});
	public static final BitSet FOLLOW_if_then_statements_in_middle_else1302 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_last_else_statements_in_middle_else1320 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_L_BRACE_in_last_else_statements1392 = new BitSet(new long[]{0x20338000D1884300L});
	public static final BitSet FOLLOW_statements_in_last_else_statements1394 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_R_BRACE_in_last_else_statements1395 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_statement_in_while_statement1404 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_L_BRACE_in_while_statement1418 = new BitSet(new long[]{0x20338000D1884300L});
	public static final BitSet FOLLOW_statements_in_while_statement1420 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_R_BRACE_in_while_statement1422 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PRINTF_in_func_call1433 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_L_PAREN_in_func_call1434 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_func_call1436 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_print__in_func_call1438 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_R_PAREN_in_func_call1440 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SCANF_in_func_call1464 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_L_PAREN_in_func_call1466 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_func_call1468 = new BitSet(new long[]{0x0008010000000000L});
	public static final BitSet FOLLOW_scanf__in_func_call1472 = new BitSet(new long[]{0x0008010000000000L});
	public static final BitSet FOLLOW_R_PAREN_in_func_call1476 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RETURN_in_func_call1500 = new BitSet(new long[]{0x0480002182008000L});
	public static final BitSet FOLLOW_arith_expression_in_func_call1503 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_String_s_in_func_call1505 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Charliteral_in_func_call1507 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MOD_in_print_1524 = new BitSet(new long[]{0x0000000000000000L,0x000000000000001EL});
	public static final BitSet FOLLOW_set_in_print_1527 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_MOD_in_print_1537 = new BitSet(new long[]{0x0000000000000000L,0x000000000000001EL});
	public static final BitSet FOLLOW_set_in_print_1540 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_print_1549 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_COMMA_in_print_1551 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_Identifier_in_print_1555 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_COMMA_in_print_1556 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_Identifier_in_print_1559 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MOD_in_print_1567 = new BitSet(new long[]{0x0000000000000000L,0x000000000000001EL});
	public static final BitSet FOLLOW_set_in_print_1570 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_print_1579 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_COMMA_in_print_1581 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_Identifier_in_print_1585 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MOD_in_scanf_1604 = new BitSet(new long[]{0x0000000000000000L,0x000000000000001EL});
	public static final BitSet FOLLOW_set_in_scanf_1607 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_MOD_in_scanf_1617 = new BitSet(new long[]{0x0000000000000000L,0x000000000000001EL});
	public static final BitSet FOLLOW_set_in_scanf_1620 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_scanf_1629 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_COMMA_in_scanf_1631 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_64_in_scanf_1632 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_Identifier_in_scanf_1636 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_COMMA_in_scanf_1637 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_64_in_scanf_1639 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_Identifier_in_scanf_1643 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MOD_in_scanf_1650 = new BitSet(new long[]{0x0000000000000000L,0x000000000000001EL});
	public static final BitSet FOLLOW_set_in_scanf_1653 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_scanf_1662 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_COMMA_in_scanf_1664 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_Identifier_in_scanf_1668 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MOD_in_scanf_get_var1683 = new BitSet(new long[]{0x0000000000000000L,0x000000000000000CL});
	public static final BitSet FOLLOW_set_in_scanf_get_var1684 = new BitSet(new long[]{0x8000010000000000L});
	public static final BitSet FOLLOW_scanf_get_var_in_scanf_get_var1690 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_COMMA_in_scanf_get_var1692 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_64_in_scanf_get_var1694 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_Identifier_in_scanf_get_var1695 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_63_in_scanf_get_var1715 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MOD_in_print_get_var1727 = new BitSet(new long[]{0x0000000000000000L,0x000000000000000CL});
	public static final BitSet FOLLOW_set_in_print_get_var1728 = new BitSet(new long[]{0x8000010000000000L});
	public static final BitSet FOLLOW_print_get_var_in_print_get_var1735 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_COMMA_in_print_get_var1737 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_Identifier_in_print_get_var1738 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_63_in_print_get_var1746 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_in_relate_op1890 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_in_assign_op2000 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Identifier_in_lIBRARY2158 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_DOT_in_lIBRARY2159 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_Identifier_in_lIBRARY2160 = new BitSet(new long[]{0x0000000000000002L});
}
