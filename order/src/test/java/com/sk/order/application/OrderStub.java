package com.sk.order.application;

import com.sk.order.domain.Order;
import com.sk.order.domain.OrderItem;

import java.math.BigDecimal;

public class OrderStub {
    static Order stub(){
        // given
        Order order = new Order();
        // when
        OrderItem item1 = new OrderItem(1L, "상품명1", BigDecimal.ONE);
        order.addItem(item1);
        OrderItem item2 = new OrderItem(2L, "상품명2", BigDecimal.TEN);
        order.addItem(item2);
        return order;
    }
}