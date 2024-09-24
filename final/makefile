ANTLR = java -jar antlr-3.5.3-complete-no-st3.jar
JAVA = java
JAVAC = javac

all: generate compile run

generate:
	$(ANTLR) myCompiler.g

compile:
	$(JAVAC) -cp antlr-3.5.3-complete-no-st3.jar:. *.java

run:
	$(JAVA) -cp antlr-3.5.3-complete-no-st3.jar:. myCompiler_test test0.c > test0.ll
	$(JAVA) -cp antlr-3.5.3-complete-no-st3.jar:. myCompiler_test test1.c > test1.ll
	$(JAVA) -cp antlr-3.5.3-complete-no-st3.jar:. myCompiler_test test2.c > test2.ll
	$(JAVA) -cp antlr-3.5.3-complete-no-st3.jar:. myCompiler_test test3.c > test3.ll

clean:
	rm -f  *.class *.tokens