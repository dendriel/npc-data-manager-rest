package com.rozsa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rozsa.dao.api.DataHolder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ItemsHolder implements DataHolder<Item> {
    private List<GoldItem> goldData;

    private List<ValuableItem> valuableItemsData;

    private List<QuestItem> questItemsData;

    private List<WearableItem> wearableItemsData;

    private List<UsableItem> usableItemsData;

    public ItemsHolder() {}

    public ItemsHolder(List<GenericItem> items) {
        setup(items);
    }

    private void setup(List<GenericItem> items) {
        goldData = filter(items, "gold", GoldItem::from);
        valuableItemsData = filter(items, "valuable", ValuableItem::from);
        questItemsData = filter(items, "quest", QuestItem::from);
        wearableItemsData = filter(items, "wearable", WearableItem::from);
        usableItemsData = filter(items, "usable", UsableItem::from);
    }

    private <T> List<T> filter(List<GenericItem> items, String type, MapItem<T> map) {
        return items
                .stream()
                .filter(i -> i.typeOf(type))
                .map(map::execute)
                .collect(Collectors.toList());
    }

    private interface MapItem<T> {
        T execute(GenericItem item);
    }

    @JsonIgnore
    public List<GoldItem> getGoldData() {
        return goldData;
    }

    public void setGoldData(List<GoldItem> goldData) {
        this.goldData = goldData;
    }

    @JsonIgnore
    public List<ValuableItem> getValuableItemsData() {
        return valuableItemsData;
    }

    public void setValuableItemsData(List<ValuableItem> valuableItemsData) {
        this.valuableItemsData = valuableItemsData;
    }

    @JsonIgnore
    public List<QuestItem> getQuestItemsData() {
        return questItemsData;
    }

    public void setQuestItemsData(List<QuestItem> questItemsData) {
        this.questItemsData = questItemsData;
    }

    @JsonIgnore
    public List<WearableItem> getWearableItemsData() {
        return wearableItemsData;
    }

    public void setWearableItemsData(List<WearableItem> wearableItemsData) {
        this.wearableItemsData = wearableItemsData;
    }
    @JsonIgnore
    public List<UsableItem> getUsableItemsData() {
        return usableItemsData;
    }

    public void setUsableItemsData(List<UsableItem> usableItemsData) {
        this.usableItemsData = usableItemsData;
    }


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
