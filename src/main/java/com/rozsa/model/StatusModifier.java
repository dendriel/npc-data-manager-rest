package com.rozsa.model;

public class StatusModifier {
    private int lifeModifier;

    private int manaModifier;

    public StatusModifier() {}

    public int getLifeModifier() {
        return lifeModifier;
    }

    public void setLifeModifier(int lifeModifier) {
        this.lifeModifier = lifeModifier;
    }

    public int getManaModifier() {
        return manaModifier;
    }

    public void setManaModifier(int manaModifier) {
        this.manaModifier = manaModifier;
    }
}
