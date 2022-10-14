/*
    Daniel J. Litten II
    Southwestern College - Professional Studies
    CSCI 421 - Java Programming Principles I
    Mr. Russell Schoech
    February 25, 2022
*/

// Needed for Scanner
import java.util.Scanner;

/*
    This program will ask the user to enter the amount that he
    or she has budgeted for a month.  A loop should then prompt
    the user to enter each of his or her expenses for the month,
    and keep a running total.  When the loop finishes, the program
    should display the amount that the user is over or under budget.
*/

public class BudgetAnalysis
{
    public static void main(String[] args)
    {
        // Identifier Declarations
        double monthsBudget;            // Holds the user's budget for the month
        double expenses;                // holds the user's entered expenses
        double totalExpenses = 0.0;     // Accumulator for the total expenses
        char repeat;                    // Holds 'y' or 'n'
        String input;                   // Holds the users input
        double overUnderBudget;         // Used to calculate expenses versus budget

        // Create Scanner object
        Scanner keyboard = new Scanner(System.in);

        // Prompt user to enter the budget for the month
        System.out.print("Enter your budget for the month: $");
        monthsBudget = keyboard.nextDouble();

        // Displays blank line for readability
        System.out.println("");

        // Prompt user to enter each expense
        System.out.println("Enter each expense below: ");

        /*
            Loop to prompt user to enter each expense for
            the month and keep a running total
        */
        do
        {
            // Get the expense
            System.out.print("Enter expense: $");
            expenses = keyboard.nextDouble();

            // Add expenses to totalExpenses accumulator
            totalExpenses += expenses;

            //Display running total after each iteration
            System.out.printf("Your total expenses for the month so far are: $%.2f.\n", totalExpenses);

            // Displays blank line for readability
            System.out.println("");

            // Ask user if they have another expense to enter
            System.out.println("Do you have any more expenses to enter " +
                                "for the month?");

            // Ask user to enter yes or no to determine if another iteration of loop needs to run
            System.out.print("Enter Y for yes or N for no: ");

            // Read the line that has the answer
            input = keyboard.next();

            // Get the first char
            repeat = input.charAt(0);

        } while (repeat == 'Y' || repeat == 'y');

        // Displays blank line for readability
        System.out.println("");

        // Display the total expenses
        System.out.printf("Your total expenses for the month is: $%.2f.\n", totalExpenses);

        // Calculate over or under budget
        overUnderBudget = monthsBudget - totalExpenses;

        // Display the amount that the user is over or under the budget
        if (totalExpenses > monthsBudget)
        {
            System.out.printf("The amount you spent over your budget is $%.2f.\n", overUnderBudget);
        }
        else if (totalExpenses < monthsBudget)
        {
            System.out.printf("The amount you spent under your budget is $%.2f.\n", overUnderBudget);
        }
        else
        {
            System.out.println("You spent your exact budget");
        }
    }
}
