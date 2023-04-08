package com.sk.order.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.math.BigDecimal;

@Data
@Setter(AccessLevel.PRIVATE)
public class OrderItem {

    private Long productId;
    private String productName;
    private BigDecimal price;
    private long quantity;

    public OrderItem(Long productId, String productName, BigDecimal price, Long quantity) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public OrderItem(Long productId, String productName, BigDecimal price) {
        this(productId, productName, price, 1L);
    }
}
