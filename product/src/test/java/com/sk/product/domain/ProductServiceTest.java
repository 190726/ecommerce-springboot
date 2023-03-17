package com.sk.product.domain;

import com.sk.product.adapter.out.InMemoryPersistenceAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

}