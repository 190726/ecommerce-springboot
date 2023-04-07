package com.sk.order.domain;

import ch.qos.logback.core.BasicStatusManager;

import java.math.BigDecimal;

public class Order {

    private Long id;
    private OrderCart cart;
    private OrderStatus orderStatus;

    public Order(){
        orderStatus = OrderStatus.Placed;
    }

    public void id(Long id) {
        this.id = id;
    }

    public Long id() {
        return this.id;
    }

    public void addItem(OrderItem item) {
        if(cart == null) cart = new OrderCart();
        cart.add(item);
    }

    public BigDecimal total(){
        return cart.total();
    }
}