JAVA=java
JAVAC=javac
JFLEX=$(JAVA) -jar ./jflex-full-1.8.2.jar
CUPJAR=./java-cup-11b.jar
CUP=$(JAVA) -jar $(CUPJAR)
CP=.:$(CUPJAR)

default: all

.SUFFIXES: $(SUFFIXES) .class .java

.java.class:
	$(JAVAC) -cp $(CP) $*.java

FILE=	Lexer.java parser.java sym.java \
	LexerRules.java ScannerTest.java \
	Program.java Expr.java Stmt.java \
	Name.java BinaryOp.java Token.java

all: scannerTests

scannerTests: build
	@rm -f scannerTestOutputs.txt;
	@for f in ./*.txt; do \
		echo "Processing file $$f"; \
		echo "\\*_____ $$f _____*\\" >> scannerTestOutputs.txt; \
		$(JAVA) -cp $(CP) ScannerTest $$f >> scannerTestOutputs.txt; \
	done;
	@cat -n scannerTestOutputs.txt

lexerTests: build
	@rm -f lexerTestOutputs.txt;
	@for f in ./*; do \
		echo "Processing file $$f"; \
		echo "\\*_____ $$f _____*\\" >> lexerTestOutputs.txt; \
		$(JAVA) -cp $(CP) LexerRules $$f >> lexerTestOutputs.txt; \
	done;
	@cat -n lexerTestOutputs.txt

build: Lexer.java parser.java $(FILE:java=class)

dump: Lexer.java parserD.java $(FILE:java=class)

clean:
	rm -f *.class *.bak Lexer.java parser.java sym.java *.txt

Lexer.java: tokens.jflex
	$(JFLEX) tokens.jflex

parser.java: grammar.cup
	$(CUP) -interface < grammar.cup

parserD.java: grammar.cup
	$(CUP) -interface -dump < grammar.cup


