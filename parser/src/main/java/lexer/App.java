package lexer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Main application class. File processing is done here.
 */
public class App {

	public static void main(String[] args) {
		String inputFileName = "";
		String outputFileName = "";

		// Validate input parameters
		if (args.length == 2) {
			inputFileName = args[0];
			outputFileName = args[1];
			System.out.println("Both file input parameters were given.");
			System.out.println("The following will be used:");
			System.out.println("Input filename: " + inputFileName);
			System.out.println("Output filename: " + outputFileName);
		} else {
			if (args.length == 1) {
				inputFileName = args[0];
				outputFileName = "output.txt";
				System.out.println("Only the file input parameter was given. Default output filename will be used.");
				System.out.println("The following will be used:");
				System.out.println("Input filename: " + inputFileName);
				System.out.println("Output filename: " + outputFileName);
			} else {
				inputFileName = "input.txt";
				outputFileName = "output.txt";
				System.out.println("No file input parameter were given. Default input/output filenames will be used.");
				System.out.println("Input filename: " + inputFileName);
				System.out.println("Output filename: " + outputFileName);
			}
		}
        // If running as a JUnit test, use the classloader to get the input file from the resources folder
        // Otherwise, use the file system to get the input file
		if (isJUnitTest()) {
			ClassLoader classLoader = App.class.getClassLoader();

			// Process input file from the test resources folder and create output file
			try (InputStream inputStream = classLoader.getResourceAsStream(inputFileName);
 				 InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
				 BufferedReader reader = new BufferedReader(streamReader);
				 BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
				processFile(reader, writer);
			} catch (FileNotFoundException e) {
				System.out.println("File not found: " + e.getMessage());
				System.out.println("Please check the input file name exists.");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
            try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName)); 
                 BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
                processFile(reader, writer);
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + e.getMessage());
                System.out.println("Please check the input file name exists.");
            } catch (IOException e) {
                e.printStackTrace();
            }
		}
	}

	/**
	 * @param reader
	 * @param writer
	 * @throws IOException
	 */
	private static void processFile(BufferedReader reader, BufferedWriter writer) throws IOException {
		String line = reader.readLine();

		while (line != null) {
			if (line.trim().equals("=")) {
				break;
			}
			Parser parser = new Parser(line);
			Double result = parser.eval();
			String resultValue = "";
			if (result != null) {
				resultValue = (result % 1) == 0 ? String.valueOf(result.intValue()) : String.valueOf(result);
			}
			String lineOut = (result == null) ? "Error" : parser.getStr() + " = " + resultValue;

			System.out.println(lineOut);
			writer.write(lineOut + "\n");

			// read next line
			line = reader.readLine();
		}
	}

	public static boolean isJUnitTest() {
		for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
			if (element.getClassName().startsWith("org.junit.")) {
				return true;
			}
		}
		return false;
	}
}
