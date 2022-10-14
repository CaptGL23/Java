/*
    Daniel J. Litten II
    Southwestern College - Professional Studies
    CSCI 421 - Java Programming Principles I
    Mr. Russell Schoech
    March 7, 2022
*/

/*
    This program takes test data and initializes an array with
    that test data.  The program has four methods to find the
    total value, average value, highest value, and lowest value
    of the test data in the initialized array.  It then displays
    those values.
*/

public class ArrayOperations
{
    //Main method
    public static void main(String[] args)
    {
        int[] testData = {10, 20, 30, 40, 50};      // Array initialized with test data
        int total;                                  // Holds the total value
        double average;                             // Holds the average value
        int highest;                                // Holds the highest value
        int lowest;                                 // Holds the lowest value

        // Calls the getTotal method which uses the testData array
        // Displays the total of all values in the testData array
        total = getTotal(testData);
        System.out.println("The Total of the test data = " + total);

        // Calls the getAverage method which uses the testData array
        // Displays the average of all values in the testData array
        average = getAverage(testData);
        System.out.println("The Average test = " + average);

        // Calls the getHighest method which uses the testData array
        // Displays the highest value in the testData array
        highest = getHighest(testData);
        System.out.println("The highest test data = " + highest);

        // Calls the getLowest method which uses the testData array
        // Displays the lowest value in the testData array
        lowest = getLowest(testData);
        System.out.println("The lowest test data = " + lowest);
    }

    // Method to accept a one-D array as its argument and return total of values in the array
    public static int getTotal(int[] array)
    {
        int total = 0;              // Accumulator

        // Enhanced for loop to find the total of the values in the array
        for (int val : array)
        {
            total += val;
        }

        // Returns the total of the values in the array
        return total;
    }

    // Method to accept a one-D array as its argument and return average of values in array
    public static double getAverage(int[] array)
    {
        int total = 0;              // Accumulator

        // Enhanced for loop to find the total of the values in the array
        for (int val : array)
        {
            total += val;
        }

        // Returns the average of the values in the array
        return (double)total/array.length;
    }

    // Method to accept a one-D array as its argument and return highest value in array
    public static int getHighest(int[] array)
    {
        int highest = array[0];             // Copy value in first array element to the variable highest

        /*
            For loop to compare remaining array element, beginning
            at subscript 1, to the value in highest. Each time there
            is a value found in the array greater than the highest variable,
            it is copied to the highest variable.  When the loop finishes,
            the highest variable contains the highest value in the array
        */
        for (int i = 1; i < array.length; i++)
        {
            if (array[i] > highest)
                highest = array[i];
        }

        // Returns the highest value in the array
        return highest;
    }

    // Method to accept a one-D array as its argument and return lowest value in array
    public static int getLowest(int[] array)
    {
        int lowest = array[0];             // Copy value in first array element to the variable lowest

        /*
            For loop to compare remaining array element, beginning
            at subscript 1, to the value in lowest. Each time there
            is a value found in the array less than the lowest variable,
            it is copied to the lowest variable.  When the loop finishes,
            the lowest variable contains the lowest value in the array
        */
        for (int i = 1; i < array.length; i++)
        {
            if (array[i] < lowest)
                lowest = array[i];
        }

        // Returns the lowest value in the array
        return lowest;
    }
}
