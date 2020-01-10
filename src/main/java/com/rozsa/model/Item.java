package com.rozsa.model;

public class Item {
    private final String type;

    private int id;

    private int level;

    private String name;

    private String description;

    private Sprite spriteData;

    private Icon iconData;

    private int count;

    private int maximumStack;

    private int price;

    public Item(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getMaximumStack() {
        return maximumStack;
    }

    public void setMaximumStack(int maximumStack) {
        this.maximumStack = maximumStack;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Sprite getSpriteData() {
        return spriteData;
    }

    public void setSpriteData(Sprite spriteData) {
        this.spriteData = spriteData;
    }

    public Icon getIconData() {
        return iconData;
    }

    public void setIconData(Icon iconData) {
        this.iconData = iconData;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
