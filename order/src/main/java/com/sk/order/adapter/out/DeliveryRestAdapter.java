package com.sk.order.adapter.out;

import com.sk.order.application.port.out.OrderDeliveryPort;
import com.sk.order.domain.Order;

public class DeliveryRestAdapter implements OrderDeliveryPort {
    @Override
    public void dispatch(Order order) {


        throw new UnsupportedOperationException("not implement");
    }
}