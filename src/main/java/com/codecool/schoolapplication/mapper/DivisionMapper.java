package com.codecool.schoolapplication.mapper;

import com.codecool.schoolapplication.dto.DivisionDto;
import com.codecool.schoolapplication.model.Division;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DivisionMapper {
    @Mapping(source = "school.id", target = "schoolId")
    DivisionDto divisionToDto(Division division);
    List<DivisionDto> divisionsToDtos(List<Division> divisions);
    @Mapping(source = "schoolId", target = "school.id")
    Division dtoToDivision(DivisionDto divisionDto);
    List<Division> dtosToDivisions(List<DivisionDto> divisionDtos);
}
