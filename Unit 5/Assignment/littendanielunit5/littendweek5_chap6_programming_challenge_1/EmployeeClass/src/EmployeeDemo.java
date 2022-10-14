/*
    Daniel J. Litten II
    Southwestern College - Professional Studies
    CSCI 421 - Java Programming Principles I
    Mr. Russell Schoech
    March 11, 2022
*/

/*
    This program demonstrates the Employee class's constructors, and
    accessor and mutator methods
*/

public class EmployeeDemo
{
    public static void main(String[] args)
    {
        // Creates three Employee objects to store the appropriate data
        Employee employee1 = new Employee("Susan Meyers", 47899,
                                            "Accounting", "Vice President");
        Employee employee2 = new Employee("Mark Jones", 39119,
                                            "IT", "Programmer");
        Employee employee3 = new Employee("Joy Rogers", 81774,
                                            "Manufacturing", "Engineer");

        //Displays data for employee number 1
        System.out.println("Employee 1 information:" +
                "\nName: "+ employee1.getName() +
                "\nID Number: " + employee1.getIdNumber() +
                "\nDepartment: " + employee1.getDepartment() +
                "\nPosition: " + employee1.getPosition());

        // Prints blank line
        System.out.println();

        //Displays data for employee number 2
        System.out.println("Employee 2 information:" +
                "\nName: "+ employee2.getName() +
                "\nID Number: " + employee2.getIdNumber() +
                "\nDepartment: " + employee2.getDepartment() +
                "\nPosition: " + employee2.getPosition());

        // Prints blank line
        System.out.println();

        //Displays data for employee number 3
        System.out.println("Employee 3 information:" +
                "\nName: "+ employee3.getName() +
                "\nID Number: " + employee3.getIdNumber() +
                "\nDepartment: " + employee3.getDepartment() +
                "\nPosition: " + employee3.getPosition());
    }


}
