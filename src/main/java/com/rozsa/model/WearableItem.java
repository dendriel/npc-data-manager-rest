package com.rozsa.model;

import java.util.List;

public class WearableItem extends Item {
    private List<WearableSlotKind> wearableSlots;

    private WearableStatus status;

    public WearableItem() {
        super("wearable");
    }

    public List<WearableSlotKind> getWearableSlots() {
        return wearableSlots;
    }

    public void setWearableSlots(List<WearableSlotKind> wearableSlots) {
        this.wearableSlots = wearableSlots;
    }

    public WearableStatus getStatus() {
        return status;
    }

    public void setStatus(WearableStatus status) {
        this.status = status;
    }
}
