package com.sk.product.application;

import com.sk.product.domain.Product;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
class ProductValidator {

    public Product validate(Product product) {

        Assert.hasText(product.getName(), "상품명은 필수 입니다.");
        Assert.isTrue(product.getAmount() > 0L, "수량은 0보다 커야 합니다.");
        return product;
    }
}