package com.codecool.schoolapplication.mapper;

import com.codecool.schoolapplication.dto.DivisionDto;
import com.codecool.schoolapplication.model.Division;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DivisionMapper {
    DivisionDto divisionToDto(Division division);
    List<DivisionDto> divisionsToDtos(List<Division> divisions);
    Division dtoToDivision(DivisionDto divisionDto);
    List<Division> dtosToDivisions(List<DivisionDto> divisionDtos);
}
