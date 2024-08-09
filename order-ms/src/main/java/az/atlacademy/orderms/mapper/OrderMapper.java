package az.atlacademy.orderms.mapper;

import az.atlacademy.orderms.dao.entity.OrderEntity;
import az.atlacademy.orderms.model.OrderDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING,
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper {

    OrderDto toDto(OrderEntity orderEntity);
    OrderEntity toEntity(OrderDto orderDto);

}
