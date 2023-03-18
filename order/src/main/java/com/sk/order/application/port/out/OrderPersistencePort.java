package com.sk.order.domain;

public interface OrderPersistencePort {
    Order placed(Order order);
}
