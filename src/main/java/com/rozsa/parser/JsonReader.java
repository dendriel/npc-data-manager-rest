package com.rozsa.parser;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

public class JsonReader<T> {
    private String filePath;

    private Class<T> type;

    public JsonReader(String filePath, Class<T> type) {
        this.filePath = filePath;
        this.type = type;
    }

    public T read() throws IOException {
        File file = new File(filePath);

        System.out.printf("Reading %s\n", filePath);

        ObjectMapper objectMapper = new ObjectMapper();
        T obj = objectMapper.readValue(file, type);

        return type.cast(obj);
    }

    public static <T> String getListAsJson(List<T> set) {
        final StringWriter sw = new StringWriter();
        final ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.writeValue(sw, set);
            return sw
                    .toString()
                    .replace("[", "")
                    .replace("]", "");
        } catch (Exception ex) {
            return "Failed to transform list to JSON.";
        }
    }
}
