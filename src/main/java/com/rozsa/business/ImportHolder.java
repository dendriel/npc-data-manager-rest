package com.rozsa.business;

import com.rozsa.dao.AbstractDao;
import com.rozsa.dao.api.DataHolder;
import com.rozsa.dao.api.Identifiable;

import java.util.List;

public class ImportHolder<
        TObj extends Identifiable,
        TDao extends AbstractDao<TObj>,
        THolder extends DataHolder<TObj>> {

    private final TDao dao;

    private final Class<THolder> holderClazz;

    private final String filePath;


    ImportHolder(TDao dao, Class<THolder> holderClazz, String filePath) {
        this.dao = dao;
        this.holderClazz = holderClazz;
        this.filePath = filePath;
    }

    public int execute() {
        THolder holder = loadFromFile();
        if (holder == null) {
            return 0;
        }

        return saveToDatabase(holder);
    }

    private THolder loadFromFile() {
        LoadResource<THolder> load = new LoadResource<>(filePath, holderClazz);
        try {
            return load.execute();
        } catch (Exception e) {
            return null;
        }
    }

    private int saveToDatabase(THolder itemsHolder) {
        List<TObj> data = itemsHolder.getData();

        dao.create(data);
        return data.size();
    }
}
