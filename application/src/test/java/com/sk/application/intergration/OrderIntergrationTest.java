package com.sk.application.intergration;

import com.sk.order.domain.Order;
import com.sk.product.domain.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class OrderIntergrationTest {

    @Test
    @DisplayName("주문통합테스트")
    void orderTest() {
        // given
        Product product = new Product("상품명", BigDecimal.ONE, 10L);
        Order order = new Order();
        // when
        
        // then
    }
}
