package com.devdiogin.ms_pedidos.repository;

import com.devdiogin.ms_pedidos.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
