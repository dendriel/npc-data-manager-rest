package com.rozsa.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PassiveNpc extends Npc {
    private List<Integer> interactionOrder;
    private List<Interaction> interactionData;
    private boolean active;

    public PassiveNpc() {
        interactionOrder = new ArrayList<>();
        interactionData = new ArrayList<>();
        active = true;
    }
}
