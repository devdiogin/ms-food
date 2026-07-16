package com.devdiogin.ms_pagamentos.repository;

import com.devdiogin.ms_pagamentos.model.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {

}
