package com.sk.product.application;

import com.sk.product.application.port.out.ProductUpdatePort;
import com.sk.product.application.usecase.ProductUpdateUseCase;
import com.sk.product.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductUpdateService implements ProductUpdateUseCase {
    private final ProductValidator productValidator;
    private final ProductUpdatePort productUpdatePort;

    @Override
    public Product update(Product product) {
        return productUpdatePort.update(productValidator.validate(product));
    }
}