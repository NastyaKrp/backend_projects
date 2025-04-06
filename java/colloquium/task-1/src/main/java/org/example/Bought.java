package org.example;

import org.example.Shop;
import org.example.State;

public class Bought extends State {

    public Bought(Shop shop) {
        super(shop);
    }

    @Override
    public String onStartShopping() {
        shop.changeState(new Buying(shop));
        return "You start shopping, you are looking at 1 item";
    }
    @Override
    public String onBuy() {
       return "You don't have any item in your bag";
    }

    @Override
    public String onLeave() {
        shop.changeState(new Leaved(shop));
        return "You leave the shop";
    }

    @Override
    public String onNext() {
        return shop.nextItem();
    }

    @Override
    public String onPrevious() {
        return shop.previousItem();
    }

    @Override
    public String onTake() {
        shop.takeThing();
        shop.changeState(new Buying(shop));
        return "You take item, you have " + shop.getCount_bag() + " items in your bag";
    }

    @Override
    public String onPut() {
        return "You haven't got any item in your bag";
    }
}
