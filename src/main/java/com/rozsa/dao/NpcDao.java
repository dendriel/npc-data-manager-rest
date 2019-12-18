package com.rozsa.dao;

import com.rozsa.dao.api.DatabaseConnection;
import com.rozsa.model.Npc;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

@Service
public class NpcDao extends AbstractDao<Npc> {
    public static final String collectionName = "npcs";

    public NpcDao(DatabaseConnection db) {
        super(db, collectionName);
    }

    public Npc findById(ObjectId id) {
        return db.findById(id);
    }
}
