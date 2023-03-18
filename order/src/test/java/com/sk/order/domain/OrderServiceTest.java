package com.sk.order.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    private OrderService orderService = new OrderService();

    @Test
    @DisplayName("")
    void orderPlacedTest() {
        // given
        // when
        Order order = null;
        orderService.placed(order);
        // then
    }
}
