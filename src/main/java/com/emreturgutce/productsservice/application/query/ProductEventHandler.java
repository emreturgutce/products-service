package com.emreturgutce.productsservice.application.query;

import com.emreturgutce.productsservice.application.ProductEntity;
import com.emreturgutce.productsservice.application.ProductRepository;
import com.emreturgutce.productsservice.application.events.ProductCreatedEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ProductEventHandler {

    private final ProductRepository productRepository;

    public ProductEventHandler(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @EventHandler
    public void on(ProductCreatedEvent productCreatedEvent) {
        var productEntity = new ProductEntity();

        BeanUtils.copyProperties(productCreatedEvent, productEntity);

        productRepository.save(productEntity);
    }
}
