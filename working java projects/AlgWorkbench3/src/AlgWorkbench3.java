import java.util.Random;
/*
    This program will complete the following program so it
    performs the following action 10 times:
    Generates a random number that is either 0 or 1.
    Display either the word "Yes" or the word "No"
    depending on the random number generated
*/

public class AlgWorkbench3
{
    public static void main(String[] args)
    {
        Random randomNumbers = new Random();

        for (int num = 0; num < 10; num++)
        {
            if (randomNumbers.nextInt(2) == 0)
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }
}
