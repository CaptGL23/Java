import java.util.Random;

public class SlotMachineSim
{
    public static void main(String[] args)
    {
        int number1;
        int number2;
        int number3;

        Random randomNumbers = new Random();

        number1 = randomNumbers.nextInt(5);
        number2 = randomNumbers.nextInt(5);
        number3 = randomNumbers.nextInt(5);

        switch (number1)
        {
            case 0:
                System.out.println("Cherries");
                break;
            case 1:
                System.out.println("Oranges");
                break;
            case 2:
                System.out.println("Plums");
                break;
            case 3:
                System.out.println("Bells");
                break;
            case 4:
                System.out.println("Melons");
                break;
            case 5:
                System.out.println("Bars");
                break;
        }

        switch (number2)
        {
            case 0:
                System.out.println("Cherries");
                break;
            case 1:
                System.out.println("Oranges");
                break;
            case 2:
                System.out.println("Plums");
                break;
            case 3:
                System.out.println("Bells");
                break;
            case 4:
                System.out.println("Melons");
                break;
            case 5:
                System.out.println("Bars");
                break;
        }

        switch (number3)
        {
            case 0:
                System.out.println("Cherries");
                break;
            case 1:
                System.out.println("Oranges");
                break;
            case 2:
                System.out.println("Plums");
                break;
            case 3:
                System.out.println("Bells");
                break;
            case 4:
                System.out.println("Melons");
                break;
            case 5:
                System.out.println("Bars");
                break;
        }
    }
}
