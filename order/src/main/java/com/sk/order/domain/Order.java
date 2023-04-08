package com.sk.order.domain;

import ch.qos.logback.core.BasicStatusManager;

import java.math.BigDecimal;
import java.util.List;

public class Order {

    private Long id;
    private OrderCart cart;
    private OrderStatus orderStatus;

    public Order(){
        orderStatus = OrderStatus.Placed;
    }

    public Order(Long id, OrderStatus orderStatus, OrderCart orderCart){
        this.id = id;
        this.orderStatus = orderStatus;
        this.cart = cart;
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

    public List<OrderItem> orderItems(){
        return  this.cart.orderItems();
    }

    public BigDecimal total(){
        return cart.total();
    }
}