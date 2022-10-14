/*
    Daniel J. Litten II
    Southwestern College - Professional Studies
    CSCI 421 - Java Programming Principles I
    Mr. Russell Schoech
    March 15, 2022
*/

/*
    This class simulates a parking meter.  This class is
    responsible to know the number of minutes of parking time
    that has been purchased
*/

public class ParkingMeter
{
    private int paidParking;                // The amount of time paid for parking

    // Copy constructor
    public ParkingMeter(ParkingMeter object2)
    {
        this.paidParking = object2.getPaidParking();
    }

    /**
     * This constructor accepts the value as an argument
     * and assigns it to the appropriate field
     * @param paid The amount of time paid for parking
     */
    public ParkingMeter(int paid)
    {
        this.paidParking = paid;
    }

    /**
     * setPaidParking method
     * @param paidParking The amount of time paid for parking
     */
    public void setPaidParking(int paidParking)
    {
        this.paidParking = paidParking;
    }

    /**
     * getPaidParking method
     * @return The amount of time paid for parking
     */
    public int getPaidParking()
    {
        return paidParking;
    }

    // toString method for the ParkingTicket class
    public String toString()
    {
        return "\nParking Meter:\nMinutes paid to park: " + paidParking;
    }
}
