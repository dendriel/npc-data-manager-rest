package com.rozsa.controller;

import com.rozsa.dao.NpcDao;
import com.rozsa.model.Npc;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

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
    public void save(@RequestBody Npc npc) {
        //System.out.println("Save npc " + npc.getName());
        npcDao.save(npc);
    }

    @RequestMapping("/npc/testsave")
    public void test() {
        //System.out.println("Save npc " + npc.getName());
        npcDao.save(new Npc());
    }


    @RequestMapping("/npc/delete")
    public boolean delete(@RequestParam(value="id") ObjectId id) {
        System.out.println("Delete npc " + id);
        return npcDao.deleteById(id);
    }
}
