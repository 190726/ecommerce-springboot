package com.sk.product.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProductService {
    private final ProductPersistencePort productPersistencePort;

    public Product register(Product product) {
        return productPersistencePort.save(product);
    }
}
