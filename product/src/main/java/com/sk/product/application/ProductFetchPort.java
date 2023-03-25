package com.sk.product.application;

import com.sk.product.domain.Product;

public interface ProductFetchPort {
    Product findBy(long id);
}
