package com.housing.market.controller;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@ComponentScan(basePackages = {"com.housing.market.services"})
@EnableJpaRepositories(basePackages = "com.housing.market.repository")
@EntityScan(basePackages = {"com.housing.market.domain"})
@Configuration
public class IntegrationTestConfig {
}
