/*
    Daniel J. Litten II
    Southwestern College - Professional Studies
    CSCI 431 - Java Programming Principles II
    Mr. Terrell Hebert
    April 15, 2022
*/

/*
    This program has a recursive function that accepts
    two arguments into the parameters x and y.  The function
    returns the value of x times y.
 */

import javax.swing.*;

public class RecursiveMultiplication
{
    public static void main(String[] args)
    {
        String xinput;          // Holds user's input for x
        String yinput;          // Holds user's input for y
        int num1;               // The value of x
        int num2;               // The value of y

        // Display and Prompt user input
        // Convert user input to int
        xinput = JOptionPane.showInputDialog("Enter the value of x: ");
        num1 = Integer.parseInt(xinput);
        yinput = JOptionPane.showInputDialog("Enter the value of y: ");
        num2 = Integer.parseInt(yinput);

        // Display the multiplication of x and y
        JOptionPane.showMessageDialog(null,
                num1
                        + " x "
                        + num2
                        + " = "
                        +  multiply(num1, num2));
    }

    /**
     * multiplicaiton method uses recursion to calculate
     * the value of x times the value of y
     * @param x The number input for x
     * @param y The number input for y
     * @return The multiple of x times y
     */
    public static int multiply(int x, int y)
    {
        if (y>0)
            return x + multiply(x, y-1);
        else
            return 0;
    }
}
