#######################################
# Edit this!
# Set CLASSDIR to the location of the cool package.
#   e.g. the makefile needs to access ${CLASSDIR}/bin
CLASSDIR= /home/samuelfeliciano/cool
#######################################

ASSN = 3J
CLASS= cs164
LIB= -L/usr/sww/lib -lfl -R/usr/sww/lib
AR= gar
ARCHIVE_NEW= -cr
RANLIB= gar -qs

SRC= cool.cup good.cl bad.cl README
CSRC= \
	AbstractSymbol.java \
	AbstractTable.java \
	BoolConst.java \
	CgenClassTable.java \
	CgenNode.java \
	CgenSupport.java \
	ClassTable.java \
	CoolTokenLexer.java \
	Flags.java \
	IdSymbol.java \
	IdTable.java \
	IntSymbol.java \
	IntTable.java \
	ListNode.java \
	Parser.java \
	StringSymbol.java \
	StringTable.java \
	SymbolTable.java \
	TreeConstants.java \
	TreeNode.java \
	Utilities.java \
	cool-tree.java
# TSRC= myparser mycoolc cool-tree.aps ref-parser
TSRC= myparser cool-tree.aps ref-parser
CGEN= CoolParser.java TokenConstants.java
# LIBS= lexer semant cgen
LIBS= lexer semant
CFIL= ${CSRC} ${CGEN}
HFIL= cool-tree.h cool-tree.handcode.h 
LSRC= Makefile
CLS= ${CFIL:.java=.class}
OUTPUT= good.output bad.output

JAVAC := javac
CUP := java_cup

CUPCLASSPATH := ${CLASSDIR}/lib

# rt.jar again ..
CLASSPATH := ${CUPCLASSPATH}:.:/usr/java/lib/rt.jar

default: source parser

source: ${SRC} ${TSRC} ${LSRC} ${LIBS} ${CSRC}

${OUTPUT}:	parser good.cl bad.cl
	@rm -f ${OUTPUT}
	./myparser good.cl >good.output 2>&1 
	-./myparser bad.cl >bad.output 2>&1 

parser: Makefile ${CLS}
	@rm -f parser
	echo '#!/bin/sh' >> parser
	echo 'java -classpath ${CLASSPATH}:`dirname $$0` Parser $$*' >> parser
	chmod 755 parser

CoolParser.java TokenConstants.java: cool.cup
	${CUP} -parser CoolParser -symbols TokenConstants -expect 10000 -dump -nopositions < $< >cool.output 2>&1 || { egrep '^Error at ' cool.output; false; }


dotest:	parser good.cl bad.cl
	@echo "\nRunning parser on good.cl\n"
	-./myparser good.cl 
	@echo "\nRunning parser on bad.cl\n"
	-./myparser bad.cl

## cool-tree.class is not a real class file, but we need to have it
## for dependency tracking
${CLS}: ${CFIL}
	${JAVAC} -g -nowarn -classpath ${CLASSPATH} ${CFIL}
	touch cool-tree.class

${LIBS}:
	ln -s ${CLASSDIR}/bin/reference-$@ $@
#sg: just symlink to the architecture independant refernce-* shell scripts

#	${CLASSDIR}/etc/link-object ${ASSN} $@

# These dependencies allow you to get the starting files for
# the assignment.  They will not overwrite a file you already have.

${SRC} :								
	-${CLASSDIR}/etc/copy-skel ${ASSN} ${SRC}

${LSRC} :
	-${CLASSDIR}/etc/link-shared ${ASSN} ${LSRC}

${TSRC} ${CSRC}:
	-ln -s ${CLASSDIR}/src/PA${ASSN}/$@ $@

${HSRC}:
	-ln -s ${CLASSDIR}/include/PA${ASSN}/$@ $@

submit-clean: ${OUTPUT}
	-rm -f cool.output *.s core *.class *~ ${CGEN} parser 

clean:
	-rm -f cool.output *.s core *.class *~ ${CGEN} parser ${OUTPUT}







