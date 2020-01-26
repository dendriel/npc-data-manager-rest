package com.rozsa.model;

import java.util.List;

public class LootHolder {
    private String name;

    private int uid;

    private int chance;

    private List<LootData> loot;

    public List<LootData> getLoot() {
        return loot;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setLoot(List<LootData> loot) {
        this.loot = loot;
    }

    public int getChance() {
        return chance;
    }

    public void setChance(int chance) {
        this.chance = chance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
