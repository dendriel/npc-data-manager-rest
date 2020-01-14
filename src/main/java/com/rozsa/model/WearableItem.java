package com.rozsa.model;

import java.util.List;

public class WearableItem extends Item {
    private List<WearableSlotType> wearableSlots;

    private WearableStatus status;

    private WearableAmmoType ammoType;

    public WearableItem() {
        super("wearable");
    }

    public List<WearableSlotType> getWearableSlots() {
        return wearableSlots;
    }

    public void setWearableSlots(List<WearableSlotType> wearableSlots) {
        this.wearableSlots = wearableSlots;
    }

    public WearableStatus getStatus() {
        return status;
    }

    public void setStatus(WearableStatus status) {
        this.status = status;
    }

    public WearableAmmoType getAmmoType() {
        return ammoType;
    }

    public void setAmmoType(WearableAmmoType ammoType) {
        this.ammoType = ammoType;
    }

    public static WearableItem from(GenericItem generic) {
        WearableItem item = new WearableItem();
        Item.copyFrom(item, generic);

        item.setWearableSlots(generic.getWearableSlots());
        item.setStatus(generic.getStatus());
        item.setAmmoType(generic.getAmmoType());

        return item;
    }
}
