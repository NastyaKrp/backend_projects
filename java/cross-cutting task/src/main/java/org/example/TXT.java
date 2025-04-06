package org.example;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TXT {
    public static List<String> ReadTXT(String file) {
        List<String> info = new ArrayList<>();
        try (FileReader reader = new FileReader(file)) {
            Scanner scan = new Scanner(reader);
            while (scan.hasNextLine())
            {
                info.add(scan.nextLine());
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return info;
    }

    public static void WriteTXT(List<String> out)
    {
        try(FileWriter f2 = new FileWriter("output.txt"))
        {
            for(String s: out)
            {
                f2.write(s + "\n");

            }
            f2.close();
        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public static void WriteTXT(List<String> out, String name)
    {
        try(FileWriter f2 = new FileWriter(name))
        {
            for(String s: out)
            {
                f2.write(s + "\n");

            }
            f2.close();
        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
