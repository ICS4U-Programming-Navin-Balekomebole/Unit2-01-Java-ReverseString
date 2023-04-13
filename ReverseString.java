import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
* The program will reverse the string.
*
* @author  Navin Balekomebole
* @version 1.0
* @since   2023-04-13
*/

public final class ReverseString {
    /**
    * For the style checker.
    *
    * @exception IllegalStateException Utility class.
    * @see IllegalStateException
    */
    private ReverseString() {
        throw new IllegalStateException("Utility class");
    }

    /**
    * Print the  messages.
    *
    * @param args Unused
    */
    public static void main(String[] args) {
        // In this section of the code, it will declare lists.
        final ArrayList<String> inputList = new ArrayList<String>();

        try {
            // In here, it will choose a file to get input from.
            final File input = new File("input.txt");
            final Scanner scanInput = new Scanner(input);

            // create a file to print the output of the string.
            final FileWriter output = new FileWriter("output.txt");

            // the Loop is used to read the line of the input file.
            while (scanInput.hasNextLine()) {
                // Add the next line.
                inputList.add(scanInput.nextLine());
            }

            // Create an array with all elements in the input list.
            final String[] inputArr = new String[inputList.size()];
            for (int location = 0; location < inputArr.length; location++) {
                inputArr[location] = inputList.get(location);
            }

            // here is the Loop to send each line to function.
            for (String strLine : inputArr) {
                // Call function.
                final String reversed = reverse(strLine);

                // Print to the console and file.
                System.out.println(reversed);
                output.write(reversed + "\n");
            }

            // Close the writer.
            output.close();

        } catch (IOException err) {
            // For when no input file is found.
            System.err.println("Error: " + err.getMessage());
        }
    }

    /**
    * This function will generate marks for each assignment.
    *
    * @param line from file
    * @return reversed line
    */
    public static String reverse(String line) {
        // Detect if the line is empty.
        if (line.isEmpty()) {
            return line;
        } else {
            // Re-call the function with all characters but the first.
            return reverse(line.substring(1)) + line.charAt(0);
        }
    }
}
