package com.emreturgutce.productsservice.infrastructure.controller;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateProductDto {

    private String title;
    private BigDecimal price;
    private Integer quantity;
}
