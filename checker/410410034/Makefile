ANTLR = java -jar antlr-3.5.3-complete-no-st3.jar
JAVA = java
JAVAC = javac

all: generate compile run

generate:
	$(ANTLR) myChecker.g

compile:
	$(JAVAC) -cp antlr-3.5.3-complete-no-st3.jar:. *.java

run:
	$(JAVA) -cp antlr-3.5.3-complete-no-st3.jar:. myChecker_test test1.c
	$(JAVA) -cp antlr-3.5.3-complete-no-st3.jar:. myChecker_test test2.c
	$(JAVA) -cp antlr-3.5.3-complete-no-st3.jar:. myChecker_test test3.c

clean:
	rm -f  *.class *.tokens