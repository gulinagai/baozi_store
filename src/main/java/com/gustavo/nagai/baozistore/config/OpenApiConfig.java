package com.gustavo.nagai.baozistore.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Baozi Store API",
                version = "1.0",
                description = "API para gerenciamento de clientes, produtos e pedidos."
        )
)
public class OpenApiConfig {
}
