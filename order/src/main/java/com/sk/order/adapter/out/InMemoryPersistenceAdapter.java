package com.sk.order.adapter.out;

import com.sk.order.domain.Order;
import com.sk.order.application.port.out.OrderPersistencePort;

import java.util.HashMap;
import java.util.Map;

public class InMemoryPersistenceAdapter implements OrderPersistencePort {
    Map<Long, Order> persistenceMap = new HashMap<>();
    private static Long sequence = 0L;

    @Override
    public Order placed(Order order) {
        persistenceMap.put(++sequence, order);
        order.id(sequence);
        return order;
    }
}
