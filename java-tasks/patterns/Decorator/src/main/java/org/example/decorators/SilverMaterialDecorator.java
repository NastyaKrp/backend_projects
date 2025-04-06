package org.example.decorators;

public class SilverMaterialDecorator extends MaterialDecorator{

    public SilverMaterialDecorator(Jewelry decoratedJewelry) {
        super(decoratedJewelry);
    }

    @Override
    public void buy() {
        decoratedJewelry.buy();
        setGold(decoratedJewelry);
    }

    private void setGold(Jewelry decoratedJewelry) {
        System.out.println("Сообщение от SilverMaterialDecorator. Материал украшения: серебро");
    }
}
