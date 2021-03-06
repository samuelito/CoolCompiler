/* The following code was generated by JFlex 1.4.3 on 11-20-14 06:34 PM */

/*
 *  The scanner definition for COOL.
 */

import java_cup.runtime.Symbol;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 11-20-14 06:34 PM from the specification file
 * <tt>/home/jaime/git/CoolCompiler/CoolCompiler/cool.lex</tt>
 */
class CoolLexer implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int STRING = 2;
  public static final int YYINITIAL = 0;
  public static final int COMMENT = 6;
  public static final int CONTINUE = 4;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1,  1,  2,  2,  3, 3
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\1\74\10\0\1\23\1\22\1\0\1\23\1\23\22\0\1\23\1\0"+
    "\1\72\5\0\1\16\1\17\1\12\1\10\1\6\1\11\1\3\1\13"+
    "\12\50\1\5\1\4\1\15\1\1\1\2\1\0\1\7\1\32\1\70"+
    "\1\35\1\46\1\30\1\42\1\70\1\47\1\41\2\70\1\33\1\70"+
    "\1\43\1\37\1\36\1\70\1\26\1\34\1\40\1\27\1\45\1\44"+
    "\1\70\1\70\1\70\1\0\1\73\2\0\1\71\1\0\1\55\1\75"+
    "\1\60\1\66\1\54\1\31\1\51\1\67\1\63\2\51\1\56\1\51"+
    "\1\64\1\62\1\61\1\51\1\52\1\57\1\25\1\53\1\24\1\65"+
    "\3\51\1\20\1\0\1\21\1\14\uff81\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\2\2\1\3\1\4\1\5\1\6\1\7"+
    "\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17"+
    "\1\20\1\21\1\22\1\23\1\24\2\2\1\25\2\26"+
    "\1\25\11\26\1\27\11\25\1\30\1\1\1\31\1\32"+
    "\1\0\1\2\1\33\1\34\1\0\3\2\1\35\1\36"+
    "\1\0\1\37\1\40\1\41\1\42\2\25\2\26\1\25"+
    "\1\43\5\26\1\44\1\26\1\45\1\26\1\46\1\43"+
    "\3\26\7\25\1\44\1\45\1\25\1\46\3\25\1\47"+
    "\1\50\1\51\1\52\1\53\1\54\1\55\1\2\1\56"+
    "\2\25\2\26\1\25\1\57\7\26\1\60\1\61\1\26"+
    "\2\25\1\57\6\25\1\60\1\61\1\25\1\62\1\63"+
    "\1\64\1\65\1\25\1\66\1\67\1\26\1\70\1\63"+
    "\3\26\1\64\1\65\1\66\1\67\1\25\1\70\3\25"+
    "\1\71\1\72\2\26\1\73\1\72\2\25\1\73\1\74"+
    "\1\26\1\74\1\25\1\26\1\25\2\75";

  private static int [] zzUnpackAction() {
    int [] result = new int[176];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\76\0\174\0\272\0\370\0\u0136\0\370\0\370"+
    "\0\370\0\370\0\370\0\370\0\u0174\0\u01b2\0\370\0\370"+
    "\0\u01f0\0\u022e\0\370\0\370\0\370\0\370\0\u026c\0\u02aa"+
    "\0\u02e8\0\u0326\0\u0364\0\u03a2\0\u03e0\0\u041e\0\u045c\0\u049a"+
    "\0\u04d8\0\u0516\0\u0554\0\u0592\0\u05d0\0\u060e\0\u064c\0\u068a"+
    "\0\u06c8\0\u0706\0\u0744\0\u0782\0\u07c0\0\u07fe\0\u083c\0\370"+
    "\0\u087a\0\370\0\370\0\u08b8\0\u08f6\0\370\0\370\0\u0934"+
    "\0\u0972\0\u09b0\0\u09ee\0\370\0\370\0\u0a2c\0\370\0\370"+
    "\0\370\0\370\0\u0a6a\0\u0aa8\0\u0ae6\0\u0b24\0\u0b62\0\u064c"+
    "\0\u0ba0\0\u0bde\0\u0c1c\0\u0c5a\0\u0c98\0\u0326\0\u0cd6\0\u0326"+
    "\0\u0d14\0\u0d52\0\u0326\0\u0d90\0\u0dce\0\u0e0c\0\u0e4a\0\u0e88"+
    "\0\u0ec6\0\u0f04\0\u0f42\0\u0f80\0\u0fbe\0\u064c\0\u064c\0\u0ffc"+
    "\0\u103a\0\u1078\0\u10b6\0\u10f4\0\370\0\370\0\370\0\370"+
    "\0\370\0\370\0\370\0\370\0\370\0\u1132\0\u1170\0\u11ae"+
    "\0\u11ec\0\u122a\0\u0326\0\u1268\0\u12a6\0\u12e4\0\u1322\0\u1360"+
    "\0\u139e\0\u13dc\0\u0326\0\u0326\0\u141a\0\u1458\0\u1496\0\u064c"+
    "\0\u14d4\0\u1512\0\u1550\0\u158e\0\u15cc\0\u160a\0\u064c\0\u064c"+
    "\0\u1648\0\u064c\0\u064c\0\u0326\0\u0326\0\u1686\0\u0326\0\u0326"+
    "\0\u16c4\0\u0326\0\u0326\0\u1702\0\u1740\0\u177e\0\u064c\0\u064c"+
    "\0\u064c\0\u064c\0\u17bc\0\u064c\0\u17fa\0\u1838\0\u1876\0\u064c"+
    "\0\u0326\0\u18b4\0\u18f2\0\u0326\0\u064c\0\u1930\0\u196e\0\u064c"+
    "\0\u0326\0\u19ac\0\u064c\0\u19ea\0\u1a28\0\u1a66\0\u0326\0\u064c";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[176];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\5\1\6\1\5\1\7\1\10\1\11\1\12\1\13"+
    "\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23"+
    "\1\24\1\25\1\26\1\27\1\30\1\31\2\32\1\33"+
    "\1\34\1\32\1\35\1\32\1\36\1\37\1\40\1\41"+
    "\1\42\1\43\1\44\1\45\3\32\1\46\3\47\1\50"+
    "\1\47\1\51\1\47\1\52\1\53\1\54\1\55\1\56"+
    "\1\57\2\47\1\32\1\5\1\60\2\5\1\47\22\61"+
    "\1\62\47\61\1\63\1\64\1\0\1\61\22\65\1\66"+
    "\47\65\1\67\1\70\2\65\12\71\1\72\3\71\1\73"+
    "\1\0\2\71\1\74\51\71\1\0\1\71\100\0\1\75"+
    "\104\0\1\76\103\0\1\77\57\0\1\100\7\0\1\101"+
    "\76\0\1\102\106\0\2\27\74\0\1\27\1\30\45\47"+
    "\3\0\1\47\24\0\2\47\1\103\20\47\1\104\2\47"+
    "\1\103\14\47\1\104\2\47\3\0\1\47\24\0\46\32"+
    "\3\0\1\32\24\0\7\32\1\105\1\106\21\32\1\105"+
    "\1\106\12\32\3\0\1\32\24\0\6\47\1\107\6\47"+
    "\1\110\13\47\1\107\5\47\1\110\6\47\3\0\1\47"+
    "\24\0\4\32\1\111\6\32\1\112\14\32\1\111\5\32"+
    "\1\112\7\32\3\0\1\32\24\0\6\32\1\113\1\114"+
    "\21\32\1\113\1\114\13\32\3\0\1\32\24\0\13\32"+
    "\1\115\22\32\1\115\7\32\3\0\1\32\24\0\5\32"+
    "\1\116\10\32\1\116\27\32\3\0\1\32\24\0\23\32"+
    "\1\117\17\32\1\117\2\32\3\0\1\32\24\0\5\32"+
    "\1\120\2\32\1\121\5\32\1\120\1\122\13\32\1\121"+
    "\4\32\1\122\5\32\3\0\1\32\24\0\15\32\1\123"+
    "\21\32\1\123\6\32\3\0\1\32\24\0\4\32\1\124"+
    "\6\32\1\125\14\32\1\124\5\32\1\125\7\32\3\0"+
    "\1\32\24\0\23\32\1\126\17\32\1\126\2\32\3\0"+
    "\1\32\50\0\1\46\51\0\46\47\3\0\1\47\24\0"+
    "\7\47\1\127\1\130\21\47\1\127\1\130\12\47\3\0"+
    "\1\47\24\0\4\47\1\131\6\47\1\132\14\47\1\131"+
    "\5\47\1\132\7\47\3\0\1\47\24\0\6\47\1\133"+
    "\1\134\21\47\1\133\1\134\13\47\3\0\1\47\24\0"+
    "\13\47\1\135\22\47\1\135\7\47\3\0\1\47\24\0"+
    "\5\47\1\136\10\47\1\136\27\47\3\0\1\47\24\0"+
    "\5\47\1\137\2\47\1\140\5\47\1\137\1\141\13\47"+
    "\1\140\4\47\1\141\5\47\3\0\1\47\24\0\4\47"+
    "\1\142\6\47\1\143\14\47\1\142\5\47\1\143\7\47"+
    "\3\0\1\47\24\0\23\47\1\144\17\47\1\144\2\47"+
    "\3\0\1\47\22\61\1\0\47\61\3\0\1\61\22\145"+
    "\1\146\2\145\1\147\3\145\1\150\32\145\1\151\7\145"+
    "\1\152\1\153\22\65\1\0\47\65\2\0\2\65\22\154"+
    "\1\74\53\154\12\71\1\0\4\71\1\0\2\71\1\0"+
    "\51\71\1\0\1\71\17\0\1\67\56\0\12\71\1\154"+
    "\4\71\1\0\2\71\1\0\51\71\1\0\1\71\22\76"+
    "\1\155\53\76\24\0\3\47\1\156\23\47\1\156\16\47"+
    "\3\0\1\47\24\0\4\47\1\157\23\47\1\157\15\47"+
    "\3\0\1\47\24\0\10\32\1\160\22\32\1\160\12\32"+
    "\3\0\1\32\24\0\6\32\1\161\22\32\1\161\14\32"+
    "\3\0\1\32\24\0\7\47\1\162\22\47\1\162\13\47"+
    "\3\0\1\47\24\0\1\32\1\163\12\32\1\163\31\32"+
    "\3\0\1\32\24\0\13\32\1\164\22\32\1\164\7\32"+
    "\3\0\1\32\24\0\10\32\1\165\22\32\1\165\12\32"+
    "\3\0\1\32\24\0\6\32\1\166\22\32\1\166\14\32"+
    "\3\0\1\32\24\0\13\32\1\167\22\32\1\167\7\32"+
    "\3\0\1\32\24\0\4\32\1\170\23\32\1\170\15\32"+
    "\3\0\1\32\24\0\1\171\20\32\1\171\24\32\3\0"+
    "\1\32\24\0\23\32\1\172\17\32\1\172\2\32\3\0"+
    "\1\32\24\0\20\32\1\173\20\32\1\173\4\32\3\0"+
    "\1\32\24\0\1\32\1\174\12\32\1\174\31\32\3\0"+
    "\1\32\24\0\15\32\1\175\21\32\1\175\6\32\3\0"+
    "\1\32\24\0\10\47\1\176\22\47\1\176\12\47\3\0"+
    "\1\47\24\0\6\47\1\177\22\47\1\177\14\47\3\0"+
    "\1\47\24\0\1\47\1\200\12\47\1\200\31\47\3\0"+
    "\1\47\24\0\13\47\1\201\22\47\1\201\7\47\3\0"+
    "\1\47\24\0\10\47\1\202\22\47\1\202\12\47\3\0"+
    "\1\47\24\0\6\47\1\203\22\47\1\203\14\47\3\0"+
    "\1\47\24\0\13\47\1\204\22\47\1\204\7\47\3\0"+
    "\1\47\24\0\1\205\20\47\1\205\24\47\3\0\1\47"+
    "\24\0\23\47\1\206\17\47\1\206\2\47\3\0\1\47"+
    "\24\0\20\47\1\207\20\47\1\207\4\47\3\0\1\47"+
    "\24\0\1\47\1\210\12\47\1\210\31\47\3\0\1\47"+
    "\24\0\15\47\1\211\21\47\1\211\6\47\3\0\1\47"+
    "\24\0\4\47\1\212\23\47\1\212\15\47\3\0\1\47"+
    "\24\0\17\47\1\213\20\47\1\213\5\47\3\0\1\47"+
    "\24\0\4\32\1\214\23\32\1\214\15\32\3\0\1\32"+
    "\24\0\11\32\1\215\22\32\1\215\11\32\3\0\1\32"+
    "\24\0\10\47\1\216\22\47\1\216\12\47\3\0\1\47"+
    "\24\0\12\32\1\217\22\32\1\217\10\32\3\0\1\32"+
    "\24\0\4\32\1\220\23\32\1\220\15\32\3\0\1\32"+
    "\24\0\10\32\1\221\22\32\1\221\12\32\3\0\1\32"+
    "\24\0\7\32\1\222\22\32\1\222\13\32\3\0\1\32"+
    "\24\0\17\32\1\223\20\32\1\223\5\32\3\0\1\32"+
    "\24\0\13\32\1\224\22\32\1\224\7\32\3\0\1\32"+
    "\24\0\4\32\1\225\23\32\1\225\15\32\3\0\1\32"+
    "\24\0\7\32\1\226\22\32\1\226\13\32\3\0\1\32"+
    "\24\0\4\47\1\227\23\47\1\227\15\47\3\0\1\47"+
    "\24\0\11\47\1\230\22\47\1\230\11\47\3\0\1\47"+
    "\24\0\12\47\1\231\22\47\1\231\10\47\3\0\1\47"+
    "\24\0\4\47\1\232\23\47\1\232\15\47\3\0\1\47"+
    "\24\0\10\47\1\233\22\47\1\233\12\47\3\0\1\47"+
    "\24\0\7\47\1\234\22\47\1\234\13\47\3\0\1\47"+
    "\24\0\13\47\1\235\22\47\1\235\7\47\3\0\1\47"+
    "\24\0\4\47\1\236\23\47\1\236\15\47\3\0\1\47"+
    "\24\0\7\47\1\237\22\47\1\237\13\47\3\0\1\47"+
    "\24\0\4\47\1\240\23\47\1\240\15\47\3\0\1\47"+
    "\24\0\10\32\1\241\22\32\1\241\12\32\3\0\1\32"+
    "\24\0\15\32\1\242\21\32\1\242\6\32\3\0\1\32"+
    "\24\0\2\32\1\243\23\32\1\243\17\32\3\0\1\32"+
    "\24\0\4\32\1\244\23\32\1\244\15\32\3\0\1\32"+
    "\24\0\10\47\1\245\22\47\1\245\12\47\3\0\1\47"+
    "\24\0\15\47\1\246\21\47\1\246\6\47\3\0\1\47"+
    "\24\0\2\47\1\247\23\47\1\247\17\47\3\0\1\47"+
    "\24\0\4\47\1\250\23\47\1\250\15\47\3\0\1\47"+
    "\24\0\22\32\1\251\17\32\1\251\3\32\3\0\1\32"+
    "\24\0\15\32\1\252\21\32\1\252\6\32\3\0\1\32"+
    "\24\0\22\47\1\253\17\47\1\253\3\47\3\0\1\47"+
    "\24\0\15\47\1\254\21\47\1\254\6\47\3\0\1\47"+
    "\24\0\1\32\1\255\12\32\1\255\31\32\3\0\1\32"+
    "\24\0\1\47\1\256\12\47\1\256\31\47\3\0\1\47"+
    "\24\0\10\32\1\257\22\32\1\257\12\32\3\0\1\32"+
    "\24\0\10\47\1\260\22\47\1\260\12\47\3\0\1\47";

  private static int [] zzUnpackTrans() {
    int [] result = new int[6820];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\3\1\1\11\1\1\6\11\2\1\2\11\2\1"+
    "\4\11\31\1\1\11\1\1\2\11\1\0\1\1\2\11"+
    "\1\0\3\1\2\11\1\0\4\11\42\1\11\11\103\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[176];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
    // Max size of string constants
    static int MAX_STR_CONST = 1025;

    // For assembling string constants
    StringBuffer string_buf = new StringBuffer();
   
	
    private int curr_lineno = 1;
    int get_curr_lineno() {
	return curr_lineno;
    }

    private AbstractSymbol filename;

    void set_filename(String fname) {
	filename = AbstractTable.stringtable.addString(fname);
    }

    AbstractSymbol curr_filename() {
	return filename;
    }
    
    


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  CoolLexer(java.io.Reader in) {
      // empty for now
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  CoolLexer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 172) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 18: 
          { return new Symbol(TokenConstants.LBRACE);
          }
        case 62: break;
        case 27: 
          { ++curr_lineno;
					yybegin(YYINITIAL);
          }
        case 63: break;
        case 34: 
          { /*System.out.println("#"+curr_lineno+ " Start Block Comment");*/
				yybegin(COMMENT);
          }
        case 64: break;
        case 33: 
          { return new Symbol(TokenConstants.ASSIGN);
          }
        case 65: break;
        case 14: 
          { return new Symbol(TokenConstants.NEG);
          }
        case 66: break;
        case 46: 
          { /*System.out.println("#"+curr_lineno+ " " + yytext());*/
					curr_lineno++;
          }
        case 67: break;
        case 37: 
          { return new Symbol(TokenConstants.IF);
          }
        case 68: break;
        case 47: 
          { return new Symbol(TokenConstants.LET);
          }
        case 69: break;
        case 38: 
          { return new Symbol(TokenConstants.IN);
          }
        case 70: break;
        case 4: 
          { return new Symbol(TokenConstants.EQ);
          }
        case 71: break;
        case 9: 
          { return new Symbol(TokenConstants.AT);
          }
        case 72: break;
        case 57: 
          { Boolean boolvalue = false;
			  		Symbol ret = new Symbol(TokenConstants.BOOL_CONST);
		  			ret.value = boolvalue;
		  			return ret;
          }
        case 73: break;
        case 48: 
          { return new Symbol(TokenConstants.NEW);
          }
        case 74: break;
        case 41: 
          { string_buf.append('\t');
          }
        case 75: break;
        case 28: 
          { yybegin(YYINITIAL);
          }
        case 76: break;
        case 54: 
          { return new Symbol(TokenConstants.LOOP);
          }
        case 77: break;
        case 7: 
          { return new Symbol(TokenConstants.COLON);
          }
        case 78: break;
        case 10: 
          { return new Symbol(TokenConstants.PLUS);
          }
        case 79: break;
        case 2: 
          { ;
          }
        case 80: break;
        case 24: 
          { string_buf.setLength(0);
				yybegin(STRING);
          }
        case 81: break;
        case 53: 
          { return new Symbol(TokenConstants.ESAC);
          }
        case 82: break;
        case 16: 
          { return new Symbol(TokenConstants.LPAREN);
          }
        case 83: break;
        case 59: 
          { return new Symbol(TokenConstants.WHILE);
          }
        case 84: break;
        case 55: 
          { return new Symbol(TokenConstants.CASE);
          }
        case 85: break;
        case 61: 
          { return new Symbol(TokenConstants.INHERITS);
          }
        case 86: break;
        case 52: 
          { return new Symbol(TokenConstants.ELSE);
          }
        case 87: break;
        case 19: 
          { return new Symbol(TokenConstants.RBRACE);
          }
        case 88: break;
        case 5: 
          { return new Symbol(TokenConstants.DOT);
          }
        case 89: break;
        case 23: 
          { AbstractSymbol intvalue = AbstractTable.inttable.addString(yytext());
		 	  		Symbol ret = new Symbol(TokenConstants.INT_CONST);
		   			ret.value = intvalue;
		   			return ret;
          }
        case 90: break;
        case 51: 
          { return new Symbol(TokenConstants.THEN);
          }
        case 91: break;
        case 50: 
          { Boolean boolvalue = true;
		 			Symbol ret = new Symbol(TokenConstants.BOOL_CONST);
		  			ret.value = boolvalue;
		  			return ret;
          }
        case 92: break;
        case 15: 
          { return new Symbol(TokenConstants.LE);
          }
        case 93: break;
        case 12: 
          { return new Symbol(TokenConstants.MULT);
          }
        case 94: break;
        case 42: 
          { string_buf.append('\f');
          }
        case 95: break;
        case 25: 
          { yybegin(YYINITIAL);
				String err_msg = new String("String Missing Close Quote");
				StringSymbol error = new StringSymbol(err_msg, err_msg.length(), 0);
				Symbol ret = new Symbol(TokenConstants.ERROR);
				ret.value = error;
				return ret;
          }
        case 96: break;
        case 30: 
          { return new Symbol(TokenConstants.DARROW);
          }
        case 97: break;
        case 20: 
          { curr_lineno++;
          }
        case 98: break;
        case 35: 
          { return new Symbol(TokenConstants.FI);
          }
        case 99: break;
        case 11: 
          { return new Symbol(TokenConstants.MINUS);
          }
        case 100: break;
        case 40: 
          { string_buf.append('\n');		  
				++curr_lineno;
				yybegin(STRING);
          }
        case 101: break;
        case 60: 
          { return new Symbol(TokenConstants.ISVOID);
          }
        case 102: break;
        case 36: 
          { return new Symbol(TokenConstants.OF);
          }
        case 103: break;
        case 22: 
          { AbstractSymbol lex_val = AbstractTable.idtable.addString(yytext());
		  			Symbol ret = new Symbol(TokenConstants.TYPEID);
		   			ret.value = lex_val;
		   			return ret;
          }
        case 104: break;
        case 6: 
          { return new Symbol(TokenConstants.SEMI);
          }
        case 105: break;
        case 39: 
          { string_buf.append(yycharat(yytext().length()-1));
          }
        case 106: break;
        case 49: 
          { return new Symbol(TokenConstants.NOT);
          }
        case 107: break;
        case 8: 
          { return new Symbol(TokenConstants.COMMA);
          }
        case 108: break;
        case 1: 
          { if(yytext().length() > MAX_STR_CONST ){
					yybegin(CONTINUE);
					String err_msg = new String("String is out of bound");
					StringSymbol error = new StringSymbol(err_msg, err_msg.length(), 0);
					Symbol ret = new Symbol(TokenConstants.ERROR);
					ret.value = error;
					return ret;	
					}
				else{
					string_buf.append(yytext());}
          }
        case 109: break;
        case 13: 
          { return new Symbol(TokenConstants.DIV);
          }
        case 110: break;
        case 32: 
          { return new Symbol(TokenConstants.LT);
          }
        case 111: break;
        case 43: 
          { string_buf.append('\n');
          }
        case 112: break;
        case 29: 
          { ++curr_lineno;
          }
        case 113: break;
        case 58: 
          { return new Symbol(TokenConstants.CLASS);
          }
        case 114: break;
        case 56: 
          { return new Symbol(TokenConstants.POOL);
          }
        case 115: break;
        case 17: 
          { return new Symbol(TokenConstants.RPAREN);
          }
        case 116: break;
        case 26: 
          { AbstractSymbol lex_val = AbstractTable.stringtable.addString(string_buf.toString());
		  	Symbol ret = new Symbol(TokenConstants.STR_CONST);
		   	ret.value = lex_val;
		   	string_buf.setLength(0);
		  	yybegin(YYINITIAL);
		    return ret;
          }
        case 117: break;
        case 45: 
          { string_buf.append('\b');
          }
        case 118: break;
        case 3: 
          { /* This rule should be the very last
                     in your lexical specification and
                     will match match everything not
                     matched by other lexical rules. */
                     System.out.println("#"+ curr_lineno+ " ERROR LEXER BUG - UNMATCHED: " + yytext());
          }
        case 119: break;
        case 31: 
          { String err_msg = new String("Unmatched Comment Terminator: *) ");
					StringSymbol error = new StringSymbol(err_msg, err_msg.length(), 0);
					Symbol ret = new Symbol(TokenConstants.ERROR);
					ret.value = error;
					return ret;
          }
        case 120: break;
        case 44: 
          { ++curr_lineno;
				String err_msg = new String("String contains null");
				StringSymbol error = new StringSymbol(err_msg, err_msg.length(), 0);
				Symbol ret = new Symbol(TokenConstants.ERROR);
				ret.value = error;
				return ret;
          }
        case 121: break;
        case 21: 
          { AbstractSymbol lex_val = AbstractTable.idtable.addString(yytext());
				   Symbol ret = new Symbol(TokenConstants.OBJECTID);
				   ret.value = lex_val;
		 		   return ret;
          }
        case 122: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
            switch (zzLexicalState) {
            case STRING: {
              yybegin(YYINITIAL);
			    String err_msg = new String("String contains EOF");
				StringSymbol error = new StringSymbol(err_msg, err_msg.length(), 0);
				Symbol ret = new Symbol(TokenConstants.ERROR);
				ret.value = error;
				return ret;
            }
            case 177: break;
            case COMMENT: {
              yybegin(YYINITIAL);
			    String err_msg = new String("Comment contains EOF");
				StringSymbol error = new StringSymbol(err_msg, err_msg.length(), 0);
				Symbol ret = new Symbol(TokenConstants.ERROR);
				ret.value = error;
				return ret;
            }
            case 178: break;
            default:
              {     switch(yystate()) {
    case YYINITIAL:
	/* nothing special to do in the initial state */
	break;
	
	/* If necessary, add code for other states here, e.g:
	   case COMMENT:
	   ...
	   break;
	*/
    }
    return new Symbol(TokenConstants.EOF);
 }
            }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
