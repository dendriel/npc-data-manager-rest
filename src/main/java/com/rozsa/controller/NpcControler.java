package com.rozsa.controller;

import com.rozsa.business.ExportNpcs;
import com.rozsa.business.ImportNpcs;
import com.rozsa.dao.NpcDao;
import com.rozsa.model.Npc;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/npc")
public class NpcControler extends BaseController<Npc> {
    private final NpcDao npcDao;

    public NpcControler(NpcDao npcDao) {
        super(npcDao);
        this.npcDao = npcDao;
    }

    @RequestMapping("/import")
    public int importFromFile(@RequestBody String filePath) {
        System.out.println("Import data into database from " + filePath);
        ImportNpcs importNpcs = new ImportNpcs(npcDao, filePath);
        return importNpcs.execute();
    }

    @RequestMapping("/export")
    public int exportToFile(@RequestBody String filePath) throws IOException {
        System.out.println("Export data into database from " + filePath);
        List<Npc> npcs = npcDao.findAll();
        ExportNpcs exportNpcs = new ExportNpcs(filePath, npcs);
        return exportNpcs.execute();
    }
}
