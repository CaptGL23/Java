import java.util.Scanner;

public class AlgWorkbench
{
    public static void main(String[] args)
    {
        String input;
        char sure = 0;

        Scanner keyboard = new Scanner(System.in);

        while (sure != 'Y' && sure != 'N')
        {
            System.out.println("Are you sure you want to quit? ");
            input = keyboard.nextLine();
            sure = input.charAt(0);
        }
    }
}
