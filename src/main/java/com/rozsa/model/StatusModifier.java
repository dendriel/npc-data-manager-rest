package com.rozsa.model;

public class StatusModifier {
    private int lifeModifier;

    private int manaModifier;

    private int skillModifier;

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

    public int getSkillModifier() {
        return skillModifier;
    }

    public void setSkillModifier(int skillModifier) {
        this.skillModifier = skillModifier;
    }
}
