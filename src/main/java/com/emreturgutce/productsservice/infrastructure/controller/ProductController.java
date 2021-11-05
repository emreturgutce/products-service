package com.emreturgutce.productsservice.infrastructure.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
public class ProductController {

    @GetMapping
    public ResponseEntity<String> getProducts() {
        return new ResponseEntity<>("products", HttpStatus.OK);
    }
}
