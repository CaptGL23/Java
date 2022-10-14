/*
    Daniel J. Litten II
    Southwestern College - Professional Studies
    CSCI 421 - Java Programming Principles I
    Mr. Russell Schoech
    February 24, 2022
*/

// Needed for Scanner class
import java.util.Scanner;

/*
    This program will use nested loops to collect data and calculate the average
    rainfall over a period of years. First it will ask the user for the number of
    years. The outer loop will iterate once for each year and the inner loop will
    iterate 12 times, once for each month. Each iteration of the inner loop will
    ask the user for the inches of rainfall that month.  After all iterations, the
    program will display the number of months, total inches of rainfall, and the
    average rainfall per month for the entire period.  Ensure that a number less
    than 1 for the number of years is not accepted and do not accept negative numbers
    for the monthly rainfall.
*/

public class AverageRainfall

{
    public static void main(String[] args)
    {
        // Identifier Declarations
        int years;                      // Number of years
        final int MONTHS = 12;          // Constant for months in a year
        int totalMonths = 0;            // Accumulator variable for months
        double monthlyRain;             // rain in inches for each month
        double totalRainfall = 0;       // total amount of rainfall
        double avgRainfall;             // average rainfall

        // Create Scanner object
        Scanner keyboard = new Scanner(System.in);

        // Display prompt to ask user to enter the number of years
        System.out.println("Enter the number of years: ");
        years = keyboard.nextInt();

        // Display prompt to have user enter amount of rainfall in inches for each month
        System.out.println("Enter the rainfall amount for each month in inches ");

        // Nested for loops and switch statement for each month within each year entered by user
        for (int x = 0; x < years; x++)
        {
            for (int y = 1; y < MONTHS + 1; y++)
            {
                switch (y)
                {
                    case 1:
                        System.out.print("Jan: " );
                        break;
                    case 2:
                        System.out.print("Feb: ");
                        break;
                    case 3:
                        System.out.print("Mar: ");
                        break;
                    case 4:
                        System.out.print("Apr: ");
                        break;
                    case 5:
                        System.out.print("May: ");
                        break;
                    case 6:
                        System.out.print("Jun: ");
                        break;
                    case 7:
                        System.out.print("Jul: ");
                        break;
                    case 8:
                        System.out.print("Aug: ");
                        break;
                    case 9:
                        System.out.print("Sep: ");
                        break;
                    case 10:
                        System.out.print("Oct: ");
                        break;
                    case 11:
                        System.out.print("Nov: ");
                        break;
                    case 12:
                        System.out.print("Dec: ");
                        break;
                    default:
                        System.out.print("Invalid entry");
                        break;
                }
                monthlyRain = keyboard.nextDouble();    // User enters monthly rainfall
                totalRainfall += monthlyRain;           // total rainfall equals monthly rainfall entered, add each time
            }
            totalMonths += MONTHS;                      // Adds MONTHS to the accumulator variable totalMonths
        }
        avgRainfall = totalRainfall / totalMonths;      // Arithmetic calculation for average to get average rainfall

        // Displays a blank line between the last month of the switch statement and the next display
        System.out.println("");

        /*
            Displays the final output to the user, total months,
            total rainfall, and average rainfall for a period of years
        */
        System.out.println("Total Months: " + totalMonths + "\nTotal Rainfall: "
                            + totalRainfall + " inches" + "\nAverage Rainfall: "
                            + avgRainfall + " inches");
    }
}
