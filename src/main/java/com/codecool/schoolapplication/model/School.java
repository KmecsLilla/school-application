package com.codecool.schoolapplication.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class School {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String address;
    @OneToMany
    private List<Division> divisions;

    public School() {
    }

    public School(Long id, String name, String address, List<Division> divisions) {
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
