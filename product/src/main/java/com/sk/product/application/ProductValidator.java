package com.sk.product.application;

import com.sk.product.application.port.out.ProductFetchPort;
import com.sk.product.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@RequiredArgsConstructor
@Component
class ProductValidator {

    private final ProductFetchPort productFetchPort;
    private long MAX_AMOUNT = 100L;

    public Product validate(Product product) {
        final var findProduct = productFetchPort.findBy(product.getId());
        final var sum = findProduct.getAmount() + product.getAmount();

        if(sum > MAX_AMOUNT) throw new ProductExceedAmountException("Maximum amount exceed over " + MAX_AMOUNT);
        return product;
    }
}