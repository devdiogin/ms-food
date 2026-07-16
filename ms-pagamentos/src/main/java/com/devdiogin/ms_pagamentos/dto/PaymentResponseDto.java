package com.devdiogin.ms_pagamentos.dto;

import com.devdiogin.ms_pagamentos.model.Status;

import java.math.BigDecimal;

public record PaymentResponseDto(
        Long id,
        BigDecimal amount,
        String name,
        String number,
        String expiration,
        String code,
        Status status,
        Long orderId,
        Long paymentMethodId
) {
}
