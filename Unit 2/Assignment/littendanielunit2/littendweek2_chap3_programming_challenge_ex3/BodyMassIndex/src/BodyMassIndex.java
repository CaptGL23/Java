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
        This program calculates body mass index and
        displays if you are optimal weight, underweight
        or overweight
*/

public class BodyMassIndex
{
        public static void main(String[] args)

        {
                // Identifier declarations
                final double CONVERSION_FACTOR = 703;   // Conversion factor for BMI formula
                double weight;                          // Weight in pounds
                double height;                          // Height in inches
                double bodyMassIndex;                   // Body mass index value
                String input;                           // To hold the user's input

                // Get the user's weight and convert it to a double.
                input = JOptionPane.showInputDialog("What is your weight in pounds?");
                weight = Double.parseDouble(input);

                // Get the user's height and convert it to a double.
                input = JOptionPane.showInputDialog("What is your height in inches?");
                height = Double.parseDouble(input);

                // Perform body mass index calculation.
                bodyMassIndex = (weight * CONVERSION_FACTOR) / Math.pow(height, 2.0);

                // Based on body mass index calculation, determine and display optimal, under, or over weight
                if (bodyMassIndex < 18.5)
                {
                        JOptionPane.showMessageDialog(null,
                                                "Your BMI is " +
                                                        bodyMassIndex + " and you are underweight");
                }
                else if (bodyMassIndex >= 18.5 && bodyMassIndex <= 25)
                {
                        JOptionPane.showMessageDialog(null,
                                                "Your BMI is " +
                                                         bodyMassIndex + " and you are an optimal weight");
                }
                else if (bodyMassIndex > 25)
                {
                        JOptionPane.showMessageDialog(null,
                                                "Your BMI is " +
                                                        bodyMassIndex + " and you are overweight");
                }
                else
                {
                        JOptionPane.showMessageDialog(null,
                                                "We cannot calculate your BMI, please try again");
                }
        }
}
