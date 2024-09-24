ANTLR = java -jar antlr-3.5.3-complete-no-st3.jar
JAVA = java
JAVAC = javac

all: generate compile run

generate:
	$(ANTLR) mylexer.g

compile:
	$(JAVAC) -cp antlr-3.5.3-complete-no-st3.jar:. *.java

run:
	$(JAVA) -cp antlr-3.5.3-complete-no-st3.jar:. testLexer sample.c
	$(JAVA) -cp antlr-3.5.3-complete-no-st3.jar:. testLexer sample2.c
	$(JAVA) -cp antlr-3.5.3-complete-no-st3.jar:. testLexer sample3.c

clean:
	rm -f *.java *.class