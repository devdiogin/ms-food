package com.devdiogin.ms_pedidos.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.stereotype.Component;

@Component
public class OpenApiConfig {

    public OpenAPI openAPI() {
        return new OpenAPI().info(
                new Info().title("Ms-Orders")
                        .description("Api desenvolvida para microserviços de pedidos, do projeto ms-food")
                        .contact(new Contact().name("Dev.Diogin")
                                .email("dev.diogelucas@gmail.com")
                                .url("https://www.linkedin.com/in/dev-cassimiro/"))
        );
    }
}
