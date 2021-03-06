package com.codecool.schoolapplication.controller;

import com.codecool.schoolapplication.dto.SchoolDto;
import com.codecool.schoolapplication.mapper.SchoolMapper;
import com.codecool.schoolapplication.model.School;
import com.codecool.schoolapplication.service.SchoolService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/school")
public class SchoolController {
    private Logger logger = LoggerFactory.getLogger(SchoolController.class);

    @Autowired
    private SchoolService schoolService;

    @Autowired
    private SchoolMapper schoolMapper;

    @GetMapping
    public List<SchoolDto> findAll() {
        logger.info("GET /school called");
        List<SchoolDto> result = schoolMapper.schoolsToDtos(schoolService.findAll());
        return result;
    }

    @GetMapping("/{id}")
    public SchoolDto findById(@PathVariable long id) {
        logger.info("GET /school/" + id + " called");
        School school = schoolService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return schoolMapper.schoolToDto(school);
    }

    @GetMapping("/{id}/students")
    public Integer countStudentsNumber(@PathVariable long id) {
        logger.info("GET /school/" + id + "/students called");
        Integer numberOfStudents = schoolService.countStudentsNumber(id);
        return numberOfStudents;
    }

    @GetMapping("/{id}/support")
    public Integer calculateGeneralSupport(@PathVariable long id) {
       logger.info("GET /school/" + id + "/support called");
       Integer generalSupport = schoolService.calculateGeneralSupport(id);
       return generalSupport;
    }

    @PostMapping
    public SchoolDto save(@RequestBody @Valid SchoolDto schoolDto) {
        logger.info("POST /school called with parameter: " + schoolDto);
        School school = schoolMapper.dtoToSchool(schoolDto);
        School saved = schoolService.save(school);
        SchoolDto result = schoolMapper.schoolToDto(saved);
        return result;
    }

    @PutMapping("/{id}")
    public ResponseEntity<SchoolDto> update(@PathVariable long id, @RequestBody SchoolDto schoolDto) {
        logger.info("PUT /school/" + id + " called with parameter: " + schoolDto);
        schoolDto.setId(id);
        School school = schoolMapper.dtoToSchool(schoolDto);
        School updated = schoolService.update(school);
        if (updated != null) {
            SchoolDto result = schoolMapper.schoolToDto(updated);
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        logger.info("DELETE /school/" + id + " called");
        schoolService.delete(id);
    }
}
