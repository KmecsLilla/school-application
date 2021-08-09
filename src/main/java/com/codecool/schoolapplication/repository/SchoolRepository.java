package com.codecool.schoolapplication.repository;

import com.codecool.schoolapplication.model.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School,Long> {
}
