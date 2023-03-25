package com.sk.product.adapter.out;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@NoArgsConstructor
@Table(name = "PRODUCT")
@Entity
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private BigDecimal price;
    private Long amount;

    public ProductEntity(String name, BigDecimal price, long amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }
}
