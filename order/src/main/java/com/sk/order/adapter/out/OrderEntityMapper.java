package com.sk.order.adapter.out;

import com.sk.order.domain.Order;
import com.sk.order.domain.OrderItem;
import com.sk.order.domain.OrderStatus;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class OrderEntityMapper implements Function<Order, OrderEntity> {
    @Override
    public OrderEntity apply(Order order) {

        final var orderItemEntities = order.orderItems().stream().map(item
                        -> new OrderItemEntity(item.getProductId(), item.getProductName(), item.getPrice(), item.getQuantity()))
                .toList();
        return new OrderEntity(OrderStatus.Placed, order.total(), orderItemEntities);
    }
}
