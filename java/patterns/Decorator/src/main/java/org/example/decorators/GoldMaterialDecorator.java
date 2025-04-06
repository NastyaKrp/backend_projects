package org.example.decorators;

public class GoldMaterialDecorator extends MaterialDecorator{

    public GoldMaterialDecorator(Jewelry decoratedJewelry) {
        super(decoratedJewelry);
    }

    @Override
    public void buy() {
        decoratedJewelry.buy();
        setGold(decoratedJewelry);
    }

    private void setGold(Jewelry decoratedJewelry) {
        System.out.println("Сообщение от GoldMaterialDecorator. Материал украшения: золото");
    }
}
