package com.codecool.schoolapplication.dto;

import com.codecool.schoolapplication.model.Division;

import java.util.List;

public class SchoolDto {

    private Long id;
    private String name;
    private String address;
    private List<Division> divisions;

    public SchoolDto() {
    }

    public SchoolDto(Long id, String name, String address, List<Division> divisions) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.divisions = divisions;
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

    public List<Division> getClasses() {
        return divisions;
    }

    public void setClasses(List<Division> divisions) {
        this.divisions = divisions;
    }
}
