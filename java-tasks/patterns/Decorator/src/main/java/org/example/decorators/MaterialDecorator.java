package org.example.decorators;

public abstract class MaterialDecorator implements Jewelry {

    protected Jewelry decoratedJewelry;

    public MaterialDecorator(Jewelry decoratedJewelry) {
        this.decoratedJewelry = decoratedJewelry;
    }

    public void draw() {
        decoratedJewelry.buy();
    }
}
