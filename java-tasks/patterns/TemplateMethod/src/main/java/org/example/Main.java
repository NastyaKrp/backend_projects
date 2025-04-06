package org.example;

import org.example.courses.First;
import org.example.courses.Fourth;
import org.example.courses.Second;
import org.example.courses.Third;

public class Main {
    public static void main(String[] args) {
        String course = "SecondCourse";
        Pr preparation = null;

        switch(course) {
            case "FirstCourse":
                System.out.println("FirstCourse");
                preparation = new First();
                preparation.startToPrepare();
                break;
            case "SecondCourse":
                System.out.println("SecondCourse");
                preparation = new Second();
                preparation.startToPrepare();
                break;
            case "ThirdCourse":
                System.out.println("ThirdCourse");
                preparation = new Third();
                preparation.startToPrepare();
                break;
            case "FourthCourse":
                System.out.println("FourthCourse");
                preparation = new Fourth();
                preparation.startToPrepare();
                break;
            default:
                System.out.println("Something wrong!");
        }
    }
}