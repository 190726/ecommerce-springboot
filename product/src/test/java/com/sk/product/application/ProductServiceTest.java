package com.sk.product.application;

import com.sk.product.adapter.out.InMemoryPersistenceAdapter;
import com.sk.product.application.port.out.ProductRegisterPort;
import com.sk.product.domain.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.sk.product.domain.ProductStub.productStub;
import static org.assertj.core.api.Assertions.assertThat;

public class ProductServiceTest {

    private ProductRegisterService productService;

    @BeforeEach
    void init() {
        ProductRegisterPort productPersistencePort = new InMemoryPersistenceAdapter();
        productService = new ProductRegisterService(productPersistencePort);
    }

    @Test
    void registerProduct() {
        Product product = productStub();
        final var register = productService.register(product);
        assertThat(register.getId()).isEqualTo(1L);
    }
}