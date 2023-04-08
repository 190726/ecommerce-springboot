package com.sk.order.adapter.out;

import com.sk.order.domain.Order;
import com.sk.order.domain.OrderCart;
import com.sk.order.domain.OrderItem;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class OrderMapper implements Function<OrderEntity, Order> {
    @Override
    public Order apply(OrderEntity orderEntity) {

        final var orderItems = orderEntity.getOrderItems().stream().map(oi
                        -> new OrderItem(oi.getProductId(), oi.getProductName(), oi.getPrice(), oi.getQuantity()))
                .toList();
        OrderCart cart = new OrderCart();
        cart.addAll(orderItems);
        return new Order(orderEntity.getId(), orderEntity.getOrderStatus(), cart);
    }
}
