package com.sk.product.domain;

import lombok.*;

import java.math.BigDecimal;

@ToString
@Data
@Setter(AccessLevel.PRIVATE)
public class Product {

    private long id;
    private String name;
    private BigDecimal price;
    private long amount;

    public Product(String name, BigDecimal price, long amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public Product(long id, String name, BigDecimal price, long amount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public void id(long id) {
        this.id = id;
    }
    
}
