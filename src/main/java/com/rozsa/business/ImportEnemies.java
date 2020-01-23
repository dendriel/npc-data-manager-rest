package com.rozsa.business;

import com.rozsa.dao.EnemyDao;
import com.rozsa.model.EnemiesHolder;
import com.rozsa.model.Enemy;

public class ImportEnemies extends ImportHolder<Enemy, EnemyDao, EnemiesHolder> {
    public ImportEnemies(EnemyDao dao, String filePath) {
        super(dao, EnemiesHolder.class, filePath);
    }
}
