package org.example;

public class Demo {
    public static void main(String[] args) {
        Shop shop = new Shop();
        UI ui = new UI(shop);
        ui.init();
    }
}
