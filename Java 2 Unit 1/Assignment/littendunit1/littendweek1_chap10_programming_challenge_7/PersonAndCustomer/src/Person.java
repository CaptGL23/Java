/*
    Daniel J. Litten II
    Southwestern College - Professional Studies
    CSCI 431 - Java Programming Principles II
    Mr. Terrell Hebert
    April 3, 2022
*/

/*
    This class has fields that hold a person's name, address,
    and phone number.  It has two constructors and the appropriate
    mutator and accessor methods for the class's fields.
 */

public class Person
{
    private String name;            // The person's name
    private String address;         // The person's address
    private String phoneNumber;     // The persons' phone number

    // no-arg constructor
    public Person()
    {

    }

    /**
     * Constructor
     * @param n The person's name
     * @param a The person's address
     * @param pN The persons' phone number
     */
    public Person(String n, String a, String pN)
    {
        name = n;
        address = a;
        phoneNumber = pN;
    }

    /**
     * setName method
     * @param n The person's name
     */
    public void setName(String n)
    {
        name = n;
    }

    /**
     *
     * @param a The person's address
     */
    public void setAddress(String a)
    {
        address = a;
    }

    /**
     * setPhoneNumber method
     * @param pN The persons' phone number
     */
    public void setPhoneNumber(String pN)
    {
        phoneNumber = pN;
    }

    /**
     * getName method
     * @return The person's name
     */
    public String getName()
    {
        return name;
    }

    /**
     * getAddress method
     * @return The person's address
     */
    public String getAddress()
    {
        return address;
    }

    /**
     * getPhoneNumber method
     * @return The persons' phone number
     */
    public String getPhoneNumber()
    {
        return phoneNumber;
    }
}
