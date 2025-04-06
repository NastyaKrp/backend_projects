package org.example;

public class Buying extends State {

    public Buying(Shop shop) {
        super(shop);
    }

    @Override
    public String onStartShopping() {
        return shop.startShopping();
    }
    @Override
    public String onBuy() {
        if(shop.getCount_bag() == 0)
        {
            return "You don't have any item in your bag";
        }
        else if(shop.getCount_bag() > 0 && shop.getCount_bag() <= 7)
        {
            shop.changeState(new Bought(shop));
            shop.emptyBag();
            return "All items are bought, you can leave shop or buy more items";
        }
        else
        {
            shop.changeState(new Full(shop));
            return "There are more than 7 items in your bag, you can't buy all";
        }
    }

    @Override
    public String onLeave() {
        if(shop.getCount_bag() > 0)
        {
            return "You should buy your items";
        }
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
        if(shop.getCount_bag() > 7)
        {
            shop.changeState(new Full(shop));
        }
        return "You take item, you have " + shop.getCount_bag() + " items in your bag";
    }

    @Override
    public String onPut() {
        if(shop.getCount_bag() > 0)
        {
            shop.putThing();
            return "You put item out of bag, you have " + shop.getCount_bag() + " items in your bag";

        }
        else
        {
            return "You haven't got any item in your bag";
        }
    }
}
