package com.example.fib;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("fibonacci")
public class FibonacciController {

    @GetMapping("{num}")
    public long fibonacci(@PathVariable long num) {
        return Fibonacci.fibonacci(num);
    }

    @GetMapping("/till/{num}")
    public ArrayList<Long> fibonacci_till(@PathVariable long num) {
        return Fibonacci.fibonacci_till(num);
    }
}