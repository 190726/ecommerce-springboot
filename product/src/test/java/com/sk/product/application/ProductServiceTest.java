package com.sk.product.application;

import com.sk.product.adapter.out.InMemoryPersistenceAdapter;
import com.sk.product.application.port.out.ProductRegisterPort;
import com.sk.product.application.usecase.ProductFetchQuery;
import com.sk.product.application.usecase.ProductRegisterUseCase;
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

    private ProductRegisterUseCase registerUseCase;
    private ProductValidator validator = new ProductValidator();
    private ProductFetchQuery productFetchQuery;

    @BeforeEach
    void init() {
        InMemoryPersistenceAdapter persistenceAdapter = new InMemoryPersistenceAdapter();
        registerUseCase = new ProductRegisterService(persistenceAdapter, validator);
        productFetchQuery = new ProductFetchService(persistenceAdapter);
    }

    @Test
    void registerProduct() {
        Product product = productStub();
        final var register = registerUseCase.register(product);
        assertThat(register.getId()).isEqualTo(1L);
    }

    @Test
    @DisplayName("상품 유효성 체크")
    void validateProduct() {
        // given
        Product product = new Product("상품", BigDecimal.ONE, 0);
        // when
        Assertions.assertThrows(IllegalArgumentException.class, ()-> registerUseCase.register(product));
        // then
    }

    @Test
    @DisplayName("상품조회하기")
    void findByIdProductTest() {
        // given
        Product product = productStub();
        final var register = registerUseCase.register(product);
        // when
        final var find = productFetchQuery.findBy(1L);
        assertThat(find.getId()).isEqualTo(1L);
        // then
    }
}