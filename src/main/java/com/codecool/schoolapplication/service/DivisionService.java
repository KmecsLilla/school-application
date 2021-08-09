package com.codecool.schoolapplication.service;

import com.codecool.schoolapplication.model.Division;
import com.codecool.schoolapplication.repository.DivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DivisionService {

    @Autowired
    DivisionRepository divisionrepository;

    public List<Division> findAll() {
        return divisionrepository.findAll();
    }

    public Optional<Division> findById(long id) {
        return divisionrepository.findById(id);
    }

    public Division save(Division division) {
        return divisionrepository.save(division);
    }

    public Division update(Division division) {
        if (divisionrepository.existsById(division.getId())) {
            return divisionrepository.save(division);
            } else {
                return null;
            }
        }

    public void delete(long id) {
        divisionrepository.deleteById(id);
    }
}
