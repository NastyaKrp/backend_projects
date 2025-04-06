package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RowTest {

    @Test
    void sol1() throws Exception {
        Row obj = new Row(0.2, 8);
        Double res = obj.sol();
        Double ans = Math.sqrt(1.2);
        boolean one;
        if(Math.abs(res - ans) < 0.00000001)
        {
            one = true;
        }
        else {
            one = false;
        }
        assertEquals(true, one);
    }

    @Test
    void sol2() throws Exception {
        Row obj = new Row(0.556, 10);
        Double res = obj.sol();
        Double ans = Math.sqrt(1.556);
        boolean one;
        if(Math.abs(res - ans) < 0.0000000001)
        {
            one = true;
        }
        else {
            one = false;
        }
        assertEquals(true, one);
    }

    @Test
    void sol3() throws Exception {
        Row obj = new Row(0.712, 12);
        Double res = obj.sol();
        Double ans = Math.sqrt(1.712);
        boolean one;
        if(Math.abs(res - ans) < 0.000000000001)
        {
            one = true;
        }
        else {
            one = false;
        }
        assertEquals(true, one);
    }

    @Test
    public void ex_test1() throws Exception {
        Row obj = new Row(2, 10);
        Exception ex = (Exception) assertThrows(Exception.class, () -> {obj.sol();});

        String expectedMes = "Error! Enter X from range [-1, 1]";
        String actualMes = ex.getMessage();

        assertEquals(expectedMes, actualMes);
    }

    @Test
    public void ex_test2() throws Exception {
        Row obj = new Row(-30, 10);
        Exception ex = (Exception) assertThrows(Exception.class, () -> {obj.sol();});

        String expectedMes = "Error! Enter X from range [-1, 1]";
        String actualMes = ex.getMessage();

        assertEquals(expectedMes, actualMes);
    }

}