package com.rozsa.controller;

import com.rozsa.dao.NpcDao;
import com.rozsa.model.Npc;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NpcControler {
    private final NpcDao npcDao;

    public NpcControler(NpcDao npcDao) {
        this.npcDao = npcDao;
    }

    @RequestMapping("/npc/getAll")
    public List<Npc> getAll() {
        return npcDao.findAll();
    }

    @RequestMapping("/npc/get")
    public Npc get(@RequestParam(value="id") ObjectId id) {
        return npcDao.findById(id);
    }

    @RequestMapping("/npc/save")
    //public void save(@RequestParam(value="npc") Npc npc) {
    public void save() {
        //System.out.println("Save npc " + npc.getName());
        npcDao.save(new Npc());
    }

    @RequestMapping("/npc/delete")
    public boolean delete(@RequestParam(value="id") ObjectId id) {
        System.out.println("Delete npc " + id);
        return npcDao.deleteById(id);
    }
}
