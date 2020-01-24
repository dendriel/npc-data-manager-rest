package com.rozsa.business;

import com.rozsa.model.Npc;
import com.rozsa.model.PassiveNpc;
import com.rozsa.model.PassiveNpcsHolder;
import com.rozsa.parser.JsonWriter;

import java.io.IOException;
import java.util.List;

public class ExportPassiveNpcs {
    private final String dataFilePath;

    private final List<PassiveNpc> npcs;

    public ExportPassiveNpcs(String dataFilePath, List<PassiveNpc> npcs) {
        this.dataFilePath = dataFilePath;
        this.npcs = npcs;
    }

    public int execute() throws IOException {
        PassiveNpcsHolder passiveNpcsHolder = new PassiveNpcsHolder(npcs);
        JsonWriter writer = new JsonWriter(dataFilePath);
        writer.write(passiveNpcsHolder);
        return passiveNpcsHolder.getData().size();
    }
}
