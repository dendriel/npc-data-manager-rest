package com.rozsa.parser;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileOutputStream;
import java.io.IOException;

public class JsonWriter {
    private String filePath;

    public JsonWriter(String filePath) {
        this.filePath = filePath;
    }

    public void write(Object data) throws IOException {
        System.out.printf("Writing %s\n", filePath);
        ObjectMapper mapper = new ObjectMapper();

        mapper.writeValue(new FileOutputStream(filePath), data);
    }
}
