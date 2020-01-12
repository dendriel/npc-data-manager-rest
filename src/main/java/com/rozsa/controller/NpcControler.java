package com.rozsa.controller;

import com.rozsa.business.ExportNpcs;
import com.rozsa.business.ImportNpcs;
import com.rozsa.dao.NpcDao;
import com.rozsa.model.Npc;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.List;

@RestController
@RequestMapping("/npc")
public class NpcControler {
    private final NpcDao npcDao;

    public NpcControler(NpcDao npcDao) {
        this.npcDao = npcDao;
    }

    //@CrossOrigin(origins = "http://localhost:9090")
    @RequestMapping("/getAll")
    public List<Npc> getAll() {
        return npcDao.findAll();
    }

    @RequestMapping("/get")
    public Npc get(@RequestParam(value="id") ObjectId id) {
        return npcDao.findById(id);
    }

    @RequestMapping("/getById")
    public Npc getById(int id) {
        return npcDao.findAll().get(0);
    }

    @RequestMapping("/save")
    public Npc save(@RequestBody Npc npc) {
        System.out.println("Save npc " + npc.getName());
        return npcDao.save(npc);
    }

    @RequestMapping("/delete")
    public boolean delete(@RequestParam(value="id") String idAsText) {
        System.out.println("Delete npc " + idAsText);

        if (idAsText == null || idAsText.isEmpty()) {
            throw new InvalidParameterException("Null or empty NPC id!");
        }

        ObjectId id = new ObjectId(idAsText);

        return npcDao.deleteById(id);
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
