package com.rozsa.business;

import com.rozsa.model.GenericItem;
import com.rozsa.model.ItemsHolder;
import com.rozsa.parser.JsonWriter;

import java.io.IOException;
import java.util.List;

public class ExportItems {
    private final String dataFilePath;

    private final List<GenericItem> items;

    public ExportItems(String dataFilePath, List<GenericItem> items) {
        this.dataFilePath = dataFilePath;
        this.items = items;
    }

    public int execute() throws IOException {
        ItemsHolder holder = new ItemsHolder(items);
        JsonWriter writer = new JsonWriter(dataFilePath);
        writer.write(holder);
        return holder.getData().size();
    }
}
