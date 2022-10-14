/*
    Daniel J. Litten II
    Southwestern College - Professional Studies
    CSCI 431 - Java Programming Principles II
    Mr. Terrell Hebert
    April 12, 2022
*/

/*
    This program runs the EncryptionFilter Class,
    which encrypts the file that is passed as the argument.
 */

import javax.swing.*;

public class FileEncryptionFilter
{
    public static void main(String[] args) throws Exception
    {
        // Call the Encrypt method from the EncryptionFilter class
        // and pass your file name as an argument
        EncryptionFilter.Encrypt("fileToEncrypt.txt");
    }
}
