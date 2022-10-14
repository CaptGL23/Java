/*
    Daniel J. Litten II
    Southwestern College - Professional Studies
    CSCI 431 - Java Programming Principles II
    Mr. Terrell Hebert
    April 16, 2022
*/

/*
    Algorithm Workbench Chap 15 Exercise 1
    Write a method that accepts a String as an argument.  The method
    should use recursion to display each individual character in
    the String.
 */

public class AlgWorkbenchChap15Ex1
{
    public static void main(String[] args)
    {
        String str = "test string";
        display(str, 0);
    }

    public static void display(String str, int pos)
    {
        if (pos < str.length())
        {
            System.out.print(str.charAt(pos));
            display(str, pos + 1);
        }
    }
}
