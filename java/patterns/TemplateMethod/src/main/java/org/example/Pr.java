package org.example;

public abstract class Pr {
    protected void collectTheory() {
        System.out.print("Collect theory.");
    }

    protected void collectPractice() {
        System.out.print(" Collect practice.");
    }

    protected void workOnTheory() {
        System.out.print(" Work on theory.");
    }

    protected void workOnPractice() {
        System.out.print(" Work on practice.");
    }

    public void startToPrepare() {
        collectTheory();
        collectPractice();
        workOnTheory();
        workOnPractice();
    }
}