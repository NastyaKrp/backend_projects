package org.example;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Sol
{
    public static ArrayList<String> ReadTXT(String file)
    {
        ArrayList<String> words = new ArrayList<String>();
        try(FileReader reader = new FileReader(file))
        {
            Scanner scan = new Scanner(reader);
            while(scan.hasNextLine())
            {
                words.add(scan.nextLine());
            }
        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }
        return words;
    }

    public static ArrayList<String> reg(ArrayList<String> words)
    {
        ArrayList<String> ans = new ArrayList<>();
        Pattern pattern = Pattern.compile("^#[0-9a-fA-F]{6}$");
        String str;
        for(String word: words)
        {
            Matcher matcher = pattern.matcher(word);
            if (matcher.find()) {
                str = word + " - Right";
                ans.add(str);
            }
            else {
                str = word + " - False";
                ans.add(str);
            }
        }
        return ans;
    }

}