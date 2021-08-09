package com.codecool.schoolapplication.service;

import com.codecool.schoolapplication.model.School;
import com.codecool.schoolapplication.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolService {

    @Autowired
    SchoolRepository schoolrepository;

    public List<School> findAll() {
        return schoolrepository.findAll();
    }

    public Optional<School> findById(long id) {
        return schoolrepository.findById(id);
    }

    public School save(School school) {
        return schoolrepository.save(school);
    }

    public School update(School school) {
        if (schoolrepository.existsById(school.getId())) {
            return schoolrepository.save(school);
            } else {
                return null;
            }
        }

    public void delete(long id) {
        schoolrepository.deleteById(id);
    }
}
