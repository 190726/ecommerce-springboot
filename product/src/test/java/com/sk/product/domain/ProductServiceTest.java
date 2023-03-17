package com.sk.product.domain;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Required;

public class ProductServiceTest {

    private ProductService productService;

    @BeforeEach
    void init() {
        ProductPersistencePort productPersistencePort = new ProductPersistencePort() {
            @Override
            public Product save(Product product) {
                return product;
            }
        };
        productService = new ProductService(productPersistencePort);
    }

    @Test
    void registerProduct() {

        Product product = new Product();
        productService.register(product);
    }

    @RequiredArgsConstructor
    private class ProductService {
        private final ProductPersistencePort productPersistencePort;

        public void register(Product product) {
            productPersistencePort.save(product);
        }


    }

    private class Product {

    }

    private interface ProductPersistencePort {
        Product save(Product product);
    }
}

