/*
    Daniel J. Litten II
    Southwestern College - Professional Studies
    CSCI 421 - Java Programming Principles I
    Mr. Russell Schoech
    March 2, 2022
*/

// Needed for Scanner Class
import java.util.Scanner;

/*
    This program will allow the user to input different
    values for the formula's terms.  There will be a method
    names presentValue that performs the Present Value
    calculation which is;

    P = F/(1 + r)to the n power

    The method should accept the future value, annual interest
    rate, and number of years as arguments.  It should return the
    present value, which is the amount that you need to
    deposit today.
*/

public class PresentValue
{
    public static void main(String[] args)
    {
        //
        double futureValue;         // Holds future value variable
        double interestRate;        // Holds interest rate variable
        double years;               // Holds number of years variable

        // Creates Scanner Object
        Scanner keyboard = new Scanner(System.in);

        // Prompts user to enter future value and applies to variable
        System.out.println("Enter your Future Value: ");
        futureValue = keyboard.nextDouble();

        // Prompts user to enter interest rate and applies to variable
        System.out.println("Enter the Interest Rate: ");
        interestRate = keyboard.nextDouble();

        // Prompts user to enter number of years and applies to variable
        System.out.println("Enter the Number of Years");
        years = keyboard.nextDouble();

        /*
            Calls the presentValue method and prints it for the user to see
            what they must deposit today
        */
        System.out.printf("The amount you need to deposit today\n" +
                        "to reach your future value is: $%.2f",
                        presentValue(futureValue, interestRate, years));
    }

    /*
        This method will perform the present value calculation.
        It accepts the future value, annual interest rate, and
        number of years as arguments.
    */
    public static double presentValue(double futureValue, double interestRate, double years)
    {
        return futureValue / Math.pow((1 + interestRate), years);
    }
}
