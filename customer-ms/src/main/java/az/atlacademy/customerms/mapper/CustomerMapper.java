package az.atlacademy.customerms.mapper;

import az.atlacademy.customerms.dao.entity.CustomerEntity;
import az.atlacademy.customerms.model.CustomerDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING,
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerMapper {

    CustomerDto toDto(CustomerEntity customerEntity);
    CustomerEntity toEntity(CustomerDto customerDto);

}
