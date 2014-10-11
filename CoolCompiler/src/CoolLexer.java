/* The following code was generated by JFlex 1.4.3 on 10/10/14 7:21 PM */

/*
 *  The scanner definition for COOL.
 */

import java_cup.runtime.Symbol;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 10/10/14 7:21 PM from the specification file
 * <tt>/home/samuelfeliciano/git/CoolCompiler/CoolCompiler/cool.lex</tt>
 */
class CoolLexer implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\1\73\10\0\1\24\1\23\1\0\1\24\1\24\22\0\1\24\1\0"+
    "\1\22\5\0\1\16\1\17\1\12\1\10\1\6\1\11\1\3\1\13"+
    "\12\26\1\5\1\4\1\15\1\1\1\2\1\0\1\7\1\34\1\71"+
    "\1\37\1\50\1\32\1\44\1\71\1\51\1\43\2\71\1\35\1\71"+
    "\1\45\1\41\1\40\1\71\1\30\1\36\1\42\1\31\1\47\1\46"+
    "\1\71\1\71\1\71\1\0\1\74\2\0\1\72\1\0\1\56\1\52"+
    "\1\61\1\67\1\55\1\33\1\52\1\70\1\64\2\52\1\57\1\52"+
    "\1\65\1\63\1\62\1\52\1\53\1\60\1\27\1\54\1\25\1\66"+
    "\3\52\1\20\1\0\1\21\1\14\uff81\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7"+
    "\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17"+
    "\1\20\1\21\1\1\1\22\2\23\1\24\1\25\2\26"+
    "\1\25\11\26\11\25\1\27\1\0\1\30\1\31\1\32"+
    "\2\0\2\33\2\25\2\26\1\25\1\34\5\26\1\35"+
    "\1\26\1\36\1\26\1\37\1\34\3\26\7\25\1\35"+
    "\1\36\1\25\1\37\3\25\1\40\3\41\2\25\2\26"+
    "\1\25\1\42\7\26\1\43\1\44\1\26\2\25\1\42"+
    "\6\25\1\43\1\44\1\25\1\45\1\46\1\47\1\50"+
    "\1\51\1\52\1\26\1\53\1\46\3\26\1\47\1\50"+
    "\1\51\1\52\1\25\1\53\3\25\1\54\2\26\1\55"+
    "\1\54\2\25\1\55\1\56\1\26\1\56\1\25\1\26"+
    "\1\25\2\57";

  private static int [] zzUnpackAction() {
    int [] result = new int[157];
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
    "\0\0\0\75\0\172\0\75\0\75\0\75\0\75\0\75"+
    "\0\75\0\267\0\364\0\75\0\75\0\u0131\0\u016e\0\75"+
    "\0\75\0\75\0\u01ab\0\75\0\u01e8\0\u0225\0\u0262\0\u029f"+
    "\0\u02dc\0\u0319\0\u0356\0\u0393\0\u03d0\0\u040d\0\u044a\0\u0487"+
    "\0\u04c4\0\u0501\0\u053e\0\u057b\0\u05b8\0\u05f5\0\u0632\0\u066f"+
    "\0\u06ac\0\u06e9\0\u0726\0\u0763\0\u07a0\0\75\0\u07dd\0\75"+
    "\0\75\0\75\0\u081a\0\u01ab\0\75\0\u01ab\0\u0857\0\u0894"+
    "\0\u08d1\0\u090e\0\u094b\0\u05b8\0\u0988\0\u09c5\0\u0a02\0\u0a3f"+
    "\0\u0a7c\0\u02dc\0\u0ab9\0\u02dc\0\u0af6\0\u0b33\0\u02dc\0\u0b70"+
    "\0\u0bad\0\u0bea\0\u0c27\0\u0c64\0\u0ca1\0\u0cde\0\u0d1b\0\u0d58"+
    "\0\u0d95\0\u05b8\0\u05b8\0\u0dd2\0\u0e0f\0\u0e4c\0\u0e89\0\u0ec6"+
    "\0\75\0\u081a\0\u0f03\0\75\0\u0f40\0\u0f7d\0\u0fba\0\u0ff7"+
    "\0\u1034\0\u02dc\0\u1071\0\u10ae\0\u10eb\0\u1128\0\u1165\0\u11a2"+
    "\0\u11df\0\u02dc\0\u02dc\0\u121c\0\u1259\0\u1296\0\u05b8\0\u12d3"+
    "\0\u1310\0\u134d\0\u138a\0\u13c7\0\u1404\0\u05b8\0\u05b8\0\u1441"+
    "\0\u05b8\0\u05b8\0\u02dc\0\u02dc\0\u02dc\0\u02dc\0\u147e\0\u02dc"+
    "\0\u02dc\0\u14bb\0\u14f8\0\u1535\0\u05b8\0\u05b8\0\u05b8\0\u05b8"+
    "\0\u1572\0\u05b8\0\u15af\0\u15ec\0\u1629\0\u02dc\0\u1666\0\u16a3"+
    "\0\u02dc\0\u05b8\0\u16e0\0\u171d\0\u05b8\0\u02dc\0\u175a\0\u05b8"+
    "\0\u1797\0\u17d4\0\u1811\0\u02dc\0\u05b8";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[157];
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
    "\1\2\1\3\1\2\1\4\1\5\1\6\1\7\1\10"+
    "\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20"+
    "\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30"+
    "\2\31\1\32\1\33\1\31\1\34\1\31\1\35\1\36"+
    "\1\37\1\40\1\41\1\42\1\43\1\44\3\31\3\45"+
    "\1\46\1\45\1\47\1\45\1\50\1\51\1\52\1\53"+
    "\1\54\1\55\2\45\1\31\3\2\77\0\1\56\103\0"+
    "\1\57\102\0\1\60\56\0\1\61\7\0\1\62\75\0"+
    "\1\63\62\0\22\64\2\65\47\64\1\0\1\66\24\0"+
    "\2\25\73\0\1\25\1\26\45\45\30\0\1\27\73\0"+
    "\3\45\1\67\20\45\1\70\1\45\1\67\14\45\1\70"+
    "\2\45\27\0\46\31\27\0\10\31\1\71\1\72\20\31"+
    "\1\71\1\72\12\31\27\0\7\45\1\73\6\45\1\74"+
    "\12\45\1\73\5\45\1\74\6\45\27\0\5\31\1\75"+
    "\6\31\1\76\13\31\1\75\5\31\1\76\7\31\27\0"+
    "\7\31\1\77\1\100\20\31\1\77\1\100\13\31\27\0"+
    "\14\31\1\101\21\31\1\101\7\31\27\0\6\31\1\102"+
    "\10\31\1\102\26\31\27\0\24\31\1\103\16\31\1\103"+
    "\2\31\27\0\6\31\1\104\2\31\1\105\5\31\1\104"+
    "\1\106\12\31\1\105\4\31\1\106\5\31\27\0\16\31"+
    "\1\107\20\31\1\107\6\31\27\0\5\31\1\110\6\31"+
    "\1\111\13\31\1\110\5\31\1\111\7\31\27\0\24\31"+
    "\1\112\16\31\1\112\2\31\27\0\46\45\27\0\10\45"+
    "\1\113\1\114\20\45\1\113\1\114\12\45\27\0\5\45"+
    "\1\115\6\45\1\116\13\45\1\115\5\45\1\116\7\45"+
    "\27\0\7\45\1\117\1\120\20\45\1\117\1\120\13\45"+
    "\27\0\14\45\1\121\21\45\1\121\7\45\27\0\6\45"+
    "\1\122\10\45\1\122\26\45\27\0\6\45\1\123\2\45"+
    "\1\124\5\45\1\123\1\125\12\45\1\124\4\45\1\125"+
    "\5\45\27\0\5\45\1\126\6\45\1\127\13\45\1\126"+
    "\5\45\1\127\7\45\27\0\24\45\1\130\16\45\1\130"+
    "\2\45\2\0\23\57\1\131\51\57\12\132\1\133\4\132"+
    "\1\134\3\132\1\63\51\132\25\0\4\45\1\135\22\45"+
    "\1\135\16\45\27\0\5\45\1\136\22\45\1\136\15\45"+
    "\27\0\11\31\1\137\21\31\1\137\12\31\27\0\7\31"+
    "\1\140\21\31\1\140\14\31\27\0\10\45\1\141\21\45"+
    "\1\141\13\45\27\0\2\31\1\142\12\31\1\142\30\31"+
    "\27\0\14\31\1\143\21\31\1\143\7\31\27\0\11\31"+
    "\1\144\21\31\1\144\12\31\27\0\7\31\1\145\21\31"+
    "\1\145\14\31\27\0\14\31\1\146\21\31\1\146\7\31"+
    "\27\0\5\31\1\147\22\31\1\147\15\31\27\0\1\150"+
    "\21\31\1\150\23\31\27\0\24\31\1\151\16\31\1\151"+
    "\2\31\27\0\21\31\1\152\17\31\1\152\4\31\27\0"+
    "\2\31\1\153\12\31\1\153\30\31\27\0\16\31\1\154"+
    "\20\31\1\154\6\31\27\0\11\45\1\155\21\45\1\155"+
    "\12\45\27\0\7\45\1\156\21\45\1\156\14\45\27\0"+
    "\2\45\1\157\12\45\1\157\30\45\27\0\14\45\1\160"+
    "\21\45\1\160\7\45\27\0\11\45\1\161\21\45\1\161"+
    "\12\45\27\0\7\45\1\162\21\45\1\162\14\45\27\0"+
    "\14\45\1\163\21\45\1\163\7\45\27\0\1\164\21\45"+
    "\1\164\23\45\27\0\24\45\1\165\16\45\1\165\2\45"+
    "\27\0\21\45\1\166\17\45\1\166\4\45\27\0\2\45"+
    "\1\167\12\45\1\167\30\45\27\0\16\45\1\170\20\45"+
    "\1\170\6\45\21\0\1\134\102\0\5\45\1\171\22\45"+
    "\1\171\15\45\27\0\20\45\1\172\17\45\1\172\5\45"+
    "\27\0\5\31\1\173\22\31\1\173\15\31\27\0\12\31"+
    "\1\174\21\31\1\174\11\31\27\0\11\45\1\135\21\45"+
    "\1\135\12\45\27\0\13\31\1\175\21\31\1\175\10\31"+
    "\27\0\5\31\1\176\22\31\1\176\15\31\27\0\11\31"+
    "\1\177\21\31\1\177\12\31\27\0\10\31\1\200\21\31"+
    "\1\200\13\31\27\0\20\31\1\201\17\31\1\201\5\31"+
    "\27\0\14\31\1\202\21\31\1\202\7\31\27\0\5\31"+
    "\1\203\22\31\1\203\15\31\27\0\10\31\1\204\21\31"+
    "\1\204\13\31\27\0\5\45\1\205\22\45\1\205\15\45"+
    "\27\0\12\45\1\206\21\45\1\206\11\45\27\0\13\45"+
    "\1\207\21\45\1\207\10\45\27\0\5\45\1\210\22\45"+
    "\1\210\15\45\27\0\11\45\1\211\21\45\1\211\12\45"+
    "\27\0\10\45\1\212\21\45\1\212\13\45\27\0\14\45"+
    "\1\213\21\45\1\213\7\45\27\0\5\45\1\214\22\45"+
    "\1\214\15\45\27\0\10\45\1\215\21\45\1\215\13\45"+
    "\27\0\11\31\1\216\21\31\1\216\12\31\27\0\16\31"+
    "\1\217\20\31\1\217\6\31\27\0\3\31\1\220\22\31"+
    "\1\220\17\31\27\0\5\31\1\221\22\31\1\221\15\31"+
    "\27\0\11\45\1\222\21\45\1\222\12\45\27\0\16\45"+
    "\1\223\20\45\1\223\6\45\27\0\3\45\1\224\22\45"+
    "\1\224\17\45\27\0\5\45\1\225\22\45\1\225\15\45"+
    "\27\0\23\31\1\226\16\31\1\226\3\31\27\0\16\31"+
    "\1\227\20\31\1\227\6\31\27\0\23\45\1\230\16\45"+
    "\1\230\3\45\27\0\16\45\1\231\20\45\1\231\6\45"+
    "\27\0\2\31\1\232\12\31\1\232\30\31\27\0\2\45"+
    "\1\233\12\45\1\233\30\45\27\0\11\31\1\234\21\31"+
    "\1\234\12\31\27\0\11\45\1\235\21\45\1\235\12\45"+
    "\2\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[6222];
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
    "\1\0\1\11\1\1\6\11\2\1\2\11\2\1\3\11"+
    "\1\1\1\11\31\1\1\11\1\0\3\11\2\0\1\11"+
    "\43\1\1\11\2\1\1\11\101\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[157];
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
        case 16: 
          { return new Symbol(TokenConstants.LBRACE);
          }
        case 48: break;
        case 41: 
          { AbstractSymbol lex_val = AbstractTable.idtable.addString(yytext());
						  Symbol ret = new Symbol(TokenConstants.LOOP);
						  ret.value = lex_val;
						  return ret;
          }
        case 49: break;
        case 27: 
          { /*TEST*/
			System.out.println("TOKEN "+yytext());
			System.out.println("LENGHT "+yytext().length());
			
			if(yytext().length() > MAX_STR_CONST){
				   	String err_msg = new String("String is out of bound");
					StringSymbol error = new StringSymbol(err_msg, err_msg.length(), 0);
					Symbol ret = new Symbol(TokenConstants.ERROR);
					ret.value = error;
					return ret;}
					
			else if(yycharat(yytext().length()-1) == '\"'){
				    AbstractSymbol lex_val = AbstractTable.stringtable.addString(yytext());
				    Symbol ret = new Symbol(TokenConstants.STR_CONST);
				    ret.value = lex_val;
				    return ret;}
				    
			else if( yycharat(yytext().length()-1) == '\n' && yycharat(yytext().length()-2) != '\\' ) { /*EDIT*/
						curr_lineno++;
						String err_msg = new String("String Missing Final Quote");
						StringSymbol error = new StringSymbol(err_msg, err_msg.length(), 0);
						Symbol ret = new Symbol(TokenConstants.ERROR);
						ret.value = error;
						return ret;
			}
          }
        case 50: break;
        case 26: 
          { return new Symbol(TokenConstants.ASSIGN);
          }
        case 51: break;
        case 38: 
          { AbstractSymbol lex_val = AbstractTable.idtable.addString(yytext());
						  Symbol ret = new Symbol(TokenConstants.THEN);
						  ret.value = lex_val;
						  return ret;
          }
        case 52: break;
        case 12: 
          { return new Symbol(TokenConstants.NEG);
          }
        case 53: break;
        case 35: 
          { AbstractSymbol lex_val = AbstractTable.idtable.addString(yytext());
						  Symbol ret = new Symbol(TokenConstants.NEW);
						  ret.value = lex_val;
						  return ret;
          }
        case 54: break;
        case 29: 
          { AbstractSymbol lex_val = AbstractTable.idtable.addString(yytext());
						  Symbol ret = new Symbol(TokenConstants.OF);
						  ret.value = lex_val;
						  return ret;
          }
        case 55: break;
        case 30: 
          { AbstractSymbol lex_val = AbstractTable.idtable.addString(yytext());
						  Symbol ret = new Symbol(TokenConstants.IF);
						  ret.value = lex_val;
						  return ret;
          }
        case 56: break;
        case 21: 
          { AbstractSymbol lex_val = AbstractTable.idtable.addString(yytext());
						  Symbol ret = new Symbol(TokenConstants.OBJECTID);
						  ret.value = lex_val;
						  return ret;
          }
        case 57: break;
        case 2: 
          { return new Symbol(TokenConstants.EQ);
          }
        case 58: break;
        case 7: 
          { return new Symbol(TokenConstants.AT);
          }
        case 59: break;
        case 36: 
          { AbstractSymbol lex_val = AbstractTable.idtable.addString(yytext());
						  Symbol ret = new Symbol(TokenConstants.NOT);
						  ret.value = lex_val;
						  return ret;
          }
        case 60: break;
        case 34: 
          { AbstractSymbol lex_val = AbstractTable.idtable.addString(yytext());
						  Symbol ret = new Symbol(TokenConstants.LET);
						  ret.value = lex_val;
						  return ret;
          }
        case 61: break;
        case 40: 
          { AbstractSymbol lex_val = AbstractTable.idtable.addString(yytext());
						  Symbol ret = new Symbol(TokenConstants.ESAC);
						  ret.value = lex_val;
						  return ret;
          }
        case 62: break;
        case 5: 
          { return new Symbol(TokenConstants.COLON);
          }
        case 63: break;
        case 8: 
          { return new Symbol(TokenConstants.PLUS);
          }
        case 64: break;
        case 19: 
          { ;
          }
        case 65: break;
        case 14: 
          { return new Symbol(TokenConstants.LPAREN);
          }
        case 66: break;
        case 37: 
          { AbstractSymbol boolvalue = AbstractTable.idtable.addString(yytext());
						  Symbol ret = new Symbol(TokenConstants.BOOL_CONST);
						  ret.value = boolvalue;
						  return ret;
          }
        case 67: break;
        case 17: 
          { return new Symbol(TokenConstants.RBRACE);
          }
        case 68: break;
        case 3: 
          { return new Symbol(TokenConstants.DOT);
          }
        case 69: break;
        case 24: 
          { String err_msg = new String("Unmatched Comment Terminator: *) ");
						StringSymbol error = new StringSymbol(err_msg, err_msg.length(), 0);
						Symbol ret = new Symbol(TokenConstants.ERROR);
						ret.value = error;
						return ret;
          }
        case 70: break;
        case 13: 
          { return new Symbol(TokenConstants.LE);
          }
        case 71: break;
        case 31: 
          { AbstractSymbol lex_val = AbstractTable.idtable.addString(yytext());
						  Symbol ret = new Symbol(TokenConstants.IN);
						  ret.value = lex_val;
						  return ret;
          }
        case 72: break;
        case 10: 
          { return new Symbol(TokenConstants.MULT);
          }
        case 73: break;
        case 45: 
          { AbstractSymbol lex_val = AbstractTable.idtable.addString(yytext());
						  Symbol ret = new Symbol(TokenConstants.WHILE);
						  ret.value = lex_val;
						  return ret;
          }
        case 74: break;
        case 23: 
          { return new Symbol(TokenConstants.DARROW);
          }
        case 75: break;
        case 43: 
          { AbstractSymbol lex_val = AbstractTable.idtable.addString(yytext());
						  Symbol ret = new Symbol(TokenConstants.POOL);
						  ret.value = lex_val;
						  return ret;
          }
        case 76: break;
        case 18: 
          { curr_lineno++;
          }
        case 77: break;
        case 9: 
          { return new Symbol(TokenConstants.MINUS);
          }
        case 78: break;
        case 42: 
          { AbstractSymbol lex_val = AbstractTable.idtable.addString(yytext());
						  Symbol ret = new Symbol(TokenConstants.CASE);
						  ret.value = lex_val;
						  return ret;
          }
        case 79: break;
        case 33: 
          { if(((yycharat(yytext().length()-1)) != ')')&&((yycharat(yytext().length()-2)) != '*')){
						String err_msg = new String("Comment can't end in EOF: " + yytext());
						StringSymbol error = new StringSymbol(err_msg, err_msg.length(), 0);
						Symbol ret = new Symbol(TokenConstants.ERROR);
						ret.value = error;
						return ret;}
					else{
						System.out.println("BLOCK Comment: \n  " + yytext());
						curr_lineno++;  }
          }
        case 80: break;
        case 22: 
          { AbstractSymbol lex_val = AbstractTable.idtable.addString(yytext());
						  Symbol ret = new Symbol(TokenConstants.TYPEID);
						  ret.value = lex_val;
						  return ret;
          }
        case 81: break;
        case 4: 
          { return new Symbol(TokenConstants.SEMI);
          }
        case 82: break;
        case 20: 
          { AbstractSymbol intvalue = AbstractTable.inttable.addString(yytext());
						  Symbol ret = new Symbol(TokenConstants.INT_CONST);
						  ret.value = intvalue;
						  return ret;
          }
        case 83: break;
        case 6: 
          { return new Symbol(TokenConstants.COMMA);
          }
        case 84: break;
        case 39: 
          { AbstractSymbol lex_val = AbstractTable.idtable.addString(yytext());
						  Symbol ret = new Symbol(TokenConstants.ELSE);
						  ret.value = lex_val;
						  return ret;
          }
        case 85: break;
        case 11: 
          { return new Symbol(TokenConstants.DIV);
          }
        case 86: break;
        case 25: 
          { return new Symbol(TokenConstants.LT);
          }
        case 87: break;
        case 44: 
          { AbstractSymbol lex_val = AbstractTable.idtable.addString(yytext());
						  Symbol ret = new Symbol(TokenConstants.CLASS);
						  ret.value = lex_val;
						  return ret;
          }
        case 88: break;
        case 47: 
          { AbstractSymbol lex_val = AbstractTable.idtable.addString(yytext());
						  Symbol ret = new Symbol(TokenConstants.INHERITS);
						  ret.value = lex_val;
						  return ret;
          }
        case 89: break;
        case 28: 
          { AbstractSymbol lex_val = AbstractTable.idtable.addString(yytext());
						  Symbol ret = new Symbol(TokenConstants.FI);
						  ret.value = lex_val;
						  return ret;
          }
        case 90: break;
        case 1: 
          { /* This rule should be the very last
                     in your lexical specification and
                     will match match everything not
                     matched by other lexical rules. */
                     System.err.println(curr_lineno+ " LEXER BUG - UNMATCHED: " + yytext());
          }
        case 91: break;
        case 15: 
          { return new Symbol(TokenConstants.RPAREN);
          }
        case 92: break;
        case 46: 
          { AbstractSymbol lex_val = AbstractTable.idtable.addString(yytext());
						  Symbol ret = new Symbol(TokenConstants.ISVOID);
						  ret.value = lex_val;
						  return ret;
          }
        case 93: break;
        case 32: 
          { System.out.println("LINE Comment: \n  " + yytext());
						curr_lineno++;
          }
        case 94: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
              {     switch(yystate()) {
    case YYINITIAL:
	/* nothing special to do in the initial state */
	break;
	/*case YYEOF:
		if((yycharat(0) == '\"') && (yycharat(yytext().length()-1)!='\"')){
			String err_msg = new String("String can't have EOF");
			StringSymbol error = new StringSymbol(err_msg, err_msg.length(), 0);
			Symbol ret = new Symbol(TokenConstants.ERROR);
			ret.value = error;
			return ret;}
		else if((yycharat(0) == '(') && (yycharat(1) == '*')
					&& (yycharat(yytext().length()-1)!=')')
					&& (yycharat(yytext().length()-2)!='*')){
			String err_msg = new String("Comment can't have EOF");
			StringSymbol error = new StringSymbol(err_msg, err_msg.length(), 0);
			Symbol ret = new Symbol(TokenConstants.ERROR);
			ret.value = error;
			return ret;}	
	break;*/
	
	/* If necessary, add code for other states here, e.g:
	   case COMMENT:
	   ...
	   break;
	*/
    }
    return new Symbol(TokenConstants.EOF);
 }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
