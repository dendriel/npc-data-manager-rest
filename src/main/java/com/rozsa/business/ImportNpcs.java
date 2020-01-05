package com.rozsa.business;

import com.rozsa.dao.NpcDao;
import com.rozsa.model.Npc;
import com.rozsa.model.NpcsHolder;

import java.util.List;

public class ImportNpcs {
    private final NpcDao npcDao;

    private final String filePath;

    public ImportNpcs(NpcDao npcDao, String filePath) {
        this.npcDao = npcDao;
        this.filePath = filePath;
    }

    public int execute() {
        NpcsHolder npcsHolder = loadFromFile();
        if (npcsHolder == null) {
            return 0;
        }

        return saveToDatabase(npcsHolder);
    }

    private NpcsHolder loadFromFile() {
        LoadNpcs loadNpcs = new LoadNpcs(filePath);
        return loadNpcs.execute();
    }

    private int saveToDatabase(NpcsHolder npcsHolder) {
        List<Npc> data = npcsHolder.getData();
        npcDao.save(data);
        return data.size();
    }
}
