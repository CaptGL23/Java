/*
    Daniel J. Litten II
    Southwestern College - Professional Studies
    CSCI 421 - Java Programming Principles I
    Mr. Russell Schoech
    February 23, 2022
*/

// Needed for Scanner

import java.io.*;
import java.util.Scanner;

/*
    This program will ask the user to enter a file name, then
    ask the user to enter a character.  The program will count
    then display the number of times that the specified
    character appears in the file.
*/

public class FileLetterCounter
{
    public static void main(String[] args) throws IOException
    {
        // Identifier Declarations
        String fileName;            // User's chosen File name
        String chosenCharacter;     // User's chosen character
        char character;             // stores chosen character
        String line;                // Store lines from the file for while and for loops
        int count = 0;              // counting variable for if statement

        // Scanner object to read from keyboard
        Scanner keyboard = new Scanner(System.in);

        // Display prompt and get input for file name
        System.out.print("Please enter a file name:  ");
        fileName = keyboard.nextLine();


        // Create file
        File file = new File(fileName + ".txt");

        // Scanner object to open the file
        Scanner fileInput = new Scanner(file);

        // Display prompt and get input for chosen character
        System.out.print("Please enter a character:  ");
        chosenCharacter = keyboard.nextLine();
        character = chosenCharacter.charAt(0);

        /*
            Create while loop and for loop with an if statement
            to determine how many times the chosen character
            appears in the file.
        */
        while (fileInput.hasNext())
        {
            line = fileInput.nextLine();
            for (int x = 0; x < line.length(); x++)
            {
                if (line.charAt(x) == character)
                {
                    count++;
                }
            }
        }

        // Show number of times the character appears in the file.
        System.out.println("The character " + character + " appears, in the file named " + fileName + ", " + count + " times.");

        // Close File
        fileInput.close();
    }
}
