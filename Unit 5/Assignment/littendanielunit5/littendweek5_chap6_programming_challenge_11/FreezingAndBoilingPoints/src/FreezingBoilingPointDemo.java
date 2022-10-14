/*
    Daniel J. Litten II
    Southwestern College - Professional Studies
    CSCI 421 - Java Programming Principles I
    Mr. Russell Schoech
    March 11, 2022
*/

/*
    This program demonstrates the FreezingBoilingPoint class.
    The user is asked to enter a temperature, then a list of
    substances that will freeze at that temperature and those
    that will boil at that temperature.
*/

import java.util.Scanner;

public class FreezingBoilingPointDemo
{
    public static void main(String[] args)
    {
        double temp;                    // Holds the user input for temperature

        // Create a FreezingBoilingPoint object
        FreezingBoilingPoint userTemp = new FreezingBoilingPoint();

        // Create Scanner object to read from keyboard
        Scanner keyboard = new Scanner(System.in);

        // Get user to enter a temperature
        System.out.print("Please enter a temperature: ");
        temp = keyboard.nextDouble();

        // Set the temperature of the FreezingBoilingPoint object
        userTemp.setTemperature(temp);

        // Display list of substances that will freeze and boil at that temperature
        String result = "at " + temp + " degrees Fahrenheit:\n";

        // if-else-if statement to determine if ethyl will freeze or boil at the input temp
        if (userTemp.ISETHYLFREEZING())
        {
            result += "\nEthyl will freeze";
        }
        else if (userTemp.ISETHYLBOILING())
        {
            result += "\nEthyl will boil";
        }

        // if-else-if statement to determine if oxygen will freeze or boil at the input temp
        if (userTemp.ISOXYGENFREEZING())
        {
            result += "\nOxygen will freeze";
        }
        else if (userTemp.ISOXYGENBOILING())
        {
            result += "\nOxygen will boil";
        }

        // if-else-if statement to determine if water will freeze or boil at the input temp
        if (userTemp.ISWARERFREEZING())
        {
            result += "\nWater will freeze";
        }
        else if (userTemp.ISWATERBOILING())
        {
            result += "\nWater will boil";
        }

        // Display the result
        System.out.println("The following will boil or freeze " + result);
    }
}
