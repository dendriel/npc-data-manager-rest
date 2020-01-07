package com.rozsa.dao.api;

import org.bson.types.ObjectId;

import java.util.List;

public interface DatabaseConnection {
    <T> T create(T npc, Class<T> kind, String collection);

    <T extends Identifiable> T update(T obj, Class<T> kind, String collection);

    <T> T findById(ObjectId id, Class<T> kind, String collection);

    <T> List<T> findAll(Class<T> kind, String collection);

    <T> boolean deleteById(ObjectId id, Class<T> kind, String collection);
}
