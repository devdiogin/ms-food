package com.devdiogin.ms_pagamentos.controller;

import com.devdiogin.ms_pagamentos.dto.PaymentRequestDto;
import com.devdiogin.ms_pagamentos.dto.PaymentResponseDto;
import com.devdiogin.ms_pagamentos.service.PaymentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
@Tag(name = "Pagamentos")
public class PaymentController {

    private final PaymentService paymentService;

    @Operation(summary = "Buscar Todos Pagamentos")
    @GetMapping
    public ResponseEntity<Page<PaymentResponseDto>> findAll(@PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok(paymentService.findAll(pageable));
    }

    @Operation(summary = "Buscar Pagamentos por ID")
    @GetMapping("/{id}")
    public ResponseEntity<PaymentResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(paymentService.findById(id));
    }

    @Operation(description = "Qual porta está rodando a instancia")
    @GetMapping("/port")
    public String returnPort(@Value("${local.server.port}") String port) {
        return String.format("Instancia rodando na PORT: " + port);
    }

    @Operation(summary = "Inserir Pagamento")
    @PostMapping
    public ResponseEntity<PaymentResponseDto> insert(@RequestBody @Valid PaymentRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(paymentService.insert(dto));
    }

    @Operation(summary = "Atualizar Pagamento")
    @PutMapping("/{id}")
    public ResponseEntity<PaymentResponseDto> update(@PathVariable Long id, @RequestBody @Valid PaymentRequestDto dto) {
        return ResponseEntity.ok(paymentService.update(id, dto));
    }

    @Operation(summary = "Deletar Pagamento")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        paymentService.delete(id);
    }
}
