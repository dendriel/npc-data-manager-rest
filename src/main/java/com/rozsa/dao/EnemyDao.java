package com.rozsa.dao;

import com.rozsa.dao.api.DatabaseConnection;
import com.rozsa.model.Enemy;
import org.springframework.stereotype.Repository;

@Repository
public class EnemyDao extends AbstractDao<Enemy> {
    public static final String collectionName = "enemies";

    public EnemyDao(DatabaseConnection db) {
        super(db, Enemy.class, collectionName);
    }
}
