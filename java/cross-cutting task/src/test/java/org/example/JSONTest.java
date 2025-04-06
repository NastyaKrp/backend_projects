package org.example;

import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class JSONTest{
    @Test
    public void testJSON1(){
        List<String> info = JSON.ReadJSON("input.json");
        List<String> expected = new ArrayList<>();
        expected.add("hello");expected.add("2+3");expected.add("sdjf");
        expected.add("4-2");expected.add("13*5");expected.add("sfkdfnjs");expected.add("6*5/(3+2)");
        assertEquals(expected, info);
    }

    @Test
    public void testJSONnoFile() {
        assertThrows(FileNotFoundException.class, () -> {
            XML.ReadXML("noname.json");
        });
    }
}