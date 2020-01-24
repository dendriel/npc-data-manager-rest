package com.rozsa.model;

import java.util.ArrayList;
import java.util.List;

public class PassiveNpc extends Npc {

    private List<Integer> interactionOrder;

    private List<Interaction> interactionData;

    public PassiveNpc() {
        interactionOrder = new ArrayList<>();
        interactionData = new ArrayList<>();
    }

    public List<Interaction> getInteractionData() {
        return interactionData;
    }

    public void setInteractionData(List<Interaction> Interaction) {
        this.interactionData = Interaction;
    }

    public List<Integer> getInteractionOrder() {
        return interactionOrder;
    }

    public void setInteractionOrder(List<Integer> interactionOrder) {
        this.interactionOrder = interactionOrder;
    }
}
