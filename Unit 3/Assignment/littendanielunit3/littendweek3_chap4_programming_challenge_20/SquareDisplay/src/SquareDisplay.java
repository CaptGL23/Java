/*
    Daniel J. Litten II
    Southwestern College - Professional Studies
    CSCI 421 - Java Programming Principles I
    Mr. Russell Schoech
    February 26, 2022
*/

// Import Scanner
import java.util.Scanner;

/*
    This program will ask the user for a positive integer
    no greater than 15.  The program will then display a square
    on the screen using the character 'X'.  The number entered
    by the user will be the length of each side of the square.
*/

public class SquareDisplay
{
    public static void main(String[] args)
    {
        // Identifier declarations
        int colsAndRows;            // Holds user's input for rows and columns of square pattern
        char repeat;                // Holds 'y' or 'n'
        String input;               // Holds user input

        // Create Scanner object
        Scanner keyboard = new Scanner(System.in);

        // Prompt user and get input
        System.out.print("To make a square with 'X's please enter a " +
                        "positive integer from 0-15: ");
        colsAndRows = keyboard.nextInt();

        // Validate the user's input with a while loop
        while (colsAndRows < 0 || colsAndRows > 15)
        {
            System.out.print("Invalid input. Enter a positive integer " +
                            "in the range of 0 through 15: ");
            colsAndRows = keyboard.nextInt();
        }

        // Nested for loops to create square pattern based on input
        for (int r = 0; r < colsAndRows; r++)
        {
            for (int c = 0; c < colsAndRows; c++)
            {
                System.out.print("X");
            }
            System.out.println();
        }
    }
}
