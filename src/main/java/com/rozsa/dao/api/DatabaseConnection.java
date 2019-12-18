package com.rozsa.dao.api;

import com.rozsa.model.Npc;
import org.bson.types.ObjectId;

public interface DatabaseConnection {
    <T> T save(T npc, Class<T> kind, String collection);

    // TODO: make if generic
    Npc findById(ObjectId id);
}
