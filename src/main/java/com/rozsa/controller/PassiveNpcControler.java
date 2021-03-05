package com.rozsa.controller;

import com.rozsa.business.ExportPassiveNpcs;
import com.rozsa.dao.PassiveNpcDao;
import com.rozsa.model.PassiveNpc;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/rest/npc")
public class PassiveNpcControler extends BaseController<PassiveNpc> {
    private final PassiveNpcDao passiveNpcDao;

    public PassiveNpcControler(PassiveNpcDao passiveNpcDao) {
        super(passiveNpcDao);
        this.passiveNpcDao = passiveNpcDao;
    }

    @RequestMapping("/export")
    public int exportToFile(@RequestBody String filePath) throws IOException {
        System.out.println("Export data into database from " + filePath);
        List<PassiveNpc> npcs = passiveNpcDao.findAll();
        ExportPassiveNpcs exportPassiveNpcs = new ExportPassiveNpcs(filePath, npcs);
        return exportPassiveNpcs.execute();
    }
}
