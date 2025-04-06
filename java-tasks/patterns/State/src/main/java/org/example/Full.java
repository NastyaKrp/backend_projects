package org.example;

public class Full extends State {

    @Override
    public String onStartShopping() {
        return "You are shopping";
    }
    Full(Shop shop) {
        super(shop);
    }

    @Override
    public String onBuy() {
        return "There are more than 7 items in your bag, you can't buy all";
    }

    @Override
    public String onLeave() {
        return "You should buy your items";
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
        return "You take item, you have " + shop.getCount_bag() + " items in your bag";
    }

    @Override
    public String onPut() {
        if (shop.getCount_bag() > 8) {
            shop.putThing();
            return "You put item out of bag, you have " + shop.getCount_bag() + " items in your bag";

        }
        else
        {
            shop.putThing();
            shop.changeState(new Buying(shop));
            return "You put item out of bag, you have " + shop.getCount_bag() + " items in your bag";
        }
    }
}
