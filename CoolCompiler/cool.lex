/*
 *  The scanner definition for COOL.
 */

import java_cup.runtime.Symbol;

%%

/*  Stuff enclosed in %{ %} is copied verbatim to the lexer class
 *  definition, all the extra variables/functions you want to use in the
 *  lexer actions should go here.  Don't remove or modify anything that
 *  was there initially.  */

%{
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
    
    
%}

/*  Stuff enclosed in %init{ %init} is copied verbatim to the lexer
 *  class constructor, all the extra initialization you want to do should
 *  go here.  Don't remove or modify anything that was there initially. */

%init{
    // empty for now
%init}

/*  Stuff enclosed in %eofval{ %eofval} specifies java code that is
 *  executed when end-of-file is reached.  If you use multiple lexical
 *  states and want to do something special if an EOF is encountered in
 *  one of those states, place your code in the switch statement.
 *  Ultimately, you should return the EOF symbol, or your lexer won't
 *  work.  */

%eofval{
    switch(yystate()) {
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
%eofval}

/* Do not modify the following two jlex directives */

%class CoolLexer
%cup

/* Define names for regular expressions here */
	
	DARROW = "=>"
	PERIOD = "."
	SEMICOLON = ";"
	COLON = ":" 
	COMMA = ","
	AT = "@"
	PLUS = "+"
	MINUS = "-"
	MULT = "*"
	DIV = "/"
	NEG = "~"
	LESS = "<"
	LEQ = "<="
	EQ = "="
	ASSIGN = "<-"
	LPAR = "("
	RPAR = ")"
	LB = "{"
	RB = "}"
	QUOTE = [\"]
	NEWLINE = [\n]
	BLANKCHAR = (" "|\t|\r|\f|\v)
	WHITESPACE = {BLANKCHAR}+
	/*OPERATIONS = ({PLUS}|{MINUS}|{MULT}|{DIV}|{NEG}|{LESS}|{LEQ}|{EQ})
	SYMBOLS = ({DARROW}|{ASSIGN}|{LPAR}|{RPAR}|{LB}|{RB})
	OTHERS = ({PERIOD}|{SEMICOLON}|{COLON}|{COMMA}|{AT}|{QUOTE})
	SPNO = ({OPERATIONS}|{OTHERS}|{SYMBOLS})*/
	DIGIT = [0-9]
	INT = {DIGIT}+	
	TRUE = ("t"[rR][uU][eE])
	FALSE = ("f"[aA][lL][sS][eE])
	CLASS = ([cC][lL][aA][sS][sS]) 
	CASE = ([cC][aA][sS][eE])
	ESAC = ([eE][sS][aA][cC])
	ELSE = ([eE][lL][sS][eE])
	POOL = ([pP][oO][oO][lL])
	LOOP = ([lL][oO][oO][pP])
	LET = ([lL][eE][tT])
	IF = ([iI][fF])
	FI = ([fF][iI])
	IN = ([iI][nN])
	OF = ([oO][fF])
	NEW = ([nN][eE][wW])
	NOT = ([nN][oO][tT])
	ISV = ([iI][sS][vV][oO][iI][dD])
	INH = ([iI][nN][hH][eE][rR][iI][tT][sS])
	THEN = ([tT][hH][eE][nN])
	WHILE = ([wW][hH][iI][lL][eE])
	LOWERCHAR = [a-z]
	UPPERCHAR = [A-Z]
	CHAR = ({LOWERCHAR}|{UPPERCHAR})
	WORD = ({CHAR}|{DIGIT}|"_")
	TID = ({UPPERCHAR}{WORD}*|"SELF_TYPE")
	OID = ({LOWERCHAR}{WORD}*|"self")
	
	/* TESTING 
	STRING = ({LINEDEF}|({LINEONE}{LINETWO}*{LINETHREE}))
	LINEONE = ({QUOTE}([^\"\0\n])*[\\\n])
	LINETWO = (([^\"\0\n])*([\\\n]|[\n]))
	LINETHREE = (([^\"\0\n])*{QUOTE})
	LINEDEF = ({QUOTE}([^\"\n\0])*{QUOTE})
	*/
	
	STRING = ({QUOTE}([^\"\n\0])*({QUOTE}|[\\\n]))
	DASHCMNT = "--"([^\n])*{NEWLINE}
	BLOCKCMNT = "(*"([^*)])*({CTERM}|[^\n])
	UNMATCH = {CTERM}
	CTERM = "*)"
	
	
	

/* Define lexical rules after the %% separator.  Don't forget that:
   - Comments should be properly nested
   - Keywords are case-insensitive except for the values true and false,
     which must begin with a lower-case letter
   - String constants adhere to C syntax and may contain escape sequences:
     \c is accepted for all characters c; except for \n \t \b \f,
     the result is c.
   - The complete Cool lexical specification is given in the
     Cool Reference Manual */

%%

<YYINITIAL>


{STRING}	{ /*TEST
			System.out.println("TOKEN "+yytext());
			System.out.println("LENGHT "+yytext().length());*/
			
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

/*
{STRERR} { 		String err_msg = new String("String can't have EOF");
					StringSymbol error = new StringSymbol(err_msg, err_msg.length(), 0);
					Symbol ret = new Symbol(TokenConstants.ERROR);
					ret.value = error;
					return ret;}*/
{WHITESPACE} {;}


{DASHCMNT} 		   {	System.out.println("LINE Comment: \n  " + yytext());
						curr_lineno++; }
{BLOCKCMNT}	       {	
					if(((yycharat(yytext().length()-1)) != ')')&&((yycharat(yytext().length()-2)) != '*')){
						String err_msg = new String("Comment can't end in EOF: " + yytext());
						StringSymbol error = new StringSymbol(err_msg, err_msg.length(), 0);
						Symbol ret = new Symbol(TokenConstants.ERROR);
						ret.value = error;
						return ret;}
					else{
						System.out.println("BLOCK Comment: \n  " + yytext());
						curr_lineno++;  }
					
					} 



{UNMATCH}			{	
						String err_msg = new String("Unmatched Comment Terminator: *) ");
						StringSymbol error = new StringSymbol(err_msg, err_msg.length(), 0);
						Symbol ret = new Symbol(TokenConstants.ERROR);
						ret.value = error;
						return ret;
					}
{NEWLINE}				{	curr_lineno++; }
{INT}					{ 
						  AbstractSymbol intvalue = AbstractTable.inttable.addString(yytext());
						  Symbol ret = new Symbol(TokenConstants.INT_CONST);
						  ret.value = intvalue;
						  return ret;
						}
{TRUE } 				{
						  AbstractSymbol boolvalue = AbstractTable.idtable.addString(yytext());
						  Symbol ret = new Symbol(TokenConstants.BOOL_CONST);
						  ret.value = boolvalue;
						  return ret;
						 }
{FALSE}					{
						  AbstractSymbol boolvalue = AbstractTable.idtable.addString(yytext());
						  Symbol ret = new Symbol(TokenConstants.BOOL_CONST);
						  ret.value = boolvalue;
						  return ret;
						 }
					
{CLASS}					{
						  AbstractSymbol lex_val = AbstractTable.idtable.addString(yytext());
						  Symbol ret = new Symbol(TokenConstants.CLASS);
						  ret.value = lex_val;
						  return ret;
						 }
{CASE} 				{
						  AbstractSymbol lex_val = AbstractTable.idtable.addString(yytext());
						  Symbol ret = new Symbol(TokenConstants.CASE);
						  ret.value = lex_val;
						  return ret;
						 }
{ESAC} 					{
						  AbstractSymbol lex_val = AbstractTable.idtable.addString(yytext());
						  Symbol ret = new Symbol(TokenConstants.ESAC);
						  ret.value = lex_val;
						  return ret;
						 }
{ELSE} {
						  AbstractSymbol lex_val = AbstractTable.idtable.addString(yytext());
						  Symbol ret = new Symbol(TokenConstants.ELSE);
						  ret.value = lex_val;
						  return ret;
						 }
{POOL}  {
						  AbstractSymbol lex_val = AbstractTable.idtable.addString(yytext());
						  Symbol ret = new Symbol(TokenConstants.POOL);
						  ret.value = lex_val;
						  return ret;
						 }
{LOOP} {
						  AbstractSymbol lex_val = AbstractTable.idtable.addString(yytext());
						  Symbol ret = new Symbol(TokenConstants.LOOP);
						  ret.value = lex_val;
						  return ret;
						 }
{LET} {
						  AbstractSymbol lex_val = AbstractTable.idtable.addString(yytext());
						  Symbol ret = new Symbol(TokenConstants.LET);
						  ret.value = lex_val;
						  return ret;
						 }
{IF} {
						  AbstractSymbol lex_val = AbstractTable.idtable.addString(yytext());
						  Symbol ret = new Symbol(TokenConstants.IF);
						  ret.value = lex_val;
						  return ret;
						 }
{FI} {
						  AbstractSymbol lex_val = AbstractTable.idtable.addString(yytext());
						  Symbol ret = new Symbol(TokenConstants.FI);
						  ret.value = lex_val;
						  return ret;
						 }
{IN}  {
						  AbstractSymbol lex_val = AbstractTable.idtable.addString(yytext());
						  Symbol ret = new Symbol(TokenConstants.IN);
						  ret.value = lex_val;
						  return ret;
						 }
{OF} {
						  AbstractSymbol lex_val = AbstractTable.idtable.addString(yytext());
						  Symbol ret = new Symbol(TokenConstants.OF);
						  ret.value = lex_val;
						  return ret;
						 }
{NEW}  {
						  AbstractSymbol lex_val = AbstractTable.idtable.addString(yytext());
						  Symbol ret = new Symbol(TokenConstants.NEW);
						  ret.value = lex_val;
						  return ret;
						 }
{NOT} {
						  AbstractSymbol lex_val = AbstractTable.idtable.addString(yytext());
						  Symbol ret = new Symbol(TokenConstants.NOT);
						  ret.value = lex_val;
						  return ret;}
						  
{ISV} {  AbstractSymbol lex_val = AbstractTable.idtable.addString(yytext());
						  Symbol ret = new Symbol(TokenConstants.ISVOID);
						  ret.value = lex_val;
						  return ret;}
						  
{INH} {  AbstractSymbol lex_val = AbstractTable.idtable.addString(yytext());
						  Symbol ret = new Symbol(TokenConstants.INHERITS);
						  ret.value = lex_val;
						  return ret; }
						  
{THEN} { AbstractSymbol lex_val = AbstractTable.idtable.addString(yytext());
						  Symbol ret = new Symbol(TokenConstants.THEN);
						  ret.value = lex_val;
						  return ret;}
						 
{WHILE} { AbstractSymbol lex_val = AbstractTable.idtable.addString(yytext());
						  Symbol ret = new Symbol(TokenConstants.WHILE);
						  ret.value = lex_val;
						  return ret;}
						 

			
{TID} 	{  AbstractSymbol lex_val = AbstractTable.idtable.addString(yytext());
						  Symbol ret = new Symbol(TokenConstants.TYPEID);
						  ret.value = lex_val;
						  return ret;}
						  
{OID} 	{  AbstractSymbol lex_val = AbstractTable.idtable.addString(yytext());
						  Symbol ret = new Symbol(TokenConstants.OBJECTID);
						  ret.value = lex_val;
						  return ret;}
						  
{DARROW}		{ return new Symbol(TokenConstants.DARROW);}
{EQ} 		    { return new Symbol(TokenConstants.EQ);}					  
{MULT} 			{ return new Symbol(TokenConstants.MULT);}					  
{PLUS} 			{ return new Symbol(TokenConstants.PLUS);}				  
{AT} 			{ return new Symbol(TokenConstants.AT);}
{COLON} 		{ return new Symbol(TokenConstants.COLON);}
{MINUS} 		{ return new Symbol(TokenConstants.MINUS);}
{SEMICOLON}	    { return new Symbol(TokenConstants.SEMI);}
{LB} 	 		{ return new Symbol(TokenConstants.LBRACE);}					
{COMMA}  		{ return new Symbol(TokenConstants.COMMA);}
{LPAR}  		{ return new Symbol(TokenConstants.LPAREN);}
{DIV}    		{ return new Symbol(TokenConstants.DIV);}
{RB} 	 		{ return new Symbol(TokenConstants.RBRACE);}
{RPAR}	 		{ return new Symbol(TokenConstants.RPAREN);}
{LEQ}	 		{ return new Symbol(TokenConstants.LT);}					
{ASSIGN} 		{ return new Symbol(TokenConstants.ASSIGN);}
{PERIOD} 		{ return new Symbol(TokenConstants.DOT);}
{NEG} 	 		{ return new Symbol(TokenConstants.NEG);}
{LESS} 	 		{ return new Symbol(TokenConstants.LE);}


.               { /* This rule should be the very last
                     in your lexical specification and
                     will match match everything not
                     matched by other lexical rules. */
                     System.err.println(curr_lineno+ " LEXER BUG - UNMATCHED: " + yytext()); 
                	
                }
