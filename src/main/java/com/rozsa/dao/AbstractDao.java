package com.rozsa.dao;

import com.rozsa.dao.api.DatabaseConnection;

public abstract class AbstractDao {
    protected final DatabaseConnection db;

    public AbstractDao(DatabaseConnection db) {
        this.db = db;
    }
}
