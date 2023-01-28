package lexer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * TODO: Add description
 */
public class App {

    public static void main(String[] args) {
        String inputFileName = "";
        String outputFileName = "";

        if (args.length == 2) {
            inputFileName = args[0];
            outputFileName = args[1];
        } else {
            if (args.length == 1) {
                inputFileName = args[0];
                outputFileName = "output.txt";
            } else {
                inputFileName = "input.txt";
                outputFileName = "output.txt";
            }
        }

        try (BufferedReader reader = new BufferedReader(
            new FileReader(inputFileName)); BufferedWriter writer = new BufferedWriter(
            new FileWriter(outputFileName))) {
            String line = reader.readLine();

            while (line != null) {
                if (line.trim().equals("=")) {
                    break;
                }
                Parser parser = new Parser(line);
                Double result = parser.eval();
                String resultValue = "";
                if (result != null) {
                    resultValue = (result % 1) == 0 ? String.valueOf(result.intValue())
                                                    : String.valueOf(result);
                }
                String lineOut = (result == null) ? "Error" : parser.getStr() + " = " + resultValue;

                System.out.println(lineOut);
                writer.write(lineOut + "\n");

                // read next line
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
