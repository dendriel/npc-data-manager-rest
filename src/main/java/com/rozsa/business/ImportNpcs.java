package com.rozsa.business;

import com.rozsa.dao.NpcDao;
import com.rozsa.model.Npc;
import com.rozsa.model.NpcsHolder;

public class ImportNpcs extends ImportHolder<Npc, NpcDao, NpcsHolder> {
    public ImportNpcs(NpcDao dao, String filePath) {
        super(dao, NpcsHolder.class, filePath);
    }
}
