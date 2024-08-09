package az.atlacademy.productms.mapper;

import az.atlacademy.productms.dao.entity.ProductEntity;
import az.atlacademy.productms.model.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING,
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    ProductDto toDto(ProductEntity productEntity);

    ProductEntity toEntity(ProductDto productDto);

}
