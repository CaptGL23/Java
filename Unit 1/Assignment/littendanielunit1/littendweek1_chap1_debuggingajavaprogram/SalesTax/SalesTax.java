/*
    Daniel J. Litten II
    Southwestern College - Professional Studies
    CSCI 421 - Java Programming Principles I
    Mr. Russell Schoech
    February 19, 0222
*/

import java.util.Scanner;  // Needed for the Scanner class

/*
   This program calculates the total price which includes
   sales tax.
*/

public class SalesTax
{
   public static void main(String[] args)
   {
      // Identifier declarations
      final double TAX_RATE = 0.055;   // Tax rate constant
      double price;                    // Price of item
      double tax;                      // Tax of the item
      double total;                    // Total price of the item
      String item;                     // Name of item

      // Create a Scanner object to read from the keyboard.
      Scanner keyboard = new Scanner(System.in);

      // Display prompts and get input.
      System.out.print("Item description:  ");
      item = keyboard.nextLine();
      System.out.print("Item price:  $");
      price = keyboard.nextDouble();

      // Perform the calculations.
      tax = price * TAX_RATE;       // Stores the value of the price times the tax rate in the tax variable
      total = price + tax;          // Stores the value of the price plus the tax in the total variable

      // Display the results.
      System.out.print(item + "        $");
      System.out.println(price);
      System.out.print("Tax          $");
      System.out.println(tax);
      System.out.print("Total        $");
      System.out.println(total);
   }
}
