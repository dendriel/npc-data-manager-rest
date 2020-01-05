package com.rozsa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.bson.codecs.pojo.annotations.BsonIgnore;

import java.util.Objects;

public class Color {
    private int r;

    private int g;

    private int b;

    public Color() {
    }

    public Color(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    @BsonIgnore
    @JsonIgnore
    public java.awt.Color getColor() {
        return new java.awt.Color(r, g, b);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Color color = (Color) o;
        return r == color.r &&
                g == color.g &&
                b == color.b;
    }

    @Override
    public int hashCode() {
        return Objects.hash(r, g, b);
    }
}
