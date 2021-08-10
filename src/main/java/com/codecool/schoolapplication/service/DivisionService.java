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
        Optional<Division> maybeExistingDivision = findById(division.getId());
        if (maybeExistingDivision.isPresent()) {
            Division existingDivision = maybeExistingDivision.get();
            if (division.getName() != null) {
                existingDivision.setName(division.getName());
            }
            if (division.getClassMaster() != null) {
                existingDivision.setClassMaster(division.getClassMaster());
            }
            if (division.getStartupYear() != null) {
                existingDivision.setStartupYear(division.getStartupYear());
            }
            if (division.getNumberOfMembers() != null) {
                existingDivision.setNumberOfMembers(division.getNumberOfMembers());
            }
            return divisionrepository.save(existingDivision);
        } else {
            return null;
        }
    }

    public void delete(long id) {
        divisionrepository.deleteById(id);
    }
}
