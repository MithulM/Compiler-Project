JAVA=java
JAVAC=javac
JFLEX=$(JAVA) -jar ./resources/jflex-full-1.8.2.jar
CUPJAR=./resources/java-cup-11b.jar
CUP=$(JAVA) -jar $(CUPJAR)
CP=.:$(CUPJAR)

default: typeCheckingTests

.SUFFIXES: $(SUFFIXES) .class .java

.java.class:
	@$(JAVAC) -cp $(CP) $*.java

FILE=	Lexer.java parser.java \
	LexerRules.java TypeCheckingTest.java \
	Program.java Memberdecls.java Methoddecl.java Fielddecl.java Expr.java Stmt.java \
	Argdecl.java Name.java BinaryOp.java Token.java

typeCheckingTests: build
	@rm -f typeCheckingTestOutputs.txt
	@for f in ./testscases/*.as; do \
		echo "Output of file $$f" >> typeCheckingTestOutputs.txt; \
		$(JAVA) -cp $(CP) TypeCheckingTest $$f 2>&1 >> typeCheckingTestOutputs.txt; \
	done;
	@cat -n typeCheckingTestOutputs.txt


scannerTests: build
	@rm -f scannerTestOutputs.as;
	@for f in ./testscases/*.as; do \
		echo "Output of file $$f" >> scannerTestOutputs.txt; \
		$(JAVA) -cp $(CP) ScannerTest $$f >> scannerTestOutputs.txt; \
	done;
	@cat -n scannerTestOutputs.txt

build: Lexer.java parser.java $(FILE:java=class)

dump: Lexer.java parserD.java $(FILE:java=class)

clean:
	@rm -f *.~ *.class *.bak Lexer.java parser.java sym.java *.txt

Lexer.java: tokens.jflex
	@$(JFLEX) tokens.jflex

parser.java: grammar.cup
	@$(CUP) -interface < grammar.cup

parserD.java: grammar.cup
	@$(CUP) -interface -dump < grammar.cup


