package com.sk.order.adapter.out;

import com.sk.order.domain.OrderStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Getter
@NoArgsConstructor
@Table(name = "ORDERS")
@Entity
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "ORDER_STATUS")
    private OrderStatus orderStatus;

    @Column(name = "TOTAL_PRICE")
    private BigDecimal totalPrice;

    @ElementCollection
    @CollectionTable(name = "ORDER_ITEMS",
            joinColumns = @JoinColumn(name = "ORDER_ITEM_ID", referencedColumnName = "id"))
    private List<OrderItemEntity> orderItems;

    public OrderEntity(OrderStatus orderStatus, BigDecimal totalPrice, List<OrderItemEntity> orderItems){
        this.orderStatus = orderStatus;
        this.totalPrice = totalPrice;
        this.orderItems =orderItems;
    }

}
