/*
    Daniel J. Litten II
    Southwestern College - Professional Studies
    CSCI 421 - Java Programming Principles I
    Mr. Russell Schoech
    March 21, 2022
*/

/*
    This class gets the user's name and gives them
    a personalized welcome message.  It will then ask
    the user what game they would like to play.  Based
    on the user's selection, either 1 = Slot Machine,
    2 = Blackjack, or 3 (or anything else) = exit application.
*/

import javax.swing.*;

public class MainMenu
{
    public void theMainMenu()
    {
        String name;                // The user's name
        String input;               // The user's input
        int gameSelection;          // The user's game selection

        // Ask the player to enter their name
        name = JOptionPane.showInputDialog("What is your name?");

        // Display a personalized welcome message
        JOptionPane.showMessageDialog(null, "Hello " + name
                + ", Welcome to the Casino Simulation");

        // do...while loop to select what game to play
        do
        {
            // Display game menu to user: 1 = Slot Machine, 2 = Blackjack
            input = JOptionPane.showInputDialog("Which game would you like to play?"
                    + "\nType 1 to play the Slot Machine."
                    + "\nType 2 to play Blackjack."
                    + "\nType 3 to exit the Casino.");
            gameSelection = Integer.parseInt(input);

            // while loop for input validation
            while (gameSelection < 1 || gameSelection > 3)
            {
                input = JOptionPane.showInputDialog("Input must be either a 1, 2, or 3");
                gameSelection = Integer.parseInt(input);
            }

            // Create a SlotMachineSimulation object
            SlotMachineSimulation playSlots = new SlotMachineSimulation();

            // Create a BlackjackSimulation object
            BlackjackSimulation playBlackjack = new BlackjackSimulation();

            // if-else-if statement to play a game based on user's decision
            if (gameSelection == 1)
            {
                // Call the playSlotMachine method in the SlotMachineSimulation Class
                playSlots.playSlotMachine();
            }
            else if (gameSelection == 2)
            {
                // Call the playBlackJack method in the Blackjack Simulation Class
                playBlackjack.playBlackjack();
            }
            else
            {
                // Exit application with personalized message
                JOptionPane.showMessageDialog(null,
                        "THANK YOU FOR PLAYING, "
                                + name
                                + ",\nCOME BACK SOON");
            }
        } while (gameSelection == 1 || gameSelection == 2);
    }
}
