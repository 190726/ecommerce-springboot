package com.sk.product.domain;

import java.math.BigDecimal;

public class ProductStub {

    static Product productStub() {
        return Product.builder().name("상품1").price(BigDecimal.ONE).amount(10L).build();
    }
}
