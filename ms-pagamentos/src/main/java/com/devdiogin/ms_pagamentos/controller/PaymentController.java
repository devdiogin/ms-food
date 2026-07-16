package com.devdiogin.ms_pagamentos.controller;

import com.devdiogin.ms_pagamentos.dto.PaymentRequestDto;
import com.devdiogin.ms_pagamentos.dto.PaymentResponseDto;
import com.devdiogin.ms_pagamentos.service.PaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(name = "/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @GetMapping
    public ResponseEntity<Page<PaymentResponseDto>> findAll(@PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok(paymentService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(paymentService.findById(id));
    }

    @PostMapping
    public ResponseEntity<PaymentResponseDto> insert(@RequestBody @Valid PaymentRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(paymentService.insert(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaymentResponseDto> update(@PathVariable Long id, @RequestBody @Valid PaymentRequestDto dto) {
        return ResponseEntity.ok(paymentService.update(id, dto));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        paymentService.delete(id);
    }
}
