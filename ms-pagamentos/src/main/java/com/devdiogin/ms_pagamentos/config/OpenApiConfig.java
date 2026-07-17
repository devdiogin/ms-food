package com.devdiogin.ms_pagamentos.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().info(
                new Info().title("MS-Payments")
                        .description("Api desenvolvida para microserviços de pagamentos, do projeto ms-food")
                        .contact(new Contact()
                                .name("Dev Diogin")
                                .email("dev.diogelucas@gmail.com")
                                .url(""))
        );
    }

}
