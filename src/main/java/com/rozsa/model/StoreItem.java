package com.rozsa.model;

public class StoreItem {
    private int id;

    private boolean useStack;

    private float stackPriceModifier;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isUseStack() {
        return useStack;
    }

    public void setUseStack(boolean useStack) {
        this.useStack = useStack;
    }

    public float getStackPriceModifier() {
        return stackPriceModifier;
    }

    public void setStackPriceModifier(float stackPriceModifier) {
        this.stackPriceModifier = stackPriceModifier;
    }
}
