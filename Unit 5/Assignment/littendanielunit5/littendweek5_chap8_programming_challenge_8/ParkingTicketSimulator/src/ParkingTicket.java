/*
    Daniel J. Litten II
    Southwestern College - Professional Studies
    CSCI 421 - Java Programming Principles I
    Mr. Russell Schoech
    March 15, 2022
*/

/*
    This class simulates a parking ticket.  It is responsible
    for reporting the make, model, color, and license number of
    the illegally parked car.  It is also responsible for reporting
    the amount of the fine.  It is also responsible for reporting the
    name and badge number of the police office issuing the ticket.
*/

// Import the DecimalFormat Class
import java.text.DecimalFormat;

public class ParkingTicket
{
    private ParkedCar illegallyParkedCar;           // The illegally parked car's information
    private ParkingMeter meterUsed;                 // The parking meter's information
    private String officerName;                     // The officer's name
    private String officerBadge;                    // The officer's badge number
    private double fine;                            // The fine

    // Copy constructor
    public ParkingTicket(ParkingTicket object2)
    {
        this.illegallyParkedCar = new ParkedCar(object2.getIllegallyParkedCar());
        this.meterUsed = new ParkingMeter(object2.getMeterUsed());
    }

    /**
     * This constructor accepts values as arguments and assigns
     * them to the appropriate fields
     * @param illPark The illegally parked car's information
     * @param meter The parking meter's information
     * @param offNam The officer's name
     * @param offBad The officer's badge number
     */
    public ParkingTicket(ParkedCar illPark, ParkingMeter meter, String offNam, String offBad)
    {
        this.illegallyParkedCar = new ParkedCar(illPark);
        this.meterUsed = new ParkingMeter(meter);
        this.officerName = offNam;
        this.officerBadge = offBad;
        this.fine = calculateFine();
    }

    /**
     * setIllegallyParkedCar method
     * @param illPark The illegally parked car's information
     */
    public void setIllegallyParkedCar(ParkedCar illPark)
    {
        this.illegallyParkedCar = illPark;
    }

    /**
     * setMeterUsed method
     * @param meter The parking meter's information
     */
    public void setMeterUsed (ParkingMeter meter)
    {
        this.meterUsed = meter;
    }

    /**
     * setFine method
     * @param fine The fine
     */
    public void setFine(double fine)
    {
        this.fine = fine;
    }

    /**
     * getIllegallyParkedCar method from the ParkedCar Class
     * @return The illegally parked car's information
     */
    public ParkedCar getIllegallyParkedCar()
    {
        return illegallyParkedCar;
    }

    /**
     * getMeterUsed method from the ParkingMeter Class
     * @return The parking meter's information
     */
    public ParkingMeter getMeterUsed()
    {
        return meterUsed;
    }

    /**
     * getFine method
     * @return The fine
     */
    public double getFine()
    {
        return fine;
    }

    /**
     * getCarDetails method
     * @return The toString method from the ParkedCar Class
     */
    public String getCarDetails()
    {
        return illegallyParkedCar.toString();
    }

    /**
     * calculateFine method to calculate the fine based on
     * how long over the paid parking car has been parked
     * @return The fine
     */
    public double calculateFine()
    {
        double fine = 0;                                    // The fine
        int hoursOver = illegallyParkedCar.getMinutes();    // Holds the getMinutes method from the ParkedCar Class

        hoursOver -= meterUsed.getPaidParking();

        if (hoursOver > 0)
        {
            fine += 25;
        }

        hoursOver -= 60;

        while (hoursOver > 0)
        {
            fine += 10;
            hoursOver -= 60;
        }

        return fine;
    }

    // toString method to be called on to print the tickets to the PoliceOfficer Class
    public String toString()
    {
        DecimalFormat d = new DecimalFormat("$#0.00");

        return  "\n-------Parking Ticket-------" + getIllegallyParkedCar() + getMeterUsed()
                + "\nFine: " + d.format(fine)
                + "\nOfficer's Name: " + officerName
                + "\nOfficer's Badge Number: " + officerBadge;
    }

}
