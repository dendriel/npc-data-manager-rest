package com.rozsa.controller;

import com.rozsa.business.ImportItems;
import com.rozsa.dao.ItemDao;
import com.rozsa.model.Item;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
public class ItemController extends BaseController<Item> {
    private final ItemDao itemDao;

    public ItemController(ItemDao itemDao) {
        super(itemDao);
        this.itemDao = itemDao;
    }

    @RequestMapping("/import")
    public int importFromFile(@RequestBody String filePath) {
        System.out.println("Import data into database from " + filePath);
        ImportItems importItems = new ImportItems(itemDao, filePath);
        return importItems.execute();
    }
//    @RequestMapping("/import")
//    public int importFromFile() {
//        String filePath = "E:\\workspace\\Java\\the-quest\\src\\com\\thequest\\resources\\data\\items_data.json";
//        System.out.println("Import data into database from " + filePath);
//        ImportItems importItems = new ImportItems(itemDao, filePath);
//        return importItems.execute();
//    }
}
