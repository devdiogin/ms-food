package com.devdiogin.ms_pedidos.controller;

import com.devdiogin.ms_pedidos.dto.OrderRequestDto;
import com.devdiogin.ms_pedidos.dto.OrderResponseDto;
import com.devdiogin.ms_pedidos.dto.OrderStatusDto;
import com.devdiogin.ms_pedidos.service.OrderService;
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
@RequestMapping("/orders")
@RequiredArgsConstructor
@Tag(name = "Pedidos")
public class OrderController {

    private final OrderService orderService;

    @Operation(description = "Buscar todos pedidos")
    @GetMapping
    public ResponseEntity<Page<OrderResponseDto>> findAll(@PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok(orderService.findAll(pageable));
    }

    @Operation(description = "Buscar pedido por ID")
    @GetMapping("/{id}")
    public ResponseEntity<OrderResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.findById(id));
    }

    @Operation(description = "Qual porta está rodando a instancia")
    @GetMapping("/port")
    public String returnPort(@Value("${local.server.port}") String port) {
        return String.format("Instancia rodando na PORT: " + port);
    }

    @Operation(description = "Cadastrar pedido")
    @PostMapping
    public ResponseEntity<OrderResponseDto> insert(@RequestBody @Valid OrderRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.insert(dto));
    }

    @Operation(description = "Atualizar Status pedido")
    @PutMapping("/{id}/status")
    public ResponseEntity<OrderResponseDto> updateStatus(@PathVariable Long id, @RequestBody OrderStatusDto dto) {
        return ResponseEntity.ok(orderService.updateStatus(id, dto));
    }

    @Operation(description = "Pedido Pagamento Aprovado")
    @PutMapping("/{id}/paid")
    public void paymentPaid(@PathVariable Long id) {
        orderService.paymentPaid(id);
    }
}
