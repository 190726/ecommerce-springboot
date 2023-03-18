package com.sk.order.application.usecase;

import com.sk.order.domain.Order;

public interface OrderPlacedUseCase {

    Order placed(Order order);
}
