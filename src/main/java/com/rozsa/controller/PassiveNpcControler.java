package com.rozsa.controller;

import com.rozsa.dao.PassiveNpcDao;
import com.rozsa.model.PassiveNpc;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/rest/npc")
public class PassiveNpcControler extends BaseController<PassiveNpc> {
    public PassiveNpcControler(PassiveNpcDao passiveNpcDao) {
        super(passiveNpcDao);
    }
}
