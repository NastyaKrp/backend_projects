package com.example.fib;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FibonacciTillTests {
    @Test
    public void testFactorialTillOfZero() {
        ArrayList<Long> expected = new ArrayList<>();
        expected.add(1L);
        ArrayList<Long> actual = new ArrayList<>(Fibonacci.fibonacci_till(0));
        assertEquals(expected, actual);
    }

    @Test
    public void testFactorialTillOfOne() {
        ArrayList<Long> expected = new ArrayList<>();
        expected.add(1L);
        expected.add(1L);
        ArrayList<Long> actual = new ArrayList<>(Fibonacci.fibonacci_till(1));
        assertEquals(expected, actual);
    }

    @Test
    public void testFibonacciTillOfPositiveNumbers5() {
        ArrayList<Long> expected = new ArrayList<>();
        expected.add(1L); expected.add(1L); expected.add(2L); expected.add(3L); expected.add(5L); expected.add(8L);
        ArrayList<Long> actual = new ArrayList<>(Fibonacci.fibonacci_till(5));
        assertEquals(expected, actual);
    }

    @Test
    public void testFibonacciTillOfPositiveNumbers10() {
        ArrayList<Long> expected = new ArrayList<>();
        expected.add(1L); expected.add(1L); expected.add(2L); expected.add(3L); expected.add(5L);
        expected.add(8L); expected.add(13L); expected.add(21L); expected.add(34L); expected.add(55L);
        expected.add(89L);
        ArrayList<Long> actual = new ArrayList<>(Fibonacci.fibonacci_till(10));
        assertEquals(expected, actual);
    }

    @Test
    public void testFibonacciTillOfNegativeNumbers() {
        assertThrows(IllegalArgumentException.class, () -> {
            Fibonacci.fibonacci_till(-1);
        });
    }
}