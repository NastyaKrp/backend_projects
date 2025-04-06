package org.example.decorators;

public class Earrings implements Jewelry{

    @Override
    public void buy() {
        System.out.println("Вы купили сережки");
    }
}
