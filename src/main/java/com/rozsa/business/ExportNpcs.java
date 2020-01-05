package com.rozsa.business;

import com.rozsa.model.Npc;
import com.rozsa.model.NpcsHolder;
import com.rozsa.parser.JsonWriter;

import java.io.IOException;
import java.util.List;

public class ExportNpcs {
    private final String dataFilePath;

    private final List<Npc> npcs;

    public ExportNpcs(String dataFilePath, List<Npc> npcs) {
        this.dataFilePath = dataFilePath;
        this.npcs = npcs;
    }

    public int execute() throws IOException {
        NpcsHolder npcsHolder = new NpcsHolder(npcs);
        JsonWriter writer = new JsonWriter(dataFilePath);
        writer.write(npcsHolder);
        return npcsHolder.getData().size();
    }
}
