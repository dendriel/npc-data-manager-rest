package com.rozsa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;

public class Label {
    private String text;

    private String font;

    private int style;

    private int size;

    private Color color;

    private Rect rect;

    private int verticalAlignment;

    private int horizontalAlignment;

    public Label() {
        color = new Color(255, 255, 255);
    }

    public Label(int size, Rect rect, int verAlign, int horAlign, String text) {
        this.text = text;
        font = "Serif";
        style = 0;
        this.size = size;
        color = new Color(255, 255, 255);
        this.rect = rect;
        verticalAlignment = verAlign;
        horizontalAlignment = horAlign;
    }

    public int getHorizontalAlignment() {
        return horizontalAlignment;
    }

    public void setHorizontalAlignment(int horizontalAlignment) {
        this.horizontalAlignment = horizontalAlignment;
    }

    public int getVerticalAlignment() {
        return verticalAlignment;
    }

    public void setVerticalAlignment(int verticalAlignment) {
        this.verticalAlignment = verticalAlignment;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFont() {
        return font;
    }

    public void setFont(String font) {
        this.font = font;
    }

    public int getStyle() {
        return style;
    }

    public void setStyle(int style) {
        this.style = style;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Rect getRect() {
        return rect;
    }

    public void setRect(Rect rect) {
        this.rect = rect;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Label label = (Label) o;
        return style == label.style &&
                size == label.size &&
                verticalAlignment == label.verticalAlignment &&
                horizontalAlignment == label.horizontalAlignment &&
                text.equals(label.text) &&
                font.equals(label.font) &&
                color.equals(label.color) &&
                rect.equals(label.rect);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, font, style, size, color, rect, verticalAlignment, horizontalAlignment);
    }

    @JsonIgnore
    public String getColorAsHex() {
        String hexValue = "#";
        hexValue += Integer.toHexString(color.getR());
        hexValue += Integer.toHexString(color.getG());
        hexValue += Integer.toHexString(color.getB());
        return hexValue;
    }
}
