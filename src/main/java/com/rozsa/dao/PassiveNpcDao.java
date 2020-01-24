package com.rozsa.dao;

import com.rozsa.dao.api.DatabaseConnection;
import com.rozsa.model.PassiveNpc;
import org.springframework.stereotype.Repository;

@Repository
public class PassiveNpcDao extends AbstractDao<PassiveNpc> {
    public static final String collectionName = "npcs";

    public PassiveNpcDao(DatabaseConnection db) {
        super(db, PassiveNpc.class, collectionName);
    }
}
