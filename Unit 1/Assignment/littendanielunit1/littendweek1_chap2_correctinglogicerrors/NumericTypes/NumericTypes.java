/*
    Daniel J. Litten II
    Southwestern College - Professional Studies
    CSCI 421 - Java Programming Principles I
    Mr. Russell Schoech
    February 20, 0222
*/

// TASK #2 Add an import statement for the Scanner class
// TASK #2(Alternate)
// Add an import statement for the JOptionPane class

/*
   This program demonstrates how numeric types and
   operators behave in Java.
*/

public class NumericTypes
{
   public static void main (String [] args)
   {
      // TASK #2 Create a Scanner object here
      // (not used for alternate)

      // Identifier declarations
      final double NUMBER = 2 ;        // Number of scores. Data type was int.
      final double SCORE1 = 100;       // First test score. Data type was int.
      final double SCORE2 = 95;        // Second test score. Data type was int.
      final double BOILING_IN_F = 212; // Boiling temperature. Data type was int.
      double fToC;                     // Temperature Celsius. Data type was int.
      double average;               // Arithmetic average
      String output;                // Line of output

      // TASK #2 declare variables used here
      // TASK #3 declare variables used here
      // TASK #4 declare variables used here

      // Find an arithmetic average.
      average = (SCORE1 + SCORE2) / NUMBER;
      output = SCORE1 + " and " + SCORE2 +
               " have an average of " + average;
      System.out.println(output);

      // Convert Fahrenheit temperature to Celsius.
      fToC = (double) 5 / 9 * (BOILING_IN_F - 32);       //Added double cast operator to 5/9
      output = BOILING_IN_F + " in Fahrenheit is " +
               fToC + " in Celsius.";
      System.out.println(output);
      System.out.println();      // To leave a blank line

      // ADD LINES FOR TASK #2 HERE
      // Prompt the user for first name
      // Read the user's first name
      // Prompt the user for last name
      // Read the user's last name
      // Concatenate the user's first and last names
      // Print out the user's full name

      System.out.println();      // To leave a blank line

      // ADD LINES FOR TASK #3 HERE
      // Get the first character from the user's first name
      // Print out the user's first initial
      // Convert the user's full name to uppercase
      // Print out the user's full name in uppercase

      System.out.println();      // To leave a blank line

      // ADD LINES FOR TASK #4 HERE
      // Prompt the user for a diameter of a sphere
      // Read the diameter
      // Calculate the radius
      // Calculate the volume
      // Print out the volume
   }
}