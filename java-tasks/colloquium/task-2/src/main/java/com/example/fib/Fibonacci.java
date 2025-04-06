package com.example.fib;

import java.util.ArrayList;

public class Fibonacci {
    public static long fibonacci(long num) {
        if(num < 0) {
            throw new IllegalArgumentException("Fibonacci of a negative number isn't calculated!");
        }
        //long res = 1;
        long n0 = 1;
        long n1 = 1;
        long n2 = 1;
        if(num == 0) { return 1; }
        if(num == 1) { return 1; }
        for(long i = 2; i <= num; i++){
            n2 = n0 + n1;
            n0 = n1;
            n1 = n2;
        }
        return n2;
    }

    public static ArrayList<Long> fibonacci_till(long num) {
        if(num < 0) {
            throw new IllegalArgumentException("Fibonacci of a negative number isn't calculated!");
        }
        ArrayList<Long> res = new ArrayList<>();
        long result = 1;
        if(num == 0) {
            res.add(1L);
            return res;
        }
        if(num == 1) {
            res.add(1L);
            res.add(1L);
            return res;
        }
        res.add(1L);
        res.add(1L);
        long n0 = 1;
        long n1 = 1;
        long n2;
        for(long i = 2; i <= num; i++) {
            n2 = n0 + n1;
            res.add(n2);
            n0 = n1;
            n1 = n2;
        }
        return res;
    }
}
