package com.sk.order.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OrderCart {

    List<OrderItem> items;
    BigDecimal total;

    public OrderCart() {
        items = new ArrayList<>();
        total = BigDecimal.ZERO;
    }

    public void add(OrderItem item) {
        items.add(item);
        total = total.add(item.getPrice());
    }

    public void addAll(List<OrderItem> items){
        items.forEach(item -> add(item));
    }

    public List<OrderItem> orderItems(){
        return this.items;
    }

    public BigDecimal total(){
        return total;
    }
}