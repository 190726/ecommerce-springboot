package com.sk.product.application.port.out;

import com.sk.product.domain.Product;

public interface ProductRegisterPort {
    Product save(Product product);
}
