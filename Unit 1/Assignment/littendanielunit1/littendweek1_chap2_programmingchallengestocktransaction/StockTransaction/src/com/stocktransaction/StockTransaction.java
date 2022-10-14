/*
    Daniel J. Litten II
    Southwestern College - Professional Studies
    CSCI 421 - Java Programming Principles I
    Mr. Russell Schoech
    February 20, 0222
*/

package com.stocktransaction;

// This program is used to track and calculate stock transactions
public class StockTransaction
{
    public static void main(String[] args)
    {
        // Identifier Declarations
        final double sharesPurchased = 1000;    // Amount of shares purchased
        final double purchasePrice = 32.87;     // Price of shares purchased
        final double COMMISSION_RATE = 0.02;    // Commission rate constant
        final double sharesSold = 1000;         // Amount of shares sold
        final double soldPrice = 33.92;         // Prices of shares sold
        double stockPaid;                       // Cost paid to purchase stocks
        double purchaseCommission;              // Cost of commission on purchase
        double stockSold;                       // Amount made on sale of shares
        double soldCommission;                  // Cost of commission on sale
        double profitOrLoss;                    // Profit or loss after sale and commissions paid

        // Calculations for purchase transaction
        stockPaid = sharesPurchased * purchasePrice;         // Stores number of shares purchased times share price
        purchaseCommission = stockPaid * COMMISSION_RATE;    // Stores cost of purchase times commission rate

        // Calculations for sell trasaction
        stockSold = sharesSold * soldPrice;             // Stores number of shares sold times share price
        soldCommission = stockSold * COMMISSION_RATE;   // Stores amount made of sale times commission rate

        // Calculation for profit or loss after stock sale
        /*
            Stores amount made of sale minus (purchase price plus purchase commission paid
            plus sale commission paid) in the profit or loss variable
        */
        profitOrLoss = stockSold - (stockPaid + purchaseCommission + soldCommission);

        //Display output
        System.out.println("Purchased stock for:  $" + stockPaid);
        System.out.println("Commission paid to broker for purchase:  $" + purchaseCommission);
        System.out.println("Sold stock for:  $" + stockSold);
        System.out.println("Commission paid to broker for sale:  $" + soldCommission);
        System.out.println("Amount of profit or loss:  $" + profitOrLoss);
    }
}
