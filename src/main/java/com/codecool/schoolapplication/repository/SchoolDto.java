package com.codecool.schoolapplication.repository;

import com.codecool.schoolapplication.model.Class;

import java.util.List;

public class SchoolDto {

    private Long id;
    private String name;
    private String address;
    private List<Class> classes;

    public SchoolDto() {
    }

    public SchoolDto(Long id, String name, String address, List<Class> classes) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.classes = classes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Class> getClasses() {
        return classes;
    }

    public void setClasses(List<Class> classes) {
        this.classes = classes;
    }
}
