package com.rozsa.controller;

import com.rozsa.dao.ItemDao;
import com.rozsa.model.GenericItem;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/rest/item")
public class ItemController extends BaseController<GenericItem> {
    public ItemController(ItemDao itemDao) {
        super(itemDao);
    }
}
