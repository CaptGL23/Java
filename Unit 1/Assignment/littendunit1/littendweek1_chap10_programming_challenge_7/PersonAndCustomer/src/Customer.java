/*
    Daniel J. Litten II
    Southwestern College - Professional Studies
    CSCI 431 - Java Programming Principles II
    Mr. Terrell Hebert
    April 3, 2022
*/

/*
    This class extends the Person class.  It has a field
    for a customer number and boolean field indicating
    whether the customer wishes to be on a mailing list.
    There are two constructors and the appropriate mutator
    and accessor methods for the class's fields.
 */

class Customer extends Person
{
    private int customerNumber;         // The customer's number
    private boolean mailing;            // The boolean field for mailing list

    // no-arg constructor
    public Customer()
    {

    }

    /**
     * Constructor
     * @param n The customer's number
     * @param m The boolean field for mailing list
     */
    public Customer(int n, boolean m)
    {
        customerNumber = n;
        mailing = m;
    }

    /**
     * setCustomerNumber method
     * @param n The customer's number
     */
    public void setCustomerNumber(int n)
    {
        customerNumber = n;
    }

    /**
     * setMailing method
     * @param m The boolean field for mailing list
     */
    public void setMailing(boolean m)
    {
        mailing = m;
    }

    /**
     * getMailing method
     * @return The boolean field for mailing list
     */
    public String getMailing()
    {
        String str;
        if(mailing==true)
            str = "yes";
        else
            str = "no";
        return str;
    }

    /**
     * toString method
     * @return The string
     */
    public String toString()
    {
        String str;             // The string

        str = "Name: "+getName()
                + "\nAddress: "+getAddress()
                + "\nPhone: "+ getPhoneNumber()
                + "\nCustomer Number: "+customerNumber
                + "\nMailing list: "+getMailing();

        return str;
    }
}
