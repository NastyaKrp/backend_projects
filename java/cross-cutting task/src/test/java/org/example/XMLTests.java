package org.example;

import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class XMLTests {

    @Test
    public void testXML1() throws ParserConfigurationException, IOException, SAXException {
        List<String> info = XML.ReadXML("input.xml");
        List<String> expected = new ArrayList<>();
        expected.add("hEllo");expected.add("2+3");expected.add("sdjf");
        expected.add("4-2");expected.add("13*5");expected.add("sfkdfnjs");
        assertEquals(expected, info);
    }

    @Test
    public void testXMLnoFile() {
        assertThrows(FileNotFoundException.class, () -> {
            XML.ReadXML("noname.xml");
        });
    }

}