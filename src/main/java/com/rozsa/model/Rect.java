package com.rozsa.model;

import java.util.Objects;

public class Rect {
    private int x;

    private int y;

    private int width;

    private int height;

    public Rect() {
    }

    public Rect(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Rect clone() {
        Rect clone = new Rect();
        clone.x = x;
        clone.y = y;
        clone.width = width;
        clone.height = height;
        return clone;
    }

    @Override
    public String toString() {
        return String.format("%d,%d - %d,%d", x, y, width, height);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rect rect = (Rect) o;
        return x == rect.x &&
                y == rect.y &&
                width == rect.width &&
                height == rect.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, width, height);
    }
}
