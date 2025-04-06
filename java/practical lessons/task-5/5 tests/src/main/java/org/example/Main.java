package org.example;

import java.io.*;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args) throws IOException {

        ArrayList<String> words = Sol.ReadTXT("input.txt");

        ArrayList<String> ans = Sol.reg(words);

        FileWriter f2 = new FileWriter("output.txt");
        for(String word: ans)
        {
            f2.write(word + "\n");
        }
        f2.close();
    }
}