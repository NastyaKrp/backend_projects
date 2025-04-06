package org.example;

import org.example.decorators.*;

public class Main {
    public static void main(String[] args) {
        Jewelry ring = new Ring();
        Jewelry goldRing = new GoldMaterialDecorator(new Ring());
        Jewelry silverNecklace = new SilverMaterialDecorator(new Necklace());
        Jewelry goldEarrings = new GoldMaterialDecorator(new Earrings());

        System.out.println("\nОбычное кольцо:");
        ring.buy();

        System.out.println("\nКольцо из золота:");
        goldRing.buy();

        System.out.println("\nСеребрянная подвеска на шею:");
        silverNecklace.buy();

        System.out.println("\nЗолотые сережки:");
        goldEarrings.buy();
    }
}