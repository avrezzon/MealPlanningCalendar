package com.avrezzon.mealplanningcalendar.model;

import lombok.AllArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
public class Role implements Serializable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
