package com.rozsa.controller;

import com.rozsa.dao.ItemDao;
import com.rozsa.dao.api.DataHolder;
import com.rozsa.model.GenericItem;
import com.rozsa.model.ItemsHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/rest/item")
public class ItemController extends BaseController<GenericItem> {
    public ItemController(ItemDao itemDao) {
        super(itemDao);
    }

    @Override
    public DataHolder<GenericItem> createDataHolder(List<GenericItem> entities) {
        return new ItemsHolder(entities);
    }
}
