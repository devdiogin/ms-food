package com.devdiogin.ms_pedidos.dto;

import jakarta.validation.constraints.Positive;

public record OrderItemDto(
        Long id,

        @Positive(message = "Quantidade precisa ser maior que 1")
        Integer quantity,

        String description
) {
}
