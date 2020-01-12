package com.rozsa.dao;

import com.rozsa.dao.api.DatabaseConnection;
import com.rozsa.model.Item;
import org.springframework.stereotype.Repository;

@Repository
public class ItemDao extends AbstractDao<Item> {
    public static final String collectionName = "items";

    public ItemDao(DatabaseConnection db) {
        super(db, Item.class, collectionName);
    }
}
