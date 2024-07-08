package az.atl.mapper;

import az.atl.dao.entity.StudentEntity;
import az.atl.model.dto.StudentDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING,
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StudentMapper {

    StudentEntity toEntity(StudentDto studentDto);

    StudentDto toDto(StudentEntity studentEntity);

}
