/*
    Daniel J. Litten II
    Southwestern College - Professional Studies
    CSCI 421 - Java Programming Principles I
    Mr. Russell Schoech
    March 2, 2022
*/

// Needed for the Scanner class
import java.util.Scanner;

/*
   You must complete this program so that it calculates
   and displays the area of a rectangle. When finished,
   the program will ask the user to enter the length and
   width of the rectangle. then display the rectangle's
   area.
*/

public class AreaRectangle
{
   public static void main(String[] args)
   {
      double length,    // The rectangle's length
             width,     // The rectangle's width
             area;      // The rectangle's area
   
      // Get the rectangle's length from the user.
      length = getLength();
   
      // Get the rectangle's width from the user.
      width = getWidth();

      // Get the rectangle's area.
      area = getArea(length, width);

      // Display the rectangle data.
      displayData(length, width, area);
   }

   /*
      This method asks the user to enter the rectangle's
      length, and then return that value as a double.
    */
   public static double getLength()
   {
      double length;       // Holds users input for length

      // Create Scanner object
      Scanner keyboard = new Scanner(System.in);

      // Prompt user to get length of rectangle
      System.out.println("Enter the length of the rectangle: ");
      length = keyboard.nextDouble();

      return length;
   }

   /*
      This method asks the user to enter the rectangle's
      width, and then return that value as a double.
   */
   public static double getWidth()
   {
      double width;       // Holds users input for width

      // Create Scanner object
      Scanner keyboard = new Scanner(System.in);

      // Prompt user to get length of rectangle
      System.out.println("Enter the width of the rectangle: ");
      width = keyboard.nextDouble();

      return width;
   }

   /*
      This method should accept the rectangle's length
      and width arguments, and return the rectangle's area.
      The area is calculated by multiplying the length by
      the width.
   */
   public static double getArea(double length, double width)
   {
      return length * width;
   }

   /*
      This method should accept the rectangle's length,
      width, and area as arguments, and display them in
      an appropriate message on the screen.
   */
   public static void displayData(double length, double width, double area)
   {
      System.out.println("Length = " + length);
      System.out.println("Width = " + width);
      System.out.println("Area = " + area);
   }
}

