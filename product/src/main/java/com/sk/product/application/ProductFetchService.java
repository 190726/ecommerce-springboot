package com.sk.product.application;

import com.sk.product.application.usecase.ProductFetchQuery;
import com.sk.product.domain.Product;

class ProductFetchService implements ProductFetchQuery {
    @Override
    public Product findBy(long id) {
        throw new UnsupportedOperationException("not implement");
    }
}
