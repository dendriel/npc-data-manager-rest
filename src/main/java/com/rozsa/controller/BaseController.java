package com.rozsa.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rozsa.dao.AbstractDao;
import com.rozsa.dao.DataHolderImpl;
import com.rozsa.dao.api.DataHolder;
import com.rozsa.dao.api.Identifiable;
import com.rozsa.model.Item;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.List;

public abstract class BaseController<T extends Identifiable> {
    protected final AbstractDao<T> dao;

    BaseController(AbstractDao<T> dao) {
        this.dao = dao;
    }

    @RequestMapping("/getAll")
    public List<T> getAll() {
        return dao.findAll();
    }

    @RequestMapping("/get")
    public T get(@RequestParam(value="id") ObjectId id) {
        return dao.findById(id);
    }

    @RequestMapping("/getById")
    public T getById(int id) {
        return dao.findAll().get(id);
    }

    @RequestMapping("/save")
    public T save(@RequestBody T entity) {
        return dao.save(entity);
    }

    @RequestMapping("/delete")
    public boolean delete(@RequestParam(value="id") String idAsText) {
        System.out.println("Delete entity " + idAsText);

        if (idAsText == null || idAsText.isEmpty()) {
            throw new InvalidParameterException("Null or empty entity id!");
        }

        ObjectId id = new ObjectId(idAsText);

        return dao.deleteById(id);
    }

    @PostMapping("/deleteAll")
    public int deleteAllById(@RequestBody List<String> textIds) {
        // TODO: improve this.
        textIds.forEach(this::delete);

        return textIds.size();
    }

    @RequestMapping("/import")
    public int importData(@RequestBody DataHolderImpl<T> holder) {
        List<T> data = holder.getData();
        if (data == null) {
            System.out.println("Failed to create entries. Data is NULL.");
            return -1;
        }

        System.out.println("Import data into database. Entries to be imported: " + data.size());

        try {
            dao.create(data);
        } catch (Exception e) {
            System.out.println("Failed to create entries. " + e.toString());
            return -2;
        }

        return data.size();
    }

    @RequestMapping("/export")
    public void exportData(HttpServletResponse response) {
        System.out.println("Export data from database.");
        List<T> entities = dao.findAll();
        DataHolder<T> holder = createDataHolder(entities);

        try {
            ObjectMapper mapper = new ObjectMapper();
            byte[] data = mapper.writeValueAsBytes(holder);

            response.setContentLength(data.length);
            response.setContentType("application/json");
            response.getOutputStream().write(data);

        } catch (IOException e) {
            System.out.println("Failed to export data.");
        }
    }

    public DataHolder<T> createDataHolder(List<T> entities) {
        return new DataHolderImpl<>(entities);
    }
}
