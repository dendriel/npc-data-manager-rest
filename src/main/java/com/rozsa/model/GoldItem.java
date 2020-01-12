package com.rozsa.model;

public class GoldItem extends Item {
    public GoldItem() {
        super("gold");
    }

    public static GoldItem from(GenericItem generic) {
        GoldItem item = new GoldItem();
        Item.copyFrom(item, generic);
        return item;
    }
}
