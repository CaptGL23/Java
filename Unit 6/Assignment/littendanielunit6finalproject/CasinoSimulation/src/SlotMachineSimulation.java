/*
    Daniel J. Litten II
    Southwestern College - Professional Studies
    CSCI 421 - Java Programming Principles I
    Mr. Russell Schoech
    March 18, 2022
*/

/*
    This class holds everything needed to run and play
    the slot machine simulation.
*/

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class SlotMachineSimulation
{
    // Create ArrayList object to hold all of the bets
    private final ArrayList<Integer> betList = new ArrayList<>();

    public void playSlotMachine()
    {
        char repeat;                                // Holds the character to repeat do...while and while loops
        String input;                               // The user's input
        final int MIN_INITIAL_DEPOSIT = 20;         // The minimum initial deposit
        final int MAX_INITIAL_DEPOSIT = 1000;       // The maximum initial deposit
        double initialDeposit;                      // The user's initial deposit into the AccountBalance class

        /*
            Ask player to make an initial deposit between 20 and 1000
            Keep track of the players account balance through the game
            Starting with this value
         */

        // Get the initial deposit
        input = JOptionPane.showInputDialog("Please make an initial deposit between 20 and 1000.");
        initialDeposit = Double.parseDouble(input);

        // Validate the initial deposit entered
        while (initialDeposit < MIN_INITIAL_DEPOSIT || initialDeposit > MAX_INITIAL_DEPOSIT)
        {
            input = JOptionPane.showInputDialog("The initial deposit must be at least "
                    + MIN_INITIAL_DEPOSIT + " and no more than "
                    + MAX_INITIAL_DEPOSIT + ".\n Please make an initial deposit between 20 and 1000.");
            initialDeposit = Double.parseDouble(input);
        }

        // If initial deposit is valid, create a AccountBalance object
        AccountBalance account = new AccountBalance(input);

        // do...while loop to play the Slot Machine
        do {
            int number1;                            // The first random number
            int number2;                            // The second random number
            int number3;                            // The third random number
            String wordGenerated1 = null;           // The first word generated based on the random number
            String wordGenerated2 = null;           // The second word generated based on the random number
            String wordGenerated3 = null;           // The third word generated based on the random number

            int amountBet;                          // The amount the user bet
            int amountWon;                          // The amount the user won

            // Display balance
            JOptionPane.showMessageDialog(null, account.toString());

            // Check player's balance
            if (account.getBalance() < 20)
            {
                input = JOptionPane.showInputDialog("Please deposit more money into your account");
                account.depositOrWin(input);
            }

            // Ask player how much they want to enter into the slot machine
            input = JOptionPane.showInputDialog("How much would you like it enter into the Slot Machine?");
            amountBet = Integer.parseInt(input);
            account.amountLoss(amountBet);

            // Store amountBet into created ArrayList Class
            betList.add(amountBet);

            // Create a Random object
            Random randomNumbers = new Random();

            // Create a random integer and assign it to the number and
            // get a random number between 0 and 5
            number1 = randomNumbers.nextInt(5);
            number2 = randomNumbers.nextInt(5);
            number3 = randomNumbers.nextInt(5);

            // Switch statement to generate the first word for the slot machine
            switch (number1)
            {
                case 0:
                    wordGenerated1 = "Cherries";
                    break;
                case 1:
                    wordGenerated1 = "Oranges";
                    break;
                case 2:
                    wordGenerated1 = "Plums";
                    break;
                case 3:
                    wordGenerated1 = "Bells";
                    break;
                case 4:
                    wordGenerated1 = "Melons";
                    break;
                case 5:
                    wordGenerated1 = "Bars";
                    break;
            }

            // Switch statement to generate the second word for the slot machine
            switch (number2)
            {
                case 0:
                    wordGenerated2 = "Cherries";
                    break;
                case 1:
                    wordGenerated2 = "Oranges";
                    break;
                case 2:
                    wordGenerated2 = "Plums";
                    break;
                case 3:
                    wordGenerated2 = "Bells";
                    break;
                case 4:
                    wordGenerated2 = "Melons";
                    break;
                case 5:
                    wordGenerated2 = "Bars";
                    break;
            }

            // Switch statement to generate the third word for the slot machine
            switch (number3)
            {
                case 0:
                    wordGenerated3 = "Cherries";
                    break;
                case 1:
                    wordGenerated3 = "Oranges";
                    break;
                case 2:
                    wordGenerated3 = "Plums";
                    break;
                case 3:
                    wordGenerated3 = "Bells";
                    break;
                case 4:
                    wordGenerated3 = "Melons";
                    break;
                case 5:
                    wordGenerated3 = "Bars";
                    break;
            }

            // Displays all three words that were generated
            JOptionPane.showMessageDialog(null, wordGenerated1
                    + "\n" + wordGenerated2
                    + "\n" + wordGenerated3);

            // if-else-if statement to determine how much money is won or lost
            if (number1 != number2 && number1 != number3 && number2 != number3)
            {
                JOptionPane.showMessageDialog(null, "You have won $0.");
            }
            else if (number1 == number2)
            {
                JOptionPane.showMessageDialog(null, "You have won 2 times the amount of money you entered.");
                amountWon = 2 * amountBet;
                account.depositOrWin(amountWon);
            }
            else if (number1 == number3)
            {
                JOptionPane.showMessageDialog(null, "You have won 2 times the amount of money you entered.");
                amountWon = 2 * amountBet;
                account.depositOrWin(amountWon);
            }
            else if (number2 == number3)
            {
                JOptionPane.showMessageDialog(null, "You have won 2 times the amount of money you entered.");
                amountWon = 2 * amountBet;
                account.depositOrWin(amountWon);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "You have won 3 times the amount of money you entered.");
                amountWon = 3 * amountBet;
                account.depositOrWin(amountWon);
            }

            // Ask user if they want to play again
            input = JOptionPane.showInputDialog("Would you like to play the slot machine again?"
                    + "\nType Y for yes or N for no.");
            repeat = input.charAt(0);

        } while (repeat == 'Y' || repeat == 'y');

        // Display the total amount of money entered into the slot machine by the player
        double totalAmountBet = 0;                      // Accumulator
        // For loop to find sum of values in the betList ArrayList
        for (int i = 0; i < betList.size(); i++)
        {
            totalAmountBet += betList.get(i);
        }

        // Display total amount bet
        JOptionPane.showMessageDialog(null,
                String.format("Total amount that you bet on the Slot Machine: $%.2f", totalAmountBet));

        // Display the account balance
        JOptionPane.showMessageDialog(null, account.toString());

        // Display the total amount won or lost
        double amountWonLost;                   // Holds the amount won or lost

        // Calculates amount won or lost
        amountWonLost = account.getBalance() - initialDeposit;

        // Displays the amount that was won or lost
        JOptionPane.showMessageDialog(null, String.format("Your total amount won or lost is: $%.2f", amountWonLost));

        // Return user to menu to select another game or exit
        JOptionPane.showMessageDialog(null, "You have chosen not to play the Slot " +
                "Machine anymore. \nReturning you back to the Main Menu...");
    }
}
