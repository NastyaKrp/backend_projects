package org.example.courses;

import org.example.Pr;

public class Third extends Pr {
    @Override
    protected void collectPractice() {
        System.out.print(" Ask your collegues about practice notes.");
    }

    @Override
    protected void collectTheory() {
        System.out.print("Open GoogleDisk with theory.");
    }

    @Override
    protected void workOnPractice() {
        System.out.print(" Please open practice.");
    }

    @Override
    protected void workOnTheory() {
        System.out.print(" Please open theory.");
    }
}