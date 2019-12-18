package com.rozsa.model;

public class Scale {
    private double width;

    private double height;

    public Scale() {}

    public Scale(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Scale clone() {
        return new Scale(width, height);
    }
}
