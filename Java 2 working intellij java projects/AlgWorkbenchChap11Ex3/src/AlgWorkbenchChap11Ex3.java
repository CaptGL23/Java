/*
    Daniel J. Litten II
    Southwestern College - Professional Studies
    CSCI 431 - Java Programming Principles II
    Mr. Terrell Hebert
    April 12, 2022
*/

/*
    Algorithm Workbench Exercise 3
    Write a method that searches a numeric array for a specified value.
    The method should return the subscript of the element containing
    the value if it is found in the array.  If the value is not found,
    the method should throw an exception of the Exception class with
    the error message "Element not found".
 */

public class AlgWorkbenchChap11Ex3
{
    public static int arraySearch (int[] array, int value) throws Exception
    {
        int i;              // Loop control
        int element;        // Element the value is found at
        boolean found;      // Flag indicating search results

        // Element 0 is the starting point of the search
        i = 0;

        // Store the default values element and found
        element = -1;
        found = false;

        // Search the array
        while (!found && i < array.length)
        {
            if (array[i] == value)
            {
                found = true;
                element = i;
            }
            i++;
        }
        if (element == -1)
        {
            throw new Exception("Element not found.");
        }
        else
        {
            return element;
        }
    }
}
