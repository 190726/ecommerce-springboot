package com.sk.product.application;

import com.sk.product.application.usecase.ProductRegisterUseCase;
import com.sk.product.domain.Product;
import com.sk.product.application.port.out.ProductRegisterPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class ProductRegisterService implements ProductRegisterUseCase {
    private final ProductRegisterPort productPersistencePort;
    private final ProductValidator validator;

    public Product register(Product product) {

        return productPersistencePort.save(validator.validate(product));
    }
}
