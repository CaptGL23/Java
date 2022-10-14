import java.util.Scanner;

public class algorithmWorkbench

{
    public static void main(String[] args)
    {
        int choice;

        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter 1, 2, 3, or 4: ");
        choice = keyboard.nextInt();


        switch (choice)
        {
            case 1:
                System.out.println("You selected 1.");
                break;
            case 2:
            case 3:
                System.out.println("You selected 2 or 3.");
                break;
            case 4:
                System.out.println("You selected 4.");
                break;
            default:
                System.out.println("Select again please.");
                break;

        }
    }
}
