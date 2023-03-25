package com.sk.product.adapter.in;

import com.sk.product.application.usecase.ProductRegisterUseCase;
import com.sk.product.domain.Product;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
public class ProductRegisterController {

    private final ProductRegisterUseCase productRegisterUseCase;

    public void register(ProductRegisterRequest request) {
        productRegisterUseCase.register(new Product(request.name(), request.price(), request.amount()));
    }

    static record ProductRegisterRequest(String name, BigDecimal price, long amount) {
    }
}
