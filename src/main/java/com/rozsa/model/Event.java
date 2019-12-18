package com.rozsa.model;

public class Event {
    private EventType type;

    private String key;

    private Boolean value;

    private int targetX;

    private int targetY;

    public EventType getType() {
        if (type == null) {
            type = EventType.SWITCH;
        }
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Boolean getValue() {
        return value;
    }

    public void setValue(Boolean value) {
        this.value = value;
    }

    public int getTargetX() {
        return targetX;
    }

    public void setTargetX(int targetX) {
        this.targetX = targetX;
    }

    public int getTargetY() {
        return targetY;
    }

    public void setTargetY(int targetY) {
        this.targetY = targetY;
    }
}
