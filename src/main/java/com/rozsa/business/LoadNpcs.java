package com.rozsa.business;

import com.rozsa.model.NpcsHolder;
import com.rozsa.parser.JsonReader;

public class LoadNpcs {
    private final String filePath;

    public LoadNpcs(String filePath) {
        this.filePath = filePath;
    }

    public NpcsHolder execute() {
        JsonReader<NpcsHolder> reader = new JsonReader<>(filePath, NpcsHolder.class);
        try {
            return reader.read();

        } catch (Exception ex) {
            System.out.printf("Failed to read data from %s. Ex.: %s", filePath, ex);
            return new NpcsHolder();
        }
    }
}

