package org.example.courses;


import org.example.Pr;

public class Fourth extends Pr {
    @Override
    protected void collectPractice() {
        System.out.print(" Ask your collegues about practice notes.");
    }

    @Override
    protected void collectTheory() {
        System.out.print("Open GoogleDisk with all theory.");
    }

    @Override
    protected void workOnPractice() {
        System.out.print(" At least open it.");
    }

    @Override
    protected void workOnTheory() {
        System.out.print(" Do something, you have a state exam this year!!!");
    }
}