/*
    Daniel J. Litten II
    Southwestern College - Professional Studies
    CSCI 431 - Java Programming Principles II
    Mr. Terrell Hebert
    April 16, 2022
*/

/*
    Algorithm Workbench Chap 15 Exercise 2
    Modify the method that was written in Algorithm Workbench 1, so
    it displays the String backwards.
 */

public class AlgWorkbenchChap15Ex2
{
    public static void main(String[] args)
    {
        String str = "test string";
        display(str, str.length() - 1);
    }

    public static void display(String str, int pos)
    {
        if (pos >= 0)
        {
            System.out.print(str.charAt(pos));
            display(str, pos - 1);
        }
    }
}
