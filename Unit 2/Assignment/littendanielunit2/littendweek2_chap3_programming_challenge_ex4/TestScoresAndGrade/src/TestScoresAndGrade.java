/*
    Daniel J. Litten II
    Southwestern College - Professional Studies
    CSCI 421 - Java Programming Principles I
    Mr. Russell Schoech
    February 22, 2022
*/


//Needed for JOptionPane
import javax.swing.JOptionPane;

/*
    This program asks the user to enter 3 numeric test scores.
    After the three scores have been entered, the user can
    then have the average and letter grade displayed to them.
*/

public class TestScoresAndGrade
{
    public static void main(String[] args)
    {
        // Identifier declarations
        double score1;      // Test score number 1
        double score2;      // Test score number 2
        double score3;      // Test score number 3
        String input;       // Holds the user's input
        double average;     // Average score value

        // Get test score number 1 and convert it to a double
        input = JOptionPane.showInputDialog("Enter the first numeric test score:");
        score1 = Double.parseDouble(input);

        // Get test score number 2 and convert it to a double
        input = JOptionPane.showInputDialog("Enter the second numeric test score:");
        score2 = Double.parseDouble(input);

        // Get test score number 3 and convert it to a double
        input = JOptionPane.showInputDialog("Enter the third numeric test score:");
        score3 = Double.parseDouble(input);

        // Calculate average score
        average = (score1 + score2 + score3) / 3;

        // Display the average grade of the three test scores and letter grade
        if (average < 60)
        {
            JOptionPane.showMessageDialog(null,
                                        "Your average score is "
                                                + average + " and your grade is an F");
        }
        else if (average < 70)
        {
            JOptionPane.showMessageDialog(null,
                                        "Your average score is "
                                                + average + " and your grade is a D");
        }
        else if (average < 80)
        {
            JOptionPane.showMessageDialog(null,
                                        "Your average score is "
                                                + average + " and your grade is a C");
        }
        else if (average < 90)
        {
            JOptionPane.showMessageDialog(null,
                    "Your average score is "
                            + average + " and your grade is a B");
        }
        else if (average <= 100)
        {
            JOptionPane.showMessageDialog(null,
                    "Your average score is "
                            + average + " and your grade is an A");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Your score is invalid.");
        }
    }
}
