/*
    Daniel J. Litten II
    Southwestern College - Professional Studies
    CSCI 431 - Java Programming Principles II
    Mr. Terrell Hebert
    April 12, 2022
*/

/*
    This class gets the file name, reads the file,
    then encrypts it and writes it to an encrypted file.
 */

import java.io.*;

public class EncryptionFilter
{
    public static void Encrypt(String fileName) throws IOException
    {
        int rawData;                                // Holds the information from the original file
        String outputFile = fileName + ".enc";      // The output file

        // Object to read the file
        FileReader reader = new FileReader(fileName);

        // Object to write to the new file
        FileWriter writer = new FileWriter(outputFile);

        // Set the original file information to the rawData variable
        rawData = reader.read();

        // While loop to encrypt and write the data to the new file
        while (rawData != -1)
        {
            if (rawData != -1)
            {
                rawData += 10;
                writer.write(rawData);
            }
            rawData = reader.read();
        }

        // Close the original file
        reader.close();

        // Close the encrypted file
        writer.close();
    }
}
