package org.example;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BigTest {

    @Test
    void big_sol1() throws Exception {
        Big obj_big = new Big(0.6868, 9);
        BigDecimal res_big = obj_big.Big_sol();
        res_big = res_big.add(BigDecimal.valueOf(-Math.sqrt(1.6868)));
        BigDecimal c = BigDecimal.valueOf(0.000000001);
        BigDecimal cc = BigDecimal.valueOf(-0.000000001);
        boolean one;
        if(res_big.compareTo(c) == 1 || res_big.compareTo(cc) == 1)
        {
            one = true;
        }
        else {
            one = false;
        }
        assertEquals(true, one);
    }

    @Test
    void big_sol2() throws Exception {
        Big obj_big = new Big(0.1757, 13);
        BigDecimal res_big = obj_big.Big_sol();
        res_big = res_big.add(BigDecimal.valueOf(-Math.sqrt(1.1757)));
        BigDecimal c = BigDecimal.valueOf(0.0000000000001);
        BigDecimal cc = BigDecimal.valueOf(-0.0000000000001);
        boolean one;
        if(res_big.compareTo(c) == 1 || res_big.compareTo(cc) == 1)
        {
            one = true;
        }
        else {
            one = false;
        }
        assertEquals(true, one);
    }

    @Test
    void big_sol3() throws Exception {
        Big obj_big = new Big(0.587, 5);
        BigDecimal res_big = obj_big.Big_sol();
        res_big = res_big.add(BigDecimal.valueOf(-Math.sqrt(1.587)));
        BigDecimal c = BigDecimal.valueOf(0.00001);
        BigDecimal cc = BigDecimal.valueOf(-0.00001);
        boolean one;
        if(res_big.compareTo(c) == 1 || res_big.compareTo(cc) == 1)
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
        Big obj = new Big(-30, 10);
        Exception ex = (Exception) assertThrows(Exception.class, () -> {obj.Big_sol();});

        String expectedMes = "Error! Enter X from range [-1, 1]";
        String actualMes = ex.getMessage();

        assertEquals(expectedMes, actualMes);
    }

    @Test
    public void ex_test2() throws Exception {
        Big obj = new Big(1.1, 10);
        Exception ex = (Exception) assertThrows(Exception.class, () -> {obj.Big_sol();});

        String expectedMes = "Error! Enter X from range [-1, 1]";
        String actualMes = ex.getMessage();

        assertEquals(expectedMes, actualMes);
    }
}