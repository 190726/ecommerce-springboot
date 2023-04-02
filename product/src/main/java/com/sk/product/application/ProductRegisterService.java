package com.sk.product.application;

import com.sk.product.application.usecase.ProductRegisterUseCase;
import com.sk.product.domain.Product;
import com.sk.product.application.port.out.ProductRegisterPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class ProductRegisterService implements ProductRegisterUseCase {

    private final ProductRegisterPort productPersistencePort;

    public Product register(Product product) {
        return productPersistencePort.save(product);
    }
}
