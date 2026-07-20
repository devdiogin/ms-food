package com.devdiogin.ms_pedidos.dto;

import com.devdiogin.ms_pedidos.model.Status;

import java.time.LocalDateTime;
import java.util.List;

public record OrderRequestDto(
        LocalDateTime orderDate,
        Status status,
        List<OrderItemDto> items) {
}
