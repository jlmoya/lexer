package lexer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    @DisplayName("Should read input file and write output file when the input file name is given")
    void mainWhenInputFileNameIsGiven() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        String[] args = {"input.txt"};
        App.main(args);

        assertEquals(
            "Only the file input parameter was given. Default output filename will be used.\n"
            + "The following will be used:\n"
            + "Input filename: input.txt\n"
            + "Output filename: output.txt\n"
            + "121 - 21 = 100\n" 
            + "Error\n" 
            + "1 + 5 = 6\n" 
            + "3 / 6 = 0.5\n" 
            + "21 - 4 = 17\n"
            + "Error\n" 
            + "2*2 = 4\n", 
            outContent.toString()
        );
    }

    @Test
    @DisplayName("Should read input file and write output file when no argument is given")
    void mainWhenNoArgumentIsGiven() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        App.main(new String[]{});

        assertEquals(
            "No file input parameter were given. Default input/output filenames will be used.\n"
            + "Input filename: input.txt\n"
            + "Output filename: output.txt\n"
            + "121 - 21 = 100\n"
            + "Error\n"
            + "1 + 5 = 6\n"
            + "3 / 6 = 0.5\n"
            + "21 - 4 = 17\n"
            + "Error\n"
            + "2*2 = 4\n",
            outContent.toString()
        );
        System.setOut(System.out);
    }

    @Test
    @DisplayName("Should read input file and write output file when the input file name and output file name are given")
    void mainWhenInputFileNameAndOutputFileNameAreGiven() {
        String inputFileName = "input.txt";
        String outputFileName = "output.txt";
        String[] args = {inputFileName, outputFileName};

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        App.main(args);

        assertEquals(
            "Both file input parameters were given.\n"
            + "The following will be used:\n"
            + "Input filename: input.txt\n"
            + "Output filename: output.txt\n"
            + "121 - 21 = 100\n"
            + "Error\n"
            + "1 + 5 = 6\n"
            + "3 / 6 = 0.5\n"
            + "21 - 4 = 17\n"
            + "Error\n"
            + "2*2 = 4\n",
            outContent.toString()
);
    }
}
