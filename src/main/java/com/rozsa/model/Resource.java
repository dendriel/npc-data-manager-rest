package com.rozsa.model;

import lombok.Data;

@Data
public class Resource {
    private Long resId;
    private Long dirId;
    private String storageId;
    private String name;
}
