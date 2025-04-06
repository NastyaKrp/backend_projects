package org.example;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Formatter;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws Exception {
        double x;
        int k;
        Scanner myObj = new Scanner(System.in);

        System.out.println("Enter x (x > -1 and x < 1)");
        x = myObj.nextDouble();
        System.out.println("Enter k");
        k = myObj.nextInt();

        if(x < -1 || x > 1)
        {
            System.out.println("Error! Incorrect value x");
            return;
        }

        Row obj = new Row(x, k);
        double res = obj.sol();
        NumberFormat formatter  = NumberFormat.getNumberInstance();
        formatter.setMaximumFractionDigits(k);
        Big obj_big = new Big(x, k);
        BigDecimal res_big = obj_big.Big_sol();
        System.out.println("Result: " + formatter.format(res));
        System.out.println("Result Big: " + res_big);
        System.out.println("Check: " + Math.sqrt(1 + x));

        /*int xo = (int)Math.abs(res * 100);
        Formatter fmt = new Formatter();
        fmt.format("1) Hex: %x, Octal: %o", xo, xo);
        System.out.println(fmt);
        Formatter fmt1 = new Formatter();
        fmt1.format ("2) Dot: %f", -res);
        System.out.println(fmt1);
        Formatter fmt2 = new Formatter();
        fmt2.format ("3,4) Width and count of numbers after dot: %020.4f", res);
        System.out.println(fmt2);
        Formatter fmt3 = new Formatter();
        fmt3.format ("5.1) Flags example 1 + : %+d", xo);
        System.out.println(fmt3);
        Formatter fmt4 = new Formatter();
        fmt4.format ("5.2) Flags example 1 - : % (d", -xo);
        System.out.println(fmt4);
        Formatter fmt5 = new Formatter();
        fmt5.format ("6) : %3$d %1$d %2$d", xo, -xo, 100);
        System.out.println(fmt5);*/
    }
}