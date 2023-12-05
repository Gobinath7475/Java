import java.io.BufferedReader;

import java.io.FileReader;

import java.io.IOException;

public class StringBufferReader 
{
    public static void main(String[] args) throws IOException
    {
        String fileName = "C:\\Users\\joshika.d\\Documents\\read.csv";
 
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) 
        {
            String line;

            while ((line = br.readLine()) != null) 
            {
                System.out.println(line);
            }
        }
    }
}