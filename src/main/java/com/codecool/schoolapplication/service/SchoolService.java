package com.codecool.schoolapplication.service;

import com.codecool.schoolapplication.config.SchoolConfiguration;
import com.codecool.schoolapplication.model.Division;
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

    @Autowired
    SchoolConfiguration schoolConfiguration;

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
        Optional<School> maybeExistingSchool = findById(school.getId());
        if (maybeExistingSchool.isPresent()) {
            School existingSchool = maybeExistingSchool.get();
            if (school.getName() != null) {
                existingSchool.setName(school.getName());
            }
            if (school.getAddress() != null) {
                existingSchool.setAddress(school.getAddress());
            }
            return schoolrepository.save(existingSchool);
        } else {
            return null;
        }
    }

    public void delete(long id) {
        schoolrepository.deleteById(id);
    }

    public Integer countStudentsNumber(long id) {
        Optional<School> maybeSchool = findById(id);
        if (maybeSchool.isPresent()) {
            School school = maybeSchool.get();
            int numberOfStudents = 0;
            for (Division division : school.getDivisions()) {
                numberOfStudents += division.getNumberOfMembers();
            }
            return numberOfStudents;
        }
        return null;
    }

    public Integer calculateGeneralSupport(long id) {
        Integer generalSupport = countStudentsNumber(id) * schoolConfiguration.getStudentSupport();
        return generalSupport;
    }
}
