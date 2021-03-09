package com.rozsa.repository.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class SystemProperties {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "config", unique = true)
    private String key;

    @Column(name = "val")
    private String value;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
