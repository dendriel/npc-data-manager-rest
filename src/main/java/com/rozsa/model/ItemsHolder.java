package com.rozsa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rozsa.dao.api.DataHolder;

import java.util.ArrayList;
import java.util.List;

public class ItemsHolder implements DataHolder<Item> {
    private List<GoldItem> goldData;

    private List<ValuableItem> valuableItemsData;

    private List<QuestItem> questItemsData;

    private List<WearableItem> wearableItemsData;

    private List<UsableItem> usableItemsData;

    public List<GoldItem> getGoldData() {
        return goldData;
    }

    public void setGoldData(List<GoldItem> goldData) {
        this.goldData = goldData;
    }

    public List<ValuableItem> getValuableItemsData() {
        return valuableItemsData;
    }

    public void setValuableItemsData(List<ValuableItem> valuableItemsData) {
        this.valuableItemsData = valuableItemsData;
    }

    public List<QuestItem> getQuestItemsData() {
        return questItemsData;
    }

    public void setQuestItemsData(List<QuestItem> questItemsData) {
        this.questItemsData = questItemsData;
    }

    public List<WearableItem> getWearableItemsData() {
        return wearableItemsData;
    }

    public void setWearableItemsData(List<WearableItem> wearableItemsData) {
        this.wearableItemsData = wearableItemsData;
    }

    public List<UsableItem> getUsableItemsData() {
        return usableItemsData;
    }

    public void setUsableItemsData(List<UsableItem> usableItemsData) {
        this.usableItemsData = usableItemsData;
    }

    @JsonIgnore
    public List<Item> getData() {
        List<Item> allItems = new ArrayList<>();
        allItems.addAll(goldData);
        allItems.addAll(valuableItemsData);
        allItems.addAll(questItemsData);
        allItems.addAll(wearableItemsData);
        allItems.addAll(usableItemsData);

        return allItems;
    }
}
