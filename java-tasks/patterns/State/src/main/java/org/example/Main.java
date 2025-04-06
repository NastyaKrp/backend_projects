package org.example;
abstract class State {
    Shop shop;

    State(Shop shop) {
        this.shop = shop;
    }

    public abstract String onStartShopping();
    public abstract String onBuy();
    public abstract String onLeave();
    public abstract String onNext();
    public abstract String onPrevious();
    public abstract String onTake();
    public abstract String onPut();
}


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}