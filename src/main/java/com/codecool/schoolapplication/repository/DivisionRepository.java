package com.codecool.schoolapplication.repository;

import com.codecool.schoolapplication.model.Division;
import com.codecool.schoolapplication.model.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DivisionRepository extends JpaRepository<Division, Long> {
}
