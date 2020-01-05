package com.rozsa.model;

import java.util.List;

public class LootHolder {
    private String name;

    private String lootItemHolder;

    private int chance;

    private List<LootData> loot;

    public List<LootData> getLoot() {
        return loot;
    }

    public String getLootItemHolder() {
        return lootItemHolder;
    }

    public void setLootItemHolder(String lootItemHolder) {
        this.lootItemHolder = lootItemHolder;
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

    public int getId() {
        return 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
