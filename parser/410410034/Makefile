ANTLR = java -jar antlr-3.5.3-complete-no-st3.jar
JAVA = java
JAVAC = javac

all: generate compile run

generate:
	$(ANTLR) myparser.g

compile:
	$(JAVAC) -cp antlr-3.5.3-complete-no-st3.jar:. *.java

run:
	$(JAVA) -cp antlr-3.5.3-complete-no-st3.jar:. testParser test.c
	$(JAVA) -cp antlr-3.5.3-complete-no-st3.jar:. testParser test2.c
	$(JAVA) -cp antlr-3.5.3-complete-no-st3.jar:. testParser test3.c

clean:
	rm -f *.java *.class