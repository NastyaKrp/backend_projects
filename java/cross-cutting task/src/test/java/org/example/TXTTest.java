package org.example;


import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TXTTest{
    @Test
    public void testTXT1(){
        List<String> info = TXT.ReadTXT("input.txt");
        List<String> expected = new ArrayList<>();
        expected.add("hello");expected.add("2+3");expected.add("sdjf");
        expected.add("4-2");expected.add("13*5");expected.add("sfkdfnjs");
        assertEquals(expected, info);
    }

    @Test
    public void testTXTnoFile() {
        assertThrows(FileNotFoundException.class, () -> {
            XML.ReadXML("noname.txt");
        });
    }
}