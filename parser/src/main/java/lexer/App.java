package lexer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * TODO: Add description
 */
public class App {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line = reader.readLine();

            while (line !=  null) {
                if (line.trim().equals("=")) {
                    break;
                }
                Parser parser = new Parser(line);
                System.out.println(parser.eval() == null ? "Error" : parser.getStr() + " = " + parser.eval());

                // read next line
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
