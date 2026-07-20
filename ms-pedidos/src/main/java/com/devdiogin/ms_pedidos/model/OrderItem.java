package com.devdiogin.ms_pedidos.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "order_item")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class OrderItem {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer quantity;

    private String description;

    @ManyToOne(optional = false)
    @JoinColumn(name = "order_id", nullable = false)
    private OrderEntity order;
}
