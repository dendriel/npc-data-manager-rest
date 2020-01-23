package com.rozsa.business;

import com.rozsa.model.EnemiesHolder;
import com.rozsa.model.Enemy;
import com.rozsa.parser.JsonWriter;

import java.io.IOException;
import java.util.List;

public class ExportEnemies {
    private final String dataFilePath;

    private final List<Enemy> enemies;

    public ExportEnemies(String dataFilePath, List<Enemy> enemies) {
        this.dataFilePath = dataFilePath;
        this.enemies = enemies;
    }

    public int execute() throws IOException {
        EnemiesHolder enemiesHolder = new EnemiesHolder(enemies);
        JsonWriter writer = new JsonWriter(dataFilePath);
        writer.write(enemiesHolder);
        return enemiesHolder.getData().size();
    }
}
