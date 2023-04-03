package com.sk.order.application;

import com.sk.order.adapter.out.InMemoryPersistenceAdapter;
import com.sk.order.application.port.out.OrderPersistencePort;
import com.sk.order.domain.Order;
import com.sk.order.domain.OrderItem;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderPlacedServiceTest {

    private OrderPersistencePort orderPersistencePort = new InMemoryPersistenceAdapter(){

    };
    private OrderPlacedService orderService = new OrderPlacedService(orderPersistencePort);

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
    
    @Test
    @DisplayName("")
    void addOrderItemTest() {
        // given
        Order order = new Order();
        // when
        OrderItem item1;
        //order.addItem(item1);
        // then
    }
}
