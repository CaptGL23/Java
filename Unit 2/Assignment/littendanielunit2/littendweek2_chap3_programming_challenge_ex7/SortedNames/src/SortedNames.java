/*
    Daniel J. Litten II
    Southwestern College - Professional Studies
    CSCI 421 - Java Programming Principles I
    Mr. Russell Schoech
    February 22, 2022
*/

// Needed for the Scanner class
import java.util.Scanner;

/*
    This program asks the user to input three names, then
    displays those three names sorted in ascending order
*/

public class SortedNames
{
    public static void main(String[] args)
    {
        // Identifier Declarations
        String name1;           // To hold name 1.
        String name2;           // To hold name 2.
        String name3;           // To hold name 3.

        // Scanner object to read from keyboard
        Scanner keyboard = new Scanner(System.in);

        // Display prompt for name 1 input
        System.out.print("Enter name number 1: ");
        name1 = keyboard.nextLine();

        // Display prompt for name 2 input
        System.out.print("Enter name number 2: ");
        name2 = keyboard.nextLine();

        // Display prompt for name 3 input
        System.out.print("Enter name number 3: ");
        name3 = keyboard.nextLine();

        // Determine what order to sort names and display them in ascending order
        if ((name1.compareToIgnoreCase(name2) < 0) && (name1.compareToIgnoreCase(name3) < 0))
        {
            System.out.println(name1);
            if (name2.compareToIgnoreCase(name3) < 0)
            {
                System.out.println(name2);
                System.out.println(name3);
            }
            else
            {
                System.out.println(name3);
                System.out.println(name2);
            }
        }
        else if ((name1.compareToIgnoreCase(name2) > 0) && (name2.compareToIgnoreCase(name3) < 0))
        {
            System.out.println(name2);
            if (name1.compareToIgnoreCase(name3) < 0)
            {
                System.out.println(name1);
                System.out.println(name3);
            }
            else
            {
                System.out.println(name3);
                System.out.println(name1);
            }
        }
        else
        {
            System.out.println(name3);
            if (name1.compareToIgnoreCase(name2) < 0)
            {
                System.out.println(name1);
                System.out.println(name2);
            }
            else
            {
                System.out.println(name2);
                System.out.println(name1);
            }
        }
    }
}
