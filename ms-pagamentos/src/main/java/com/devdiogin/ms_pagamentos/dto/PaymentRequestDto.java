package com.devdiogin.ms_pagamentos.dto;

import com.devdiogin.ms_pagamentos.model.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record PaymentRequestDto(
        @NotNull(message = "Informe a quantia do pagamento")
        @Positive(message = "Qauntia deve ser maior que 0")
        BigDecimal amount,

        @NotBlank(message = "Informe o nome")
        @Size(max = 100)
        String name,

        @NotBlank(message = "Informe o número")
        @Size(max = 19)
        String number,

        @NotBlank(message = "Informe a expiração")
        @Size(max = 7)
        String expiration,

        @NotBlank(message = "Informe o código")
        @Size(min = 3, max = 3)
        String code,

        @NotNull(message = "Informe o status do pagamento")
        Status status,

        @NotNull(message = "Informe o Id do pedido")
        Long orderId,

        @NotNull(message = "Informe o id da forma de pagamento")
        Long paymentMethodId) {
}
