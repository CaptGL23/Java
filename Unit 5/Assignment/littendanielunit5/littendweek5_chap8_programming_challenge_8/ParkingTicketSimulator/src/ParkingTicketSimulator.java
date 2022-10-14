/*
    Daniel J. Litten II
    Southwestern College - Professional Studies
    CSCI 421 - Java Programming Principles I
    Mr. Russell Schoech
    March 15, 2022
*/

/*
    This program demonstrates how the four other classes
    collaborate.
*/

import java.util.Scanner;

public class ParkingTicketSimulator
{
    public static void main(String[] args)
    {
        // Create a PoliceOfficer method
        PoliceOfficer litten = new PoliceOfficer("Daniel Litten", "0023");

        // Call the examineCars method from the PoliceOfficer Class
        litten.examineCars();
        // Call the printTickets method from the PoliceOfficer Class
        litten.printTickets();
    }
}
