package com.housing.market.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;

@Configuration
public class Swagger {

    @Bean
    public OpenAPI myOpenAPI() {
        return new OpenAPI();
    }
}