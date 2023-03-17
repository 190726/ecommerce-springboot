package com.sk.product.domain;

import org.junit.jupiter.api.Test;

public class ProductServiceTest {

    private ProductService productService = new ProductService();

    @Test
    void registerProduct() {

        Product product = new Product();
        productService.register(product);
    }

    private class Product {
    }

    private class ProductService {
        public void register(Product request) {
            throw new UnsupportedOperationException("not implement");
        }
    }
}

