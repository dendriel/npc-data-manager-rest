package com.rozsa.business;

import com.rozsa.dao.ItemDao;
import com.rozsa.model.Item;
import com.rozsa.model.ItemsHolder;

public class ImportItems extends ImportHolder<Item, ItemDao, ItemsHolder> {
    public ImportItems(ItemDao dao, String filePath) {
        super(dao, ItemsHolder.class, filePath);
    }
}
