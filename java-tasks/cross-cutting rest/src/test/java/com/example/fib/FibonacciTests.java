package com.example.fib;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FibonacciTests {
	@Test
	public void testFibonacciOfZero() {
		assertEquals(1, Fibonacci.fibonacci(0));
	}

	@Test
	public void testFibonacciOfPositiveNumbers() {
		assertEquals(1, Fibonacci.fibonacci(1));
		assertEquals(2, Fibonacci.fibonacci(2));
		assertEquals(3, Fibonacci.fibonacci(3));
		assertEquals(5, Fibonacci.fibonacci(4));
		assertEquals(8, Fibonacci.fibonacci(5));
	}

	@Test
	public void testFibonacciOfNegativeNumbers() {
		assertThrows(IllegalArgumentException.class, () -> {
			Fibonacci.fibonacci(-1);
		});
	}
}
