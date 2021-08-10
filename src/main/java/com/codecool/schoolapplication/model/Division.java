package com.codecool.schoolapplication.model;

import javax.persistence.*;

@Entity
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String classMaster;
    private Integer startupYear;
    private Integer numberOfMembers;

    @ManyToOne
    private School school;

    public Division() {
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

    public Integer getStartupYear() {
        return startupYear;
    }

    public void setStartupYear(Integer startupYear) {
        this.startupYear = startupYear;
    }

    public Integer getNumberOfMembers() {
        return numberOfMembers;
    }

    public void setNumberOfMembers(Integer numberOfMembers) {
        this.numberOfMembers = numberOfMembers;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
