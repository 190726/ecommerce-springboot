package com.sk.product.application;

import com.sk.product.application.port.in.ProductRegisterUseCase;
import com.sk.product.domain.Product;
import com.sk.product.application.port.out.ProductPersistencePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class ProductService implements ProductRegisterUseCase {
    private final ProductPersistencePort productPersistencePort;

    public Product register(Product product) {
        return productPersistencePort.save(product);
    }
}
