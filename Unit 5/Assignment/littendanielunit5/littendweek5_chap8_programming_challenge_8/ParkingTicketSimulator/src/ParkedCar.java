/*
    Daniel J. Litten II
    Southwestern College - Professional Studies
    CSCI 421 - Java Programming Principles I
    Mr. Russell Schoech
    March 15, 2022
*/

/*
    This class simulates a parked car and its responsibilities
    are to know the car's make, model, color, license number, and
    the number of minutes the car has been parked.
*/

public class ParkedCar
{
    private String make;                // The car's make
    private String model;               // The car's model
    private String color;               // The car's color
    private String licenseNumber;       // The car's license number
    private int minutes;                // The number of minutes the car has been parked


    public ParkedCar()
    {}

    /**
     * This constructor accepts values as arguments and assigns
     * them to the appropriate fields
     * @param ma The car's make
     * @param mo The car's model
     * @param co The car's color
     * @param lic The car's license number
     * @param mins The number of minutes the car has been parked
     */
    public ParkedCar(String ma, String mo, String co, String lic, int mins)
    {
        this.make = ma;
        this.model = mo;
        this.color = co;
        this.licenseNumber = lic;
        this.minutes = mins;
    }

    /**
     * setMake method
     * @param ma The car's make
     */
    public void setMake(String ma)
    {
        this.make = ma;
    }

    /**
     * setModel method
     * @param mo The car's model
     */
    public void setModel(String mo)
    {
        this.model = mo;
    }

    /**
     * setColor method
     * @param co The car's color
     */
    public void setColor(String co)
    {
        this.color = co;
    }

    /**
     * setLicenseNumber method
     * @param lic The car's license number
     */
    public void setLicenseNumber(String lic)
    {
        this.licenseNumber = lic;
    }

    /**
     * setMinutes method
     * @param mins The number of minutes the car has been parked
     */
    public void setMinutes(int mins)
    {
        this.minutes = mins;
    }

    /**
     * getMake method
     * @return The car's make
     */
    public String getMake()
    {
        return make;
    }

    /**
     * getModel method
     * @return The car's model
     */
    public String getModel()
    {
        return model;
    }

    /**
     * getColor method
     * @return The car's color
     */
    public String getColor()
    {
        return color;
    }

    /**
     * getLicenseNumber method
     * @return The car's license number
     */
    public String getLicenseNumber()
    {
        return licenseNumber;
    }

    /**
     * getMinutes method
     * @return The number of minutes the car has been parked
     */
    public int getMinutes()
    {
        return minutes;
    }

    // toString method to be called by the ParkingTicket class
    public String toString()
    {
        return  "\nMake: " + make
                + "\nModel: " + model
                + "\nColor: " + color
                + "\nLicense Number: " + licenseNumber
                + "\nMinutes Parked: " + minutes + " ";
    }

    // copy constructor
    public ParkedCar(ParkedCar object2)
    {
        this.make = object2.make;
        this.model = object2.model;
        this.color = object2.color;
        this.licenseNumber = object2.licenseNumber;
        this.minutes = object2.minutes;
    }
}
