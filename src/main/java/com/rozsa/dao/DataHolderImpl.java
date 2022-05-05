package com.rozsa.dao;

import com.rozsa.dao.api.DataHolder;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DataHolderImpl<T> implements DataHolder<T> {
    private List<T> data;
}
