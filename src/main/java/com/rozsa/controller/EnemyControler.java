package com.rozsa.controller;

import com.rozsa.dao.EnemyDao;
import com.rozsa.model.Enemy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/rest/enemy")
public class EnemyControler extends BaseController<Enemy> {
    public EnemyControler(EnemyDao enemyDao) {
        super(enemyDao);
    }
}
