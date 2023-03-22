package com.sk.order.application;

import com.sk.order.application.port.out.OrderPersistencePort;
import com.sk.order.application.usecase.OrderPlacedUseCase;
import com.sk.order.domain.Order;

class OrderPlacedService implements OrderPlacedUseCase {

    private final OrderPersistencePort orderPersistencePort;

    public OrderPlacedService(OrderPersistencePort orderPersistencePort) {
        this.orderPersistencePort = orderPersistencePort;
    }

    @Override
    public Order placed(Order order) {
        return orderPersistencePort.placed(order);
    };
}
