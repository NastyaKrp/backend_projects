package org.example;


import org.testng.annotations.Test;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolTest {

    @Test
    public void readTXT1() {
        ArrayList<String> tmp = Sol.ReadTXT("src/test/java/inputFiles/f1.txt");
        String res = "";
        String ans = "#00ff00 232323 f#fddee ";
        for(String word: tmp)
        {
            res += word + " ";
        }
        assertEquals(res, ans);
    }

    @Test
    public void readTXT2() {
        ArrayList<String> tmp = Sol.ReadTXT("src/test/java/inputFiles/f2.txt");
        String res = "";
        String ans = "#FF3421 #00ff00 232323 f#fddee ";
        for(String word: tmp)
        {
            res += word + " ";
        }
        assertEquals(res, ans);
    }

    @Test
    public void reg1() {
        ArrayList<String> tmp = Sol.ReadTXT("src/test/java/inputFiles/f1.txt");
        tmp = Sol.reg(tmp);
        String res = "";
        for(String line: tmp)
        {
            res += line + " ";
        }
        String ans = "#00ff00 - Right 232323 - False f#fddee - False ";
        assertEquals(res, ans);
    }

    @Test
    public void reg2() {
        ArrayList<String> tmp = Sol.ReadTXT("src/test/java/inputFiles/f2.txt");
        tmp = Sol.reg(tmp);
        String res = "";
        for(String line: tmp)
        {
            res += line + " ";
        }
        String ans = "#FF3421 - Right #00ff00 - Right 232323 - False f#fddee - False ";
        assertEquals(res, ans);
    }
}