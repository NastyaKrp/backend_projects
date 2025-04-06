package org.example.decorators;

public class Necklace implements Jewelry{
    @Override
    public void buy() {
        System.out.println("Вы купили подвеску на шею");
    }
}
