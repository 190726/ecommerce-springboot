package com.sk.product.domain;

import lombok.*;

import java.math.BigDecimal;

@Data
@Setter(AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private long id;
    private String name;
    private BigDecimal price;
    private long amount;

    public void id(long id) {
        this.id = id;
    }
}
