/*
    Daniel J. Litten II
    Southwestern College - Professional Studies
    CSCI 421 - Java Programming Principles I
    Mr. Russell Schoech
    March 5, 2022
*/

// Needed for Scanner Class
import java.util.Scanner;

/*
    This program will display each employee number and ask
    the user to enter that employee's hours and pay rate.
    It will then display each employee's ID number and gross
    wages.

    It calls methods from another class named Payroll.
*/
public class PayrollClass
{
    public static void main(String[] args)
    {
        int hoursOfEmp;                         // Holds user input for employee hours worked
        double empPayRate;                      // Holds user input for employee hourly pay rate

        // Create a Payroll object to get employee ID from Class Payroll
        Payroll employee = new Payroll();

        // Uses Payroll object to call method for getting employee ID
        employee.displayID();

        // Create scanner object for keyboard input
        Scanner keyboard = new Scanner(System.in);

        // For loop to prompt and get hours worked and hourly pay rate for 7 iterations
        for (int i = 0; i < employee.getNOEmp(); i++)
        {
            // Prompt user for input of hours worked
            System.out.print("Please enter the employee " + (i + 1) + " hours:  ");
            hoursOfEmp=keyboard.nextInt();

            // While loop to validate user input of hours is not a negative integer
            while (hoursOfEmp < 0)
            {
                System.out.print("Please enter the valid employee " + (i + 1) + " hours:  ");
                hoursOfEmp=keyboard.nextInt();
            }
            // Calls setHrs method from Class Payroll and sets users input
            employee.setHrs(hoursOfEmp,i);

            // Prompt user for input of hourly pay rate
            System.out.print("Please enter the employee " + (i + 1) + " pay rate:  $");
            empPayRate=keyboard.nextDouble();

            // While loop to validate user input of hourly pay rate is not less than 6
            while (empPayRate < 6.00)
            {
                System.out.print("Please enter the valid employee " + (i + 1) + " pay rate:  $");
                empPayRate=keyboard.nextInt();
            }
            // Calls setPayRate method from Class Payroll and sets users input
            employee.setPayRate(empPayRate, i);
        }
        // For loop that iterates 7 times and displays out put of employees number and their gross wages
        for (int i = 0; i < employee.getNOEmp(); i++)
        {
            System.out.printf("Gross wage for employee " + (i + 1) + " with ID number "
                                + employee.getID(i) + " is: $%.2f.\n", employee.getWages(i));
        }
    }
}