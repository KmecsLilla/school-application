package com.codecool.schoolapplication.mapper;

import com.codecool.schoolapplication.dto.SchoolDto;
import com.codecool.schoolapplication.model.School;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SchoolMapper {
    SchoolDto schoolToDto(School school);
    List<SchoolDto> schoolsToDtos(List<School> schools);
    School dtoToSchool(SchoolDto schoolDto);
    List<School> dtosToSchools(List<SchoolDto> schoolDtos);
}
