package com.emreturgutce.productsservice.application;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity(name = "products")
@Data
public class ProductEntity implements Serializable {

    private static final Long serialVersionUUID = -227264951080660124L;

    @Id
    @Column(nullable = false)
    private String productId;

    @Column(nullable = false)
    private String title;

    private BigDecimal price;

    private Integer quantity;
}
