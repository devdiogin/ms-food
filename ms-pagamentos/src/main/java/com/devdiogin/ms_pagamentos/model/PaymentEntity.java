package com.devdiogin.ms_pagamentos.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "payments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class PaymentEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 19)
    private String number;

    @Column(nullable = false, length = 7)
    private String expiration;

    @Column(nullable = false, length = 3)
    private String code;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(nullable = false)
    private Long orderId;

    @Column(nullable = false)
    private Long paymentMethodId;
}
