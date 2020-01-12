package com.rozsa.business;

import com.rozsa.parser.JsonReader;

public class LoadResource<T> {
    private final String filePath;

    private final Class<T> clazz;

    public LoadResource(String filePath, Class<T> clazz) {
        this.filePath = filePath;
        this.clazz = clazz;
    }

    @SuppressWarnings("unchecked")
    public T execute() throws ClassNotFoundException {
        JsonReader<T> reader = new JsonReader<>(filePath, clazz);
        try {
            return reader.read();
        } catch (Exception ex) {
            System.out.printf("Failed to read data from %s. Ex.: %s", filePath, ex);
            return (T)Class.forName(clazz.getName());
        }
    }
}

