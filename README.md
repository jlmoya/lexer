# Lexer Project

This is a Lexical Recognition Parser of the recursive descent type. It supports the following features:

- Addition
- Subtraction
- Multiplication
- Division

## Usage

In order to use this parser, you must first compile it. To do so, run the following command in the parser directory:

```
mvn clean install
```

There will be a jar file in the target directory of the parser project. To run the parser, run the following command:

```
java -jar parser/target/parser-1.0-SNAPSHOT-jar-with-dependencies.jar inputFilename.txt outputFilename.txt
```

If no parameters are passed, the input file will be input.txt and the output file will be output.txt.

## Input File Example
```
121 - 21
a plus b
1 + 5
3 / 6
21 - 4
6 ; 1
2*2
=
```

The equals sign is used to denote the end of the input file and immediate termination of the parser.

