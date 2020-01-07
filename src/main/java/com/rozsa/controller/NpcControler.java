package com.rozsa.controller;

import com.rozsa.business.ExportNpcs;
import com.rozsa.business.ImportNpcs;
import com.rozsa.dao.NpcDao;
import com.rozsa.model.Npc;
import com.rozsa.model.NpcsHolder;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.List;

@RestController
public class NpcControler {
    private final NpcDao npcDao;

    public NpcControler(NpcDao npcDao) {
        this.npcDao = npcDao;
    }

    //@CrossOrigin(origins = "http://localhost:9090")
    @RequestMapping("/npc/getAll")
    public List<Npc> getAll() {
        return npcDao.findAll();
    }

    @RequestMapping("/npc/get")
    public Npc get(@RequestParam(value="id") ObjectId id) {
        return npcDao.findById(id);
    }

    @RequestMapping("/npc/getById")
    public Npc getById(int id) {
        return npcDao.findAll().get(0);
    }

    @RequestMapping("/npc/save")
    public Npc save(@RequestBody Npc npc) {
        System.out.println("Save npc " + npc.getName());
        return npcDao.save(npc);
    }

    @RequestMapping("/npc/testsave")
    public void test() {
        //System.out.println("Save npc " + npc.getName());
        npcDao.save(new Npc());
    }


    @RequestMapping("/npc/delete")
    public boolean delete(@RequestParam(value="id") String idAsText) {
        System.out.println("Delete npc " + idAsText);

        if (idAsText == null || idAsText.isEmpty()) {
            throw new InvalidParameterException("Null or empty NPC id!");
        }

        ObjectId id = new ObjectId(idAsText);

        return npcDao.deleteById(id);
    }

    @RequestMapping("/npc/import")
    public int importFromFile(String filePath) {
        filePath = "E:\\workspace\\Java\\the-quest\\src\\com\\thequest\\resources\\data\\npcs_data.json";
        System.out.println("Import data into database from " + filePath);
        ImportNpcs importNpcs = new ImportNpcs(npcDao, filePath);
        return importNpcs.execute();
    }

    @RequestMapping("/npc/export")
    public int exportToFile(@RequestBody String filePath) throws IOException {
        System.out.println("Export data into database from " + filePath);
        List<Npc> npcs = npcDao.findAll();
        ExportNpcs exportNpcs = new ExportNpcs(filePath, npcs);
        return exportNpcs.execute();
    }
}
