/*
    Daniel J. Litten II
    Southwestern College - Professional Studies
    CSCI 431 - Java Programming Principles II
    Mr. Terrell Hebert
    April 3, 2022
*/

/*
    This class demonstrates an object of the Customer
    class in a simple program.
 */

public class PersonCustomerDemo
{
    public static void main(String[] args)
    {
        // Create Customer object
        Customer c = new Customer();

        // Call Customer class and set the following values to them
        c.setCustomerNumber(1561);
        c.setName("John Smith");
        c.setAddress("316 South St.");
        c.setPhoneNumber("(555)631-1228");
        c.setMailing(true);

        // Display the toString method from the Customer class
        System.out.println(c);
    }
}
