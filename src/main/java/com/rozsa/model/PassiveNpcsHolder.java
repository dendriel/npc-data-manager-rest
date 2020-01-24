package com.rozsa.model;

import com.rozsa.dao.api.DataHolder;

import java.util.List;

public class PassiveNpcsHolder implements DataHolder<PassiveNpc> {
    private List<PassiveNpc> data;

    public PassiveNpcsHolder() {}

    public PassiveNpcsHolder(List<PassiveNpc> data) {
        this.data = data;
    }

    public List<PassiveNpc> getData() {
        return data;
    }

    public void setData(List<PassiveNpc> data) {
        this.data = data;
    }
}
