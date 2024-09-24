// $ANTLR 3.5.3 myCompiler.g 2024-06-12 17:38:16

    // import packages here.
    import java.util.HashMap;
    import java.util.ArrayList;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings("all")
public class myCompilerParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ADD", "ADD_ASSIGN", "AND", "ASSIGN", 
		"BREAK", "CHAR", "COLON", "COMMA", "COMMENT1", "COMMENT2", "CONTINUE", 
		"DIV", "DIV_ASSIGN", "DOT", "DOUBLE", "ELSE", "END", "EQ_OP", "EscapeSequence", 
		"FLOAT", "FOR", "Floating_point_constant", "GE_OP", "HASH", "IF", "INCLUDE", 
		"INT", "Identifier", "Integer_constant", "LARGER", "LE_OP", "L_BRACE", 
		"L_BRACKET", "L_PAREN", "MAIN", "MM_OP", "MOD", "MUL", "MUL_ASSIGN", "NE_OP", 
		"NOT", "OR", "PP_OP", "PRINTF", "RETURN", "R_BRACE", "R_BRACKET", "R_PAREN", 
		"SCANF", "SHORT", "SMALLER", "STRING_LITERAL", "SUB", "SUB_ASSIGN", "Semicolon", 
		"UNDERSCORE", "VOID", "WHILE", "WS", "'&'"
	};
	public static final int EOF=-1;
	public static final int T__63=63;
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
	public static final int DIV=15;
	public static final int DIV_ASSIGN=16;
	public static final int DOT=17;
	public static final int DOUBLE=18;
	public static final int ELSE=19;
	public static final int END=20;
	public static final int EQ_OP=21;
	public static final int EscapeSequence=22;
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
	public static final int STRING_LITERAL=55;
	public static final int SUB=56;
	public static final int SUB_ASSIGN=57;
	public static final int Semicolon=58;
	public static final int UNDERSCORE=59;
	public static final int VOID=60;
	public static final int WHILE=61;
	public static final int WS=62;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public myCompilerParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public myCompilerParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return myCompilerParser.tokenNames; }
	@Override public String getGrammarFileName() { return "myCompiler.g"; }


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



	// $ANTLR start "program"
	// myCompiler.g:109:1: program : ( INT | VOID ) MAIN '(' ')' '{' statements '}' ;
	public final void program() throws RecognitionException {
		try {
			// myCompiler.g:109:8: ( ( INT | VOID ) MAIN '(' ')' '{' statements '}' )
			// myCompiler.g:109:10: ( INT | VOID ) MAIN '(' ')' '{' statements '}'
			{
			if ( input.LA(1)==INT||input.LA(1)==VOID ) {
				input.consume();
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			match(input,MAIN,FOLLOW_MAIN_in_program42); if (state.failed) return;
			match(input,L_PAREN,FOLLOW_L_PAREN_in_program44); if (state.failed) return;
			match(input,R_PAREN,FOLLOW_R_PAREN_in_program46); if (state.failed) return;
			if ( state.backtracking==0 ) {
			           /* Output function prologue */
			           prologue();
			        }
			match(input,L_BRACE,FOLLOW_L_BRACE_in_program67); if (state.failed) return;
			pushFollow(FOLLOW_statements_in_program81);
			statements();
			state._fsp--;
			if (state.failed) return;
			match(input,R_BRACE,FOLLOW_R_BRACE_in_program91); if (state.failed) return;
			if ( state.backtracking==0 ) {
				   if (TRACEON)
				      System.out.println("VOID MAIN () {declarations statements}");

			           /* output function epilogue */	  
			           epilogue();
			        }
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
	// myCompiler.g:127:1: include_lib : HASH INCLUDE '<' lIBRARY '>' ;
	public final void include_lib() throws RecognitionException {
		try {
			// myCompiler.g:127:12: ( HASH INCLUDE '<' lIBRARY '>' )
			// myCompiler.g:127:13: HASH INCLUDE '<' lIBRARY '>'
			{
			match(input,HASH,FOLLOW_HASH_in_include_lib116); if (state.failed) return;
			match(input,INCLUDE,FOLLOW_INCLUDE_in_include_lib118); if (state.failed) return;
			match(input,SMALLER,FOLLOW_SMALLER_in_include_lib120); if (state.failed) return;
			pushFollow(FOLLOW_lIBRARY_in_include_lib121);
			lIBRARY();
			state._fsp--;
			if (state.failed) return;
			match(input,LARGER,FOLLOW_LARGER_in_include_lib122); if (state.failed) return;
			if ( state.backtracking==0 ) {if (TRACEON) System.out.println("include_lib:HASH INCLUDE <LIBRARY>");}
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
	// myCompiler.g:133:1: type returns [Type attr_type] : ( INT | CHAR | FLOAT | VOID );
	public final Type type() throws RecognitionException {
		Type attr_type = null;


		try {
			// myCompiler.g:135:5: ( INT | CHAR | FLOAT | VOID )
			int alt1=4;
			switch ( input.LA(1) ) {
			case INT:
				{
				alt1=1;
				}
				break;
			case CHAR:
				{
				alt1=2;
				}
				break;
			case FLOAT:
				{
				alt1=3;
				}
				break;
			case VOID:
				{
				alt1=4;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return attr_type;}
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}
			switch (alt1) {
				case 1 :
					// myCompiler.g:135:7: INT
					{
					match(input,INT,FOLLOW_INT_in_type156); if (state.failed) return attr_type;
					if ( state.backtracking==0 ) { if (TRACEON) System.out.println("type: INT"); attr_type =Type.INT; }
					}
					break;
				case 2 :
					// myCompiler.g:136:7: CHAR
					{
					match(input,CHAR,FOLLOW_CHAR_in_type166); if (state.failed) return attr_type;
					if ( state.backtracking==0 ) { if (TRACEON) System.out.println("type: CHAR"); attr_type =Type.CHAR; }
					}
					break;
				case 3 :
					// myCompiler.g:137:7: FLOAT
					{
					match(input,FLOAT,FOLLOW_FLOAT_in_type176); if (state.failed) return attr_type;
					if ( state.backtracking==0 ) {if (TRACEON) System.out.println("type: FLOAT"); attr_type =Type.FLOAT; }
					}
					break;
				case 4 :
					// myCompiler.g:138:7: VOID
					{
					match(input,VOID,FOLLOW_VOID_in_type186); if (state.failed) return attr_type;
					if ( state.backtracking==0 ) {if (TRACEON) System.out.println("type: VOID"); attr_type =Type.VOID; }
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
		return attr_type;
	}
	// $ANTLR end "type"



	// $ANTLR start "statements"
	// myCompiler.g:142:1: statements : ( statement statements |);
	public final void statements() throws RecognitionException {
		try {
			// myCompiler.g:142:11: ( statement statements |)
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==CHAR||(LA2_0 >= FLOAT && LA2_0 <= FOR)||LA2_0==IF||(LA2_0 >= INT && LA2_0 <= Identifier)||(LA2_0 >= PRINTF && LA2_0 <= RETURN)||LA2_0==SCANF||(LA2_0 >= VOID && LA2_0 <= WHILE)) ) {
				alt2=1;
			}
			else if ( (LA2_0==R_BRACE) ) {
				alt2=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// myCompiler.g:142:12: statement statements
					{
					pushFollow(FOLLOW_statement_in_statements197);
					statement();
					state._fsp--;
					if (state.failed) return;
					pushFollow(FOLLOW_statements_in_statements199);
					statements();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 2 :
					// myCompiler.g:144:11: 
					{
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



	// $ANTLR start "statement"
	// myCompiler.g:147:1: statement : ( flow | assign ';' | func_call ';' );
	public final void statement() throws RecognitionException {
		try {
			// myCompiler.g:147:10: ( flow | assign ';' | func_call ';' )
			int alt3=3;
			switch ( input.LA(1) ) {
			case FOR:
			case IF:
			case WHILE:
				{
				alt3=1;
				}
				break;
			case CHAR:
			case FLOAT:
			case INT:
			case Identifier:
			case VOID:
				{
				alt3=2;
				}
				break;
			case PRINTF:
			case RETURN:
			case SCANF:
				{
				alt3=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}
			switch (alt3) {
				case 1 :
					// myCompiler.g:148:4: flow
					{
					pushFollow(FOLLOW_flow_in_statement234);
					flow();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 2 :
					// myCompiler.g:149:5: assign ';'
					{
					pushFollow(FOLLOW_assign_in_statement240);
					assign();
					state._fsp--;
					if (state.failed) return;
					match(input,Semicolon,FOLLOW_Semicolon_in_statement242); if (state.failed) return;
					}
					break;
				case 3 :
					// myCompiler.g:150:5: func_call ';'
					{
					pushFollow(FOLLOW_func_call_in_statement249);
					func_call();
					state._fsp--;
					if (state.failed) return;
					match(input,Semicolon,FOLLOW_Semicolon_in_statement250); if (state.failed) return;
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



	// $ANTLR start "assign"
	// myCompiler.g:154:1: assign : ( type )? Identifier assign_or_declare[$Identifier.text, $Identifier.getLine(),$type.attr_type] ;
	public final void assign() throws RecognitionException {
		Token Identifier1=null;
		Type type2 =null;

		try {
			// myCompiler.g:154:7: ( ( type )? Identifier assign_or_declare[$Identifier.text, $Identifier.getLine(),$type.attr_type] )
			// myCompiler.g:154:9: ( type )? Identifier assign_or_declare[$Identifier.text, $Identifier.getLine(),$type.attr_type]
			{
			// myCompiler.g:154:9: ( type )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==CHAR||LA4_0==FLOAT||LA4_0==INT||LA4_0==VOID) ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// myCompiler.g:154:9: type
					{
					pushFollow(FOLLOW_type_in_assign262);
					type2=type();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}

			Identifier1=(Token)match(input,Identifier,FOLLOW_Identifier_in_assign265); if (state.failed) return;
			pushFollow(FOLLOW_assign_or_declare_in_assign267);
			assign_or_declare((Identifier1!=null?Identifier1.getText():null), Identifier1.getLine(), type2);
			state._fsp--;
			if (state.failed) return;
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
	// $ANTLR end "assign"



	// $ANTLR start "assign_or_declare"
	// myCompiler.g:158:1: assign_or_declare[String Id, int gline, Type attr_type] : ( '=' arith_expression |);
	public final void assign_or_declare(String Id, int gline, Type attr_type) throws RecognitionException {
		Info arith_expression3 =null;

		try {
			// myCompiler.g:158:57: ( '=' arith_expression |)
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==ASSIGN) ) {
				alt5=1;
			}
			else if ( (LA5_0==R_PAREN||LA5_0==Semicolon) ) {
				alt5=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}

			switch (alt5) {
				case 1 :
					// myCompiler.g:159:4: '=' arith_expression
					{
					match(input,ASSIGN,FOLLOW_ASSIGN_in_assign_or_declare285); if (state.failed) return;
					pushFollow(FOLLOW_arith_expression_in_assign_or_declare287);
					arith_expression3=arith_expression();
					state._fsp--;
					if (state.failed) return;
					if ( state.backtracking==0 ) {  //assign
					      Info theRHS = arith_expression3;
							Info theLHS = symtab.get(Id); 
							   
					      if ((theLHS.theType == Type.INT) &&
					            (theRHS.theType == Type.INT)) {		   
					            // issue store insruction.
					            // Ex: store i32 %tx, i32* %ty
					            TextCode.add("store i32 %t" + theRHS.theVar.varIndex + ", i32* %t" + theLHS.theVar.varIndex + ", align 4");
							} else if ((theLHS.theType == Type.INT) &&
									(theRHS.theType == Type.CONST_INT)) {
					            // issue store insruction.
					            // Ex: store i32 value, i32* %ty
					            TextCode.add("store i32 " + theRHS.theVar.iValue + ", i32* %t" + theLHS.theVar.varIndex + ", align 4");				
							}else if ((theLHS.theType == Type.FLOAT) &&
									(theRHS.theType == Type.FLOAT)) {
					            TextCode.add("store float %t" + theRHS.theVar.varIndex + ", float* %t" + theLHS.theVar.varIndex + ", align 4");
					      }else if ((theLHS.theType == Type.FLOAT) &&
									(theRHS.theType == Type.CONST_FLOAT)) {
					            String floatBits = "0x" + Long.toHexString(Double.doubleToRawLongBits(theRHS.theVar.fValue));
					            TextCode.add("store float " + floatBits + ", float* %t" + theLHS.theVar.varIndex + ", align 4");				
							}
						}
					}
					break;
				case 2 :
					// myCompiler.g:184:4: 
					{
					if ( state.backtracking==0 ) {  //declare
					      if (symtab.containsKey(Id)) {
					         // variable re-declared.
					         System.out.println("Type Error: " + 
					            gline + ": Redeclared identifier.");
					         System.exit(0);
					      }
					      /* Add ID and its info into the symbol table. */
						      Info the_entry = new Info();
							   the_entry.theType = attr_type;
							   the_entry.theVar.varIndex = varCount;
							   varCount ++;
							   symtab.put(Id, the_entry);

					         // issue the instruction.
							   // Ex: %a = alloca i32, align 4

					         switch(attr_type){
					            case INT:
					               TextCode.add("%t" + the_entry.theVar.varIndex + " = alloca i32, align 4");
					               break;
					            case FLOAT: 
					               TextCode.add("%t" + the_entry.theVar.varIndex + " = alloca float, align 4");
					               break;
					            case CHAR:
					               TextCode.add("%t" + the_entry.theVar.varIndex + " = alloca i8, align 1");
					               break;
					         }
					   }
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
	// $ANTLR end "assign_or_declare"



	// $ANTLR start "arith_expression"
	// myCompiler.g:216:1: arith_expression returns [Info theInfo] : a= multExpr ( '+' b= multExpr | '-' c= multExpr )* ;
	public final Info arith_expression() throws RecognitionException {
		Info theInfo = null;


		ParserRuleReturnScope a =null;
		ParserRuleReturnScope b =null;
		ParserRuleReturnScope c =null;

		theInfo = new Info();
		try {
			// myCompiler.g:219:4: (a= multExpr ( '+' b= multExpr | '-' c= multExpr )* )
			// myCompiler.g:219:6: a= multExpr ( '+' b= multExpr | '-' c= multExpr )*
			{
			pushFollow(FOLLOW_multExpr_in_arith_expression340);
			a=multExpr();
			state._fsp--;
			if (state.failed) return theInfo;
			if ( state.backtracking==0 ) { theInfo =(a!=null?((myCompilerParser.multExpr_return)a).theInfo:null); }
			// myCompiler.g:220:4: ( '+' b= multExpr | '-' c= multExpr )*
			loop6:
			while (true) {
				int alt6=3;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==ADD) ) {
					alt6=1;
				}
				else if ( (LA6_0==SUB) ) {
					alt6=2;
				}

				switch (alt6) {
				case 1 :
					// myCompiler.g:220:6: '+' b= multExpr
					{
					match(input,ADD,FOLLOW_ADD_in_arith_expression349); if (state.failed) return theInfo;
					pushFollow(FOLLOW_multExpr_in_arith_expression353);
					b=multExpr();
					state._fsp--;
					if (state.failed) return theInfo;
					if ( state.backtracking==0 ) {
					      // We need to do type checking first.
					      if((b!=null?((myCompilerParser.multExpr_return)b).theInfo:null).theType != theInfo.theType){
					         int get=0;
					         //如果是一個int 一個const_int 可以執行
					         if(!(((b!=null?((myCompilerParser.multExpr_return)b).theInfo:null).theType==Type.INT || (b!=null?((myCompilerParser.multExpr_return)b).theInfo:null).theType==Type.CONST_INT) 
					            && (theInfo.theType==Type.INT||theInfo.theType==Type.CONST_INT))){
					            get=get+1;
					         }
					         //如果是一個float 一個const_float 可以執行
					         if(!(((b!=null?((myCompilerParser.multExpr_return)b).theInfo:null).theType==Type.FLOAT || (b!=null?((myCompilerParser.multExpr_return)b).theInfo:null).theType==Type.CONST_FLOAT) 
					            && (theInfo.theType==Type.FLOAT||theInfo.theType==Type.CONST_FLOAT))){
					            get=get+1;
					         }
					         if(get==2){
					            System.out.println("Error! "+(a!=null?(a.start):null).getLine()+
								   ": Type mismatch for the operator '+' in an expression.");
					            System.exit(0);
					         }
					      }

					      int change =1;			  
					      // code generation.					   
					      if (((a!=null?((myCompilerParser.multExpr_return)a).theInfo:null).theType == Type.INT) &&
					         ((b!=null?((myCompilerParser.multExpr_return)b).theInfo:null).theType == Type.INT)) {
					         TextCode.add("%t" + varCount + " = add nsw i32 %t" + theInfo.theVar.varIndex + ", %t" + (b!=null?((myCompilerParser.multExpr_return)b).theInfo:null).theVar.varIndex);
								theInfo.theType =Type.INT;
					      } else if (((a!=null?((myCompilerParser.multExpr_return)a).theInfo:null).theType == Type.INT) &&
							   ((b!=null?((myCompilerParser.multExpr_return)b).theInfo:null).theType == Type.CONST_INT)) {
					         TextCode.add("%t" + varCount + " = add nsw i32 %t" + theInfo.theVar.varIndex + ", " + (b!=null?((myCompilerParser.multExpr_return)b).theInfo:null).theVar.iValue);
								theInfo.theType =Type.INT;	   
					      }else if (((a!=null?((myCompilerParser.multExpr_return)a).theInfo:null).theType == Type.CONST_INT) &&
							   ((b!=null?((myCompilerParser.multExpr_return)b).theInfo:null).theType == Type.INT)){
					         TextCode.add("%t" + varCount + " = add nsw i32 " + theInfo.theVar.iValue + ", %t" + (b!=null?((myCompilerParser.multExpr_return)b).theInfo:null).theVar.varIndex);
								theInfo.theType =Type.INT;		   
					      }else if (((a!=null?((myCompilerParser.multExpr_return)a).theInfo:null).theType == Type.CONST_INT) &&
							   ((b!=null?((myCompilerParser.multExpr_return)b).theInfo:null).theType == Type.CONST_INT)){
					         theInfo.theVar.iValue = theInfo.theVar.iValue + (b!=null?((myCompilerParser.multExpr_return)b).theInfo:null).theVar.iValue;
					         change =0;
					      }else if (((a!=null?((myCompilerParser.multExpr_return)a).theInfo:null).theType == Type.FLOAT) &&
					         ((b!=null?((myCompilerParser.multExpr_return)b).theInfo:null).theType == Type.FLOAT)) {  //float
					         TextCode.add("%t" + varCount + " = fadd float %t" + theInfo.theVar.varIndex + ", %t" + (b!=null?((myCompilerParser.multExpr_return)b).theInfo:null).theVar.varIndex);
								theInfo.theType =Type.FLOAT;
					      } else if (((a!=null?((myCompilerParser.multExpr_return)a).theInfo:null).theType == Type.FLOAT) &&
							   ((b!=null?((myCompilerParser.multExpr_return)b).theInfo:null).theType == Type.CONST_FLOAT)) {
					         int varindex = theInfo.theVar.varIndex;
					         TextCode.add("%t" + varCount + " = fpext float %t"+varindex+" to double");
					         varindex = varCount++;
					         TextCode.add("%t" + varCount + " = fadd double %t" + varindex + ", " + (b!=null?((myCompilerParser.multExpr_return)b).theInfo:null).theVar.fValue);
					         varindex = varCount++;
					         TextCode.add("%t" + varCount + " = fptrunc double %t" + varindex +" to float");
								theInfo.theType =Type.FLOAT;	   
					      }else if (((a!=null?((myCompilerParser.multExpr_return)a).theInfo:null).theType == Type.CONST_FLOAT) &&
							   ((b!=null?((myCompilerParser.multExpr_return)b).theInfo:null).theType == Type.FLOAT)){
					         int varindex = (b!=null?((myCompilerParser.multExpr_return)b).theInfo:null).theVar.varIndex;
					         TextCode.add("%t" + varCount + " = fpext float %t"+varindex+" to double");
					         varindex = varCount++;
					         TextCode.add("%t" + varCount + " = fadd double " + theInfo.theVar.fValue + ", %t" + varindex);
					         varindex = varCount++;
					         TextCode.add("%t" + varCount + " = fptrunc double %t" + varindex +" to float");
								theInfo.theType =Type.FLOAT;	   
					      }else if (((a!=null?((myCompilerParser.multExpr_return)a).theInfo:null).theType == Type.CONST_FLOAT) &&
							   ((b!=null?((myCompilerParser.multExpr_return)b).theInfo:null).theType == Type.CONST_FLOAT)){
					         theInfo.theVar.fValue = theInfo.theVar.fValue + (b!=null?((myCompilerParser.multExpr_return)b).theInfo:null).theVar.fValue;
					         change =0;
					      }

					      //把TYPE改掉
					      /*if ((  theInfo.theType != Type.CONST_INT ||   theInfo.theType != Type.CONST_FLOAT)&&
					          ((b!=null?((myCompilerParser.multExpr_return)b).theInfo:null).theType != Type.CONST_INT || (b!=null?((myCompilerParser.multExpr_return)b).theInfo:null).theType != Type.CONST_FLOAT)) {
					          theInfo.theVar.varIndex = varCount;
					          varCount++;
					      }*/
					      //把TYPE改掉
					      if (change==1) {
					          theInfo.theVar.varIndex = varCount;
					          varCount++;
					      }
					   }
					}
					break;
				case 2 :
					// myCompiler.g:300:6: '-' c= multExpr
					{
					match(input,SUB,FOLLOW_SUB_in_arith_expression365); if (state.failed) return theInfo;
					pushFollow(FOLLOW_multExpr_in_arith_expression369);
					c=multExpr();
					state._fsp--;
					if (state.failed) return theInfo;
					if ( state.backtracking==0 ) {
					      // We need to do type checking first.
					      if((c!=null?((myCompilerParser.multExpr_return)c).theInfo:null).theType != theInfo.theType){
					         int get=0;
					         //如果是一個int 一個const_int 可以執行
					         if(!(((c!=null?((myCompilerParser.multExpr_return)c).theInfo:null).theType==Type.INT || (c!=null?((myCompilerParser.multExpr_return)c).theInfo:null).theType==Type.CONST_INT) 
					            && (theInfo.theType==Type.INT||theInfo.theType==Type.CONST_INT))){
					            get=get+1;
					         }
					         //如果是一個float 一個const_float 可以執行
					         if(!(((c!=null?((myCompilerParser.multExpr_return)c).theInfo:null).theType==Type.FLOAT || (c!=null?((myCompilerParser.multExpr_return)c).theInfo:null).theType==Type.CONST_FLOAT) 
					            && (theInfo.theType==Type.FLOAT||theInfo.theType==Type.CONST_FLOAT))){
					            get=get+1;
					         }
					         if(get==2){
					            System.out.println("Error! "+(a!=null?(a.start):null).getLine()+
								   ": Type mismatch for the operator '-' in an expression.");
					            System.exit(0);
					         }
					      }
										  
					      int change =1;	
					      // code generation.					   
					      if (((a!=null?((myCompilerParser.multExpr_return)a).theInfo:null).theType == Type.INT) &&
					         ((c!=null?((myCompilerParser.multExpr_return)c).theInfo:null).theType == Type.INT)) {
					         TextCode.add("%t" + varCount + " = sub nsw i32 %t" + theInfo.theVar.varIndex + ", %t" + (c!=null?((myCompilerParser.multExpr_return)c).theInfo:null).theVar.varIndex);
								theInfo.theType =Type.INT;
					      } else if (((a!=null?((myCompilerParser.multExpr_return)a).theInfo:null).theType == Type.INT) &&
							   ((c!=null?((myCompilerParser.multExpr_return)c).theInfo:null).theType == Type.CONST_INT)) {
					         TextCode.add("%t" + varCount + " = sub nsw i32 %t" + theInfo.theVar.varIndex + ", " + (c!=null?((myCompilerParser.multExpr_return)c).theInfo:null).theVar.iValue);
								theInfo.theType =Type.INT;
					      }else if (((a!=null?((myCompilerParser.multExpr_return)a).theInfo:null).theType == Type.CONST_INT) &&
							   ((c!=null?((myCompilerParser.multExpr_return)c).theInfo:null).theType == Type.INT)){
					         TextCode.add("%t" + varCount + " = sub nsw i32 " + theInfo.theVar.iValue + ", %t" + (c!=null?((myCompilerParser.multExpr_return)c).theInfo:null).theVar.varIndex);
								theInfo.theType =Type.INT;
					      }else if (((a!=null?((myCompilerParser.multExpr_return)a).theInfo:null).theType == Type.CONST_INT) &&
							   ((c!=null?((myCompilerParser.multExpr_return)c).theInfo:null).theType == Type.CONST_INT)){
					         theInfo.theVar.iValue = theInfo.theVar.iValue - (c!=null?((myCompilerParser.multExpr_return)c).theInfo:null).theVar.iValue;
					         change =0;	
					      }else if (((a!=null?((myCompilerParser.multExpr_return)a).theInfo:null).theType == Type.FLOAT) &&
					         ((c!=null?((myCompilerParser.multExpr_return)c).theInfo:null).theType == Type.FLOAT)) {     //FLOAT
					         TextCode.add("%t" + varCount + " = fsub float %t" + theInfo.theVar.varIndex + ", %t" + (c!=null?((myCompilerParser.multExpr_return)c).theInfo:null).theVar.varIndex);
								theInfo.theType =Type.FLOAT;
					      } else if (((a!=null?((myCompilerParser.multExpr_return)a).theInfo:null).theType == Type.FLOAT) &&
							   ((c!=null?((myCompilerParser.multExpr_return)c).theInfo:null).theType == Type.CONST_FLOAT)) {
					         int varindex = theInfo.theVar.varIndex;
					         TextCode.add("%t" + varCount + " = fpext float %t"+varindex+" to double");
					         varindex = varCount++;
					         TextCode.add("%t" + varCount + " = fsub double %t" + varindex + ", " + (c!=null?((myCompilerParser.multExpr_return)c).theInfo:null).theVar.fValue);
					         varindex = varCount++;
					         TextCode.add("%t" + varCount + " = fptrunc double %t" + varindex +" to float");
								theInfo.theType =Type.FLOAT;
					      }else if (((a!=null?((myCompilerParser.multExpr_return)a).theInfo:null).theType == Type.CONST_FLOAT) &&
							   ((c!=null?((myCompilerParser.multExpr_return)c).theInfo:null).theType == Type.FLOAT)){
					         int varindex = (c!=null?((myCompilerParser.multExpr_return)c).theInfo:null).theVar.varIndex;
					         TextCode.add("%t" + varCount + " = fpext float %t"+varindex+" to double");
					         varindex = varCount++;
					         TextCode.add("%t" + varCount + " = fsub double " + theInfo.theVar.fValue + ", %t" + varindex);
					         varindex = varCount++;
					         TextCode.add("%t" + varCount + " = fptrunc double %t" + varindex +" to float");
								theInfo.theType =Type.FLOAT;	
					      }else if (((a!=null?((myCompilerParser.multExpr_return)a).theInfo:null).theType == Type.CONST_FLOAT) &&
							   ((c!=null?((myCompilerParser.multExpr_return)c).theInfo:null).theType == Type.CONST_FLOAT)){
					         theInfo.theVar.fValue = theInfo.theVar.fValue - (c!=null?((myCompilerParser.multExpr_return)c).theInfo:null).theVar.fValue;
					         change =0;	
					      }

					      if (change == 1) {
					          theInfo.theVar.varIndex = varCount;
					          varCount++;
					      }
					   }
					}
					break;

				default :
					break loop6;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return theInfo;
	}
	// $ANTLR end "arith_expression"


	public static class multExpr_return extends ParserRuleReturnScope {
		public Info theInfo;
	};


	// $ANTLR start "multExpr"
	// myCompiler.g:376:1: multExpr returns [Info theInfo] : a= signExpr ( '*' b= signExpr | '/' c= signExpr )* ;
	public final myCompilerParser.multExpr_return multExpr() throws RecognitionException {
		myCompilerParser.multExpr_return retval = new myCompilerParser.multExpr_return();
		retval.start = input.LT(1);

		ParserRuleReturnScope a =null;
		ParserRuleReturnScope b =null;
		ParserRuleReturnScope c =null;

		retval.theInfo = new Info();
		try {
			// myCompiler.g:379:4: (a= signExpr ( '*' b= signExpr | '/' c= signExpr )* )
			// myCompiler.g:380:4: a= signExpr ( '*' b= signExpr | '/' c= signExpr )*
			{
			pushFollow(FOLLOW_signExpr_in_multExpr410);
			a=signExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) { retval.theInfo =(a!=null?((myCompilerParser.signExpr_return)a).theInfo:null); }
			// myCompiler.g:381:4: ( '*' b= signExpr | '/' c= signExpr )*
			loop7:
			while (true) {
				int alt7=3;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==MUL) ) {
					alt7=1;
				}
				else if ( (LA7_0==DIV) ) {
					alt7=2;
				}

				switch (alt7) {
				case 1 :
					// myCompiler.g:381:6: '*' b= signExpr
					{
					match(input,MUL,FOLLOW_MUL_in_multExpr419); if (state.failed) return retval;
					pushFollow(FOLLOW_signExpr_in_multExpr423);
					b=signExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					      if((b!=null?((myCompilerParser.signExpr_return)b).theInfo:null).theType != retval.theInfo.theType){
					         int get=0;
					         //如果是一個int 一個const_int 可以執行
					         if(!(((b!=null?((myCompilerParser.signExpr_return)b).theInfo:null).theType==Type.INT || (b!=null?((myCompilerParser.signExpr_return)b).theInfo:null).theType==Type.CONST_INT) 
					            && (retval.theInfo.theType==Type.INT||retval.theInfo.theType==Type.CONST_INT))){
					            get=get+1;
					         }
					         //如果是一個float 一個const_float 可以執行
					         if(!(((b!=null?((myCompilerParser.signExpr_return)b).theInfo:null).theType==Type.FLOAT || (b!=null?((myCompilerParser.signExpr_return)b).theInfo:null).theType==Type.CONST_FLOAT) 
					            && (retval.theInfo.theType==Type.FLOAT||retval.theInfo.theType==Type.CONST_FLOAT))){
					            get=get+1;
					         }
					         if(get==2){
					            System.out.println("Error! "+(a!=null?(a.start):null).getLine()+
								   ": Type mismatch for the operator '*' in an expression.");
					            System.exit(0);
					         }
					      }

					      int change =1;	
					      // 生成乘法操作的LLVM IR指令
					      //更新theInfo.theVar.iValue
					      if ((retval.theInfo.theType == Type.INT) && ((b!=null?((myCompilerParser.signExpr_return)b).theInfo:null).theType == Type.INT)) {
					         TextCode.add("%t" + varCount + " = mul nsw i32 %t" + retval.theInfo.theVar.varIndex + ", %t" + (b!=null?((myCompilerParser.signExpr_return)b).theInfo:null).theVar.varIndex);
					         retval.theInfo.theType =Type.INT;
					      }else if((retval.theInfo.theType == Type.INT) && ((b!=null?((myCompilerParser.signExpr_return)b).theInfo:null).theType == Type.CONST_INT)){
					         TextCode.add("%t" + varCount + " = mul nsw i32 %t" + retval.theInfo.theVar.varIndex + ", " + (b!=null?((myCompilerParser.signExpr_return)b).theInfo:null).theVar.iValue);
					         retval.theInfo.theType =Type.INT;
					      }else if((retval.theInfo.theType == Type.CONST_INT) && ((b!=null?((myCompilerParser.signExpr_return)b).theInfo:null).theType == Type.INT)){
					         TextCode.add("%t" + varCount + " = mul nsw i32 " + retval.theInfo.theVar.iValue + ", %t" + (b!=null?((myCompilerParser.signExpr_return)b).theInfo:null).theVar.varIndex);
					         retval.theInfo.theType =Type.INT;
					      }else if((retval.theInfo.theType == Type.CONST_INT) && ((b!=null?((myCompilerParser.signExpr_return)b).theInfo:null).theType == Type.CONST_INT)){
					         retval.theInfo.theVar.iValue = retval.theInfo.theVar.iValue * (b!=null?((myCompilerParser.signExpr_return)b).theInfo:null).theVar.iValue;
					         change =0;	
					      } else if ((retval.theInfo.theType == Type.FLOAT) && ((b!=null?((myCompilerParser.signExpr_return)b).theInfo:null).theType == Type.FLOAT)) {//float處理
					         TextCode.add("%t" + varCount + " = fmul float %t" + retval.theInfo.theVar.varIndex + ", %t" + (b!=null?((myCompilerParser.signExpr_return)b).theInfo:null).theVar.varIndex);
					         retval.theInfo.theType =Type.FLOAT;
					      }else if((retval.theInfo.theType == Type.FLOAT) && ((b!=null?((myCompilerParser.signExpr_return)b).theInfo:null).theType == Type.CONST_FLOAT)){
					         int varindex = retval.theInfo.theVar.varIndex;
					         TextCode.add("%t" + varCount + " = fpext float %t"+varindex+" to double");
					         varindex = varCount++;
					         TextCode.add("%t" + varCount + " = fmul double %t" + varindex + ", " + (b!=null?((myCompilerParser.signExpr_return)b).theInfo:null).theVar.fValue);
					         varindex = varCount++;
					         TextCode.add("%t" + varCount + " = fptrunc double %t" + varindex +" to float");
								retval.theInfo.theType =Type.FLOAT;
					      }else if((retval.theInfo.theType == Type.CONST_FLOAT) && ((b!=null?((myCompilerParser.signExpr_return)b).theInfo:null).theType == Type.FLOAT)){
					         int varindex = (b!=null?((myCompilerParser.signExpr_return)b).theInfo:null).theVar.varIndex;
					         TextCode.add("%t" + varCount + " = fpext float %t"+varindex+" to double");
					         varindex = varCount++;
					         TextCode.add("%t" + varCount + " = fmul double " + retval.theInfo.theVar.fValue + ", %t" + varindex);
					         varindex = varCount++;
					         TextCode.add("%t" + varCount + " = fptrunc double %t" + varindex +" to float");
								retval.theInfo.theType =Type.FLOAT;	
					      }else if((retval.theInfo.theType == Type.CONST_FLOAT) && ((b!=null?((myCompilerParser.signExpr_return)b).theInfo:null).theType == Type.CONST_FLOAT)){
					         retval.theInfo.theVar.fValue = retval.theInfo.theVar.fValue * (b!=null?((myCompilerParser.signExpr_return)b).theInfo:null).theVar.fValue;
					         change =0;	
					      }


					      //把TYPE改掉
					      if (change == 1) {
					          retval.theInfo.theVar.varIndex = varCount;
					          varCount++;
					      }

					   }
					}
					break;
				case 2 :
					// myCompiler.g:449:6: '/' c= signExpr
					{
					match(input,DIV,FOLLOW_DIV_in_multExpr435); if (state.failed) return retval;
					pushFollow(FOLLOW_signExpr_in_multExpr439);
					c=signExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					      if((c!=null?((myCompilerParser.signExpr_return)c).theInfo:null).theType != retval.theInfo.theType){
					         int get=0;
					         //如果是一個int 一個const_int 可以執行
					         if(!(((c!=null?((myCompilerParser.signExpr_return)c).theInfo:null).theType==Type.INT || (c!=null?((myCompilerParser.signExpr_return)c).theInfo:null).theType==Type.CONST_INT) 
					            && (retval.theInfo.theType==Type.INT||retval.theInfo.theType==Type.CONST_INT))){
					            get=get+1;
					         }
					         //如果是一個float 一個const_float 可以執行
					         if(!(((c!=null?((myCompilerParser.signExpr_return)c).theInfo:null).theType==Type.FLOAT || (c!=null?((myCompilerParser.signExpr_return)c).theInfo:null).theType==Type.CONST_FLOAT) 
					            && (retval.theInfo.theType==Type.FLOAT||retval.theInfo.theType==Type.CONST_FLOAT))){
					            get=get+1;
					         }
					         if(get==2){
					            System.out.println("Error! "+(a!=null?(a.start):null).getLine()+
								   ": Type mismatch for the operator '/' in an expression.");
					            System.exit(0);
					         }
					      }

					      int change =1;	
					      // 生成除法操作的LLVM IR指令
					      if ((retval.theInfo.theType == Type.INT) && ((c!=null?((myCompilerParser.signExpr_return)c).theInfo:null).theType == Type.INT)) {
					         TextCode.add("%t" + varCount + " = sdiv i32 %t" + retval.theInfo.theVar.varIndex + ", %t" + (c!=null?((myCompilerParser.signExpr_return)c).theInfo:null).theVar.varIndex);
					         retval.theInfo.theType =Type.INT;
					      }else if((retval.theInfo.theType == Type.INT) && ((c!=null?((myCompilerParser.signExpr_return)c).theInfo:null).theType == Type.CONST_INT)){
					         TextCode.add("%t" + varCount + " = sdiv i32 %t" + retval.theInfo.theVar.varIndex + ", " + (c!=null?((myCompilerParser.signExpr_return)c).theInfo:null).theVar.iValue);
					         retval.theInfo.theType =Type.INT;
					      }else if((retval.theInfo.theType == Type.CONST_INT) && ((c!=null?((myCompilerParser.signExpr_return)c).theInfo:null).theType == Type.INT)){
					         TextCode.add("%t" + varCount + " = sdiv i32 " + retval.theInfo.theVar.iValue + ", %t" + (c!=null?((myCompilerParser.signExpr_return)c).theInfo:null).theVar.varIndex);
					         retval.theInfo.theType =Type.INT;
					      }else if((retval.theInfo.theType == Type.CONST_INT) && ((c!=null?((myCompilerParser.signExpr_return)c).theInfo:null).theType == Type.CONST_INT)){
					         retval.theInfo.theVar.iValue = retval.theInfo.theVar.iValue / (c!=null?((myCompilerParser.signExpr_return)c).theInfo:null).theVar.iValue;
					         change =0;	
					      }else if ((retval.theInfo.theType == Type.FLOAT) && ((c!=null?((myCompilerParser.signExpr_return)c).theInfo:null).theType == Type.FLOAT)) {    //float
					         TextCode.add("%t" + varCount + " = fdiv float %t" + retval.theInfo.theVar.varIndex + ", %t" + (c!=null?((myCompilerParser.signExpr_return)c).theInfo:null).theVar.varIndex);
					         retval.theInfo.theType =Type.FLOAT;
					      }else if((retval.theInfo.theType == Type.FLOAT) && ((c!=null?((myCompilerParser.signExpr_return)c).theInfo:null).theType == Type.CONST_FLOAT)){
					         int varindex = retval.theInfo.theVar.varIndex;
					         TextCode.add("%t" + varCount + " = fpext float %t"+varindex+" to double");
					         varindex = varCount++;
					         TextCode.add("%t" + varCount + " = fdiv double %t" + varindex + ", " + (c!=null?((myCompilerParser.signExpr_return)c).theInfo:null).theVar.fValue);
					         varindex = varCount++;
					         TextCode.add("%t" + varCount + " = fptrunc double %t" + varindex +" to float");
								retval.theInfo.theType =Type.FLOAT;
					         //TextCode.add("%t" + varCount + " = fdiv float %t" + retval.theInfo.theVar.varIndex + ", " + (c!=null?((myCompilerParser.signExpr_return)c).theInfo:null).theVar.fValue);
					         //retval.theInfo.theType =Type.FLOAT;
					      }else if((retval.theInfo.theType == Type.CONST_FLOAT) && ((c!=null?((myCompilerParser.signExpr_return)c).theInfo:null).theType == Type.FLOAT)){
					         int varindex = (c!=null?((myCompilerParser.signExpr_return)c).theInfo:null).theVar.varIndex;
					         TextCode.add("%t" + varCount + " = fpext float %t"+varindex+" to double");
					         varindex = varCount++;
					         TextCode.add("%t" + varCount + " = fdiv double " + retval.theInfo.theVar.fValue + ", %t" + varindex);
					         varindex = varCount++;
					         TextCode.add("%t" + varCount + " = fptrunc double %t" + varindex +" to float");
								retval.theInfo.theType =Type.FLOAT;	
					         //TextCode.add("%t" + varCount + " = fdiv float " + retval.theInfo.theVar.fValue + ", %t" + (c!=null?((myCompilerParser.signExpr_return)c).theInfo:null).theVar.varIndex);
					         //retval.theInfo.theType =Type.FLOAT;
					      }else if((retval.theInfo.theType == Type.CONST_FLOAT) && ((c!=null?((myCompilerParser.signExpr_return)c).theInfo:null).theType == Type.CONST_FLOAT)){
					         retval.theInfo.theVar.fValue = retval.theInfo.theVar.fValue / (c!=null?((myCompilerParser.signExpr_return)c).theInfo:null).theVar.fValue;
					         change =0;	
					      }

					      if ( change == 1	) {
					          retval.theInfo.theVar.varIndex = varCount;
					          varCount++;
					      }
					   }
					}
					break;

				default :
					break loop7;
				}
			}

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
		public Info theInfo;
	};


	// $ANTLR start "signExpr"
	// myCompiler.g:520:1: signExpr returns [Info theInfo] : (a= primaryExpr | '-' b= primaryExpr );
	public final myCompilerParser.signExpr_return signExpr() throws RecognitionException {
		myCompilerParser.signExpr_return retval = new myCompilerParser.signExpr_return();
		retval.start = input.LT(1);

		Info a =null;
		Info b =null;

		retval.theInfo = new Info();
		try {
			// myCompiler.g:523:4: (a= primaryExpr | '-' b= primaryExpr )
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0==Floating_point_constant||(LA8_0 >= Identifier && LA8_0 <= Integer_constant)||LA8_0==L_PAREN) ) {
				alt8=1;
			}
			else if ( (LA8_0==SUB) ) {
				alt8=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}

			switch (alt8) {
				case 1 :
					// myCompiler.g:523:10: a= primaryExpr
					{
					pushFollow(FOLLOW_primaryExpr_in_signExpr476);
					a=primaryExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) { retval.theInfo =a; }
					}
					break;
				case 2 :
					// myCompiler.g:524:6: '-' b= primaryExpr
					{
					match(input,SUB,FOLLOW_SUB_in_signExpr486); if (state.failed) return retval;
					pushFollow(FOLLOW_primaryExpr_in_signExpr490);
					b=primaryExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) { retval.theInfo =b; }
					if ( state.backtracking==0 ) {
					      if(retval.theInfo.theType != Type.INT && retval.theInfo.theType != Type.CONST_INT && retval.theInfo.theType != Type.FLOAT && retval.theInfo.theType != Type.CONST_FLOAT){
					         System.out.println("Type Error: " + 
					               (retval.start).getLine() + ": '-' can only be applied to int or const int or float or const float types.");
					             System.exit(0);
					      }
					      //產生負號
					      if (retval.theInfo.theType == Type.INT) {
					         TextCode.add("%t" + varCount + " = sub nsw i32 0, %t" + retval.theInfo.theVar.varIndex);
					      } else if (retval.theInfo.theType == Type.FLOAT) {
					         TextCode.add("%t" + varCount + " = fsub float 0.0, %t" + retval.theInfo.theVar.varIndex);
					      }else if(retval.theInfo.theType == Type.CONST_INT){
					         retval.theInfo.theVar.iValue = -1*retval.theInfo.theVar.iValue;
					         //TextCode.add("%t" + varCount + " = sub nsw i32 0, " + retval.theInfo.theVar.iValue);
					      }else if(retval.theInfo.theType == Type.CONST_FLOAT){
					         retval.theInfo.theVar.fValue = -1*retval.theInfo.theVar.fValue;
					         //TextCode.add("%t" + varCount + " = fsub nsw float 0.0, " + retval.theInfo.theVar.iValue);
					      }

					      if((retval.theInfo.theType == Type.INT) || (retval.theInfo.theType == Type.FLOAT)){
					         retval.theInfo.theVar.varIndex = varCount;
					         varCount++;
					      }
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
	// $ANTLR end "signExpr"



	// $ANTLR start "primaryExpr"
	// myCompiler.g:552:1: primaryExpr returns [Info theInfo] : ( Integer_constant | Floating_point_constant | Identifier | '(' arith_expression ')' );
	public final Info primaryExpr() throws RecognitionException {
		Info theInfo = null;


		Token Integer_constant4=null;
		Token Floating_point_constant5=null;
		Token Identifier6=null;
		Info arith_expression7 =null;

		theInfo = new Info();
		try {
			// myCompiler.g:555:4: ( Integer_constant | Floating_point_constant | Identifier | '(' arith_expression ')' )
			int alt9=4;
			switch ( input.LA(1) ) {
			case Integer_constant:
				{
				alt9=1;
				}
				break;
			case Floating_point_constant:
				{
				alt9=2;
				}
				break;
			case Identifier:
				{
				alt9=3;
				}
				break;
			case L_PAREN:
				{
				alt9=4;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return theInfo;}
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}
			switch (alt9) {
				case 1 :
					// myCompiler.g:555:6: Integer_constant
					{
					Integer_constant4=(Token)match(input,Integer_constant,FOLLOW_Integer_constant_in_primaryExpr520); if (state.failed) return theInfo;
					if ( state.backtracking==0 ) {
					      theInfo.theType = Type.CONST_INT;
							theInfo.theVar.iValue = Integer.parseInt((Integer_constant4!=null?Integer_constant4.getText():null));
					   }
					}
					break;
				case 2 :
					// myCompiler.g:560:6: Floating_point_constant
					{
					Floating_point_constant5=(Token)match(input,Floating_point_constant,FOLLOW_Floating_point_constant_in_primaryExpr530); if (state.failed) return theInfo;
					if ( state.backtracking==0 ) {
					      theInfo.theType = Type.CONST_FLOAT;
							theInfo.theVar.fValue = Float.parseFloat((Floating_point_constant5!=null?Floating_point_constant5.getText():null));
					   }
					}
					break;
				case 3 :
					// myCompiler.g:565:6: Identifier
					{
					Identifier6=(Token)match(input,Identifier,FOLLOW_Identifier_in_primaryExpr542); if (state.failed) return theInfo;
					if ( state.backtracking==0 ) {
					      //未宣告報錯
					      if(!symtab.containsKey((Identifier6!=null?Identifier6.getText():null))){
					          System.out.println("Type Error: " + 
					            Identifier6.getLine() + ": Undeclare.");
					         System.exit(0);
					      }
					      // get type information from symtab.

					      Type the_type = symtab.get((Identifier6!=null?Identifier6.getText():null)).theType;
							theInfo.theType = the_type;

					      
					      // get variable index from symtab.
					      int vIndex = symtab.get((Identifier6!=null?Identifier6.getText():null)).theVar.varIndex;
									
					      switch (the_type) {
					         case INT: 
									TextCode.add("%t" + varCount + " = load i32, i32* %t" + vIndex + ", align 4");
									theInfo.theVar.varIndex = varCount;
									varCount ++;
					            break;
					         case FLOAT:
					            TextCode.add("%t" + varCount + " = load float, float* %t" + vIndex + ", align 4");
					            theInfo.theVar.varIndex = varCount;
									varCount ++;
					            break;
					         case CHAR:
					            System.out.println("Type Error: " + 
					            Identifier6.getLine() + ": Type error in arith_expression only use int and float type identifier.");
					            System.exit(0);
					            break;
					      }
					   }
					}
					break;
				case 4 :
					// myCompiler.g:601:4: '(' arith_expression ')'
					{
					match(input,L_PAREN,FOLLOW_L_PAREN_in_primaryExpr554); if (state.failed) return theInfo;
					pushFollow(FOLLOW_arith_expression_in_primaryExpr556);
					arith_expression7=arith_expression();
					state._fsp--;
					if (state.failed) return theInfo;
					match(input,R_PAREN,FOLLOW_R_PAREN_in_primaryExpr558); if (state.failed) return theInfo;
					if ( state.backtracking==0 ) {
					      theInfo = arith_expression7;
					   }
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
		return theInfo;
	}
	// $ANTLR end "primaryExpr"


	public static class flow_return extends ParserRuleReturnScope {
		public Info theInfo;
		public String LEnd;
	};


	// $ANTLR start "flow"
	// myCompiler.g:607:1: flow returns [Info theInfo, String LEnd] : ( if_statement[$LEnd] | while_stat | for_stat );
	public final myCompilerParser.flow_return flow() throws RecognitionException {
		myCompilerParser.flow_return retval = new myCompilerParser.flow_return();
		retval.start = input.LT(1);

		retval.theInfo = new Info();retval.LEnd =newLabel();
		try {
			// myCompiler.g:609:4: ( if_statement[$LEnd] | while_stat | for_stat )
			int alt10=3;
			switch ( input.LA(1) ) {
			case IF:
				{
				alt10=1;
				}
				break;
			case WHILE:
				{
				alt10=2;
				}
				break;
			case FOR:
				{
				alt10=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}
			switch (alt10) {
				case 1 :
					// myCompiler.g:610:4: if_statement[$LEnd]
					{
					pushFollow(FOLLOW_if_statement_in_flow590);
					if_statement(retval.LEnd);
					state._fsp--;
					if (state.failed) return retval;
					}
					break;
				case 2 :
					// myCompiler.g:612:4: while_stat
					{
					pushFollow(FOLLOW_while_stat_in_flow602);
					while_stat();
					state._fsp--;
					if (state.failed) return retval;
					}
					break;
				case 3 :
					// myCompiler.g:614:4: for_stat
					{
					pushFollow(FOLLOW_for_stat_in_flow612);
					for_stat();
					state._fsp--;
					if (state.failed) return retval;
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


	public static class for_stat_return extends ParserRuleReturnScope {
		public String loopL;
		public String condL;
		public String tailL;
		public String endL;
	};


	// $ANTLR start "for_stat"
	// myCompiler.g:617:1: for_stat returns [String loopL,String condL,String tailL,String endL] : FOR '(' h= assign ';' g= compare_expression ';' i= assign ')' '{' statements '}' ;
	public final myCompilerParser.for_stat_return for_stat() throws RecognitionException {
		myCompilerParser.for_stat_return retval = new myCompilerParser.for_stat_return();
		retval.start = input.LT(1);

		ParserRuleReturnScope g =null;

		try {
			// myCompiler.g:618:4: ( FOR '(' h= assign ';' g= compare_expression ';' i= assign ')' '{' statements '}' )
			// myCompiler.g:619:4: FOR '(' h= assign ';' g= compare_expression ';' i= assign ')' '{' statements '}'
			{
			if ( state.backtracking==0 ) {
			      retval.loopL = newLabel();
			      retval.condL = newLabel();
			      retval.tailL = newLabel();
			      retval.endL =  newLabel();
			   }
			match(input,FOR,FOLLOW_FOR_in_for_stat638); if (state.failed) return retval;
			match(input,L_PAREN,FOLLOW_L_PAREN_in_for_stat639); if (state.failed) return retval;
			pushFollow(FOLLOW_assign_in_for_stat642);
			assign();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) {//先初始化
			      TextCode.add("br label %" + retval.condL);
			      TextCode.add(retval.condL + ":");
			   }
			match(input,Semicolon,FOLLOW_Semicolon_in_for_stat652); if (state.failed) return retval;
			pushFollow(FOLLOW_compare_expression_in_for_stat655);
			g=compare_expression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			      TextCode.add("br i1  %t"+(g!=null?((myCompilerParser.compare_expression_return)g).theInfo:null).theVar.varIndex +", label %" + retval.loopL + ", label %" + retval.endL); 
			      TextCode.add(retval.tailL + ":");
			   }
			match(input,Semicolon,FOLLOW_Semicolon_in_for_stat665); if (state.failed) return retval;
			pushFollow(FOLLOW_assign_in_for_stat668);
			assign();
			state._fsp--;
			if (state.failed) return retval;
			match(input,R_PAREN,FOLLOW_R_PAREN_in_for_stat669); if (state.failed) return retval;
			if ( state.backtracking==0 ) { //tail結束要回 cond
			      TextCode.add("br label %" + retval.condL);
			   }
			if ( state.backtracking==0 ) {//開始執行loop
			      TextCode.add(retval.loopL + ":");
			   }
			match(input,L_BRACE,FOLLOW_L_BRACE_in_for_stat684); if (state.failed) return retval;
			pushFollow(FOLLOW_statements_in_for_stat686);
			statements();
			state._fsp--;
			if (state.failed) return retval;
			match(input,R_BRACE,FOLLOW_R_BRACE_in_for_stat688); if (state.failed) return retval;
			if ( state.backtracking==0 ) {//執行完處理後半部分 回tailL
			      TextCode.add("br label %" + retval.tailL);
			      TextCode.add(retval.endL + ":");
			   }
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
	// $ANTLR end "for_stat"


	public static class while_stat_return extends ParserRuleReturnScope {
		public String startLabel;
		public String trueLabel;
		public String endLabel;
	};


	// $ANTLR start "while_stat"
	// myCompiler.g:649:1: while_stat returns [String startLabel, String trueLabel, String endLabel] : WHILE '(' a= compare_expression ')' (b= statement | '{' c= statements '}' ) ;
	public final myCompilerParser.while_stat_return while_stat() throws RecognitionException {
		myCompilerParser.while_stat_return retval = new myCompilerParser.while_stat_return();
		retval.start = input.LT(1);

		ParserRuleReturnScope a =null;

		try {
			// myCompiler.g:650:4: ( WHILE '(' a= compare_expression ')' (b= statement | '{' c= statements '}' ) )
			// myCompiler.g:651:4: WHILE '(' a= compare_expression ')' (b= statement | '{' c= statements '}' )
			{
			if ( state.backtracking==0 ) {
			      retval.startLabel = newLabel();
			      retval.trueLabel = newLabel();
			      retval.endLabel = newLabel();
			      TextCode.add("br label %" + retval.startLabel);
			      TextCode.add(retval.startLabel+':');
			   }
			match(input,WHILE,FOLLOW_WHILE_in_while_stat719); if (state.failed) return retval;
			match(input,L_PAREN,FOLLOW_L_PAREN_in_while_stat720); if (state.failed) return retval;
			pushFollow(FOLLOW_compare_expression_in_while_stat723);
			a=compare_expression();
			state._fsp--;
			if (state.failed) return retval;
			match(input,R_PAREN,FOLLOW_R_PAREN_in_while_stat724); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			      if ((a!=null?((myCompilerParser.compare_expression_return)a).theInfo:null).theType != Type.BOOL) {
			         System.out.println("Error! " + (a!=null?(a.start):null).getLine() + ": Condition in WHILE statement must be a boolean expression.");
			         System.exit(0);
			      }
			      TextCode.add("br i1 %t" + (a!=null?((myCompilerParser.compare_expression_return)a).theInfo:null).theVar.varIndex + ", label %" + retval.trueLabel + ", label %" + retval.endLabel);
			      TextCode.add(retval.trueLabel + ":");
			   }
			// myCompiler.g:668:4: (b= statement | '{' c= statements '}' )
			int alt11=2;
			int LA11_0 = input.LA(1);
			if ( (LA11_0==CHAR||(LA11_0 >= FLOAT && LA11_0 <= FOR)||LA11_0==IF||(LA11_0 >= INT && LA11_0 <= Identifier)||(LA11_0 >= PRINTF && LA11_0 <= RETURN)||LA11_0==SCANF||(LA11_0 >= VOID && LA11_0 <= WHILE)) ) {
				alt11=1;
			}
			else if ( (LA11_0==L_BRACE) ) {
				alt11=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 11, 0, input);
				throw nvae;
			}

			switch (alt11) {
				case 1 :
					// myCompiler.g:668:5: b= statement
					{
					pushFollow(FOLLOW_statement_in_while_stat738);
					statement();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					      TextCode.add("br label %" + retval.startLabel);
					      TextCode.add(retval.endLabel + ":");
					   }
					}
					break;
				case 2 :
					// myCompiler.g:674:5: '{' c= statements '}'
					{
					match(input,L_BRACE,FOLLOW_L_BRACE_in_while_stat750); if (state.failed) return retval;
					pushFollow(FOLLOW_statements_in_while_stat753);
					statements();
					state._fsp--;
					if (state.failed) return retval;
					match(input,R_BRACE,FOLLOW_R_BRACE_in_while_stat754); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					      TextCode.add("br label %" + retval.startLabel);
					      TextCode.add(retval.endLabel + ":");
					   }
					}
					break;

			}

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
	// $ANTLR end "while_stat"


	public static class if_statement_return extends ParserRuleReturnScope {
		public String LTrue;
		public String LFalse;
	};


	// $ANTLR start "if_statement"
	// myCompiler.g:682:1: if_statement[String LEnd] returns [String LTrue, String LFalse] : IF '(' a= compare_expression ')' ( statement | '{' statements '}' ) ( ( ELSE )=> ELSE else_statement |) ;
	public final myCompilerParser.if_statement_return if_statement(String LEnd) throws RecognitionException {
		myCompilerParser.if_statement_return retval = new myCompilerParser.if_statement_return();
		retval.start = input.LT(1);

		ParserRuleReturnScope a =null;

		try {
			// myCompiler.g:683:5: ( IF '(' a= compare_expression ')' ( statement | '{' statements '}' ) ( ( ELSE )=> ELSE else_statement |) )
			// myCompiler.g:683:7: IF '(' a= compare_expression ')' ( statement | '{' statements '}' ) ( ( ELSE )=> ELSE else_statement |)
			{
			match(input,IF,FOLLOW_IF_in_if_statement786); if (state.failed) return retval;
			match(input,L_PAREN,FOLLOW_L_PAREN_in_if_statement788); if (state.failed) return retval;
			pushFollow(FOLLOW_compare_expression_in_if_statement792);
			a=compare_expression();
			state._fsp--;
			if (state.failed) return retval;
			match(input,R_PAREN,FOLLOW_R_PAREN_in_if_statement793); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			        if ((a!=null?((myCompilerParser.compare_expression_return)a).theInfo:null).theType != Type.BOOL) {
			            System.out.println("Error! " + (a!=null?(a.start):null).getLine() + ": Not boolean in condition.");
			        } else {
			            retval.LTrue = newLabel();
			            retval.LFalse = newLabel();
			            TextCode.add("br i1 %t" + (a!=null?((myCompilerParser.compare_expression_return)a).theInfo:null).theVar.varIndex + ", label %" + retval.LTrue + ", label %" + retval.LFalse);
			            TextCode.add(retval.LTrue + ":");
			        }
			    }
			// myCompiler.g:692:7: ( statement | '{' statements '}' )
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( (LA12_0==CHAR||(LA12_0 >= FLOAT && LA12_0 <= FOR)||LA12_0==IF||(LA12_0 >= INT && LA12_0 <= Identifier)||(LA12_0 >= PRINTF && LA12_0 <= RETURN)||LA12_0==SCANF||(LA12_0 >= VOID && LA12_0 <= WHILE)) ) {
				alt12=1;
			}
			else if ( (LA12_0==L_BRACE) ) {
				alt12=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				throw nvae;
			}

			switch (alt12) {
				case 1 :
					// myCompiler.g:692:8: statement
					{
					pushFollow(FOLLOW_statement_in_if_statement798);
					statement();
					state._fsp--;
					if (state.failed) return retval;
					}
					break;
				case 2 :
					// myCompiler.g:692:20: '{' statements '}'
					{
					match(input,L_BRACE,FOLLOW_L_BRACE_in_if_statement802); if (state.failed) return retval;
					pushFollow(FOLLOW_statements_in_if_statement803);
					statements();
					state._fsp--;
					if (state.failed) return retval;
					match(input,R_BRACE,FOLLOW_R_BRACE_in_if_statement804); if (state.failed) return retval;
					}
					break;

			}

			// myCompiler.g:693:9: ( ( ELSE )=> ELSE else_statement |)
			int alt13=2;
			int LA13_0 = input.LA(1);
			if ( (LA13_0==ELSE) ) {
				int LA13_1 = input.LA(2);
				if ( (synpred1_myCompiler()) ) {
					alt13=1;
				}
				else if ( (true) ) {
					alt13=2;
				}

			}
			else if ( (LA13_0==CHAR||(LA13_0 >= FLOAT && LA13_0 <= FOR)||LA13_0==IF||(LA13_0 >= INT && LA13_0 <= Identifier)||(LA13_0 >= PRINTF && LA13_0 <= R_BRACE)||LA13_0==SCANF||(LA13_0 >= VOID && LA13_0 <= WHILE)) ) {
				alt13=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 13, 0, input);
				throw nvae;
			}

			switch (alt13) {
				case 1 :
					// myCompiler.g:693:11: ( ELSE )=> ELSE else_statement
					{
					if ( state.backtracking==0 ) {
					            TextCode.add("br label %" + LEnd);
					            TextCode.add(retval.LFalse + ":");
					        }
					match(input,ELSE,FOLLOW_ELSE_in_if_statement824); if (state.failed) return retval;
					pushFollow(FOLLOW_else_statement_in_if_statement826);
					else_statement();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					            TextCode.add("br label %" + LEnd);
					            TextCode.add(LEnd + ":");
					        }
					}
					break;
				case 2 :
					// myCompiler.g:700:11: 
					{
					if ( state.backtracking==0 ) {
					            TextCode.add("br label %" + retval.LFalse);
					            TextCode.add(retval.LFalse + ":");
					        }
					}
					break;

			}

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
	// $ANTLR end "if_statement"



	// $ANTLR start "else_statement"
	// myCompiler.g:705:1: else_statement returns [String LEnd] : ( ( IF )=> if_statement[$LEnd] | ( statement | '{' statements '}' ) );
	public final String else_statement() throws RecognitionException {
		String LEnd = null;


		LEnd =newLabel();
		try {
			// myCompiler.g:707:5: ( ( IF )=> if_statement[$LEnd] | ( statement | '{' statements '}' ) )
			int alt15=2;
			int LA15_0 = input.LA(1);
			if ( (LA15_0==IF) ) {
				int LA15_1 = input.LA(2);
				if ( (synpred2_myCompiler()) ) {
					alt15=1;
				}
				else if ( (true) ) {
					alt15=2;
				}

			}
			else if ( (LA15_0==CHAR||(LA15_0 >= FLOAT && LA15_0 <= FOR)||(LA15_0 >= INT && LA15_0 <= Identifier)||LA15_0==L_BRACE||(LA15_0 >= PRINTF && LA15_0 <= RETURN)||LA15_0==SCANF||(LA15_0 >= VOID && LA15_0 <= WHILE)) ) {
				alt15=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return LEnd;}
				NoViableAltException nvae =
					new NoViableAltException("", 15, 0, input);
				throw nvae;
			}

			switch (alt15) {
				case 1 :
					// myCompiler.g:708:5: ( IF )=> if_statement[$LEnd]
					{
					pushFollow(FOLLOW_if_statement_in_else_statement874);
					if_statement(LEnd);
					state._fsp--;
					if (state.failed) return LEnd;
					}
					break;
				case 2 :
					// myCompiler.g:709:6: ( statement | '{' statements '}' )
					{
					// myCompiler.g:709:6: ( statement | '{' statements '}' )
					int alt14=2;
					int LA14_0 = input.LA(1);
					if ( (LA14_0==CHAR||(LA14_0 >= FLOAT && LA14_0 <= FOR)||LA14_0==IF||(LA14_0 >= INT && LA14_0 <= Identifier)||(LA14_0 >= PRINTF && LA14_0 <= RETURN)||LA14_0==SCANF||(LA14_0 >= VOID && LA14_0 <= WHILE)) ) {
						alt14=1;
					}
					else if ( (LA14_0==L_BRACE) ) {
						alt14=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return LEnd;}
						NoViableAltException nvae =
							new NoViableAltException("", 14, 0, input);
						throw nvae;
					}

					switch (alt14) {
						case 1 :
							// myCompiler.g:709:7: statement
							{
							pushFollow(FOLLOW_statement_in_else_statement883);
							statement();
							state._fsp--;
							if (state.failed) return LEnd;
							}
							break;
						case 2 :
							// myCompiler.g:709:19: '{' statements '}'
							{
							match(input,L_BRACE,FOLLOW_L_BRACE_in_else_statement887); if (state.failed) return LEnd;
							pushFollow(FOLLOW_statements_in_else_statement888);
							statements();
							state._fsp--;
							if (state.failed) return LEnd;
							match(input,R_BRACE,FOLLOW_R_BRACE_in_else_statement889); if (state.failed) return LEnd;
							}
							break;

					}

					if ( state.backtracking==0 ) {if (TRACEON) System.out.println("ELSE ...");}
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
		return LEnd;
	}
	// $ANTLR end "else_statement"


	public static class compare_expression_return extends ParserRuleReturnScope {
		public Info theInfo;
	};


	// $ANTLR start "compare_expression"
	// myCompiler.g:714:1: compare_expression returns [Info theInfo] : a= Identifier relate_op (b= Identifier |c= Integer_constant ) ;
	public final myCompilerParser.compare_expression_return compare_expression() throws RecognitionException {
		myCompilerParser.compare_expression_return retval = new myCompilerParser.compare_expression_return();
		retval.start = input.LT(1);

		Token a=null;
		Token b=null;
		Token c=null;
		ParserRuleReturnScope relate_op8 =null;

		retval.theInfo = new Info();
		try {
			// myCompiler.g:716:4: (a= Identifier relate_op (b= Identifier |c= Integer_constant ) )
			// myCompiler.g:717:4: a= Identifier relate_op (b= Identifier |c= Integer_constant )
			{
			a=(Token)match(input,Identifier,FOLLOW_Identifier_in_compare_expression933); if (state.failed) return retval;
			pushFollow(FOLLOW_relate_op_in_compare_expression935);
			relate_op8=relate_op();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) {//先確認是否有定義過了
			      retval.theInfo.theType = Type.BOOL;   //初始化
			      if(! symtab.containsKey((a!=null?a.getText():null))){
						System.out.println("Error! "+(retval.start).getLine()+": Undeclared identifier.");
						System.exit(0);
					}
			   }
			// myCompiler.g:725:4: (b= Identifier |c= Integer_constant )
			int alt16=2;
			int LA16_0 = input.LA(1);
			if ( (LA16_0==Identifier) ) {
				alt16=1;
			}
			else if ( (LA16_0==Integer_constant) ) {
				alt16=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 16, 0, input);
				throw nvae;
			}

			switch (alt16) {
				case 1 :
					// myCompiler.g:725:5: b= Identifier
					{
					b=(Token)match(input,Identifier,FOLLOW_Identifier_in_compare_expression948); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					      //確認ID定義過
							if(! symtab.containsKey((b!=null?b.getText():null))){
								System.out.println("Error! "+(retval.start).getLine()+": Undeclared identifier.");
								System.exit(0);
							}
					      //id type check
					      Type typeA = symtab.get((a!=null?a.getText():null)).theType;
					      Type typeB = symtab.get((b!=null?b.getText():null)).theType;
					      if(typeA !=typeB){
					         if(typeA!= typeB){
					            System.out.println("Error! "+(relate_op8!=null?(relate_op8.start):null).getLine()+
								   ": Type mismatch for the relate_op in an expression.");
					            System.exit(0);
					         }
					      }
					      String op = "==";
					      switch((relate_op8!=null?input.toString(relate_op8.start,relate_op8.stop):null)){
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
					         int varIndexA = symtab.get((a!=null?a.getText():null)).theVar.varIndex;
					         int varIndexB = symtab.get((b!=null?b.getText():null)).theVar.varIndex;
					         TextCode.add("%t"+ varCount + "= load i32, i32* %t"+varIndexA+", align 4");
					         //symtab.get((a!=null?a.getText():null)).theVar.varIndex = varCount; 
					         varIndexA = varCount;
					         varCount++;
					         TextCode.add("%t"+ varCount + "= load i32, i32* %t"+varIndexB+", align 4");
					         //symtab.get((b!=null?b.getText():null)).theVar.varIndex = varCount; 
					         varIndexB = varCount;
					         varCount++;
					         TextCode.add("%t" + varCount + " = icmp " + op + " i32 %t" + varIndexA + ", %t" + varIndexB);
					         retval.theInfo.theVar.varIndex= varCount;
					         varCount++;
					      }

					   }
					}
					break;
				case 2 :
					// myCompiler.g:783:5: c= Integer_constant
					{
					c=(Token)match(input,Integer_constant,FOLLOW_Integer_constant_in_compare_expression961); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					      Type typeA = symtab.get((a!=null?a.getText():null)).theType;
					      if(typeA != Type.INT){
					         System.out.println("Error! "+(relate_op8!=null?(relate_op8.start):null).getLine()+
								": Type mismatch for the relate_op in an expression.");
					         System.exit(0);
					      }
					      String op = "==";
					      switch((relate_op8!=null?input.toString(relate_op8.start,relate_op8.stop):null)){
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
					      int varIndexA = symtab.get((a!=null?a.getText():null)).theVar.varIndex;
					      int constValueC = Integer.parseInt((c!=null?c.getText():null));
					      TextCode.add("%t"+ varCount + "= load i32, i32* %t"+varIndexA+", align 4");
					      //symtab.get((a!=null?a.getText():null)).theVar.varIndex = varCount; 
					      varIndexA = varCount;
					      varCount++;
					      TextCode.add("%t" + varCount + " = icmp " + op + " i32 %t" + varIndexA + ", " + constValueC);
					      retval.theInfo.theVar.varIndex= varCount;
					      varCount++;
					   }
					}
					break;

			}

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


	public static class func_call_return extends ParserRuleReturnScope {
		public Info theInfo;
	};


	// $ANTLR start "func_call"
	// myCompiler.g:828:1: func_call returns [Info theInfo] : ( PRINTF '(' s= STRING_LITERAL ( ',' a= arith_expression )? ')' | SCANF '(' s= STRING_LITERAL ',' '&' id= Identifier ')' | RETURN ( arith_expression ) );
	public final myCompilerParser.func_call_return func_call() throws RecognitionException {
		myCompilerParser.func_call_return retval = new myCompilerParser.func_call_return();
		retval.start = input.LT(1);

		Token s=null;
		Token id=null;
		Info a =null;

		retval.theInfo = new Info();
		try {
			// myCompiler.g:831:4: ( PRINTF '(' s= STRING_LITERAL ( ',' a= arith_expression )? ')' | SCANF '(' s= STRING_LITERAL ',' '&' id= Identifier ')' | RETURN ( arith_expression ) )
			int alt18=3;
			switch ( input.LA(1) ) {
			case PRINTF:
				{
				alt18=1;
				}
				break;
			case SCANF:
				{
				alt18=2;
				}
				break;
			case RETURN:
				{
				alt18=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 18, 0, input);
				throw nvae;
			}
			switch (alt18) {
				case 1 :
					// myCompiler.g:832:4: PRINTF '(' s= STRING_LITERAL ( ',' a= arith_expression )? ')'
					{
					match(input,PRINTF,FOLLOW_PRINTF_in_func_call998); if (state.failed) return retval;
					match(input,L_PAREN,FOLLOW_L_PAREN_in_func_call999); if (state.failed) return retval;
					s=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_func_call1002); if (state.failed) return retval;
					// myCompiler.g:832:29: ( ',' a= arith_expression )?
					int alt17=2;
					int LA17_0 = input.LA(1);
					if ( (LA17_0==COMMA) ) {
						alt17=1;
					}
					switch (alt17) {
						case 1 :
							// myCompiler.g:832:30: ',' a= arith_expression
							{
							match(input,COMMA,FOLLOW_COMMA_in_func_call1004); if (state.failed) return retval;
							pushFollow(FOLLOW_arith_expression_in_func_call1007);
							a=arith_expression();
							state._fsp--;
							if (state.failed) return retval;
							}
							break;

					}

					match(input,R_PAREN,FOLLOW_R_PAREN_in_func_call1010); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					      // LLVM IR code generation for printf
					      String formatStr = (s!=null?s.getText():null).substring(1, (s!=null?s.getText():null).length()-1 );
					      long count = (s!=null?s.getText():null).chars().filter(ch -> ch =='\\').count();
					      long formatStrLength = formatStr.length()-count+1;
					      int formatStrIndex = varCount;
					      varCount++;

					      // Declare and initialize the format string
					      Print_str.add("@.str" + formatStrIndex + " = private unnamed_addr constant [" 
					                   + formatStrLength + " x i8] c\"" + formatStr.replace("\\n", "\\0A") + "\\00\", align 1");
					      if(a!=null){
					         //先確認 type 目前只INT,FLOAT可以用
					         if(a.theType != Type.INT && a.theType != Type.FLOAT){
					            System.out.println("Error! "+(retval.start).getLine()+
							   	   ": Type mismatch for the printf only INT and FLOAT legal.");
					            System.exit(0);
					         }


					         int exprIndex=a.theVar.varIndex;
					         if(a.theType ==Type.INT){
					            TextCode.add("%t" + varCount + " = call i32 (i8*, ...) @printf(i8* noundef getelementptr inbounds (["
					                         + formatStrLength + " x i8], ["
					                         + formatStrLength + " x i8]* @.str" + formatStrIndex + ", i64 0, i64 0), i32 noundef %t"
					                         + exprIndex + ")");
					         }else if(a.theType == Type.FLOAT){
					            TextCode.add("%t" + varCount + " = fpext float %t" + exprIndex + " to double");
					            int doubleExprIndex = varCount;
					            varCount++;
					            TextCode.add("%t" + varCount + " = call i32 (i8*, ...) @printf(i8* noundef getelementptr inbounds (["
					                         + formatStrLength + " x i8], ["
					                         + formatStrLength + " x i8]* @.str" + formatStrIndex + ", i64 0, i64 0), double noundef %t"
					                         + doubleExprIndex + ")");
					         }
					       
					      }else {
					         // No arithmetic expression, just print the string
					         TextCode.add("%t" + varCount + " = call i32 (i8*, ...) @printf(i8* noundef getelementptr inbounds (["
					                      + formatStrLength + " x i8], ["
					                      + formatStrLength + " x i8]* @.str" + formatStrIndex + ", i64 0, i64 0))");
					      }
					      varCount++;

					   }
					}
					break;
				case 2 :
					// myCompiler.g:878:5: SCANF '(' s= STRING_LITERAL ',' '&' id= Identifier ')'
					{
					match(input,SCANF,FOLLOW_SCANF_in_func_call1021); if (state.failed) return retval;
					match(input,L_PAREN,FOLLOW_L_PAREN_in_func_call1022); if (state.failed) return retval;
					s=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_func_call1026); if (state.failed) return retval;
					match(input,COMMA,FOLLOW_COMMA_in_func_call1027); if (state.failed) return retval;
					match(input,63,FOLLOW_63_in_func_call1028); if (state.failed) return retval;
					id=(Token)match(input,Identifier,FOLLOW_Identifier_in_func_call1031); if (state.failed) return retval;
					match(input,R_PAREN,FOLLOW_R_PAREN_in_func_call1032); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					      //先確認 type 目前只INT可以用
					      if(symtab.get((id!=null?id.getText():null)).theType != Type.INT){
					         System.out.println("Error! "+(retval.start).getLine()+
								   ": Type mismatch for the scanf only INT legal.");
					            System.exit(0);
					      }
					      String formatStr = (s!=null?s.getText():null).substring(1, (s!=null?s.getText():null).length()-1 );
					      long count = (s!=null?s.getText():null).chars().filter(ch -> ch =='\\').count();
					      long formatStrLength = formatStr.length()-count+1;
					      int formatStrIndex = varCount;
					      varCount++;

					      // Declare and initialize the format string
					      Print_str.add("@.str" + formatStrIndex + " = private unnamed_addr constant [" 
					                   + formatStrLength + " x i8] c\"" + formatStr.replace("\\n", "\\0A") + "\\00\", align 1");
					      int varIndex = symtab.get((id!=null?id.getText():null)).theVar.varIndex;
					      TextCode.add("%t" + varCount + " = call i32 (i8*, ...) @scanf(i8* noundef getelementptr inbounds (["
					                   + formatStrLength + " x i8], ["
					                   + formatStrLength + " x i8]* @.str" + formatStrIndex + ", i64 0, i64 0), i32* noundef %t"
					                   + varIndex + ")");
					      varCount++;

					   }
					}
					break;
				case 3 :
					// myCompiler.g:903:5: RETURN ( arith_expression )
					{
					match(input,RETURN,FOLLOW_RETURN_in_func_call1043); if (state.failed) return retval;
					// myCompiler.g:903:12: ( arith_expression )
					// myCompiler.g:903:13: arith_expression
					{
					pushFollow(FOLLOW_arith_expression_in_func_call1046);
					arith_expression();
					state._fsp--;
					if (state.failed) return retval;
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
	// $ANTLR end "func_call"


	public static class relate_op_return extends ParserRuleReturnScope {
	};


	// $ANTLR start "relate_op"
	// myCompiler.g:942:1: relate_op : ( EQ_OP | LE_OP | GE_OP | NE_OP | LARGER | SMALLER ) ;
	public final myCompilerParser.relate_op_return relate_op() throws RecognitionException {
		myCompilerParser.relate_op_return retval = new myCompilerParser.relate_op_return();
		retval.start = input.LT(1);

		try {
			// myCompiler.g:942:10: ( ( EQ_OP | LE_OP | GE_OP | NE_OP | LARGER | SMALLER ) )
			// myCompiler.g:942:12: ( EQ_OP | LE_OP | GE_OP | NE_OP | LARGER | SMALLER )
			{
			if ( input.LA(1)==EQ_OP||input.LA(1)==GE_OP||(input.LA(1) >= LARGER && input.LA(1) <= LE_OP)||input.LA(1)==NE_OP||input.LA(1)==SMALLER ) {
				input.consume();
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			if ( state.backtracking==0 ) { if (TRACEON) System.out.println("relate_op: (EQ_OP|LE_OP|GE_OP|NE_OP| LARGER|SMALLER)"); }
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
	// $ANTLR end "relate_op"



	// $ANTLR start "assign_op"
	// myCompiler.g:962:1: assign_op : ( ASSIGN | ADD_ASSIGN | SUB_ASSIGN | MUL_ASSIGN | DIV_ASSIGN ) ;
	public final void assign_op() throws RecognitionException {
		try {
			// myCompiler.g:962:10: ( ( ASSIGN | ADD_ASSIGN | SUB_ASSIGN | MUL_ASSIGN | DIV_ASSIGN ) )
			// myCompiler.g:962:11: ( ASSIGN | ADD_ASSIGN | SUB_ASSIGN | MUL_ASSIGN | DIV_ASSIGN )
			{
			if ( input.LA(1)==ADD_ASSIGN||input.LA(1)==ASSIGN||input.LA(1)==DIV_ASSIGN||input.LA(1)==MUL_ASSIGN||input.LA(1)==SUB_ASSIGN ) {
				input.consume();
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			if ( state.backtracking==0 ) { if (TRACEON) System.out.println("assign_op:(ASSIGN|ADD_ASSIGN| SUB_ASSIGN| MUL_ASSIGN | DIV_ASSIGN)"); }
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
	// myCompiler.g:992:1: lIBRARY : Identifier '.' Identifier ;
	public final void lIBRARY() throws RecognitionException {
		try {
			// myCompiler.g:992:9: ( Identifier '.' Identifier )
			// myCompiler.g:992:11: Identifier '.' Identifier
			{
			match(input,Identifier,FOLLOW_Identifier_in_lIBRARY1462); if (state.failed) return;
			match(input,DOT,FOLLOW_DOT_in_lIBRARY1463); if (state.failed) return;
			match(input,Identifier,FOLLOW_Identifier_in_lIBRARY1464); if (state.failed) return;
			if ( state.backtracking==0 ) { if (TRACEON) System.out.println("lIBRARY : Identifier'.'Identifier "); }
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

	// $ANTLR start synpred1_myCompiler
	public final void synpred1_myCompiler_fragment() throws RecognitionException {
		// myCompiler.g:693:11: ( ELSE )
		// myCompiler.g:693:12: ELSE
		{
		match(input,ELSE,FOLLOW_ELSE_in_synpred1_myCompiler818); if (state.failed) return;
		}

	}
	// $ANTLR end synpred1_myCompiler

	// $ANTLR start synpred2_myCompiler
	public final void synpred2_myCompiler_fragment() throws RecognitionException {
		// myCompiler.g:708:5: ( IF )
		// myCompiler.g:708:6: IF
		{
		match(input,IF,FOLLOW_IF_in_synpred2_myCompiler870); if (state.failed) return;
		}

	}
	// $ANTLR end synpred2_myCompiler

	// Delegated rules

	public final boolean synpred1_myCompiler() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred1_myCompiler_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred2_myCompiler() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred2_myCompiler_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}



	public static final BitSet FOLLOW_set_in_program36 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_MAIN_in_program42 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_L_PAREN_in_program44 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_R_PAREN_in_program46 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_L_BRACE_in_program67 = new BitSet(new long[]{0x30138000D1800200L});
	public static final BitSet FOLLOW_statements_in_program81 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_R_BRACE_in_program91 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_HASH_in_include_lib116 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_INCLUDE_in_include_lib118 = new BitSet(new long[]{0x0040000000000000L});
	public static final BitSet FOLLOW_SMALLER_in_include_lib120 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_lIBRARY_in_include_lib121 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_LARGER_in_include_lib122 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_type156 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CHAR_in_type166 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FLOAT_in_type176 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VOID_in_type186 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_statement_in_statements197 = new BitSet(new long[]{0x30118000D1800200L});
	public static final BitSet FOLLOW_statements_in_statements199 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_flow_in_statement234 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_assign_in_statement240 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_Semicolon_in_statement242 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_func_call_in_statement249 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_Semicolon_in_statement250 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_in_assign262 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_Identifier_in_assign265 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_assign_or_declare_in_assign267 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ASSIGN_in_assign_or_declare285 = new BitSet(new long[]{0x0100002182000000L});
	public static final BitSet FOLLOW_arith_expression_in_assign_or_declare287 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_multExpr_in_arith_expression340 = new BitSet(new long[]{0x0100000000000012L});
	public static final BitSet FOLLOW_ADD_in_arith_expression349 = new BitSet(new long[]{0x0100002182000000L});
	public static final BitSet FOLLOW_multExpr_in_arith_expression353 = new BitSet(new long[]{0x0100000000000012L});
	public static final BitSet FOLLOW_SUB_in_arith_expression365 = new BitSet(new long[]{0x0100002182000000L});
	public static final BitSet FOLLOW_multExpr_in_arith_expression369 = new BitSet(new long[]{0x0100000000000012L});
	public static final BitSet FOLLOW_signExpr_in_multExpr410 = new BitSet(new long[]{0x0000020000008002L});
	public static final BitSet FOLLOW_MUL_in_multExpr419 = new BitSet(new long[]{0x0100002182000000L});
	public static final BitSet FOLLOW_signExpr_in_multExpr423 = new BitSet(new long[]{0x0000020000008002L});
	public static final BitSet FOLLOW_DIV_in_multExpr435 = new BitSet(new long[]{0x0100002182000000L});
	public static final BitSet FOLLOW_signExpr_in_multExpr439 = new BitSet(new long[]{0x0000020000008002L});
	public static final BitSet FOLLOW_primaryExpr_in_signExpr476 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SUB_in_signExpr486 = new BitSet(new long[]{0x0000002182000000L});
	public static final BitSet FOLLOW_primaryExpr_in_signExpr490 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Integer_constant_in_primaryExpr520 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Floating_point_constant_in_primaryExpr530 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Identifier_in_primaryExpr542 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_L_PAREN_in_primaryExpr554 = new BitSet(new long[]{0x0100002182000000L});
	public static final BitSet FOLLOW_arith_expression_in_primaryExpr556 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_R_PAREN_in_primaryExpr558 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_if_statement_in_flow590 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_while_stat_in_flow602 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_for_stat_in_flow612 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FOR_in_for_stat638 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_L_PAREN_in_for_stat639 = new BitSet(new long[]{0x10000000C0800200L});
	public static final BitSet FOLLOW_assign_in_for_stat642 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_Semicolon_in_for_stat652 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_compare_expression_in_for_stat655 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_Semicolon_in_for_stat665 = new BitSet(new long[]{0x10000000C0800200L});
	public static final BitSet FOLLOW_assign_in_for_stat668 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_R_PAREN_in_for_stat669 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_L_BRACE_in_for_stat684 = new BitSet(new long[]{0x30138000D1800200L});
	public static final BitSet FOLLOW_statements_in_for_stat686 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_R_BRACE_in_for_stat688 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WHILE_in_while_stat719 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_L_PAREN_in_while_stat720 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_compare_expression_in_while_stat723 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_R_PAREN_in_while_stat724 = new BitSet(new long[]{0x30118008D1800200L});
	public static final BitSet FOLLOW_statement_in_while_stat738 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_L_BRACE_in_while_stat750 = new BitSet(new long[]{0x30138000D1800200L});
	public static final BitSet FOLLOW_statements_in_while_stat753 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_R_BRACE_in_while_stat754 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_if_statement786 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_L_PAREN_in_if_statement788 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_compare_expression_in_if_statement792 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_R_PAREN_in_if_statement793 = new BitSet(new long[]{0x30118008D1800200L});
	public static final BitSet FOLLOW_statement_in_if_statement798 = new BitSet(new long[]{0x0000000000080002L});
	public static final BitSet FOLLOW_L_BRACE_in_if_statement802 = new BitSet(new long[]{0x30138000D1800200L});
	public static final BitSet FOLLOW_statements_in_if_statement803 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_R_BRACE_in_if_statement804 = new BitSet(new long[]{0x0000000000080002L});
	public static final BitSet FOLLOW_ELSE_in_if_statement824 = new BitSet(new long[]{0x30118008D1800200L});
	public static final BitSet FOLLOW_else_statement_in_if_statement826 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_if_statement_in_else_statement874 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_statement_in_else_statement883 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_L_BRACE_in_else_statement887 = new BitSet(new long[]{0x30138000D1800200L});
	public static final BitSet FOLLOW_statements_in_else_statement888 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_R_BRACE_in_else_statement889 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Identifier_in_compare_expression933 = new BitSet(new long[]{0x0040080604200000L});
	public static final BitSet FOLLOW_relate_op_in_compare_expression935 = new BitSet(new long[]{0x0000000180000000L});
	public static final BitSet FOLLOW_Identifier_in_compare_expression948 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Integer_constant_in_compare_expression961 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PRINTF_in_func_call998 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_L_PAREN_in_func_call999 = new BitSet(new long[]{0x0080000000000000L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_func_call1002 = new BitSet(new long[]{0x0008000000000800L});
	public static final BitSet FOLLOW_COMMA_in_func_call1004 = new BitSet(new long[]{0x0100002182000000L});
	public static final BitSet FOLLOW_arith_expression_in_func_call1007 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_R_PAREN_in_func_call1010 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SCANF_in_func_call1021 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_L_PAREN_in_func_call1022 = new BitSet(new long[]{0x0080000000000000L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_func_call1026 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_COMMA_in_func_call1027 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_63_in_func_call1028 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_Identifier_in_func_call1031 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_R_PAREN_in_func_call1032 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RETURN_in_func_call1043 = new BitSet(new long[]{0x0100002182000000L});
	public static final BitSet FOLLOW_arith_expression_in_func_call1046 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_in_relate_op1194 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_in_assign_op1304 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Identifier_in_lIBRARY1462 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_DOT_in_lIBRARY1463 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_Identifier_in_lIBRARY1464 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ELSE_in_synpred1_myCompiler818 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_synpred2_myCompiler870 = new BitSet(new long[]{0x0000000000000002L});
}
