/*
    Daniel J. Litten II
    Southwestern College - Professional Studies
    CSCI 421 - Java Programming Principles I
    Mr. Russell Schoech
    February 22, 2022
*/

// Needed for JOptionPane
import javax.swing.JOptionPane;

/*
    This program will ask the user to enter the number
    of books that he or she has purchased this month
    and then displays the number of points awarded
*/

public class BookClubPoints

{
    public static void main(String[] args)
    {
        // Identifier Declaration
        int booksPurchased;         // How many books were purchased
        String input;               // Holds the user's input

        // Gets the user's number of books purchased and converts it to int
        input = JOptionPane.showInputDialog("How many books did you purchase this month?");
        booksPurchased = Integer.parseInt(input);

        // If-else-if statement to determine how many points to be awarded
        if (booksPurchased == 0)
        {
            JOptionPane.showMessageDialog(null, "You earned 0 points.");
        }
        else if (booksPurchased == 1)
        {
            JOptionPane.showMessageDialog(null, "You earned 5 points.");
        }
        else if (booksPurchased == 2)
        {
            JOptionPane.showMessageDialog(null, "You earned 15 points.");
        }
        else if (booksPurchased == 3)
        {
            JOptionPane.showMessageDialog(null, "You earned 30 points.");
        }
        else if (booksPurchased >= 4)
        {
            JOptionPane.showMessageDialog(null, "You earned 60 points.");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Invalid input");
        }
    }
}
