package com.sk.product.application;

import com.sk.product.adapter.out.InMemoryPersistenceAdapter;
import com.sk.product.application.port.out.ProductRegisterPort;
import com.sk.product.domain.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static com.sk.product.domain.ProductStub.productStub;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ProductServiceTest {

    private ProductRegisterService productService;
    private ProductValidator validator = new ProductValidator();

    @BeforeEach
    void init() {
        ProductRegisterPort productPersistencePort = new InMemoryPersistenceAdapter();
        productService = new ProductRegisterService(productPersistencePort, validator);
    }

    @Test
    void registerAndFindProduct() {
        Product product = productStub();
        final var register = productService.register(product);
        assertThat(register.getId()).isEqualTo(1L);
    }

    @Test
    @DisplayName("상품 유효성 체크")
    void validateProduct() {
        // given
        Product product = new Product("", BigDecimal.ONE, 5L);
        // when
        Assertions.assertThrows(IllegalArgumentException.class, ()->productService.register(product));
        // then
    }
}