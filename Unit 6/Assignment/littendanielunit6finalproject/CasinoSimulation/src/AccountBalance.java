/*
    Daniel J. Litten II
    Southwestern College - Professional Studies
    CSCI 421 - Java Programming Principles I
    Mr. Russell Schoech
    March 18, 2022
*/

/*
    This class handles the account balance throughout
    the games that are played.
*/

public class AccountBalance
{
    private double balance;         // Account balance

    // Copy constructor if needed
    public AccountBalance(AccountBalance object2)
    {
        balance = object2.balance;
    }

    /**
     * This constructor sets the starting balance
     * at 0.0.
     */
    public AccountBalance()
    {
        balance = 0.0;
    }

    /**
     * This constructor sets the initial balance to the
     * value passed as an argument.
     * @param initialDeposit The initial deposit
     */
    public AccountBalance(double initialDeposit)
    {
        balance = initialDeposit;
    }

    /**
     * This constructor sets the initial balance to the
     * value in the String argument
     * @param str The initial deposit, as a String
     */
    public AccountBalance(String str)
    {
        balance = Double.parseDouble(str);
    }

    /**
     * The depositOrWin method makes a deposit
     * into the account
     * @param amount The amount to add to the balance field
     */
    public void depositOrWin(double amount)
    {
        balance += amount;
    }

    /**
     * The depositOrWin method makes a deposit
     * into the account
     * @param str The amount to add to the balance field, as a String
     */
    public void depositOrWin(String str)
    {
        balance += Double.parseDouble(str);
    }

    /**
     * The amountLoss method takes away an amount
     * from the account balance
     * @param amount The amount to subtract from the balance field
     */
    public void amountLoss(double amount)
    {
        balance -= amount;
    }

    /**
     * The amountLoss method takes away an amount
     * from the account balance
     * @param str The amount to subtract from the balance field, as a String
     */
    public void amountLoss(String str)
    {
        balance -= Double.parseDouble(str);
    }

    /**
     * setBalance method sets the account balance
     * @param b The value to store in the balance field
     */
    public void setBalance(double b)
    {
        balance = b;
    }

    /**
     * setBalance method sets the account balance
     * @param str The value to store in the balance field, as a String
     */
    public void setBalance(String str)
    {
        balance = Double.parseDouble(str);
    }

    public double getBalance()
    {
        return balance;
    }

    public String toString()
    {
        // Create a string to give the account balance
        String str = String.format("The account balance is: $%.2f", balance) ;

        // Return the string
        return str;
    }
}
