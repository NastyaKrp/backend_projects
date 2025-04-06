package org.example.decorators;

public class Ring implements Jewelry{

    @Override
    public void buy() {
        System.out.println("Вы купили кольцо");
    }
}
