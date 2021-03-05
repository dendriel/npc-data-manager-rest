package com.rozsa.controller;

import com.rozsa.business.ExportItems;
import com.rozsa.dao.ItemDao;
import com.rozsa.model.GenericItem;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/rest/item")
public class ItemController extends BaseController<GenericItem> {
    private final ItemDao itemDao;

    public ItemController(ItemDao itemDao) {
        super(itemDao);
        this.itemDao = itemDao;
    }

    @RequestMapping("/export")
    public int exportToFile(@RequestBody String filePath) throws IOException {
        System.out.println("Export data into database from " + filePath);
        List<GenericItem> items = itemDao.findAll();
        ExportItems export = new ExportItems(filePath, items);
        return export.execute();
    }

//    @RequestMapping("/export")
//    public int exportToFile() throws IOException {
//        String filePath = "E:\\workspace\\Java\\the-quest\\src\\com\\thequest\\resources\\data\\items_data.json";
//        System.out.println("Export data into database from " + filePath);
//        List<GenericItem> items = itemDao.findAll();
//        ExportItems export = new ExportItems(filePath, items);
//        return export.execute();
//    }
}
