package com.rozsa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rozsa.dao.api.Identifiable;
import org.bson.codecs.pojo.annotations.BsonIgnore;
import org.bson.types.ObjectId;

public class Item implements Identifiable<ObjectId> {
    private String type;

    private ObjectId id;

    private long uid;

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

    public Item() {}

    @JsonIgnore
    @BsonIgnore
    public ObjectId getObjectId() {
        return id;
    }

    @JsonIgnore
    public ObjectId getId() {
        return id;
    }

    @JsonIgnore
    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getIdAsText() {
        return id.toString();
    }

    public void setIdAsText(String idAsText) {
        if (idAsText != null && !idAsText.isEmpty()) {
            id = new ObjectId(idAsText);
        }
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
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
