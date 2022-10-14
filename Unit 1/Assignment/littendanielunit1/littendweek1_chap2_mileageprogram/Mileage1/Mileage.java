/*
    Daniel J. Litten II
    Southwestern College - Professional Studies
    CSCI 421 - Java Programming Principles I
    Mr. Russell Schoech
    February 20, 0222
*/

// Scanner class
import java.util.Scanner;

// This program will calculate mileage
public class Mileage

{
    public static void main(String[] args)
    {
        //add your declaration and code here

        // Identifier declarations
        double miles;           // How many miles driven
        double gallons;         // How many gallons were used
        double mpg;             // Stores the value of miles per gallon

        // Scanner object to read from keyboard
        Scanner keyboard = new Scanner(System.in);

        // Display prompts and get input.
        System.out.print("Miles driven:    ");
        miles = keyboard.nextDouble();
        System.out.print("Gallons used:    ");
        gallons = keyboard.nextDouble();

        // Perform the calculation of miles per gallons.
        mpg = miles / gallons;

        // Display results
        System.out.println(miles + " Miles driven");
        System.out.println(gallons + " Gallons used");
        System.out.println(mpg + " Miles per gallon");
    }
}