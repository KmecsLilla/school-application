package com.codecool.schoolapplication.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SchoolConfiguration {
    @Value("${student.support}")
    private Integer studentSupport;

    public Integer getStudentSupport() {
        return studentSupport;
    }
}
