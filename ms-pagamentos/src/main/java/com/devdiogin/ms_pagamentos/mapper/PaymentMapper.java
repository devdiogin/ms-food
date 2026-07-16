package com.devdiogin.ms_pagamentos.mapper;

import com.devdiogin.ms_pagamentos.dto.PaymentRequestDto;
import com.devdiogin.ms_pagamentos.dto.PaymentResponseDto;
import com.devdiogin.ms_pagamentos.model.PaymentEntity;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    PaymentEntity toEntity(PaymentRequestDto dto);

    PaymentResponseDto toResponse(PaymentEntity entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updatePayment(PaymentRequestDto dto, @MappingTarget PaymentEntity entity);
}
