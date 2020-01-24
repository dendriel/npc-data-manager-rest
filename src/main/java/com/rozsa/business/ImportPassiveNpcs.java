package com.rozsa.business;

import com.rozsa.dao.PassiveNpcDao;
import com.rozsa.model.PassiveNpc;
import com.rozsa.model.PassiveNpcsHolder;

public class ImportPassiveNpcs extends ImportHolder<PassiveNpc, PassiveNpcDao, PassiveNpcsHolder> {
    public ImportPassiveNpcs(PassiveNpcDao dao, String filePath) {
        super(dao, PassiveNpcsHolder.class, filePath);
    }
}
