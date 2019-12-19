package com.rozsa.dao;

import com.rozsa.dao.api.DatabaseConnection;
import com.rozsa.model.Npc;
import org.springframework.stereotype.Service;

@Service
public class NpcDao extends AbstractDao<Npc> {
    public static final String collectionName = "npcs";

    public NpcDao(DatabaseConnection db) {
        super(db, Npc.class, collectionName);
    }
}
