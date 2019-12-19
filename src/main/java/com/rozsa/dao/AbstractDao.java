package com.rozsa.dao;

import com.rozsa.dao.api.DatabaseConnection;
import org.bson.types.ObjectId;

import java.util.List;

public abstract class AbstractDao<TType> {
    protected final DatabaseConnection db;

    protected final String collectionName;

    private Class<TType> objKind;

    public AbstractDao(DatabaseConnection db, Class<TType> kind, String collectionName) {
        this.db = db;
        this.objKind = kind;
        this.collectionName = collectionName;
    }

    public TType save(TType obj) {
        db.save(obj, objKind, collectionName);
        return obj;
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
