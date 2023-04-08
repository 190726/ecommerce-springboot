package com.sk.order.adapter.out;

import com.sk.order.application.port.out.OrderPlacedPort;
import com.sk.order.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class JpaPersistenceAdapter implements OrderPlacedPort {

    private final OrderJpaRepository orderJpaRepository;

    @Override
    public Order placed(Order order) {
        throw new UnsupportedOperationException("not implement");
    }
}
