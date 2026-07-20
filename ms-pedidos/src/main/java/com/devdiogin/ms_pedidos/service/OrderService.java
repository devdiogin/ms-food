package com.devdiogin.ms_pedidos.service;

import com.devdiogin.ms_pedidos.dto.OrderRequestDto;
import com.devdiogin.ms_pedidos.dto.OrderResponseDto;
import com.devdiogin.ms_pedidos.dto.OrderStatusDto;
import com.devdiogin.ms_pedidos.exception.OrderNotFoundException;
import com.devdiogin.ms_pedidos.mapper.OrderMapper;
import com.devdiogin.ms_pedidos.model.Status;
import com.devdiogin.ms_pedidos.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    private static final String ORDER = "Pedido não encontrado";

    @Transactional(readOnly = true)
    public Page<OrderResponseDto> findAll(Pageable pageable) {
        return orderRepository.findAll(pageable)
                .map(orderMapper::toResponse);
    }

    @Transactional(readOnly = true)
    public OrderResponseDto findById(Long id) {
        var order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(ORDER));
        return orderMapper.toResponse(order);
    }

    @Transactional
    public OrderResponseDto insert(OrderRequestDto dto) {
        var order = orderMapper.toEntity(dto);
        order.setOrderDate(LocalDateTime.now());
        order.setStatus(Status.CONFIRMED);
        order.getItems().forEach(item -> item.setOrder(order));

        return orderMapper.toResponse(orderRepository.save(order));
    }

    @Transactional
    public OrderResponseDto updateStatus(Long id, OrderStatusDto dto) {
        var order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(ORDER));

        order.setStatus(dto.status());
        return orderMapper.toResponse(orderRepository.save(order));
    }

    @Transactional
    public void paymentPaid(Long id) {
        var order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(ORDER));

        order.setStatus(Status.PAID);
        orderRepository.save(order);
    }
}
