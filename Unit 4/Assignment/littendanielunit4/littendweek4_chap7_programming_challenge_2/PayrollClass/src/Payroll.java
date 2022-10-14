/*
    Daniel J. Litten II
    Southwestern College - Professional Studies
    CSCI 421 - Java Programming Principles I
    Mr. Russell Schoech
    March 5, 2022
*/

/*
    This class creates all of the arrays and methods needed
    for the class named PayrollClass.  It also relates the data
    in each array thought their subscripts so that the number in
    all element 0's go with each other when called.
*/

public class Payroll
{
    // Arrays for the methods below to use
    private final int[] employeeID = {5658845, 4520125, 7895122,
            8777541, 8451277, 1302850, 7580489};                // Array to hold employee ID
    private int[] hours = new int[employeeID.length];           // Array to hold number of hours worked
    private double[] payRate = new double[employeeID.length];   // Array to hold hourly pay rate
    private double[] wages = new double[employeeID.length];     // Array to hold employee's gross wages
    private final int noOfEmp = employeeID.length;              // Variable to hold number of employees

    // Displays employee ID based on its location in the array
    public void displayID()
    {
        for (int index = 0; index < employeeID.length; index++)
        {
            System.out.printf("Employee\t %d\tID \t%d\n",(index + 1), employeeID[index] );
        }
    }

    // Get number of employees
    public int getNOEmp()
    {
        return noOfEmp;
    }

    // Get employeeId
    public int getID(int index)
    {
        return employeeID[index];
    }

    // Get and Set Hours
    public int getHrs(int index)
    {
        return hours[index];
    }

    public void setHrs(int hourOfEmployee, int index)

    {
        hours[index] = hourOfEmployee;
    }

    // Get and Set payRate
    public double getPayRate(int index)
    {
        return payRate[index];
    }

    public void setPayRate(double payRateEmployee, int index)

    {
        payRate[index] = payRateEmployee;
    }

    // Get Wages
    public double getWages(int ID)
    {
        return hours[ID] * payRate[ID];
    }
}