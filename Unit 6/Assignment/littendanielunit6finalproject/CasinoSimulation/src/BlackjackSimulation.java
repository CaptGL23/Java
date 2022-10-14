/*
    Daniel J. Litten II
    Southwestern College - Professional Studies
    CSCI 421 - Java Programming Principles I
    Mr. Russell Schoech
    March 21, 2022
*/

/*
    This class holds everything needed to run and play
    the blackjack simulation
*/

// Needed for JOptionPane
import javax.swing.*;
// Needed to create own ArrayList
import java.util.ArrayList;

public class BlackjackSimulation
{
    // Create ArrayList object to hold all of the bets
    private final ArrayList<Integer> betList = new ArrayList<>();

    public void playBlackjack()
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

        do
        {
            final int DIE1_SIDES = 6;               // Number of sides for the player die 1
            final int DIE2_SIDES = 6;               // Number of sides for the player die 2
            final int DIE3_SIDES = 6;               // Number of sides for the computer die 1
            final int DIE4_SIDES = 6;               // Number of sides for the computer die 2
            int amountBet;                          // The amount the user bet
            int amountWon;                          // The amount the user won
            int computerRollTotal;                  // The computer's dice roll
            int playerRollTotal;                    // The player's dice roll
            int computerTotal = 0;                  // The computer's total
            int playerTotal = 0;                    // The player's total

            // Display balance
            JOptionPane.showMessageDialog(null, account.toString());

            // Check player's balance
            if (account.getBalance() < 20)
            {
                input = JOptionPane.showInputDialog("Please deposit more money into your account");
                account.depositOrWin(input);
            }

            // Ask player whether or not they want to roll the dice to get points
            input = JOptionPane.showInputDialog("Would you like to start a hand of Blackjack?" + "\nType Y for yes or N for no:");
            repeat = input.charAt(0);

            while (repeat == 'Y' || repeat == 'y')
            {
                // Ask player how much they want to enter into the slot machine
                input = JOptionPane.showInputDialog("How much would you like to bet on this hand of Blackjack?");
                amountBet = Integer.parseInt(input);
                account.amountLoss(amountBet);

                // Store amountBet into created ArrayList Class
                betList.add(amountBet);

                // Create four instances of the Die class
                Die die1 = new Die(DIE1_SIDES);
                Die die2 = new Die(DIE2_SIDES);
                Die die3 = new Die(DIE3_SIDES);
                Die die4 = new Die(DIE4_SIDES);

                // do...while loop to play the hand
                do
                {
                    // Roll the dice for the computer
                    die3.roll();
                    die4.roll();

                    // Roll the dice for the player
                    die1.roll();
                    die2.roll();

                    // Calculate computer's first roll total
                    computerRollTotal = die3.getValue() + die4.getValue();

                    // Calculate player's first roll total
                    playerRollTotal = die1.getValue() + die2.getValue();

                    // Display dice total to the player
                    JOptionPane.showMessageDialog(null,
                            "Your dice roll total is: " + playerRollTotal);

                    // Add to computer running total
                    computerTotal += computerRollTotal;

                    // Add to player running total
                    playerTotal += playerRollTotal;

                    // Display player running total
                    JOptionPane.showMessageDialog(null,
                            "Your total so far is: " + playerTotal);

                    // Ask player if they want to roll again to get more points
                    // if-else-if statement for if user total roll is < 21 ask to roll again
                    if (playerTotal < 21)
                    {
                        input = JOptionPane.showInputDialog("Would you like to roll the die again for a higher number?"
                                + "\nType roll to roll again or stay to end the hand.");
                        repeat = input.charAt(0);
                    }
                    else if (playerTotal > 21)
                    {
                        JOptionPane.showMessageDialog(null,
                                "You have went over 21 and have lost");
                        input = "bust";
                        repeat = input.charAt(0);
                    }
                } while (repeat == 'R' || repeat == 'r');

                // if statement to display computer total
                if (computerTotal > 21)
                {
                    JOptionPane.showMessageDialog(null,
                            "The dealer busted!!");
                }
                else
                {
                    JOptionPane.showMessageDialog(null,
                            "The dealer's score is: " + computerTotal + ".");
                }

                // if statement to display player total
                if (playerTotal > 21)
                {
                    JOptionPane.showMessageDialog(null,
                            "You have busted and you have lost.");
                }
                else
                {
                    JOptionPane.showMessageDialog(null,
                            "Your score is: " + playerTotal + ".");
                }

                /*
                    if-else-if statement to tell player they
                    won or lost and how much money they won or lost
                */
                if (computerTotal > 21 && playerTotal <= 21)
                {
                    JOptionPane.showMessageDialog(null,
                            "The dealer busted and you scored " + playerTotal + "!!"
                                    + "\nYou have won twice the amount of money that you bet!!");
                    amountWon = 2 * amountBet;
                    account.depositOrWin(amountWon);
                }
                else if (computerTotal < 21 && playerTotal < 21)
                {
                    if (playerTotal > computerTotal)
                    {
                        JOptionPane.showMessageDialog(null,
                                 "You scored: " + playerTotal
                                         + "\nThe dealer scored: " + computerTotal
                                         + "\nYou have won twice the amount of money that you bet!!");
                        amountWon = 2 * amountBet;
                        account.depositOrWin(amountWon);
                    }
                    else if (playerTotal < computerTotal)
                    {
                        JOptionPane.showMessageDialog(null,
                                "You scored: " + playerTotal + "."
                                        + "\nThe dealer scored: " + computerTotal + "."
                                        + "\nThe dealer has won and you have lost what you bet.");
                    }
                }
                else if (playerTotal == 21)
                {
                    JOptionPane.showMessageDialog(null,
                            "You scored: " + playerTotal + "."
                                    + "\nThe dealer scored: " + computerTotal + "."
                                    + "\nYou have won twice the amount of money that you bet!!");
                    amountWon = 2 * amountBet;
                    account.depositOrWin(amountWon);
                }
                else if (playerTotal > 21 && computerTotal > 21)
                {
                    JOptionPane.showMessageDialog(null,
                            "Both you and the dealer have busted."
                                    + "You have lost what you bet.");
                }
                else
                {
                    JOptionPane.showMessageDialog(null,
                            "You and the dealer have tied."
                                    + "\nYou get your money back.");
                    amountWon = amountBet;
                    account.depositOrWin(amountWon);
                }
            }

            // Ask user if they want to play again
            input = JOptionPane.showInputDialog("Would you like to play another game of Blackjack?"
                    + "\nType Y for yes or N for no:");
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
                String.format("Total amount that you bet on the Blackjack: $%.2f", totalAmountBet));

        // Display the account balance
        JOptionPane.showMessageDialog(null, account.toString());

        // Display the total amount won or lost
        double amountWonLost;                   // Holds the amount won or lost

        // Calculates amount won or lost
        amountWonLost = account.getBalance() - initialDeposit;

        // Displays the amount that was won or lost
        JOptionPane.showMessageDialog(null, String.format("Your total amount won or lost is: $%.2f", amountWonLost));

        // Return user to menu to select another game or exit
        JOptionPane.showMessageDialog(null, "You have chosen not to play another hand of " +
                "Blackjack. \nReturning you back to the Main Menu...");
    }
}
