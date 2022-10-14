/*
    Daniel J. Litten II
    Southwestern College - Professional Studies
    CSCI 421 - Java Programming Principles I
    Mr. Russell Schoech
    February 25, 2022
*/

// Needed for Scanner Class
import java.util.Scanner;

// Needed for file input/output
import java.io.*;

/*
    This program asks the user for the names of two files.  The first
    file should be opened for reading and the second file should be
    opened for writing.  The program should read the contents of the
    first file, change all characters to uppercase, and store the results
    in the second file.  The second file will be a copy of the first file,
    except that all the characters will be in uppercase.  Use Notepad or
    another text editor to create a simple file that can be used to test
    the program.
*/

public class UppercaseFileConverter
{
    public static void main(String[] args) throws IOException
    {

        // Identifier Variables
        String firstFileName;       // Holds the first files name
        String secondFileName;      // Holds the second files name

        // Create Scanner object for user input
        Scanner keyboard = new Scanner(System.in);

        // Prompt user to enter first file name
        System.out.print("Enter the first files name you want to read from: ");
        firstFileName = keyboard.nextLine();

        // Prompt user to enter second file name
        System.out.print("Enter the second files name you want to write to: ");
        secondFileName = keyboard.nextLine();

        // Open first file
        File file = new File(firstFileName + ".txt");
        Scanner inputFile = new Scanner(file);

        // Read first file
        String line = inputFile.nextLine();

        //Display the content of the first file
        System.out.print("The content held in the first file is as follows: ");
        System.out.println(line);

        // Convert contents of first file to uppercase
        String upperCase = line.toUpperCase();

        // Open second file
        PrintWriter outputFile = new PrintWriter(secondFileName + ".txt");

        // Write to second file
        outputFile.println(upperCase);

        // Close the second file
        outputFile.close();

        // Display the data as been written to file
        System.out.println("Your data from the first file has been " +
                            "converted to uppercase and written to the second file.");

        // Close the first file
        inputFile.close();
    }
}
