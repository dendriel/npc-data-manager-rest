package com.rozsa.model;

import java.util.List;

public class WearableItem extends Item {
    private List<WearableSlotType> wearableSlots;

    private WearableStatus status;

    private WearableAmmoType ammoType;

    private Aim aim;

    private Hit hit;

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

    public Aim getAim() {
        return aim;
    }

    public void setAim(Aim aim) {
        this.aim = aim;
    }

    public Hit getHit() {
        return hit;
    }

    public void setHit(Hit hit) {
        this.hit = hit;
    }

    public static WearableItem from(GenericItem generic) {
        WearableItem item = new WearableItem();
        Item.copyFrom(item, generic);

        item.setWearableSlots(generic.getWearableSlots());
        item.setStatus(generic.getStatus());
        item.setAmmoType(generic.getAmmoType());
        item.setAim(generic.getAim());
        item.setHit(generic.getHit());

        return item;
    }
}
