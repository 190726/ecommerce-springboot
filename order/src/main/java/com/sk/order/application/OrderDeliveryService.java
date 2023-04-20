package com.sk.order.application;

import com.sk.order.application.port.out.OrderDeliveryPort;
import com.sk.order.application.port.out.OrderDerliveryPort;
import com.sk.order.application.usecase.OrderDeliveryUseCase;

public class OrderDeliveriedService implements OrderDeliveryUseCase {

    private final OrderDeliveryPort orderDeliveryPort;

    public OrderDeliveriedService(OrderDeliveryPort orderDeliveryPort) {
        this.orderDeliveryPort = orderDeliveryPort;
    }

    @Override
    public void delivery(Order order) {
        orderDerliveryPort.dispatch(order);
    }

    @Override
    public void delivery() {

    }
}
