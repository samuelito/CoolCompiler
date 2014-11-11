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
	
	NEWLINE = [\n]
	BLANKCHAR = (" "|\t|\r|\f|\v)
	WHITESPACE = {BLANKCHAR}+
	
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
	
	DIGIT = [0-9]
	INT = {DIGIT}+	
	LOWERCHAR = [a-z]
	UPPERCHAR = [A-Z]
	CHAR = ({LOWERCHAR}|{UPPERCHAR})
	ID = ({CHAR}|{DIGIT}|"_")
	TID = ({UPPERCHAR}{ID}*|"SELF_TYPE")
	OID = ({LOWERCHAR}{ID}*|"self")
	
	LINECMNT = "--"([^\n])*{NEWLINE}
	UNMATCH = "*)"

/* Define lexical rules after the %% separator.  Don't forget that:
   - Comments should be properly nested
   - Keywords are case-insensitive except for the values true and false,
     which must begin with a lower-case letter
   - String constants adhere to C syntax and may contain escape sequences:
     \c is accepted for all characters c; except for \n \t \b \f,
     the result is c.
   - The complete Cool lexical specification is given in the
     Cool Reference Manual */
     
%x STRING CONTINUE COMMENT
%%

<YYINITIAL> 

[\"] 		{
				string_buf.setLength(0);
				yybegin(STRING);
		    }
		    
"(*"		{
				/*System.out.println("#"+curr_lineno+ " Start Block Comment");*/
				yybegin(COMMENT);
			}
			
			
<STRING>{

[\"]		{	
			
			AbstractSymbol lex_val = AbstractTable.stringtable.addString(string_buf.toString());
		  	Symbol ret = new Symbol(TokenConstants.STR_CONST);
		   	ret.value = lex_val;
		   	string_buf.setLength(0);
		  	yybegin(YYINITIAL);
		    return ret;
		    }	    
		    
[\\][\0] 	{	++curr_lineno;
				String err_msg = new String("String contains null");
				StringSymbol error = new StringSymbol(err_msg, err_msg.length(), 0);
				Symbol ret = new Symbol(TokenConstants.ERROR);
				ret.value = error;
				return ret;
			}
[\n]		{	
				
				yybegin(YYINITIAL);
				String err_msg = new String("String Missing Close Quote");
				StringSymbol error = new StringSymbol(err_msg, err_msg.length(), 0);
				Symbol ret = new Symbol(TokenConstants.ERROR);
				ret.value = error;
				return ret;
			}
				
[\\]n		{   string_buf.append('\n'); }
[\\]b 		{	string_buf.append('\b'); }
[\\]f 		{	string_buf.append('\f'); }
[\\]t 		{	string_buf.append('\t'); }
[\\].		{	string_buf.append(yycharat(yytext().length()-1)); }
		
[\\][\n]	  { 	
				string_buf.append('\n');		  
				++curr_lineno;
				yybegin(STRING);
			}
						
[^\\\n\0\"]* {	
				if(yytext().length() > MAX_STR_CONST ){
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
	 
<<EOF>>		{
			    yybegin(YYINITIAL);
			    String err_msg = new String("String contains EOF");
				StringSymbol error = new StringSymbol(err_msg, err_msg.length(), 0);
				Symbol ret = new Symbol(TokenConstants.ERROR);
				ret.value = error;
				return ret;
			}
}
			
<CONTINUE>{
	[\"] 		{ yybegin(YYINITIAL);}
	[\\][\n]	{ ++curr_lineno;}
	[\n] 		{
					++curr_lineno;
					yybegin(YYINITIAL);
				}
	[\\].		{;}
	[^\"\\\n]* 	{;}	
}

<COMMENT>{
	 "*)" 	{	
				yybegin(YYINITIAL);
		   	}
	"(*"    {;}
	"("     {;}
	"*"		{;}
		   	  
	[\n]   	{    ++curr_lineno;    }
	
	[^*)\n\0]*  {;}
	
	<<EOF>>	{
			    yybegin(YYINITIAL);
			    String err_msg = new String("Comment contains EOF");
				StringSymbol error = new StringSymbol(err_msg, err_msg.length(), 0);
				Symbol ret = new Symbol(TokenConstants.ERROR);
				ret.value = error;
				return ret;
			}
}

{WHITESPACE} 	{;}

{NEWLINE}		{	curr_lineno++;}

{LINECMNT} 		{	/*System.out.println("#"+curr_lineno+ " " + yytext());*/
					curr_lineno++; }

{UNMATCH}		{	String err_msg = new String("Unmatched Comment Terminator: *) ");
					StringSymbol error = new StringSymbol(err_msg, err_msg.length(), 0);
					Symbol ret = new Symbol(TokenConstants.ERROR);
					ret.value = error;
					return ret;}
				
{INT}			{ 	AbstractSymbol intvalue = AbstractTable.inttable.addString(yytext());
		 	  		Symbol ret = new Symbol(TokenConstants.INT_CONST);
		   			ret.value = intvalue;
		   			return ret;}
						  	   
{TRUE}		 	{ 	
					Boolean boolvalue = true;
		 			Symbol ret = new Symbol(TokenConstants.BOOL_CONST);
		  			ret.value = boolvalue;
		  			return ret;}
		  
{FALSE}			{ 	
					
			  		Boolean boolvalue = false;
			  		Symbol ret = new Symbol(TokenConstants.BOOL_CONST);
		  			ret.value = boolvalue;
		  			return ret;}
					
{CLASS}			{ return new Symbol(TokenConstants.CLASS);}
{CASE} 			{ return new Symbol(TokenConstants.CASE);}
{ESAC} 			{ return new Symbol(TokenConstants.ESAC);}
{ELSE} 			{ return new Symbol(TokenConstants.ELSE);}
{POOL}  		{ return new Symbol(TokenConstants.POOL);}
{LOOP} 			{ return new Symbol(TokenConstants.LOOP);}
{LET} 			{ return new Symbol(TokenConstants.LET);}
{IF} 			{ return new Symbol(TokenConstants.IF);}
{FI} 			{ return new Symbol(TokenConstants.FI);}
{IN} 			{ return new Symbol(TokenConstants.IN);}
{OF} 			{ return new Symbol(TokenConstants.OF);}
{NEW}  			{ return new Symbol(TokenConstants.NEW);}
{NOT} 			{ return new Symbol(TokenConstants.NOT);}			  
{ISV} 			{ return new Symbol(TokenConstants.ISVOID);}				  
{INH} 			{ return new Symbol(TokenConstants.INHERITS);}						  
{THEN} 			{ return new Symbol(TokenConstants.THEN);}						 
{WHILE} 		{ return new Symbol(TokenConstants.WHILE);}
						  
{TID} 			{   AbstractSymbol lex_val = AbstractTable.idtable.addString(yytext());
		  			Symbol ret = new Symbol(TokenConstants.TYPEID);
		   			ret.value = lex_val;
		   			return ret;}
						  
{OID} 			{  AbstractSymbol lex_val = AbstractTable.idtable.addString(yytext());
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
                     System.out.println("#"+ curr_lineno+ " ERROR LEXER BUG - UNMATCHED: " + yytext()); 
                	
                }
