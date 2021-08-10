package com.codecool.schoolapplication.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.*;

public class DivisionDto {

    private Long id;

    @NotEmpty(message = "Name is mandatory")
    private String name;

    @Size(min = 5, max = 50, message = "Size should be between min and max value")
    private String classMaster;

    @Min(value = 2000, message = "Year should not be less than 2000")
    @Max(value = 2030, message = "Year should not be greater than 2030")
    private Integer startupYear;

    @Positive(message = "Number should be positive")
    private Integer numberOfMembers;

    private Long schoolId;

    public DivisionDto() {
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

    public Long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }
}
