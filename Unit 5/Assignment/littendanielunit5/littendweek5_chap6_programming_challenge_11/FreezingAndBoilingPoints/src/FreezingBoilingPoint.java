/*
    Daniel J. Litten II
    Southwestern College - Professional Studies
    CSCI 421 - Java Programming Principles I
    Mr. Russell Schoech
    March 11, 2022
*/

/*
    This class creates the constructors, and accessor and mutator
    methods.  It also has boolean methods to determine if the input
    temperature is freezing or boiling and return true or false to
    the program calling the method.
*/

public class FreezingBoilingPoint
{
    private double temperature;         // Holds the input temperature

    /**
     * no-arg constructor that assigns 0 to the temperature field
     */
    public FreezingBoilingPoint()
    {
        temperature = 0;
    }

    /**
     * Constructor to accept the value as an argument and assign
     * it to the appropriate field
     * @param t The entered temperature
     */
    public FreezingBoilingPoint(double t)
    {
        temperature = t;
    }

    /**
     * setTemperature method
     * @param t The entered temperature
     */
    public void setTemperature(double t)
    {
        temperature = t;
    }

    /**
     * getTemperature method
     * @return The entered temperature
     */
    public double getTemperature()
    {
        return temperature;
    }

    /**
     * ISETHYLFREEZING method
     * @return Boolean value true if the condition is met
     */
    public boolean ISETHYLFREEZING()
    {
        return temperature <= -173;
    }

    /**
     * ISETHYLBOILING method
     * @return Boolean value true if the condition is met
     */
    public boolean ISETHYLBOILING()
    {
        return temperature >= 172;
    }

    /**
     * ISOXYGENFREEZING method
     * @return Boolean value true if the condition is met
     */
    public boolean ISOXYGENFREEZING()
    {
        return temperature <= -362;
    }

    /**
     * ISOXYGENBOILING method
     * @return Boolean value true if the condition is met
     */
    public boolean ISOXYGENBOILING()
    {
        return temperature >= -306;
    }

    /**
     * ISWARERFREEZING method
     * @return Boolean value true if the condition is met
     */
    public boolean ISWARERFREEZING()
    {
        return temperature <= 32;
    }

    /**
     * ISWATERBOILING method
     * @return Boolean value true if the condition is met
     */
    public boolean ISWATERBOILING()
    {
        return temperature >= 212;
    }
}
