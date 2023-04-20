package com.sk.order.application;

import com.sk.order.application.port.out.OrderPlacedPort;
import com.sk.order.application.usecase.OrderDeliveryUseCase;
import com.sk.order.application.usecase.OrderPlacedUseCase;
import com.sk.order.domain.Order;
import org.springframework.stereotype.Service;

@Service
class OrderPlacedService implements OrderPlacedUseCase {

    private final OrderPlacedPort orderPersistencePort;

    public OrderPlacedService(OrderPlacedPort orderPersistencePort) {
        this.orderPersistencePort = orderPersistencePort;
    }

    @Override
    public Order placed(Order order) {
        return orderPersistencePort.placed(order);
    };
}
