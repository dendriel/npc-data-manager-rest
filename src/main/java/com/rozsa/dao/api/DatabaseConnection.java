package com.rozsa.dao.api;

import com.rozsa.model.Npc;

public interface DatabaseConnection {
    void save(Npc npc);

    Npc findById(int id);
}
