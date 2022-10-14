/*
    Daniel J. Litten II
    Southwestern College - Professional Studies
    CSCI 421 - Java Programming Principles I
    Mr. Russell Schoech
    March 11, 2022
*/

/*
    This program demonstrates the Area class.
*/

public class AreaDemo
{
    public static void main(String[] args)
    {
        double radius = 6;              // Sets radius variable to 6
        double width = 7;               // Sets width variable to 7
        double length = 8;              // Sets length variable to 8
        double height = 9;              // Sets height variable to 9

        // Displays that the following areas are to be calculated with the variables
        System.out.println("Area of a circle, rectangle, and cylinder: ");

        // Calls the proper Areas method from the Area class and displays the output
        System.out.println("A Circle with a radius of "
                + radius + " has an area of "
                + Area.Areas(radius));

        // Calls the proper Areas method from the Area class and displays the output
        System.out.println("A rectangle with a width of "
                + width + " and a length of "
                + length + " has an area of "
                + Area.Areas(width, length));

        // Calls the proper Areas method from the Area class and displays the output
        System.out.println("A cylinder with a radius of "
                + radius + " and a height of "
                + height + " has an area of "
                + Area.Areas(0, radius, height));
    }
}
