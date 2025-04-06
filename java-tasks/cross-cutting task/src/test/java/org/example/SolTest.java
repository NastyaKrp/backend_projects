package org.example;


import org.junit.jupiter.api.Test;

import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SolTest{
    @Test
    public void testSol1(){
        assertEquals(5, Sol.eval("4+3*2-5"));
        assertEquals(-5, Sol.eval("4+3*(2-5)"));
        assertEquals(9, Sol.eval("(4+3)*2-5"));
        assertEquals(4, Sol.eval("4+3*2-12/2"));
    }

    @Test
    public void testSol2() throws ScriptException {
        List<String> info = new ArrayList<>();
        List<String> expected = new ArrayList<>();
        expected.add("5");expected.add("-5");expected.add("9");expected.add("4");
        info.add("4+3*2-5");info.add("4+3*(2-5)");info.add("(4+3)*2-5");info.add("4+3*2-12/2");
        assertEquals(expected, Sol.Sol_M(info));
    }

    @Test
    public void testSol3() {
        List<String> info = new ArrayList<>();
        info.add("4+3*2-5");info.add("hello/5");info.add("(4+3)*2-5");info.add("4+3*2-12/2");
        assertThrows(NumberFormatException.class, () -> {
            Sol.Sol_M(info);
        });
    }
}