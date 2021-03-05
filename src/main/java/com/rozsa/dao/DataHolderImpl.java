package com.rozsa.dao;

import com.rozsa.dao.api.DataHolder;

import java.util.List;

public class DataHolderImpl<T> implements DataHolder<T> {
    private List<T> data;

    public void setData(List<T> data) {
        this.data = data;
    }

    @Override
    public List<T> getData() {
        return data;
    }
}
