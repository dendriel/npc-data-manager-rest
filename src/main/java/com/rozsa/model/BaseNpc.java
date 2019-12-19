package com.rozsa.model;

import org.bson.types.ObjectId;

public class BaseNpc {
    private ObjectId id;

    private long uid;

    private String name;

    private int behaviorId;

    private boolean isFacingRight;

    private Status status;

    private Sprite sprite;

    public BaseNpc() {
    }

    public BaseNpc(ObjectId id) {
        this.id = id;
        status = new Status();
        sprite = new Sprite();
        name = "FIX ME";
        behaviorId = 2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBehaviorId() {
        return behaviorId;
    }

    public void setBehaviorId(int behaviorId) {
        this.behaviorId = behaviorId;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite spriteData) {
        this.sprite = spriteData;
    }

    @Override
    public String toString() {
        return name;
    }

    public boolean isFacingRight() {
        return isFacingRight;
    }

    public void setFacingRight(boolean facingRight) {
        isFacingRight = facingRight;
    }
}
