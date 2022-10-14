/*
    Daniel J. Litten II
    Southwestern College - Professional Studies
    CSCI 421 - Java Programming Principles I
    Mr. Russell Schoech
    February 22, 2022
*/

// Needed for JOptionPane
import javax.swing.JOptionPane;

/*
    This program will ask the user for the number
    of checks written for the month then calculate and
    display the bank's service fees for the month.
*/

public class BankCharges
{
    public static void main(String[] args)
    {
        // Identifier Declarations
        final double BASE_FEE = 10;         // The bank's base fee
        double numberOfChecks;              // Number of checks for the month
        String input;                       // To hold the user's input
        double checkFees;                   // Fee based on how many checks for the month
        double totalFees;                   // Total fees owed for the month
        String output;                      // Output for totalFees to be formatted as a currency

        // Get the user's number of checks for the month and convert it to double
        input = JOptionPane.showInputDialog("How many checks were written for the month?");
        numberOfChecks = Double.parseDouble(input);

        /*
            Calculate fees based on number of checks
            and calculate total fee then display the
            bank's service fee for the month
        */

        if (numberOfChecks < 20)
        {
            checkFees = 0.10 * numberOfChecks;
            totalFees = BASE_FEE + checkFees;
            output = String.format("Your bank fees for the month are $%.2f.", totalFees);
            JOptionPane.showMessageDialog(null, output);
        }
        else if (numberOfChecks >= 20 && numberOfChecks <= 39)
        {
            checkFees = 0.08 * numberOfChecks;
            totalFees = BASE_FEE + checkFees;
            output = String.format("Your bank fees for the month are $%.2f.", totalFees);
            JOptionPane.showMessageDialog(null, output);
        }
        else if (numberOfChecks >= 40 && numberOfChecks <= 59)
        {
            checkFees = 0.06 * numberOfChecks;
            totalFees = BASE_FEE + checkFees;
            output = String.format("Your bank fees for the month are $%.2f.", totalFees);
            JOptionPane.showMessageDialog(null, output);
        }
        else if (numberOfChecks >= 60)
        {
            checkFees = 0.04 * numberOfChecks;
            totalFees = BASE_FEE + checkFees;
            output = String.format("Your bank fees for the month are $%.2f.", totalFees);
            JOptionPane.showMessageDialog(null, output);
        }
        else
        {
            JOptionPane.showMessageDialog(null,
                                    "Invalid entry, try again.");
        }
    }
}
