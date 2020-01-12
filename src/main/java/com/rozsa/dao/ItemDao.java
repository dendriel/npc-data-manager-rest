package com.rozsa.dao;

import com.rozsa.dao.api.DatabaseConnection;
import com.rozsa.model.GenericItem;
import org.springframework.stereotype.Repository;

@Repository
public class ItemDao extends AbstractDao<GenericItem> {
    public static final String collectionName = "items";

    public ItemDao(DatabaseConnection db) {
        super(db, GenericItem.class, collectionName);
    }
}
