/*
    Daniel J. Litten II
    Southwestern College - Professional Studies
    CSCI 421 - Java Programming Principles I
    Mr. Russell Schoech
    March 11, 2022
*/

/*
    This class creates the constructors, and accessor
    and mutator methods needed for the EmployeeDemo
    class.
*/

public class Employee
{
    private String name;            // Holds the employee's name
    private int idNumber;           // Holds the employee's ID number
    private String department;      // Holds the employee's department name
    private String position;        // Holds the employee's job title

    /**
     * This Constructor accepts values as arguments and assigns them to
     * the appropriate fields
     * @param n The employee's name
     * @param id The employee's ID number
     * @param d The employee's department name
     * @param p The employee's job title
     */
    public Employee(String n, int id, String d, String p)
    {
        name = n;
        idNumber = id;
        department = d;
        position = p;
    }

    /**
     * This Constructor accepts the values as arguments and assigns them to
     * the appropriate fields.  The department nad position fields are
     * assigned an empty string
     * @param n The employee's name
     * @param id The employee's ID number
     */
    public Employee(String n, int id)
    {
        name = n;
        idNumber = id;
        department = "";
        position = "";
    }

    /**
     * no-arg constructor that assigns empty strings ("") to the name,
     * department, and position, and 0 to the idNumber field
     */
    public Employee()
    {
        name = "";
        idNumber = 0;
        department = "";
        position = "";
    }

    /**
     * setName method
     * @param n The employee's name
     */
    public void setName(String n)
    {
        name = n;
    }

    /**
     * setIdNumber method
     * @param id The employee's ID number
     */
    public void setIdNumber(int id)
    {
        idNumber = id;
    }

    /**
     * setDepartment method
     * @param d The employee's department name
     */
    public void setDepartment(String d)
    {
        department = d;
    }

    /**
     * setPosition method
     * @param p The employee's job title
     */
    public void setPosition(String p)
    {
        position = p;
    }

    /**
     * getName method
     * @return The employee's name
     */
    public String getName()
    {
        return name;
    }

    /**
     * getIdNumber method
     * @return The employee's ID number
     */
    public int getIdNumber()
    {
        return idNumber;
    }

    /**
     * getDepartment method
     * @return The employee's department name
     */
    public String getDepartment()
    {
        return department;
    }

    /**
     * getPosition method
     * @return The employee's job title
     */
    public String getPosition()
    {
        return position;
    }
}
