package com.sk.order.application;

import com.sk.order.adapter.out.InMemoryPersistenceAdapter;
import com.sk.order.application.port.out.OrderPersistencePort;
import com.sk.order.domain.Order;
import com.sk.order.domain.OrderItem;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

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
    @DisplayName("주문 아이템 생성후 카트에 담기")
    void addOrderItemTest() {
        // given
        Order order = new Order();
        // when
        OrderItem item1 = new OrderItem(1L, "상품명1", BigDecimal.ONE);
        order.addItem(item1);
        OrderItem item2 = new OrderItem(2L, "상품명2", BigDecimal.TEN);
        order.addItem(item2);
        // then
        final var total = order.total();
        Assertions.assertThat(total).isEqualTo(new BigDecimal(11.0));
    }
}
