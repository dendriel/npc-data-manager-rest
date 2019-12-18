package com.rozsa.dao;

import com.rozsa.dao.api.DatabaseConnection;
import com.rozsa.model.Npc;
import org.springframework.stereotype.Service;

@Service
public class NpcDao extends AbstractDao {

    public NpcDao(DatabaseConnection db) {
        super(db);
    }

//    public Npc getById(int id) {
//
//    }

    public void save(Npc npc) {
        System.out.println("Saving npc");
        db.save(npc);
        System.out.println("Npc saved!");
    }

    public Npc findById(int id) {
        return db.findById(id);
    }
}
