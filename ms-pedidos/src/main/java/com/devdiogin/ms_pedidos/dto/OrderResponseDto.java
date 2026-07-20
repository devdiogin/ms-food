package com.devdiogin.ms_pedidos.dto;

import com.devdiogin.ms_pedidos.model.Status;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public record OrderResponseDto(Long id,
                               LocalDateTime orderDate,
                               Status status,
                               List<OrderItemDto> items) {
}
