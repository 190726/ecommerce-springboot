package com.sk.order.domain;

public class OrderPlacedService {

    private final OrderPersistencePort orderPersistencePort;

    public OrderPlacedService(OrderPersistencePort orderPersistencePort) {
        this.orderPersistencePort = orderPersistencePort;
    }

    public Order placed(Order order) {
        return orderPersistencePort.placed(order);
    };
}
