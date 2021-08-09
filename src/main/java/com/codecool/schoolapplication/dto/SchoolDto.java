package com.codecool.schoolapplication.dto;

import javax.validation.constraints.NotEmpty;
import java.util.List;

public class SchoolDto {

    private Long id;

    @NotEmpty(message = "Name is mandatory")
    private String name;

    @NotEmpty(message = "Address is mandatory")
    private String address;
    private List<DivisionDto> divisions;

    public SchoolDto() {
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

    public List<DivisionDto> getDivisions() {
        return divisions;
    }

    public void setDivisions(List<DivisionDto> divisions) {
        this.divisions = divisions;
    }
}
