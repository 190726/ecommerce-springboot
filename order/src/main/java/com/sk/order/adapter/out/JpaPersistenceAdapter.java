package com.sk.order.adapter.out;

import com.sk.order.application.port.out.OrderPlacedPort;
import com.sk.order.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class JpaPersistenceAdapter implements OrderPlacedPort {

    private final OrderEntityMapper orderEntityMapper;
    private final OrderMapper orderMapper;
    private final OrderJpaRepository orderJpaRepository;

    @Override
    public Order placed(Order order) {
        final var save = orderJpaRepository.save(orderEntityMapper.apply(order));
        return orderMapper.apply(save);
    }
}