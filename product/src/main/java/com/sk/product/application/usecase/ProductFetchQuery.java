package com.sk.product.application.usecase;

import com.sk.product.domain.Product;

public interface ProductFetchQuery {
    Product findBy(long id);
}
