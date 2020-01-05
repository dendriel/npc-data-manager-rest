package com.rozsa.model;

import java.util.List;

public class NpcsHolder {
    private List<Npc> data;

    public NpcsHolder() {}

    public NpcsHolder(List<Npc> data) {
        this.data = data;
    }

    public List<Npc> getData() {
        return data;
    }

    public void setData(List<Npc> data) {
        this.data = data;
    }
}
