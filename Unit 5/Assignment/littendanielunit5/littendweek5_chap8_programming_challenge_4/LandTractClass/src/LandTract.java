/*
    Daniel J. Litten II
    Southwestern College - Professional Studies
    CSCI 421 - Java Programming Principles I
    Mr. Russell Schoech
    March 12, 2022
*/

/*
    This class will have two fields: one for the tract's
    length and one for the width. The class will have a method
    that returns the tract's area, as well as an equals method
    and a toString method.
*/

public class LandTract
{
    private double length;          // The length of the tract
    private double width;           // The width of the tract

    /**
     * Constructor accepts values as arguments and assigns
     * them to the appropriate fields
     * @param len The length of the tract
     * @param w The width of the tract
     */
    public LandTract(double len, double w)
    {
        length = len;
        width = w;
    }

    /**
     * getArea method
     * @return The area of the tract
     */
    public double getArea()
    {
        return length * width;
    }

    /**
     * toString method
     * @return The string representing the state of the object
     */
    public String toString()
    {
        String str = "The area of the tract is " + getArea();

        return str;
    }

    /**
     * equals method
     * @param object2 The object that is passes as an argument
     * @return The status of true or false
     */
    public boolean equals(LandTract object2)
    {
        boolean status;

        /*
            Determine whether this object's area is equal
            to object2's area
        */
        if (getArea() == object2.getArea())
        {
            status = true;          // Yes, the objects are equal
        }
        else
        {
            status = false;         // No, the objects are not equal
        }

        // Return the value in status
        return status;
    }
}
