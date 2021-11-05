package com.emreturgutce.productsservice.infrastructure.controller;

import com.emreturgutce.productsservice.application.commands.CreateProductCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("products")
public class ProductController {

    private final Environment environment;
    private final CommandGateway commandGateway;

    public ProductController(Environment environment, CommandGateway commandGateway) {
        this.environment = environment;
        this.commandGateway = commandGateway;
    }

    @GetMapping
    public ResponseEntity<String> getProducts() {
        return new ResponseEntity<>("products - " + environment.getProperty("local.server.port"), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody CreateProductDto createProductDto) {

        var command = CreateProductCommand.builder()
                .price(createProductDto.getPrice())
                .quantity(createProductDto.getQuantity())
                .title(createProductDto.getTitle())
                .productId(UUID.randomUUID().toString())
                .build();

        String value;

        try {
            value = commandGateway.sendAndWait(command);
        } catch (Exception ex) {
            value = ex.getLocalizedMessage();
        }

        return new ResponseEntity<>(value, HttpStatus.CREATED);
    }
}
