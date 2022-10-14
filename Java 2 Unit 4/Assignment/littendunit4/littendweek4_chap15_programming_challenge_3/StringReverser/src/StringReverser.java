/*
    Daniel J. Litten II
    Southwestern College - Professional Studies
    CSCI 431 - Java Programming Principles II
    Mr. Terrell Hebert
    April 15, 2022
*/

/*
    This program has a recursive method that accepts a
    string as its argument and prints the string in
    reverse order.
 */


import javax.swing.*;

public class StringReverser
{
    public static void main(String[] args)
    {
        String input;
        char repeat;

        do
        {
            // Display and get user string input to be reversed
            input = JOptionPane.showInputDialog("Enter a string that you would like to be reversed:");

            String toReverse = input;           // String to reverse is the user input

            //
            reverse(toReverse, toReverse.length());

            // Display and ask user if they want to reverse another string
            input = JOptionPane.showInputDialog("Would you like to reverse another String?"
                    + "\nType y for YES or n for NO.");

            repeat = input.charAt(0);
        } while(repeat == 'Y' || repeat == 'y');

    }

    public static void reverse(String s, int len)
    {
        if (len > 0)
        {
            JOptionPane.showMessageDialog(null, s.charAt(len - 1));
            reverse(s, len - 1);
        }
        else
        {
            System.out.println();
        }
    }
}
