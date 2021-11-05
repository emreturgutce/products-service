package com.emreturgutce.productsservice.application.events;

import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.math.BigDecimal;

@Data
public class ProductCreatedEvent {

    private String productId;

    private String title;

    private BigDecimal price;

    private Integer quantity;
}
