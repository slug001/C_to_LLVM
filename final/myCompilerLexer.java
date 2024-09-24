// $ANTLR 3.5.3 myCompiler.g 2024-06-12 17:38:16

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class myCompilerLexer extends Lexer {
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
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public myCompilerLexer() {} 
	public myCompilerLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public myCompilerLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "myCompiler.g"; }

	// $ANTLR start "T__63"
	public final void mT__63() throws RecognitionException {
		try {
			int _type = T__63;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:7:7: ( '&' )
			// myCompiler.g:7:9: '&'
			{
			match('&'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__63"

	// $ANTLR start "INT"
	public final void mINT() throws RecognitionException {
		try {
			int _type = INT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:913:6: ( 'integer' | 'int' )
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0=='i') ) {
				int LA1_1 = input.LA(2);
				if ( (LA1_1=='n') ) {
					int LA1_2 = input.LA(3);
					if ( (LA1_2=='t') ) {
						int LA1_3 = input.LA(4);
						if ( (LA1_3=='e') ) {
							alt1=1;
						}

						else {
							alt1=2;
						}

					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 1, 2, input);
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
							new NoViableAltException("", 1, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}

			switch (alt1) {
				case 1 :
					// myCompiler.g:913:8: 'integer'
					{
					match("integer"); 

					}
					break;
				case 2 :
					// myCompiler.g:913:20: 'int'
					{
					match("int"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INT"

	// $ANTLR start "CHAR"
	public final void mCHAR() throws RecognitionException {
		try {
			int _type = CHAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:914:6: ( 'char' )
			// myCompiler.g:914:8: 'char'
			{
			match("char"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CHAR"

	// $ANTLR start "VOID"
	public final void mVOID() throws RecognitionException {
		try {
			int _type = VOID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:915:6: ( 'void' )
			// myCompiler.g:915:8: 'void'
			{
			match("void"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "VOID"

	// $ANTLR start "FLOAT"
	public final void mFLOAT() throws RecognitionException {
		try {
			int _type = FLOAT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:916:6: ( 'float' )
			// myCompiler.g:916:8: 'float'
			{
			match("float"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FLOAT"

	// $ANTLR start "DOUBLE"
	public final void mDOUBLE() throws RecognitionException {
		try {
			int _type = DOUBLE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:917:7: ( 'double' )
			// myCompiler.g:917:9: 'double'
			{
			match("double"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DOUBLE"

	// $ANTLR start "SHORT"
	public final void mSHORT() throws RecognitionException {
		try {
			int _type = SHORT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:918:6: ( 'short' )
			// myCompiler.g:918:8: 'short'
			{
			match("short"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SHORT"

	// $ANTLR start "MAIN"
	public final void mMAIN() throws RecognitionException {
		try {
			int _type = MAIN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:921:5: ( 'main' )
			// myCompiler.g:921:7: 'main'
			{
			match("main"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MAIN"

	// $ANTLR start "RETURN"
	public final void mRETURN() throws RecognitionException {
		try {
			int _type = RETURN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:922:7: ( 'return' )
			// myCompiler.g:922:9: 'return'
			{
			match("return"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RETURN"

	// $ANTLR start "INCLUDE"
	public final void mINCLUDE() throws RecognitionException {
		try {
			int _type = INCLUDE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:923:8: ( 'include' )
			// myCompiler.g:923:10: 'include'
			{
			match("include"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INCLUDE"

	// $ANTLR start "IF"
	public final void mIF() throws RecognitionException {
		try {
			int _type = IF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:926:3: ( 'if' )
			// myCompiler.g:926:5: 'if'
			{
			match("if"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IF"

	// $ANTLR start "ELSE"
	public final void mELSE() throws RecognitionException {
		try {
			int _type = ELSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:927:5: ( 'else' )
			// myCompiler.g:927:7: 'else'
			{
			match("else"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ELSE"

	// $ANTLR start "WHILE"
	public final void mWHILE() throws RecognitionException {
		try {
			int _type = WHILE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:928:6: ( 'while' )
			// myCompiler.g:928:8: 'while'
			{
			match("while"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WHILE"

	// $ANTLR start "BREAK"
	public final void mBREAK() throws RecognitionException {
		try {
			int _type = BREAK;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:929:6: ( 'break' )
			// myCompiler.g:929:8: 'break'
			{
			match("break"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BREAK"

	// $ANTLR start "CONTINUE"
	public final void mCONTINUE() throws RecognitionException {
		try {
			int _type = CONTINUE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:930:9: ( 'continue' )
			// myCompiler.g:930:11: 'continue'
			{
			match("continue"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CONTINUE"

	// $ANTLR start "FOR"
	public final void mFOR() throws RecognitionException {
		try {
			int _type = FOR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:931:4: ( 'for' )
			// myCompiler.g:931:6: 'for'
			{
			match("for"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FOR"

	// $ANTLR start "PRINTF"
	public final void mPRINTF() throws RecognitionException {
		try {
			int _type = PRINTF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:934:7: ( 'printf' )
			// myCompiler.g:934:9: 'printf'
			{
			match("printf"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PRINTF"

	// $ANTLR start "SCANF"
	public final void mSCANF() throws RecognitionException {
		try {
			int _type = SCANF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:935:6: ( 'scanf' )
			// myCompiler.g:935:8: 'scanf'
			{
			match("scanf"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SCANF"

	// $ANTLR start "EQ_OP"
	public final void mEQ_OP() throws RecognitionException {
		try {
			int _type = EQ_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:943:7: ( '==' )
			// myCompiler.g:943:9: '=='
			{
			match("=="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EQ_OP"

	// $ANTLR start "LE_OP"
	public final void mLE_OP() throws RecognitionException {
		try {
			int _type = LE_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:944:7: ( '<=' )
			// myCompiler.g:944:9: '<='
			{
			match("<="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LE_OP"

	// $ANTLR start "GE_OP"
	public final void mGE_OP() throws RecognitionException {
		try {
			int _type = GE_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:945:7: ( '>=' )
			// myCompiler.g:945:9: '>='
			{
			match(">="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GE_OP"

	// $ANTLR start "NE_OP"
	public final void mNE_OP() throws RecognitionException {
		try {
			int _type = NE_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:946:7: ( '!=' )
			// myCompiler.g:946:9: '!='
			{
			match("!="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NE_OP"

	// $ANTLR start "LARGER"
	public final void mLARGER() throws RecognitionException {
		try {
			int _type = LARGER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:947:7: ( '>' )
			// myCompiler.g:947:9: '>'
			{
			match('>'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LARGER"

	// $ANTLR start "SMALLER"
	public final void mSMALLER() throws RecognitionException {
		try {
			int _type = SMALLER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:948:8: ( '<' )
			// myCompiler.g:948:10: '<'
			{
			match('<'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SMALLER"

	// $ANTLR start "PP_OP"
	public final void mPP_OP() throws RecognitionException {
		try {
			int _type = PP_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:951:7: ( '++' )
			// myCompiler.g:951:9: '++'
			{
			match("++"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PP_OP"

	// $ANTLR start "MM_OP"
	public final void mMM_OP() throws RecognitionException {
		try {
			int _type = MM_OP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:952:7: ( '--' )
			// myCompiler.g:952:9: '--'
			{
			match("--"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MM_OP"

	// $ANTLR start "ADD"
	public final void mADD() throws RecognitionException {
		try {
			int _type = ADD;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:955:4: ( '+' )
			// myCompiler.g:955:6: '+'
			{
			match('+'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ADD"

	// $ANTLR start "SUB"
	public final void mSUB() throws RecognitionException {
		try {
			int _type = SUB;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:956:4: ( '-' )
			// myCompiler.g:956:5: '-'
			{
			match('-'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SUB"

	// $ANTLR start "MUL"
	public final void mMUL() throws RecognitionException {
		try {
			int _type = MUL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:957:4: ( '*' )
			// myCompiler.g:957:6: '*'
			{
			match('*'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MUL"

	// $ANTLR start "DIV"
	public final void mDIV() throws RecognitionException {
		try {
			int _type = DIV;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:958:4: ( '/' )
			// myCompiler.g:958:6: '/'
			{
			match('/'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DIV"

	// $ANTLR start "MOD"
	public final void mMOD() throws RecognitionException {
		try {
			int _type = MOD;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:959:4: ( '%' )
			// myCompiler.g:959:6: '%'
			{
			match('%'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MOD"

	// $ANTLR start "ASSIGN"
	public final void mASSIGN() throws RecognitionException {
		try {
			int _type = ASSIGN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:963:7: ( '=' )
			// myCompiler.g:963:9: '='
			{
			match('='); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ASSIGN"

	// $ANTLR start "ADD_ASSIGN"
	public final void mADD_ASSIGN() throws RecognitionException {
		try {
			int _type = ADD_ASSIGN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:964:11: ( '+=' )
			// myCompiler.g:964:13: '+='
			{
			match("+="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ADD_ASSIGN"

	// $ANTLR start "SUB_ASSIGN"
	public final void mSUB_ASSIGN() throws RecognitionException {
		try {
			int _type = SUB_ASSIGN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:965:11: ( '-=' )
			// myCompiler.g:965:13: '-='
			{
			match("-="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SUB_ASSIGN"

	// $ANTLR start "MUL_ASSIGN"
	public final void mMUL_ASSIGN() throws RecognitionException {
		try {
			int _type = MUL_ASSIGN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:966:11: ( '*=' )
			// myCompiler.g:966:13: '*='
			{
			match("*="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MUL_ASSIGN"

	// $ANTLR start "DIV_ASSIGN"
	public final void mDIV_ASSIGN() throws RecognitionException {
		try {
			int _type = DIV_ASSIGN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:967:11: ( '/=' )
			// myCompiler.g:967:13: '/='
			{
			match("/="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DIV_ASSIGN"

	// $ANTLR start "AND"
	public final void mAND() throws RecognitionException {
		try {
			int _type = AND;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:970:4: ( '&&' )
			// myCompiler.g:970:6: '&&'
			{
			match("&&"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AND"

	// $ANTLR start "OR"
	public final void mOR() throws RecognitionException {
		try {
			int _type = OR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:971:3: ( '||' )
			// myCompiler.g:971:5: '||'
			{
			match("||"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OR"

	// $ANTLR start "NOT"
	public final void mNOT() throws RecognitionException {
		try {
			int _type = NOT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:972:4: ( '!' )
			// myCompiler.g:972:6: '!'
			{
			match('!'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NOT"

	// $ANTLR start "END"
	public final void mEND() throws RecognitionException {
		try {
			int _type = END;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:974:4: ( EOF )
			// myCompiler.g:974:6: EOF
			{
			match(EOF); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "END"

	// $ANTLR start "Semicolon"
	public final void mSemicolon() throws RecognitionException {
		try {
			int _type = Semicolon;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:978:10: ( ';' )
			// myCompiler.g:978:12: ';'
			{
			match(';'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Semicolon"

	// $ANTLR start "L_PAREN"
	public final void mL_PAREN() throws RecognitionException {
		try {
			int _type = L_PAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:979:8: ( '(' )
			// myCompiler.g:979:10: '('
			{
			match('('); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "L_PAREN"

	// $ANTLR start "R_PAREN"
	public final void mR_PAREN() throws RecognitionException {
		try {
			int _type = R_PAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:980:8: ( ')' )
			// myCompiler.g:980:10: ')'
			{
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "R_PAREN"

	// $ANTLR start "L_BRACKET"
	public final void mL_BRACKET() throws RecognitionException {
		try {
			int _type = L_BRACKET;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:981:10: ( '[' )
			// myCompiler.g:981:12: '['
			{
			match('['); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "L_BRACKET"

	// $ANTLR start "R_BRACKET"
	public final void mR_BRACKET() throws RecognitionException {
		try {
			int _type = R_BRACKET;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:982:10: ( ']' )
			// myCompiler.g:982:12: ']'
			{
			match(']'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "R_BRACKET"

	// $ANTLR start "L_BRACE"
	public final void mL_BRACE() throws RecognitionException {
		try {
			int _type = L_BRACE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:983:8: ( '{' )
			// myCompiler.g:983:10: '{'
			{
			match('{'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "L_BRACE"

	// $ANTLR start "R_BRACE"
	public final void mR_BRACE() throws RecognitionException {
		try {
			int _type = R_BRACE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:984:8: ( '}' )
			// myCompiler.g:984:10: '}'
			{
			match('}'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "R_BRACE"

	// $ANTLR start "HASH"
	public final void mHASH() throws RecognitionException {
		try {
			int _type = HASH;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:985:5: ( '#' )
			// myCompiler.g:985:7: '#'
			{
			match('#'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "HASH"

	// $ANTLR start "COMMA"
	public final void mCOMMA() throws RecognitionException {
		try {
			int _type = COMMA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:986:6: ( ',' )
			// myCompiler.g:986:8: ','
			{
			match(','); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMA"

	// $ANTLR start "DOT"
	public final void mDOT() throws RecognitionException {
		try {
			int _type = DOT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:987:4: ( '.' )
			// myCompiler.g:987:6: '.'
			{
			match('.'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DOT"

	// $ANTLR start "UNDERSCORE"
	public final void mUNDERSCORE() throws RecognitionException {
		try {
			int _type = UNDERSCORE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:988:11: ( '_' )
			// myCompiler.g:988:12: '_'
			{
			match('_'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "UNDERSCORE"

	// $ANTLR start "COLON"
	public final void mCOLON() throws RecognitionException {
		try {
			int _type = COLON;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:989:6: ( ':' )
			// myCompiler.g:989:8: ':'
			{
			match(':'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COLON"

	// $ANTLR start "Identifier"
	public final void mIdentifier() throws RecognitionException {
		try {
			int _type = Identifier;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:993:11: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// myCompiler.g:993:12: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// myCompiler.g:993:36: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( ((LA2_0 >= '0' && LA2_0 <= '9')||(LA2_0 >= 'A' && LA2_0 <= 'Z')||LA2_0=='_'||(LA2_0 >= 'a' && LA2_0 <= 'z')) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// myCompiler.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop2;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Identifier"

	// $ANTLR start "Integer_constant"
	public final void mInteger_constant() throws RecognitionException {
		try {
			int _type = Integer_constant;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:994:17: ( ( '0' .. '9' )+ )
			// myCompiler.g:994:18: ( '0' .. '9' )+
			{
			// myCompiler.g:994:18: ( '0' .. '9' )+
			int cnt3=0;
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( ((LA3_0 >= '0' && LA3_0 <= '9')) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// myCompiler.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt3 >= 1 ) break loop3;
					EarlyExitException eee = new EarlyExitException(3, input);
					throw eee;
				}
				cnt3++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Integer_constant"

	// $ANTLR start "Floating_point_constant"
	public final void mFloating_point_constant() throws RecognitionException {
		try {
			int _type = Floating_point_constant;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:995:24: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )+ )
			// myCompiler.g:995:25: ( '0' .. '9' )+ '.' ( '0' .. '9' )+
			{
			// myCompiler.g:995:25: ( '0' .. '9' )+
			int cnt4=0;
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( ((LA4_0 >= '0' && LA4_0 <= '9')) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// myCompiler.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt4 >= 1 ) break loop4;
					EarlyExitException eee = new EarlyExitException(4, input);
					throw eee;
				}
				cnt4++;
			}

			match('.'); 
			// myCompiler.g:995:39: ( '0' .. '9' )+
			int cnt5=0;
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( ((LA5_0 >= '0' && LA5_0 <= '9')) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// myCompiler.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt5 >= 1 ) break loop5;
					EarlyExitException eee = new EarlyExitException(5, input);
					throw eee;
				}
				cnt5++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Floating_point_constant"

	// $ANTLR start "STRING_LITERAL"
	public final void mSTRING_LITERAL() throws RecognitionException {
		try {
			int _type = STRING_LITERAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:998:5: ( '\"' ( EscapeSequence |~ ( '\\\\' | '\"' ) )* '\"' )
			// myCompiler.g:998:8: '\"' ( EscapeSequence |~ ( '\\\\' | '\"' ) )* '\"'
			{
			match('\"'); 
			// myCompiler.g:998:12: ( EscapeSequence |~ ( '\\\\' | '\"' ) )*
			loop6:
			while (true) {
				int alt6=3;
				int LA6_0 = input.LA(1);
				if ( (LA6_0=='\\') ) {
					alt6=1;
				}
				else if ( ((LA6_0 >= '\u0000' && LA6_0 <= '!')||(LA6_0 >= '#' && LA6_0 <= '[')||(LA6_0 >= ']' && LA6_0 <= '\uFFFF')) ) {
					alt6=2;
				}

				switch (alt6) {
				case 1 :
					// myCompiler.g:998:14: EscapeSequence
					{
					mEscapeSequence(); 

					}
					break;
				case 2 :
					// myCompiler.g:998:31: ~ ( '\\\\' | '\"' )
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop6;
				}
			}

			match('\"'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STRING_LITERAL"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:1001:3: ( ( ' ' | '\\t' | '\\r' | '\\n' ) )
			// myCompiler.g:1001:4: ( ' ' | '\\t' | '\\r' | '\\n' )
			{
			if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			_channel=HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	// $ANTLR start "COMMENT1"
	public final void mCOMMENT1() throws RecognitionException {
		try {
			int _type = COMMENT1;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:1002:9: ( '//' ( . )* '\\n' )
			// myCompiler.g:1002:11: '//' ( . )* '\\n'
			{
			match("//"); 

			// myCompiler.g:1002:15: ( . )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0=='\n') ) {
					alt7=2;
				}
				else if ( ((LA7_0 >= '\u0000' && LA7_0 <= '\t')||(LA7_0 >= '\u000B' && LA7_0 <= '\uFFFF')) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// myCompiler.g:1002:16: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop7;
				}
			}

			match('\n'); 
			_channel=HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMENT1"

	// $ANTLR start "COMMENT2"
	public final void mCOMMENT2() throws RecognitionException {
		try {
			int _type = COMMENT2;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myCompiler.g:1003:9: ( '/*' ( . )* '*/' )
			// myCompiler.g:1003:10: '/*' ( . )* '*/'
			{
			match("/*"); 

			// myCompiler.g:1003:15: ( . )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0=='*') ) {
					int LA8_1 = input.LA(2);
					if ( (LA8_1=='/') ) {
						alt8=2;
					}
					else if ( ((LA8_1 >= '\u0000' && LA8_1 <= '.')||(LA8_1 >= '0' && LA8_1 <= '\uFFFF')) ) {
						alt8=1;
					}

				}
				else if ( ((LA8_0 >= '\u0000' && LA8_0 <= ')')||(LA8_0 >= '+' && LA8_0 <= '\uFFFF')) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// myCompiler.g:1003:15: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop8;
				}
			}

			match("*/"); 

			_channel=HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMENT2"

	// $ANTLR start "EscapeSequence"
	public final void mEscapeSequence() throws RecognitionException {
		try {
			// myCompiler.g:1009:5: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) )
			// myCompiler.g:1009:9: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
			{
			match('\\'); 
			if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EscapeSequence"

	@Override
	public void mTokens() throws RecognitionException {
		// myCompiler.g:1:8: ( T__63 | INT | CHAR | VOID | FLOAT | DOUBLE | SHORT | MAIN | RETURN | INCLUDE | IF | ELSE | WHILE | BREAK | CONTINUE | FOR | PRINTF | SCANF | EQ_OP | LE_OP | GE_OP | NE_OP | LARGER | SMALLER | PP_OP | MM_OP | ADD | SUB | MUL | DIV | MOD | ASSIGN | ADD_ASSIGN | SUB_ASSIGN | MUL_ASSIGN | DIV_ASSIGN | AND | OR | NOT | END | Semicolon | L_PAREN | R_PAREN | L_BRACKET | R_BRACKET | L_BRACE | R_BRACE | HASH | COMMA | DOT | UNDERSCORE | COLON | Identifier | Integer_constant | Floating_point_constant | STRING_LITERAL | WS | COMMENT1 | COMMENT2 )
		int alt9=59;
		alt9 = dfa9.predict(input);
		switch (alt9) {
			case 1 :
				// myCompiler.g:1:10: T__63
				{
				mT__63(); 

				}
				break;
			case 2 :
				// myCompiler.g:1:16: INT
				{
				mINT(); 

				}
				break;
			case 3 :
				// myCompiler.g:1:20: CHAR
				{
				mCHAR(); 

				}
				break;
			case 4 :
				// myCompiler.g:1:25: VOID
				{
				mVOID(); 

				}
				break;
			case 5 :
				// myCompiler.g:1:30: FLOAT
				{
				mFLOAT(); 

				}
				break;
			case 6 :
				// myCompiler.g:1:36: DOUBLE
				{
				mDOUBLE(); 

				}
				break;
			case 7 :
				// myCompiler.g:1:43: SHORT
				{
				mSHORT(); 

				}
				break;
			case 8 :
				// myCompiler.g:1:49: MAIN
				{
				mMAIN(); 

				}
				break;
			case 9 :
				// myCompiler.g:1:54: RETURN
				{
				mRETURN(); 

				}
				break;
			case 10 :
				// myCompiler.g:1:61: INCLUDE
				{
				mINCLUDE(); 

				}
				break;
			case 11 :
				// myCompiler.g:1:69: IF
				{
				mIF(); 

				}
				break;
			case 12 :
				// myCompiler.g:1:72: ELSE
				{
				mELSE(); 

				}
				break;
			case 13 :
				// myCompiler.g:1:77: WHILE
				{
				mWHILE(); 

				}
				break;
			case 14 :
				// myCompiler.g:1:83: BREAK
				{
				mBREAK(); 

				}
				break;
			case 15 :
				// myCompiler.g:1:89: CONTINUE
				{
				mCONTINUE(); 

				}
				break;
			case 16 :
				// myCompiler.g:1:98: FOR
				{
				mFOR(); 

				}
				break;
			case 17 :
				// myCompiler.g:1:102: PRINTF
				{
				mPRINTF(); 

				}
				break;
			case 18 :
				// myCompiler.g:1:109: SCANF
				{
				mSCANF(); 

				}
				break;
			case 19 :
				// myCompiler.g:1:115: EQ_OP
				{
				mEQ_OP(); 

				}
				break;
			case 20 :
				// myCompiler.g:1:121: LE_OP
				{
				mLE_OP(); 

				}
				break;
			case 21 :
				// myCompiler.g:1:127: GE_OP
				{
				mGE_OP(); 

				}
				break;
			case 22 :
				// myCompiler.g:1:133: NE_OP
				{
				mNE_OP(); 

				}
				break;
			case 23 :
				// myCompiler.g:1:139: LARGER
				{
				mLARGER(); 

				}
				break;
			case 24 :
				// myCompiler.g:1:146: SMALLER
				{
				mSMALLER(); 

				}
				break;
			case 25 :
				// myCompiler.g:1:154: PP_OP
				{
				mPP_OP(); 

				}
				break;
			case 26 :
				// myCompiler.g:1:160: MM_OP
				{
				mMM_OP(); 

				}
				break;
			case 27 :
				// myCompiler.g:1:166: ADD
				{
				mADD(); 

				}
				break;
			case 28 :
				// myCompiler.g:1:170: SUB
				{
				mSUB(); 

				}
				break;
			case 29 :
				// myCompiler.g:1:174: MUL
				{
				mMUL(); 

				}
				break;
			case 30 :
				// myCompiler.g:1:178: DIV
				{
				mDIV(); 

				}
				break;
			case 31 :
				// myCompiler.g:1:182: MOD
				{
				mMOD(); 

				}
				break;
			case 32 :
				// myCompiler.g:1:186: ASSIGN
				{
				mASSIGN(); 

				}
				break;
			case 33 :
				// myCompiler.g:1:193: ADD_ASSIGN
				{
				mADD_ASSIGN(); 

				}
				break;
			case 34 :
				// myCompiler.g:1:204: SUB_ASSIGN
				{
				mSUB_ASSIGN(); 

				}
				break;
			case 35 :
				// myCompiler.g:1:215: MUL_ASSIGN
				{
				mMUL_ASSIGN(); 

				}
				break;
			case 36 :
				// myCompiler.g:1:226: DIV_ASSIGN
				{
				mDIV_ASSIGN(); 

				}
				break;
			case 37 :
				// myCompiler.g:1:237: AND
				{
				mAND(); 

				}
				break;
			case 38 :
				// myCompiler.g:1:241: OR
				{
				mOR(); 

				}
				break;
			case 39 :
				// myCompiler.g:1:244: NOT
				{
				mNOT(); 

				}
				break;
			case 40 :
				// myCompiler.g:1:248: END
				{
				mEND(); 

				}
				break;
			case 41 :
				// myCompiler.g:1:252: Semicolon
				{
				mSemicolon(); 

				}
				break;
			case 42 :
				// myCompiler.g:1:262: L_PAREN
				{
				mL_PAREN(); 

				}
				break;
			case 43 :
				// myCompiler.g:1:270: R_PAREN
				{
				mR_PAREN(); 

				}
				break;
			case 44 :
				// myCompiler.g:1:278: L_BRACKET
				{
				mL_BRACKET(); 

				}
				break;
			case 45 :
				// myCompiler.g:1:288: R_BRACKET
				{
				mR_BRACKET(); 

				}
				break;
			case 46 :
				// myCompiler.g:1:298: L_BRACE
				{
				mL_BRACE(); 

				}
				break;
			case 47 :
				// myCompiler.g:1:306: R_BRACE
				{
				mR_BRACE(); 

				}
				break;
			case 48 :
				// myCompiler.g:1:314: HASH
				{
				mHASH(); 

				}
				break;
			case 49 :
				// myCompiler.g:1:319: COMMA
				{
				mCOMMA(); 

				}
				break;
			case 50 :
				// myCompiler.g:1:325: DOT
				{
				mDOT(); 

				}
				break;
			case 51 :
				// myCompiler.g:1:329: UNDERSCORE
				{
				mUNDERSCORE(); 

				}
				break;
			case 52 :
				// myCompiler.g:1:340: COLON
				{
				mCOLON(); 

				}
				break;
			case 53 :
				// myCompiler.g:1:346: Identifier
				{
				mIdentifier(); 

				}
				break;
			case 54 :
				// myCompiler.g:1:357: Integer_constant
				{
				mInteger_constant(); 

				}
				break;
			case 55 :
				// myCompiler.g:1:374: Floating_point_constant
				{
				mFloating_point_constant(); 

				}
				break;
			case 56 :
				// myCompiler.g:1:398: STRING_LITERAL
				{
				mSTRING_LITERAL(); 

				}
				break;
			case 57 :
				// myCompiler.g:1:413: WS
				{
				mWS(); 

				}
				break;
			case 58 :
				// myCompiler.g:1:416: COMMENT1
				{
				mCOMMENT1(); 

				}
				break;
			case 59 :
				// myCompiler.g:1:425: COMMENT2
				{
				mCOMMENT2(); 

				}
				break;

		}
	}


	protected DFA9 dfa9 = new DFA9(this);
	static final String DFA9_eotS =
		"\1\30\1\52\14\45\1\74\1\76\1\100\1\102\1\105\1\110\1\112\1\116\15\uffff"+
		"\1\117\2\uffff\1\120\4\uffff\1\45\1\124\16\45\27\uffff\1\144\1\45\1\uffff"+
		"\4\45\1\152\12\45\1\uffff\1\45\1\166\1\45\1\170\1\45\1\uffff\3\45\1\175"+
		"\1\45\1\177\5\45\1\uffff\1\45\1\uffff\1\u0086\1\45\1\u0088\1\u0089\1\uffff"+
		"\1\45\1\uffff\1\u008b\1\u008c\4\45\1\uffff\1\u0091\2\uffff\1\u0092\2\uffff"+
		"\1\u0093\1\144\1\u0094\1\45\4\uffff\1\u0096\1\uffff";
	static final String DFA9_eofS =
		"\u0097\uffff";
	static final String DFA9_minS =
		"\1\11\1\46\1\146\1\150\1\157\1\154\1\157\1\143\1\141\1\145\1\154\1\150"+
		"\2\162\4\75\1\53\1\55\1\75\1\52\15\uffff\1\60\2\uffff\1\56\4\uffff\1\143"+
		"\1\60\1\141\1\156\1\151\1\157\1\162\1\165\1\157\1\141\1\151\1\164\1\163"+
		"\1\151\1\145\1\151\27\uffff\1\60\1\154\1\uffff\1\162\1\164\1\144\1\141"+
		"\1\60\1\142\1\162\2\156\1\165\1\145\1\154\1\141\1\156\1\147\1\uffff\1"+
		"\165\1\60\1\151\1\60\1\164\1\uffff\1\154\1\164\1\146\1\60\1\162\1\60\1"+
		"\145\1\153\1\164\1\145\1\144\1\uffff\1\156\1\uffff\1\60\1\145\2\60\1\uffff"+
		"\1\156\1\uffff\2\60\1\146\1\162\1\145\1\165\1\uffff\1\60\2\uffff\1\60"+
		"\2\uffff\3\60\1\145\4\uffff\1\60\1\uffff";
	static final String DFA9_maxS =
		"\1\175\1\46\1\156\4\157\1\150\1\141\1\145\1\154\1\150\2\162\10\75\15\uffff"+
		"\1\172\2\uffff\1\71\4\uffff\1\164\1\172\1\141\1\156\1\151\1\157\1\162"+
		"\1\165\1\157\1\141\1\151\1\164\1\163\1\151\1\145\1\151\27\uffff\1\172"+
		"\1\154\1\uffff\1\162\1\164\1\144\1\141\1\172\1\142\1\162\2\156\1\165\1"+
		"\145\1\154\1\141\1\156\1\147\1\uffff\1\165\1\172\1\151\1\172\1\164\1\uffff"+
		"\1\154\1\164\1\146\1\172\1\162\1\172\1\145\1\153\1\164\1\145\1\144\1\uffff"+
		"\1\156\1\uffff\1\172\1\145\2\172\1\uffff\1\156\1\uffff\2\172\1\146\1\162"+
		"\1\145\1\165\1\uffff\1\172\2\uffff\1\172\2\uffff\3\172\1\145\4\uffff\1"+
		"\172\1\uffff";
	static final String DFA9_acceptS =
		"\26\uffff\1\37\1\46\1\50\1\51\1\52\1\53\1\54\1\55\1\56\1\57\1\60\1\61"+
		"\1\62\1\uffff\1\64\1\65\1\uffff\1\70\1\71\1\45\1\1\20\uffff\1\23\1\40"+
		"\1\24\1\30\1\25\1\27\1\26\1\47\1\31\1\41\1\33\1\32\1\42\1\34\1\43\1\35"+
		"\1\44\1\72\1\73\1\36\1\63\1\66\1\67\2\uffff\1\13\17\uffff\1\2\5\uffff"+
		"\1\20\13\uffff\1\3\1\uffff\1\4\4\uffff\1\10\1\uffff\1\14\6\uffff\1\5\1"+
		"\uffff\1\7\1\22\1\uffff\1\15\1\16\4\uffff\1\6\1\11\1\21\1\12\1\uffff\1"+
		"\17";
	static final String DFA9_specialS =
		"\u0097\uffff}>";
	static final String[] DFA9_transitionS = {
			"\2\50\2\uffff\1\50\22\uffff\1\50\1\21\1\47\1\40\1\uffff\1\26\1\1\1\uffff"+
			"\1\32\1\33\1\24\1\22\1\41\1\23\1\42\1\25\12\46\1\44\1\31\1\17\1\16\1"+
			"\20\2\uffff\32\45\1\34\1\uffff\1\35\1\uffff\1\43\1\uffff\1\45\1\14\1"+
			"\3\1\6\1\12\1\5\2\45\1\2\3\45\1\10\2\45\1\15\1\45\1\11\1\7\2\45\1\4\1"+
			"\13\3\45\1\36\1\27\1\37",
			"\1\51",
			"\1\54\7\uffff\1\53",
			"\1\55\6\uffff\1\56",
			"\1\57",
			"\1\60\2\uffff\1\61",
			"\1\62",
			"\1\64\4\uffff\1\63",
			"\1\65",
			"\1\66",
			"\1\67",
			"\1\70",
			"\1\71",
			"\1\72",
			"\1\73",
			"\1\75",
			"\1\77",
			"\1\101",
			"\1\103\21\uffff\1\104",
			"\1\106\17\uffff\1\107",
			"\1\111",
			"\1\115\4\uffff\1\114\15\uffff\1\113",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
			"",
			"",
			"\1\121\1\uffff\12\46",
			"",
			"",
			"",
			"",
			"\1\123\20\uffff\1\122",
			"\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
			"\1\125",
			"\1\126",
			"\1\127",
			"\1\130",
			"\1\131",
			"\1\132",
			"\1\133",
			"\1\134",
			"\1\135",
			"\1\136",
			"\1\137",
			"\1\140",
			"\1\141",
			"\1\142",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\4\45\1\143\25\45",
			"\1\145",
			"",
			"\1\146",
			"\1\147",
			"\1\150",
			"\1\151",
			"\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
			"\1\153",
			"\1\154",
			"\1\155",
			"\1\156",
			"\1\157",
			"\1\160",
			"\1\161",
			"\1\162",
			"\1\163",
			"\1\164",
			"",
			"\1\165",
			"\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
			"\1\167",
			"\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
			"\1\171",
			"",
			"\1\172",
			"\1\173",
			"\1\174",
			"\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
			"\1\176",
			"\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
			"\1\u0080",
			"\1\u0081",
			"\1\u0082",
			"\1\u0083",
			"\1\u0084",
			"",
			"\1\u0085",
			"",
			"\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
			"\1\u0087",
			"\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
			"\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
			"",
			"\1\u008a",
			"",
			"\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
			"\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
			"\1\u008d",
			"\1\u008e",
			"\1\u008f",
			"\1\u0090",
			"",
			"\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
			"",
			"",
			"\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
			"",
			"",
			"\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
			"\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
			"\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
			"\1\u0095",
			"",
			"",
			"",
			"",
			"\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45",
			""
	};

	static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
	static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
	static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
	static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
	static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
	static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
	static final short[][] DFA9_transition;

	static {
		int numStates = DFA9_transitionS.length;
		DFA9_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
		}
	}

	protected class DFA9 extends DFA {

		public DFA9(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 9;
			this.eot = DFA9_eot;
			this.eof = DFA9_eof;
			this.min = DFA9_min;
			this.max = DFA9_max;
			this.accept = DFA9_accept;
			this.special = DFA9_special;
			this.transition = DFA9_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( T__63 | INT | CHAR | VOID | FLOAT | DOUBLE | SHORT | MAIN | RETURN | INCLUDE | IF | ELSE | WHILE | BREAK | CONTINUE | FOR | PRINTF | SCANF | EQ_OP | LE_OP | GE_OP | NE_OP | LARGER | SMALLER | PP_OP | MM_OP | ADD | SUB | MUL | DIV | MOD | ASSIGN | ADD_ASSIGN | SUB_ASSIGN | MUL_ASSIGN | DIV_ASSIGN | AND | OR | NOT | END | Semicolon | L_PAREN | R_PAREN | L_BRACKET | R_BRACKET | L_BRACE | R_BRACE | HASH | COMMA | DOT | UNDERSCORE | COLON | Identifier | Integer_constant | Floating_point_constant | STRING_LITERAL | WS | COMMENT1 | COMMENT2 );";
		}
	}

}
