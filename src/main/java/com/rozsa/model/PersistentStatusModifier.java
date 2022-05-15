package com.rozsa.model;

public class PersistentStatusModifier {
    private PersistentStatusModifierType type;
    private float value;
    private int turns;

    public PersistentStatusModifierType getType() {
        return type;
    }

    public void setType(PersistentStatusModifierType type) {
        this.type = type;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public int getTurns() {
        return turns;
    }

    public void setTurns(int turns) {
        this.turns = turns;
    }
}
