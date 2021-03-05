package com.rozsa.controller;

import com.rozsa.business.ExportEnemies;
import com.rozsa.dao.EnemyDao;
import com.rozsa.model.Enemy;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/rest/enemy")
public class EnemyControler extends BaseController<Enemy> {
    private final EnemyDao enemyDao;

    public EnemyControler(EnemyDao enemyDao) {
        super(enemyDao);
        this.enemyDao = enemyDao;
    }

    @RequestMapping("/export")
    public int exportToFile(@RequestBody String filePath) throws IOException {
        System.out.println("Export data into database from " + filePath);
        List<Enemy> enemies = enemyDao.findAll();
        ExportEnemies exportEnemies = new ExportEnemies(filePath, enemies);
        return exportEnemies.execute();
    }
}
