package com.devdiogin.ms_pagamentos.dto;

import com.devdiogin.ms_pagamentos.model.Status;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

@Schema(description = "Dados para cadastro do pagamento")
public record PaymentRequestDto(
        @NotNull(message = "Informe a quantia do pagamento")
        @Positive(message = "Qauntia deve ser maior que 0")
        BigDecimal amount,

        @Size(max = 100)
        String name,

        @Size(max = 19)
        String number,

        @Size(max = 7)
        String expiration,

        @Size(min = 3, max = 3)
        String code,
        
        Status status,

        @NotNull(message = "Informe o Id do pedido")
        Long orderId,

        @NotNull(message = "Informe o id da forma de pagamento")
        Long paymentMethodId) {
}
