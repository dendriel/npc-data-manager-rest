package com.rozsa.dao;

import com.rozsa.dao.api.DatabaseConnection;
import com.rozsa.dao.api.Identifiable;
import org.bson.types.ObjectId;

import java.util.List;

public abstract class AbstractDao<TType extends Identifiable> {
    protected final DatabaseConnection db;

    protected final String collectionName;

    private Class<TType> objKind;

    public AbstractDao(DatabaseConnection db, Class<TType> kind, String collectionName) {
        this.db = db;
        this.objKind = kind;
        this.collectionName = collectionName;
    }

    public TType save(TType obj) {
        if (obj.getObjectId() == null) {
            return db.create(obj, objKind, collectionName);
        }
        return db.update(obj, objKind, collectionName);
    }

    public void save(List<TType> obj) {
        obj.forEach(this::save);
    }

    public TType findById(ObjectId id) {
        return db.findById(id, objKind, collectionName);
    }

    public List<TType> findAll() {
        return db.findAll(objKind, collectionName);
    }

    public boolean deleteById(ObjectId id) {
        return db.deleteById(id, objKind, collectionName);
    }
}
