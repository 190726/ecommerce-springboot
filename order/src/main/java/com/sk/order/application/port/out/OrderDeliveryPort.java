package com.sk.order.application.port.out;

import com.sk.order.domain.Order;

public interface OrderDeliveryPort {

    void dispatch(Order order);
}
