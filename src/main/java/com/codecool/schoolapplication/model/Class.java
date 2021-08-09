package com.codecool.schoolapplication.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Class {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String classMaster;
    private int startupYear;
    private int numberOfMembers;

    public Class() {
    }

    public Class(Long id, String name, String classMaster, int startupYear, int numberOfMembers) {
        this.id = id;
        this.name = name;
        this.classMaster = classMaster;
        this.startupYear = startupYear;
        this.numberOfMembers = numberOfMembers;
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

    public String getClassMaster() {
        return classMaster;
    }

    public void setClassMaster(String classMaster) {
        this.classMaster = classMaster;
    }

    public int getStartupYear() {
        return startupYear;
    }

    public void setStartupYear(int startupYear) {
        this.startupYear = startupYear;
    }

    public int getNumberOfMembers() {
        return numberOfMembers;
    }

    public void setNumberOfMembers(int numberOfMembers) {
        this.numberOfMembers = numberOfMembers;
    }
}
