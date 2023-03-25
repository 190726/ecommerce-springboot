package com.sk.product.application;

import com.sk.product.application.port.out.ProductFetchPort;
import com.sk.product.application.usecase.ProductFetchQuery;
import com.sk.product.domain.Product;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class ProductFetchService implements ProductFetchQuery {

    private final ProductFetchPort productFetchPort;

    @Override
    public Product findBy(long id) {
        return productFetchPort.findBy(id);
    }
}
