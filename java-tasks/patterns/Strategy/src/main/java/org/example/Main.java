package org.example;

import org.example.order.Ar;
import org.example.strategies.ArchiveStrategy;
import org.example.strategies.Jar;
import org.example.strategies.Zip;


import java.io.IOException;
import java.util.Scanner;


public class Main {
    private static Ar ar = new Ar();
    private static ArchiveStrategy strategy;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please, select a method of archiving:" + "\n" +
                "1 - Zip" + "\n" +
                "2 - Jar");
        String archivingMethod = sc.nextLine();

        if (archivingMethod.equals("1")) {
            strategy = new Zip();
        } else {
            strategy = new Jar();
        }
        ar.processAr(strategy);
    }
}