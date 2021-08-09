package com.codecool.schoolapplication.mapper;

import com.codecool.schoolapplication.model.School;
import com.codecool.schoolapplication.repository.SchoolDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SchoolMapper {
    SchoolDto schoolToDto(School school);
    List<SchoolDto> schoolsToDtos(List<School> schools);
    School dtoToSchool(SchoolDto schoolDto);
    List<School> dtosToSchools(List<SchoolDto> schoolDtos);

}
