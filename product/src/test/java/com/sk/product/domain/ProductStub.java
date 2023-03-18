package com.sk.product.domain;

import java.math.BigDecimal;

public class ProductStub {

    public static Product productStub() {
        return new Product("상품1", BigDecimal.ONE, 10L);
    }
}
