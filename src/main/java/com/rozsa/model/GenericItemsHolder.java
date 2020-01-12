package com.rozsa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rozsa.dao.api.DataHolder;

import java.util.ArrayList;
import java.util.List;

public class GenericItemsHolder implements DataHolder<GenericItem> {
    private List<GenericItem> goldData;

    private List<GenericItem> valuableItemsData;

    private List<GenericItem> questItemsData;

    private List<GenericItem> wearableItemsData;

    private List<GenericItem> usableItemsData;

    public GenericItemsHolder() {}

//    public ItemsHolder(List<Item> items) {
//        setup(items);
//    }
//
//    private void setup(List<Item> items) {
//        goldData = items
//                .stream()
//                .filter(i -> i.typeOf("gold"))
//                .map(i -> )
//                .collect(Collectors.toList());
//    }

    public List<GenericItem> getGoldData() {
        return goldData;
    }

    public void setGoldData(List<GenericItem> goldData) {
        this.goldData = goldData;
    }

    public List<GenericItem> getValuableItemsData() {
        return valuableItemsData;
    }

    public void setValuableItemsData(List<GenericItem> valuableItemsData) {
        this.valuableItemsData = valuableItemsData;
    }

    public List<GenericItem> getQuestItemsData() {
        return questItemsData;
    }

    public void setQuestItemsData(List<GenericItem> questItemsData) {
        this.questItemsData = questItemsData;
    }

    public List<GenericItem> getWearableItemsData() {
        return wearableItemsData;
    }

    public void setWearableItemsData(List<GenericItem> wearableItemsData) {
        this.wearableItemsData = wearableItemsData;
    }

    public List<GenericItem> getUsableItemsData() {
        return usableItemsData;
    }

    public void setUsableItemsData(List<GenericItem> usableItemsData) {
        this.usableItemsData = usableItemsData;
    }

    @JsonIgnore
    public List<GenericItem> getData() {
        List<GenericItem> allItems = new ArrayList<>();
        goldData.forEach(i -> i.setType("gold"));
        allItems.addAll(goldData);
        valuableItemsData.forEach(i -> i.setType("valuable"));
        allItems.addAll(valuableItemsData);
        questItemsData.forEach(i -> i.setType("quest"));
        allItems.addAll(questItemsData);
        wearableItemsData.forEach(i -> i.setType("wearable"));
        allItems.addAll(wearableItemsData);
        usableItemsData.forEach(i -> i.setType("usable"));
        allItems.addAll(usableItemsData);

        return allItems;
    }
}
