package com.sk.product.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductServiceTest {

    private ProductService productService;

    @BeforeEach
    void init() {
        ProductPersistencePort productPersistencePort = new InMemoryPersistenceAdapter();
        productService = new ProductService(productPersistencePort);
    }

    @Test
    void registerProduct() {
        Product product = new Product();
        final var register = productService.register(product);
        assertThat(register.getId()).isEqualTo(1L);
    }

    @RequiredArgsConstructor
    private class ProductService {
        private final ProductPersistencePort productPersistencePort;

        public Product register(Product product) {
            return productPersistencePort.save(product);
        }
    }

    @Getter
    private class Product {

        private long id;

        public void id(long id) {
            this.id = id;
        }
    }

    private interface ProductPersistencePort {
        Product save(Product product);
    }

    private class InMemoryPersistenceAdapter implements ProductPersistencePort {
        Map<Long, Product> persistenceMap = new HashMap<>();
        private long sequence = 0L;
        @Override
        public Product save(Product product) {
            persistenceMap.put(++sequence, product);
            product.id(sequence);
            return product;
        }
    }
}