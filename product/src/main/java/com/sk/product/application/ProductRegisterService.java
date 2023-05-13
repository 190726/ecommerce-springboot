package com.sk.product.application;

import com.sk.product.application.usecase.ProductRegisterUseCase;
import com.sk.product.domain.Product;
import com.sk.product.application.port.out.ProductRegisterPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
@RequiredArgsConstructor
class ProductRegisterService implements ProductRegisterUseCase {

    private final ProductRegisterPort productPersistencePort;

    public Product register(Product product) {
        Assert.isTrue(product.getAmount() > 0, "수량은 0보다 커야 합니다.");
        return productPersistencePort.save(product);
    }
}
