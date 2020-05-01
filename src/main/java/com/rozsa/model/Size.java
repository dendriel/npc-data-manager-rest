package com.rozsa.model;

import java.util.Objects;

public class Size {
    public static Size zeroed() {
        return new Size();
    }

    private int width;
    private int height;

    public Size() {
    }

    public Size(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void addWidth(int width) {this.width += width; }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void addHeight(int height) { this.height += height;}

    public Size clone() {
        return new Size(width, height);
    }

    @Override
    public String toString() {
        return String.format("w: %d h: %d", width, height);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Size size = (Size) o;
        return width == size.width &&
                height == size.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }
}
