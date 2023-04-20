package com.sk.order.application;

import com.sk.order.application.port.out.OrderDeliveryPort;
import com.sk.order.application.usecase.OrderDeliveryUseCase;
import com.sk.order.domain.Order;

public class OrderDeliveryService implements OrderDeliveryUseCase {

    private final OrderDeliveryPort orderDeliveryPort;

    public OrderDeliveryService(OrderDeliveryPort orderDeliveryPort) {
        this.orderDeliveryPort = orderDeliveryPort;
    }

    @Override
    public void delivery(Order order) {
        orderDeliveryPort.dispatch(order);
    }
}
