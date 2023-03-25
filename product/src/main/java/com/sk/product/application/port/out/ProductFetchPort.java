package com.sk.product.application.port.out;

import com.sk.product.domain.Product;

public interface ProductFetchPort {
    Product findBy(long id);
}
