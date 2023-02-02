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

## Output File Example
There will be an output file named `output.txt` (if no output parameter was given), 
at the same level as the input file with the following format:

```
121 - 21 = 100
Error
1 + 5 = 6
3 / 6 = 0.5
21 - 4 = 17
Error
2*2 = 4
```

# Assignment 1

## Description

The App.intersection method is used to compute the instersection of two arrays.
The method takes two arrays as parameters and returns an array containing the elements that are common to both arrays.
The method should not modify the original arrays and the method should return an empty array if there is no intersection.

## Usage

In order to use this application, you must first compile it. To do so, run the following command in the assignment directory:

```
mvn clean install
```

There will be a jar file in the target directory of the parser project. To run the application, run the following command:

```
java -jar assignment/target/assignment-1.0-SNAPSHOT-jar-with-dependencies.jar
```
## Output
The output of this exercise is:

```
nums1: [1, 2, 2, 1]
nums2: [2, 2]
Output: [2]
nums1: [4, 9, 5]
nums2: [9, 4, 9, 8, 4]
Output: [4, 9]
```
