package com.rozsa.util;

import org.springframework.http.HttpHeaders;

import java.util.ArrayList;
import java.util.List;

public final class HeaderUtil {

    public static List<String> getHeaderValues(HttpHeaders headers, String key) {
        List<String> values = headers.get(key);

        if (values == null) {
            return new ArrayList<>();
        }

        return  values;
    }
}
