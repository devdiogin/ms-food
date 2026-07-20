package com.devdiogin.ms_pedidos.mapper;

import com.devdiogin.ms_pedidos.dto.OrderRequestDto;
import com.devdiogin.ms_pedidos.dto.OrderResponseDto;
import com.devdiogin.ms_pedidos.model.OrderEntity;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(target = "id", ignore = true)
    OrderEntity toEntity(OrderRequestDto dto);

    OrderResponseDto toResponse(OrderEntity entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateOrder(OrderRequestDto dto, @MappingTarget OrderEntity entity);
}
