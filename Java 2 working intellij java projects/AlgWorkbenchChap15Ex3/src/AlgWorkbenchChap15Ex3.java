/*
    Daniel J. Litten II
    Southwestern College - Professional Studies
    CSCI 431 - Java Programming Principles II
    Mr. Terrell Hebert
    April 16, 2022
*/

/*
    Algorithm Workbench Chap 15 Exercise 3
    What will the code in the textbook display
 */

public class AlgWorkbenchChap15Ex3
{
    public static void main(String[] args)
    {
        int num = 0;
        showMe(num);
    }

    public static void showMe(int arg)
    {
        if (arg < 10)
        {
            showMe(arg +1);
        }
        else
        {
            System.out.println(arg);
        }
    }
}
