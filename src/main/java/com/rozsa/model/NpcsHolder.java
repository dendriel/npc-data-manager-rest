package com.rozsa.model;

import com.rozsa.dao.api.DataHolder;

import java.util.List;

public class NpcsHolder implements DataHolder<Npc> {
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
