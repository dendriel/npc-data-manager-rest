package com.rozsa.business;

import com.rozsa.dao.ItemDao;
import com.rozsa.model.GenericItem;
import com.rozsa.model.GenericItemsHolder;

public class ImportItems extends ImportHolder<GenericItem, ItemDao, GenericItemsHolder> {
    public ImportItems(ItemDao dao, String filePath) {
        super(dao, GenericItemsHolder.class, filePath);
    }
}
