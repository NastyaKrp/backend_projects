package org.example;

public class Leaved extends State {

    Leaved(Shop shop) {
        super(shop);
        shop.setShopping(false);
    }

    @Override
    public String onStartShopping() {
        shop.changeState(new Buying(shop));
        shop.startShopping();
        return "You start shopping again";
    }
    @Override
    public String onLeave() {
        return "You have leaved the shop";
    }

    @Override
    public String onBuy() {
        return "You have leaved the shop. You should start  shopping again";
    }

    @Override
    public String onNext() {
        return "Locked... You should start  shopping again";
    }

    @Override
    public String onPrevious() {
        return "Locked... You should start  shopping again";
    }

    @Override
    public String onTake() {
        return "Locked... You should start  shopping again";
    }

    @Override
    public String onPut() { return "Locked... You should start  shopping again";}
}
