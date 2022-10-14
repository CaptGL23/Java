/*
    Daniel J. Litten II
    Southwestern College - Professional Studies
    CSCI 421 - Java Programming Principles I
    Mr. Russell Schoech
    March 11, 2022
*/

/*
    This class creates the three overloaded static methods
    for calculating the areas of circles, rectangles, and
    cylinders.
*/

public class Area
{
    private static double x;                    // The filler
    private static double radius;               // The radius
    private static double width;                // The width
    private static double length;               // The length
    private static double height;               // The height

    /**
     * Areas method
     * @param r The radius
     * @return The area of a circle
     */
    public static double Areas(double r)
    {
        radius = r;

        return Math.PI * Math.pow(radius, 2);
    }

    /**
     * Areas method
     * @param w The width
     * @param len The length
     * @return The area of a rectangle
     */
    public static double Areas(double w, double len)
    {
        width = w;
        length = len;

        return width * length;
    }

    /**
     * Areas method
     * @param x The filler
     * @param r The radius
     * @param h The height
     * @return The area of a cylinder
     */
    public static double Areas(double x, double r, double h)
    {
        radius = r;
        height = h;

        return Math.PI * Math.pow(radius, 2) * height;
    }
}
