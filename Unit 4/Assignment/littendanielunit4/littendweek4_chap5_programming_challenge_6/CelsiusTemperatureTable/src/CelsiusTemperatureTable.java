/*
    Daniel J. Litten II
    Southwestern College - Professional Studies
    CSCI 421 - Java Programming Principles I
    Mr. Russell Schoech
    March 2, 2022
*/

/*
    The formula for converting a temperature from Fahrenheit
    to Celsius is:
                    C = 5/9 (F-32)
    where F is Fahrenheit and C is Celsius.
    This program will have a method named celsius that
    accepts a Fahrenheit temperature as an argument.
    The method should return the temperature, converted
    to celsius.  Demonstrate the method by calling it in
    a loop that displays a table of the Fahrenheit temperatures
    0 through 20 and their Celsius equivalents.
*/

public class CelsiusTemperatureTable
{
    public static void main(String[] args)
    {
        // Identifier Declaration
        double degreesInCelsius;        // Holds celsius variable

        System.out.println("Fahrenheit\tCelsius");
        System.out.println("--------------------");

        /*
            for loop to create table and display the temperature
            in fahrenheit while calling the celsius method to
            display the fahrenheit temperature in celsius
        */
        for (int degreesFahrenheit = 0; degreesFahrenheit <= 20; degreesFahrenheit++)
        {
            degreesInCelsius = celsius(degreesFahrenheit);
            System.out.printf("%d\t\t\t%.2f\n", degreesFahrenheit, degreesInCelsius);
        }
    }

    /*
        The celsius method calculates celsius and
        accepts a Fahrenheit temperature as an argument.
        Then returns the calculation of celsius to the main method
    */
    public static double celsius(int fahrenheit)
    {
        double degreesInCelsius;        // Holds celsius variable

        //Calculates degrees in celsius
        degreesInCelsius = (5/9.0F) * (fahrenheit - 32);

        /*
            Return statement to return the degreesInCelsius
            variable to the main method.
        */
        return degreesInCelsius;
    }
}
