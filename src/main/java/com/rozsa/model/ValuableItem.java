package com.rozsa.model;

public class ValuableItem extends Item {
    public ValuableItem() {
        super("valuable");
    }

    public static ValuableItem from(GenericItem generic) {
        ValuableItem item = new ValuableItem();
        Item.copyFrom(item, generic);
        return item;
    }
}
