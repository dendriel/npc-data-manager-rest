package com.rozsa.controller;

import com.rozsa.dao.NpcDao;
import com.rozsa.model.Npc;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NpcControler {
    private final NpcDao npcDao;

    public NpcControler(NpcDao npcDao) {
        this.npcDao = npcDao;
    }

    @RequestMapping("/npc/getAll")
    public Npc[] getAll() {
        return new Npc[] { new Npc(0), new Npc(1) };
    }

    @RequestMapping("/npc/get")
    public Npc get(@RequestParam(value="id") int id) {

        return npcDao.findById(id);
    }

    @RequestMapping("/npc/save")
    public void save(@RequestParam(value="npc") Npc npc) {
        System.out.println("Save npc " + npc.getName());

        npcDao.save(new Npc(12345));
    }

    @RequestMapping("/npc/delete")
    public void delete(@RequestParam(value="id") int id) {
        System.out.println("Delete npc " + id);
    }
}
