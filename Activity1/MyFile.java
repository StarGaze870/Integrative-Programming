package Activity1;

import java.nio.file.Paths;
import java.util.*;
import java.nio.file.*;
import java.io.*;
import static java.nio.file.StandardOpenOption.*;


public class MyFile {

    public static void main(String[] args)
    {
        Scanner input = new Scanner (System.in);
        int id = 0;
        double payRate;
        final int QUIT = 999;
        String name;
        String filename;
        String record = "";
        String Delimeter = ",";


        System.out.println("Please enter a filename : ");
        filename = input.nextLine();
        Path inputPath = Paths.get(filename);
        Path fullPath = inputPath.toAbsolutePath();
        System.out.println("Full path: "+fullPath.toString());
        Path file = Paths.get(fullPath.toString());
        try
        {
            BufferedOutputStream output = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
            System.out.println("Enter the employee id Number: ");
            while(id != QUIT)
            {
                System.out.println("Enter name for Employee #"+id);
                input.nextLine();
                name=input.nextLine();
                System.out.println("Enter the payrate ");
                payRate = input.nextDouble();
                record = id+Delimeter+name+Delimeter+payRate;
                writer.write(record, 0, record.length());
                writer.newLine();
                System.out.println("Please enter id number: ");
                id = input.nextInt();

            }
            writer.close();
        }
        catch(Exception e)
        {
            System.out.println("Message: "+e);
        }
    }
}