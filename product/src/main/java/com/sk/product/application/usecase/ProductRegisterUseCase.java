package com.sk.product.application.port.in;

import com.sk.product.domain.Product;

public interface ProductRegisterUseCase {
    Product register(Product product);
}