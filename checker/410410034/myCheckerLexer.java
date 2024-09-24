// $ANTLR 3.5.3 myChecker.g 2024-05-03 23:14:48

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class myCheckerLexer extends Lexer {
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
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public myCheckerLexer() {} 
	public myCheckerLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public myCheckerLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "myChecker.g"; }

	// $ANTLR start "T__63"
	public final void mT__63() throws RecognitionException {
		try {
			int _type = T__63;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myChecker.g:2:7: ( '\"' )
			// myChecker.g:2:9: '\"'
			{
			match('\"'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__63"

	// $ANTLR start "T__64"
	public final void mT__64() throws RecognitionException {
		try {
			int _type = T__64;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myChecker.g:3:7: ( '&' )
			// myChecker.g:3:9: '&'
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
	// $ANTLR end "T__64"

	// $ANTLR start "T__65"
	public final void mT__65() throws RecognitionException {
		try {
			int _type = T__65;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myChecker.g:4:7: ( 'c' )
			// myChecker.g:4:9: 'c'
			{
			match('c'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__65"

	// $ANTLR start "T__66"
	public final void mT__66() throws RecognitionException {
		try {
			int _type = T__66;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myChecker.g:5:7: ( 'd' )
			// myChecker.g:5:9: 'd'
			{
			match('d'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__66"

	// $ANTLR start "T__67"
	public final void mT__67() throws RecognitionException {
		try {
			int _type = T__67;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myChecker.g:6:7: ( 'f' )
			// myChecker.g:6:9: 'f'
			{
			match('f'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__67"

	// $ANTLR start "T__68"
	public final void mT__68() throws RecognitionException {
		try {
			int _type = T__68;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myChecker.g:7:7: ( 's' )
			// myChecker.g:7:9: 's'
			{
			match('s'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__68"

	// $ANTLR start "INT"
	public final void mINT() throws RecognitionException {
		try {
			int _type = INT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myChecker.g:635:6: ( 'integer' | 'int' )
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
					// myChecker.g:635:8: 'integer'
					{
					match("integer"); 

					}
					break;
				case 2 :
					// myChecker.g:635:20: 'int'
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
			// myChecker.g:636:6: ( 'char' )
			// myChecker.g:636:8: 'char'
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
			// myChecker.g:637:6: ( 'void' )
			// myChecker.g:637:8: 'void'
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
			// myChecker.g:638:6: ( 'float' )
			// myChecker.g:638:8: 'float'
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
			// myChecker.g:639:7: ( 'double' )
			// myChecker.g:639:9: 'double'
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
			// myChecker.g:640:6: ( 'short' )
			// myChecker.g:640:8: 'short'
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
			// myChecker.g:643:5: ( 'main' )
			// myChecker.g:643:7: 'main'
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
			// myChecker.g:644:7: ( 'return' )
			// myChecker.g:644:9: 'return'
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
			// myChecker.g:645:8: ( 'include' )
			// myChecker.g:645:10: 'include'
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
			// myChecker.g:648:3: ( 'if' )
			// myChecker.g:648:5: 'if'
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
			// myChecker.g:649:5: ( 'else' )
			// myChecker.g:649:7: 'else'
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
			// myChecker.g:650:6: ( 'while' )
			// myChecker.g:650:8: 'while'
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
			// myChecker.g:651:6: ( 'break' )
			// myChecker.g:651:8: 'break'
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
			// myChecker.g:652:9: ( 'continue' )
			// myChecker.g:652:11: 'continue'
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
			// myChecker.g:653:4: ( 'for' )
			// myChecker.g:653:6: 'for'
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
			// myChecker.g:656:7: ( 'printf' )
			// myChecker.g:656:9: 'printf'
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
			// myChecker.g:657:6: ( 'scanf' )
			// myChecker.g:657:8: 'scanf'
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
			// myChecker.g:665:7: ( '==' )
			// myChecker.g:665:9: '=='
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
			// myChecker.g:666:7: ( '<=' )
			// myChecker.g:666:9: '<='
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
			// myChecker.g:667:7: ( '>=' )
			// myChecker.g:667:9: '>='
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
			// myChecker.g:668:7: ( '!=' )
			// myChecker.g:668:9: '!='
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
			// myChecker.g:669:7: ( '>' )
			// myChecker.g:669:9: '>'
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
			// myChecker.g:670:8: ( '<' )
			// myChecker.g:670:10: '<'
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
			// myChecker.g:673:7: ( '++' )
			// myChecker.g:673:9: '++'
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
			// myChecker.g:674:7: ( '--' )
			// myChecker.g:674:9: '--'
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
			// myChecker.g:677:4: ( '+' )
			// myChecker.g:677:6: '+'
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
			// myChecker.g:678:4: ( '-' )
			// myChecker.g:678:5: '-'
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
			// myChecker.g:679:4: ( '*' )
			// myChecker.g:679:6: '*'
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
			// myChecker.g:680:4: ( '/' )
			// myChecker.g:680:6: '/'
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
			// myChecker.g:681:4: ( '%' )
			// myChecker.g:681:6: '%'
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
			// myChecker.g:685:7: ( '=' )
			// myChecker.g:685:9: '='
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
			// myChecker.g:686:11: ( '+=' )
			// myChecker.g:686:13: '+='
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
			// myChecker.g:687:11: ( '-=' )
			// myChecker.g:687:13: '-='
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
			// myChecker.g:688:11: ( '*=' )
			// myChecker.g:688:13: '*='
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
			// myChecker.g:689:11: ( '/=' )
			// myChecker.g:689:13: '/='
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
			// myChecker.g:692:4: ( '&&' )
			// myChecker.g:692:6: '&&'
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
			// myChecker.g:693:3: ( '||' )
			// myChecker.g:693:5: '||'
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
			// myChecker.g:694:4: ( '!' )
			// myChecker.g:694:6: '!'
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
			// myChecker.g:696:4: ( EOF )
			// myChecker.g:696:6: EOF
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
			// myChecker.g:700:10: ( ';' )
			// myChecker.g:700:12: ';'
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
			// myChecker.g:701:8: ( '(' )
			// myChecker.g:701:10: '('
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
			// myChecker.g:702:8: ( ')' )
			// myChecker.g:702:10: ')'
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
			// myChecker.g:703:10: ( '[' )
			// myChecker.g:703:12: '['
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
			// myChecker.g:704:10: ( ']' )
			// myChecker.g:704:12: ']'
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
			// myChecker.g:705:8: ( '{' )
			// myChecker.g:705:10: '{'
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
			// myChecker.g:706:8: ( '}' )
			// myChecker.g:706:10: '}'
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
			// myChecker.g:707:5: ( '#' )
			// myChecker.g:707:7: '#'
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
			// myChecker.g:708:6: ( ',' )
			// myChecker.g:708:8: ','
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
			// myChecker.g:709:4: ( '.' )
			// myChecker.g:709:6: '.'
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
			// myChecker.g:710:11: ( '_' )
			// myChecker.g:710:12: '_'
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
			// myChecker.g:711:6: ( ':' )
			// myChecker.g:711:8: ':'
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
			// myChecker.g:715:11: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// myChecker.g:715:12: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// myChecker.g:715:36: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( ((LA2_0 >= '0' && LA2_0 <= '9')||(LA2_0 >= 'A' && LA2_0 <= 'Z')||LA2_0=='_'||(LA2_0 >= 'a' && LA2_0 <= 'z')) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// myChecker.g:
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
			// myChecker.g:716:17: ( ( '0' .. '9' )+ )
			// myChecker.g:716:18: ( '0' .. '9' )+
			{
			// myChecker.g:716:18: ( '0' .. '9' )+
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
					// myChecker.g:
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
			// myChecker.g:717:24: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )+ )
			// myChecker.g:717:25: ( '0' .. '9' )+ '.' ( '0' .. '9' )+
			{
			// myChecker.g:717:25: ( '0' .. '9' )+
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
					// myChecker.g:
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
			// myChecker.g:717:39: ( '0' .. '9' )+
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
					// myChecker.g:
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

	// $ANTLR start "Charliteral"
	public final void mCharliteral() throws RecognitionException {
		try {
			int _type = Charliteral;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myChecker.g:718:12: ( '\\'' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) '\\'' )
			// myChecker.g:718:13: '\\'' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) '\\''
			{
			match('\''); 
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			match('\''); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Charliteral"

	// $ANTLR start "String_s"
	public final void mString_s() throws RecognitionException {
		try {
			int _type = String_s;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myChecker.g:719:10: ( '\\\"' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* '\\\"' )
			// myChecker.g:719:11: '\\\"' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* '\\\"'
			{
			match('\"'); 
			// myChecker.g:719:17: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( ((LA6_0 >= '0' && LA6_0 <= '9')||(LA6_0 >= 'A' && LA6_0 <= 'Z')||LA6_0=='_'||(LA6_0 >= 'a' && LA6_0 <= 'z')) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// myChecker.g:
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
	// $ANTLR end "String_s"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// myChecker.g:721:3: ( ( ' ' | '\\t' | '\\r' | '\\n' ) )
			// myChecker.g:721:4: ( ' ' | '\\t' | '\\r' | '\\n' )
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
			// myChecker.g:722:9: ( '//' ( . )* '\\n' )
			// myChecker.g:722:11: '//' ( . )* '\\n'
			{
			match("//"); 

			// myChecker.g:722:15: ( . )*
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
					// myChecker.g:722:16: .
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
			// myChecker.g:723:9: ( '/*' ( . )* '*/' )
			// myChecker.g:723:10: '/*' ( . )* '*/'
			{
			match("/*"); 

			// myChecker.g:723:15: ( . )*
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
					// myChecker.g:723:15: .
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

	@Override
	public void mTokens() throws RecognitionException {
		// myChecker.g:1:8: ( T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | INT | CHAR | VOID | FLOAT | DOUBLE | SHORT | MAIN | RETURN | INCLUDE | IF | ELSE | WHILE | BREAK | CONTINUE | FOR | PRINTF | SCANF | EQ_OP | LE_OP | GE_OP | NE_OP | LARGER | SMALLER | PP_OP | MM_OP | ADD | SUB | MUL | DIV | MOD | ASSIGN | ADD_ASSIGN | SUB_ASSIGN | MUL_ASSIGN | DIV_ASSIGN | AND | OR | NOT | END | Semicolon | L_PAREN | R_PAREN | L_BRACKET | R_BRACKET | L_BRACE | R_BRACE | HASH | COMMA | DOT | UNDERSCORE | COLON | Identifier | Integer_constant | Floating_point_constant | Charliteral | String_s | WS | COMMENT1 | COMMENT2 )
		int alt9=65;
		alt9 = dfa9.predict(input);
		switch (alt9) {
			case 1 :
				// myChecker.g:1:10: T__63
				{
				mT__63(); 

				}
				break;
			case 2 :
				// myChecker.g:1:16: T__64
				{
				mT__64(); 

				}
				break;
			case 3 :
				// myChecker.g:1:22: T__65
				{
				mT__65(); 

				}
				break;
			case 4 :
				// myChecker.g:1:28: T__66
				{
				mT__66(); 

				}
				break;
			case 5 :
				// myChecker.g:1:34: T__67
				{
				mT__67(); 

				}
				break;
			case 6 :
				// myChecker.g:1:40: T__68
				{
				mT__68(); 

				}
				break;
			case 7 :
				// myChecker.g:1:46: INT
				{
				mINT(); 

				}
				break;
			case 8 :
				// myChecker.g:1:50: CHAR
				{
				mCHAR(); 

				}
				break;
			case 9 :
				// myChecker.g:1:55: VOID
				{
				mVOID(); 

				}
				break;
			case 10 :
				// myChecker.g:1:60: FLOAT
				{
				mFLOAT(); 

				}
				break;
			case 11 :
				// myChecker.g:1:66: DOUBLE
				{
				mDOUBLE(); 

				}
				break;
			case 12 :
				// myChecker.g:1:73: SHORT
				{
				mSHORT(); 

				}
				break;
			case 13 :
				// myChecker.g:1:79: MAIN
				{
				mMAIN(); 

				}
				break;
			case 14 :
				// myChecker.g:1:84: RETURN
				{
				mRETURN(); 

				}
				break;
			case 15 :
				// myChecker.g:1:91: INCLUDE
				{
				mINCLUDE(); 

				}
				break;
			case 16 :
				// myChecker.g:1:99: IF
				{
				mIF(); 

				}
				break;
			case 17 :
				// myChecker.g:1:102: ELSE
				{
				mELSE(); 

				}
				break;
			case 18 :
				// myChecker.g:1:107: WHILE
				{
				mWHILE(); 

				}
				break;
			case 19 :
				// myChecker.g:1:113: BREAK
				{
				mBREAK(); 

				}
				break;
			case 20 :
				// myChecker.g:1:119: CONTINUE
				{
				mCONTINUE(); 

				}
				break;
			case 21 :
				// myChecker.g:1:128: FOR
				{
				mFOR(); 

				}
				break;
			case 22 :
				// myChecker.g:1:132: PRINTF
				{
				mPRINTF(); 

				}
				break;
			case 23 :
				// myChecker.g:1:139: SCANF
				{
				mSCANF(); 

				}
				break;
			case 24 :
				// myChecker.g:1:145: EQ_OP
				{
				mEQ_OP(); 

				}
				break;
			case 25 :
				// myChecker.g:1:151: LE_OP
				{
				mLE_OP(); 

				}
				break;
			case 26 :
				// myChecker.g:1:157: GE_OP
				{
				mGE_OP(); 

				}
				break;
			case 27 :
				// myChecker.g:1:163: NE_OP
				{
				mNE_OP(); 

				}
				break;
			case 28 :
				// myChecker.g:1:169: LARGER
				{
				mLARGER(); 

				}
				break;
			case 29 :
				// myChecker.g:1:176: SMALLER
				{
				mSMALLER(); 

				}
				break;
			case 30 :
				// myChecker.g:1:184: PP_OP
				{
				mPP_OP(); 

				}
				break;
			case 31 :
				// myChecker.g:1:190: MM_OP
				{
				mMM_OP(); 

				}
				break;
			case 32 :
				// myChecker.g:1:196: ADD
				{
				mADD(); 

				}
				break;
			case 33 :
				// myChecker.g:1:200: SUB
				{
				mSUB(); 

				}
				break;
			case 34 :
				// myChecker.g:1:204: MUL
				{
				mMUL(); 

				}
				break;
			case 35 :
				// myChecker.g:1:208: DIV
				{
				mDIV(); 

				}
				break;
			case 36 :
				// myChecker.g:1:212: MOD
				{
				mMOD(); 

				}
				break;
			case 37 :
				// myChecker.g:1:216: ASSIGN
				{
				mASSIGN(); 

				}
				break;
			case 38 :
				// myChecker.g:1:223: ADD_ASSIGN
				{
				mADD_ASSIGN(); 

				}
				break;
			case 39 :
				// myChecker.g:1:234: SUB_ASSIGN
				{
				mSUB_ASSIGN(); 

				}
				break;
			case 40 :
				// myChecker.g:1:245: MUL_ASSIGN
				{
				mMUL_ASSIGN(); 

				}
				break;
			case 41 :
				// myChecker.g:1:256: DIV_ASSIGN
				{
				mDIV_ASSIGN(); 

				}
				break;
			case 42 :
				// myChecker.g:1:267: AND
				{
				mAND(); 

				}
				break;
			case 43 :
				// myChecker.g:1:271: OR
				{
				mOR(); 

				}
				break;
			case 44 :
				// myChecker.g:1:274: NOT
				{
				mNOT(); 

				}
				break;
			case 45 :
				// myChecker.g:1:278: END
				{
				mEND(); 

				}
				break;
			case 46 :
				// myChecker.g:1:282: Semicolon
				{
				mSemicolon(); 

				}
				break;
			case 47 :
				// myChecker.g:1:292: L_PAREN
				{
				mL_PAREN(); 

				}
				break;
			case 48 :
				// myChecker.g:1:300: R_PAREN
				{
				mR_PAREN(); 

				}
				break;
			case 49 :
				// myChecker.g:1:308: L_BRACKET
				{
				mL_BRACKET(); 

				}
				break;
			case 50 :
				// myChecker.g:1:318: R_BRACKET
				{
				mR_BRACKET(); 

				}
				break;
			case 51 :
				// myChecker.g:1:328: L_BRACE
				{
				mL_BRACE(); 

				}
				break;
			case 52 :
				// myChecker.g:1:336: R_BRACE
				{
				mR_BRACE(); 

				}
				break;
			case 53 :
				// myChecker.g:1:344: HASH
				{
				mHASH(); 

				}
				break;
			case 54 :
				// myChecker.g:1:349: COMMA
				{
				mCOMMA(); 

				}
				break;
			case 55 :
				// myChecker.g:1:355: DOT
				{
				mDOT(); 

				}
				break;
			case 56 :
				// myChecker.g:1:359: UNDERSCORE
				{
				mUNDERSCORE(); 

				}
				break;
			case 57 :
				// myChecker.g:1:370: COLON
				{
				mCOLON(); 

				}
				break;
			case 58 :
				// myChecker.g:1:376: Identifier
				{
				mIdentifier(); 

				}
				break;
			case 59 :
				// myChecker.g:1:387: Integer_constant
				{
				mInteger_constant(); 

				}
				break;
			case 60 :
				// myChecker.g:1:404: Floating_point_constant
				{
				mFloating_point_constant(); 

				}
				break;
			case 61 :
				// myChecker.g:1:428: Charliteral
				{
				mCharliteral(); 

				}
				break;
			case 62 :
				// myChecker.g:1:440: String_s
				{
				mString_s(); 

				}
				break;
			case 63 :
				// myChecker.g:1:449: WS
				{
				mWS(); 

				}
				break;
			case 64 :
				// myChecker.g:1:452: COMMENT1
				{
				mCOMMENT1(); 

				}
				break;
			case 65 :
				// myChecker.g:1:461: COMMENT2
				{
				mCOMMENT2(); 

				}
				break;

		}
	}


	protected DFA9 dfa9 = new DFA9(this);
	static final String DFA9_eotS =
		"\1\31\1\52\1\55\1\60\1\62\1\65\1\70\10\46\1\103\1\105\1\107\1\111\1\114"+
		"\1\117\1\121\1\125\15\uffff\1\126\2\uffff\1\127\6\uffff\2\46\1\uffff\1"+
		"\46\1\uffff\2\46\1\uffff\2\46\1\uffff\1\46\1\142\7\46\27\uffff\4\46\1"+
		"\156\2\46\1\162\1\46\1\uffff\7\46\1\173\3\46\1\uffff\3\46\1\uffff\1\46"+
		"\1\u0083\1\u0084\1\46\1\u0086\3\46\1\uffff\2\46\1\u008c\1\u008d\1\u008e"+
		"\2\46\2\uffff\1\46\1\uffff\1\u0092\1\u0093\2\46\1\u0096\3\uffff\2\46\1"+
		"\u0099\2\uffff\1\u009a\1\46\1\uffff\1\162\1\u009c\2\uffff\1\u009d\2\uffff";
	static final String DFA9_eofS =
		"\u009e\uffff";
	static final String DFA9_minS =
		"\1\11\1\42\1\46\4\60\1\146\1\157\1\141\1\145\1\154\1\150\2\162\4\75\1"+
		"\53\1\55\1\75\1\52\15\uffff\1\60\2\uffff\1\56\6\uffff\1\141\1\156\1\uffff"+
		"\1\165\1\uffff\1\157\1\162\1\uffff\1\157\1\141\1\uffff\1\143\1\60\2\151"+
		"\1\164\1\163\1\151\1\145\1\151\27\uffff\1\162\1\164\1\142\1\141\1\60\1"+
		"\162\1\156\1\60\1\154\1\uffff\1\144\1\156\1\165\1\145\1\154\1\141\1\156"+
		"\1\60\1\151\1\154\1\164\1\uffff\1\164\1\146\1\147\1\uffff\1\165\2\60\1"+
		"\162\1\60\1\145\1\153\1\164\1\uffff\1\156\1\145\3\60\1\145\1\144\2\uffff"+
		"\1\156\1\uffff\2\60\1\146\1\165\1\60\3\uffff\1\162\1\145\1\60\2\uffff"+
		"\1\60\1\145\1\uffff\2\60\2\uffff\1\60\2\uffff";
	static final String DFA9_maxS =
		"\1\175\1\172\1\46\4\172\1\156\1\157\1\141\1\145\1\154\1\150\2\162\10\75"+
		"\15\uffff\1\172\2\uffff\1\71\6\uffff\1\141\1\156\1\uffff\1\165\1\uffff"+
		"\1\157\1\162\1\uffff\1\157\1\141\1\uffff\1\164\1\172\2\151\1\164\1\163"+
		"\1\151\1\145\1\151\27\uffff\1\162\1\164\1\142\1\141\1\172\1\162\1\156"+
		"\1\172\1\154\1\uffff\1\144\1\156\1\165\1\145\1\154\1\141\1\156\1\172\1"+
		"\151\1\154\1\164\1\uffff\1\164\1\146\1\147\1\uffff\1\165\2\172\1\162\1"+
		"\172\1\145\1\153\1\164\1\uffff\1\156\1\145\3\172\1\145\1\144\2\uffff\1"+
		"\156\1\uffff\2\172\1\146\1\165\1\172\3\uffff\1\162\1\145\1\172\2\uffff"+
		"\1\172\1\145\1\uffff\2\172\2\uffff\1\172\2\uffff";
	static final String DFA9_acceptS =
		"\27\uffff\1\44\1\53\1\55\1\56\1\57\1\60\1\61\1\62\1\63\1\64\1\65\1\66"+
		"\1\67\1\uffff\1\71\1\72\1\uffff\1\75\1\77\1\1\1\76\1\52\1\2\2\uffff\1"+
		"\3\1\uffff\1\4\2\uffff\1\5\2\uffff\1\6\11\uffff\1\30\1\45\1\31\1\35\1"+
		"\32\1\34\1\33\1\54\1\36\1\46\1\40\1\37\1\47\1\41\1\50\1\42\1\51\1\100"+
		"\1\101\1\43\1\70\1\73\1\74\11\uffff\1\20\13\uffff\1\25\3\uffff\1\7\10"+
		"\uffff\1\10\7\uffff\1\11\1\15\1\uffff\1\21\5\uffff\1\12\1\14\1\27\3\uffff"+
		"\1\22\1\23\2\uffff\1\13\2\uffff\1\16\1\26\1\uffff\1\17\1\24";
	static final String DFA9_specialS =
		"\u009e\uffff}>";
	static final String[] DFA9_transitionS = {
			"\2\51\2\uffff\1\51\22\uffff\1\51\1\22\1\1\1\41\1\uffff\1\27\1\2\1\50"+
			"\1\33\1\34\1\25\1\23\1\42\1\24\1\43\1\26\12\47\1\45\1\32\1\20\1\17\1"+
			"\21\2\uffff\32\46\1\35\1\uffff\1\36\1\uffff\1\44\1\uffff\1\46\1\15\1"+
			"\3\1\4\1\13\1\5\2\46\1\7\3\46\1\11\2\46\1\16\1\46\1\12\1\6\2\46\1\10"+
			"\1\14\3\46\1\37\1\30\1\40",
			"\1\53\15\uffff\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
			"\1\54",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\7\46\1\56\6\46\1\57\13\46",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\16\46\1\61\13\46",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\13\46\1\63\2\46\1\64\13\46",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\2\46\1\67\4\46\1\66\22\46",
			"\1\72\7\uffff\1\71",
			"\1\73",
			"\1\74",
			"\1\75",
			"\1\76",
			"\1\77",
			"\1\100",
			"\1\101",
			"\1\102",
			"\1\104",
			"\1\106",
			"\1\110",
			"\1\112\21\uffff\1\113",
			"\1\115\17\uffff\1\116",
			"\1\120",
			"\1\124\4\uffff\1\123\15\uffff\1\122",
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
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"",
			"",
			"\1\130\1\uffff\12\47",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\131",
			"\1\132",
			"",
			"\1\133",
			"",
			"\1\134",
			"\1\135",
			"",
			"\1\136",
			"\1\137",
			"",
			"\1\141\20\uffff\1\140",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\1\143",
			"\1\144",
			"\1\145",
			"\1\146",
			"\1\147",
			"\1\150",
			"\1\151",
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
			"\1\152",
			"\1\153",
			"\1\154",
			"\1\155",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\1\157",
			"\1\160",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\4\46\1\161\25\46",
			"\1\163",
			"",
			"\1\164",
			"\1\165",
			"\1\166",
			"\1\167",
			"\1\170",
			"\1\171",
			"\1\172",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\1\174",
			"\1\175",
			"\1\176",
			"",
			"\1\177",
			"\1\u0080",
			"\1\u0081",
			"",
			"\1\u0082",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\1\u0085",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\1\u0087",
			"\1\u0088",
			"\1\u0089",
			"",
			"\1\u008a",
			"\1\u008b",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\1\u008f",
			"\1\u0090",
			"",
			"",
			"\1\u0091",
			"",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\1\u0094",
			"\1\u0095",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"",
			"",
			"",
			"\1\u0097",
			"\1\u0098",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"",
			"",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\1\u009b",
			"",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"",
			"",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"",
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
			return "1:1: Tokens : ( T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | INT | CHAR | VOID | FLOAT | DOUBLE | SHORT | MAIN | RETURN | INCLUDE | IF | ELSE | WHILE | BREAK | CONTINUE | FOR | PRINTF | SCANF | EQ_OP | LE_OP | GE_OP | NE_OP | LARGER | SMALLER | PP_OP | MM_OP | ADD | SUB | MUL | DIV | MOD | ASSIGN | ADD_ASSIGN | SUB_ASSIGN | MUL_ASSIGN | DIV_ASSIGN | AND | OR | NOT | END | Semicolon | L_PAREN | R_PAREN | L_BRACKET | R_BRACKET | L_BRACE | R_BRACE | HASH | COMMA | DOT | UNDERSCORE | COLON | Identifier | Integer_constant | Floating_point_constant | Charliteral | String_s | WS | COMMENT1 | COMMENT2 );";
		}
	}

}
