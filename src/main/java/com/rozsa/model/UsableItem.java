package com.rozsa.model;

import java.util.ArrayList;
import java.util.List;

public class UsableItem extends Item {
    private List<StatusModifier> statusModifiersData;

    private String soundEfx;

    public UsableItem() {
        super("usable");
    }

    public List<StatusModifier> getStatusModifiersData() {
        return new ArrayList<>(statusModifiersData);
    }

    public void setStatusModifiersData(List<StatusModifier> statusModifiersData) {
        this.statusModifiersData = statusModifiersData;
    }

    public String getSoundEfx() {
        return soundEfx;
    }

    public void setSoundEfx(String soundEfx) {
        this.soundEfx = soundEfx;
    }

    public static UsableItem from(GenericItem generic) {
        UsableItem item = new UsableItem();
        Item.copyFrom(item, generic);

        item.setStatusModifiersData(generic.getStatusModifiersData());
        item.setSoundEfx(generic.getSoundEfx());

        return item;
    }
}
