package com.rozsa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Sprite {
    private String imageFile;
    private int order;
    private Offset offset;
    private Scale scale;
    private Size size;
    private boolean enabled;
    private boolean isFlipX;
    private boolean isFlipY;

    public Sprite() {
        offset = new Offset(0, 0);
        scale = new Scale(1, 1);
        enabled = true;
        order = 0;
    }

    public String getImageFile() {
        return imageFile;
    }

    public void setImageFile(String imageFile) {
        this.imageFile = imageFile;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public Offset getOffset() {
        return offset;
    }

    public void setOffset(Offset offset) {
        this.offset = offset;
    }

    public Scale getScale() {
        return scale;
    }

    public void setScale(Scale scale) {
        this.scale = scale;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    @JsonIgnore
    public String getEnabledAsText() {
        return enabled ? "checked" : "";
    }

    public boolean isFlipX() {
        return isFlipX;
    }

    public void setFlipX(boolean flipX) {
        isFlipX = flipX;
    }

    public boolean isFlipY() {
        return isFlipY;
    }

    public void setFlipY(boolean flipY) {
        isFlipY = flipY;
    }
}
