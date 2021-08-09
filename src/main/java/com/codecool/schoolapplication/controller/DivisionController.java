package com.codecool.schoolapplication.controller;

import com.codecool.schoolapplication.dto.DivisionDto;
import com.codecool.schoolapplication.mapper.DivisionMapper;
import com.codecool.schoolapplication.model.Division;
import com.codecool.schoolapplication.service.DivisionService;
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
@RequestMapping("/division")
public class DivisionController {
    private Logger logger = LoggerFactory.getLogger(DivisionController.class);

    @Autowired
    private DivisionService divisionService;

    @Autowired
    private DivisionMapper divisionMapper;

    @GetMapping
    public List<DivisionDto> findAll() {
        logger.info("GET /divisions called");
        List<DivisionDto> result = divisionMapper.divisionsToDtos(divisionService.findAll());
        return result;
    }

    @GetMapping("/{id}")
    public DivisionDto findById(@PathVariable long id) {
        logger.info("GET /divisions/" + id + " called");
        Division division = divisionService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return divisionMapper.divisionToDto(division);
    }

    @PostMapping
    public DivisionDto save(@RequestBody @Valid DivisionDto divisionDto) {
        logger.info("POST /divisions called with parameter: " + divisionDto);
        Division division = divisionMapper.dtoToDivision(divisionDto);
        Division saved = divisionService.save(division);
        DivisionDto result = divisionMapper.divisionToDto(saved);
        return result;
    }

    @PutMapping("/{id}")
    public ResponseEntity<DivisionDto> update(@PathVariable long id, @RequestBody DivisionDto divisionDto) {
        logger.info("PUT /divisions/" + id + " called with parameter: " + divisionDto);
        divisionDto.setId(id);
        Division division = divisionMapper.dtoToDivision(divisionDto);
        Division updated = divisionService.update(division);
        if (updated != null) {
            DivisionDto result = divisionMapper.divisionToDto(updated);
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        logger.info("DELETE /divisions/" + id + " called");
        divisionService.delete(id);
    }
    
}
