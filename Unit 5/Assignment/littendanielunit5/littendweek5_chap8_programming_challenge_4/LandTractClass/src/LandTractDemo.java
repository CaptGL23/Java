/*
    Daniel J. Litten II
    Southwestern College - Professional Studies
    CSCI 421 - Java Programming Principles I
    Mr. Russell Schoech
    March 12, 2022
*/

/*
    This program will demonstrate the LandTract class.
    It will ask the user to enter the dimensions for
    the two tracts of land. The program displays the area
    of each tract of land and indicates whether the
    tracts are of equal size.
*/

// Imports Scanner Class
import java.util.Scanner;

public class LandTractDemo
{
    public static void main(String[] args)
    {
        double length;              // Holds length input
        double width;               // Holds width input

        // Create Scanner object
        Scanner keyboard = new Scanner(System.in);

        // Prompt and ask user for length and width of tract 1
        System.out.print("Enter the length of tract 1: ");
        length = keyboard.nextDouble();
        System.out.print("Enter the width of tract 1: ");
        width = keyboard.nextDouble();

        /*
            Create LandTract object from user input for tract 1 and display area
            by passing the object as an argument to println
         */
        LandTract tract1 = new LandTract(length, width);
        System.out.println(tract1);

        // Prompt and ask user for length and width of tract 2
        System.out.print("Enter the length of tract 2: ");
        length = keyboard.nextDouble();
        System.out.print("Enter the width of tract 2: ");
        width = keyboard.nextDouble();

        /*
            Create LandTract object from user input for tract 2 and display area
            by passing the object as an argument to println
         */
        LandTract tract2 = new LandTract(length, width);
        System.out.println(tract2);

        /*
            if-else statement to determine if area f the tracts are
            equal and display to user whether they are or not.
         */
        if (tract1.equals(tract2))
        {
            System.out.println("The tracts are equal to each other.");
        }
        else
        {
            System.out.println("The tracts are not equal to each other");
        }

    }
}
