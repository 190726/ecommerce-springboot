package com.sk.order.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderPlacedServiceTest {

    private OrderPersistencePort orderPersistencePort = new InMemoryPersistenceAdapter(){

    };
    private OrderService orderService = new OrderService(orderPersistencePort);

    @Test
    @DisplayName("주문 생성 테스트")
    void orderPlacedTest() {
        // given
        Order order = new Order();
        // when
        final var placed = orderService.placed(order);
        Assertions.assertThat(placed.id()).isEqualTo(1L);
        // then
    }
}
