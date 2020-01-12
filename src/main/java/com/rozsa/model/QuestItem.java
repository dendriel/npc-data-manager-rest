package com.rozsa.model;


public class QuestItem extends Item {
    public QuestItem() {
        super("quest");
    }

    public static QuestItem from(GenericItem generic) {
        QuestItem item = new QuestItem();
        Item.copyFrom(item, generic);
        return item;
    }
}
