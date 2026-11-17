all: compile run clean

compile :
	javac -d bin hw1/homework1/*.java
run:
	java -cp bin hw1.homework1.Main
clean:
	rm bin/hw1/homework1/*.class
