package org.example;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private State state;
    private boolean shopping = false;

    private int count_bag = 0;
    private List<String> shoplist = new ArrayList<>();
    private int currentItem = 0;

    public Shop() {
        this.state = new Buying(this);
        setShopping(true);
        for (int i = 1; i <= 10; i++) {
            shoplist.add("Item " + i);
        }
    }

    public void changeState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void setShopping(boolean shopping) {
        this.shopping = shopping;
    }

    public void takeThing() { this.count_bag += 1;}

    public void putThing() { this.count_bag -= 1;}

    public void emptyBag() { this.count_bag = 0;}

    public int getCount_bag() { return count_bag;}

    public String startShopping() {
        return "looking at " + shoplist.get(currentItem);
    }

    public String nextItem() {
        currentItem++;
        if (currentItem > shoplist.size() - 1) {
            currentItem = 0;
        }
        return "looking at " + shoplist.get(currentItem);
    }

    public String previousItem() {
        currentItem--;
        if (currentItem < 0) {
            currentItem = shoplist.size() - 1;
        }
        return "looking at " + shoplist.get(currentItem);
    }
}
