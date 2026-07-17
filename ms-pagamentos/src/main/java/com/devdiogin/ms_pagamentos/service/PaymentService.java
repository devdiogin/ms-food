package com.devdiogin.ms_pagamentos.service;

import com.devdiogin.ms_pagamentos.dto.PaymentRequestDto;
import com.devdiogin.ms_pagamentos.dto.PaymentResponseDto;
import com.devdiogin.ms_pagamentos.exception.PaymentNotFoundException;
import com.devdiogin.ms_pagamentos.mapper.PaymentMapper;
import com.devdiogin.ms_pagamentos.model.Status;
import com.devdiogin.ms_pagamentos.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;

    private static final String PAGAMENTO = "Pagamento não encontrado";

    @Transactional(readOnly = true)
    public Page<PaymentResponseDto> findAll(Pageable pageable) {
        return paymentRepository.findAll(pageable)
                .map(paymentMapper::toResponse);
    }

    @Transactional(readOnly = true)
    public PaymentResponseDto findById(Long id) {
        var payment = paymentRepository.findById(id)
                .orElseThrow(() -> new PaymentNotFoundException(PAGAMENTO));

        return paymentMapper.toResponse(payment);
    }

    @Transactional
    public PaymentResponseDto insert(PaymentRequestDto dto) {
        var payment = paymentMapper.toEntity(dto);
        payment.setStatus(Status.CREATED);
        paymentRepository.save(payment);

        return paymentMapper.toResponse(payment);
    }

    @Transactional
    public PaymentResponseDto update(Long id, PaymentRequestDto dto) {
        var payment = paymentRepository.findById(id)
                .orElseThrow(() -> new PaymentNotFoundException(PAGAMENTO));

        paymentMapper.updatePayment(dto, payment);
        paymentRepository.save(payment);

        return paymentMapper.toResponse(payment);
    }

    @Transactional
    public void delete(Long id) {
        var payment = paymentRepository.findById(id)
                .orElseThrow(() -> new PaymentNotFoundException(PAGAMENTO));

        paymentRepository.delete(payment);
    }
}
