package com.rozsa.model;

import com.rozsa.dao.api.DataHolder;

import java.util.List;

public class EnemiesHolder implements DataHolder<Enemy> {
    private List<Enemy> data;

    public EnemiesHolder() {}

    public EnemiesHolder(List<Enemy> data) {
        this.data = data;
    }

    public List<Enemy> getData() {
        return data;
    }

    public void setData(List<Enemy> data) {
        this.data = data;
    }
}
