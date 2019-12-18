package com.rozsa.dao;

import com.rozsa.dao.api.DatabaseConnection;

@SuppressWarnings("unchecked")
public abstract class AbstractDao<TType> {
    protected final DatabaseConnection db;

    protected final String collectionName;

    public AbstractDao(DatabaseConnection db, String collectionName) {
        this.db = db;
        this.collectionName = collectionName;
    }

    public TType save(TType obj) {
        db.save(obj, (Class)obj.getClass(), collectionName);
        return obj;
    }
}
