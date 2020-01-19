package com.rozsa.model;

public class Aim {
    private Sprite aimSprite;

    public Aim() {
        aimSprite = new Sprite();
    }

    public Sprite getAimSprite() {
        return aimSprite;
    }

    public void setAimSprite(Sprite aimSprite) {
        this.aimSprite = aimSprite;
    }
}
