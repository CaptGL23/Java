/*
    Daniel J. Litten II
    Southwestern College - Professional Studies
    CSCI 421 - Java Programming Principles I
    Mr. Russell Schoech
    March 8, 2022
*/

/*
    This program will read the "USPopulation.txt" file's contents
    into an array.  It will then display the average change in
    population, the year with the greatest increase in population,
    and the year with the smallest increase in populations from
    1950-1990.
*/

import java.io.*;
import java.util.Scanner;

public class PopulationData
{
    public static void main(String[] args) throws IOException
    {
        // Calls the average change method to display
        averageChange();

        // Calls the greatest increase method to display
        greatestIncrease();

        // Calls the smallest increase method to display
        smallestIncrease();
    }

    // Create array from file and return that array
    public static int[] populationData() throws IOException
    {
        final int SIZE = 41;                    // Number of elements set for the array
        int [] population = new int[SIZE];      // Array to hold the population numbers from file
        int index = 0;                          // Loop control variable

        // Open the file
        File myfile = new File("USPopulation.txt");
        Scanner inputFile = new Scanner(myfile);

        // Read lines from the file until no more are left and put them into the array
        while (inputFile.hasNext() && index < population.length)
        {
            population[index] = inputFile.nextInt();
            index++;
        }

        inputFile.close();

        // Return the array created from the file
        return population;
    }

    // Get the average change in population
    public static void averageChange() throws IOException
    {
        int firstYear;              // Holds the first years population
        int lastYear;               // Holds the last years population

        // Sets the first and last year population to the declarations above
        firstYear = populationData()[0];
        lastYear = populationData()[40];

        // Finds the average change from all of the years
        double average = (double) (lastYear - firstYear) / populationData().length;

        // Displays the average change in population during the time period
        System.out.println("Average annual change of population from 1950 - 1990 = " + average);
    }

    // Get the year with the greatest increase in population
    public static void greatestIncrease() throws IOException
    {
        // Copy value of first and second year and subtract them
        int greatestChange = populationData()[1] - populationData()[0];

        //Sets the first year to 0 to be used in output and in the if statement
        int year = 0;

        // For loop to compare remaining differences between years
        for (int i = 1; i < populationData().length; i++)
        {
            int greatest = populationData()[i] - populationData()[i - 1];       // Holds the greatest change
            if (greatest > greatestChange)
            {
                greatestChange = greatest;
                year = i;
            }
        }
        // Outputs the greatest change year based on the value last held by the for loop
        System.out.println("The greatest increase in population was from year "
                            + (1950 + (year - 1)) + " to year "
                            + (1950 + year) + ": " + greatestChange);
    }

    // Get the year with the smallest increase in population
    public static void smallestIncrease() throws IOException
    {
        // Copy value of first and second year and subtract them
        int smallestChange = populationData()[1] - populationData()[0];

        //Sets the first year to 0 to be used in output and in the if statement
        int year = 0;

        // For loop to compare remaining differences between years
        for (int i = 1; i < populationData().length; i++)
        {
            int smallest = populationData()[i] - populationData()[i - 1];       // Holds the smallest change
            if (smallest < smallestChange)
            {
                smallestChange = smallest;
                year = i;
            }
        }
        // Outputs the smallest change year based on the value last held by the for loop
        System.out.println("The smallest increase in population was from year "
                            + (1950 + (year - 1)) + " to year "
                            + (1950 + year) + ": " + smallestChange);
    }
}
