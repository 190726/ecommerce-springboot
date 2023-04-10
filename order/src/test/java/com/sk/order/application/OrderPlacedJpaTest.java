package com.sk.order.application;

import com.sk.order.adapter.out.JpaPersistenceAdapter;
import com.sk.order.application.port.out.OrderPlacedPort;
import com.sk.order.application.usecase.OrderPlacedUseCase;
import com.sk.order.domain.Order;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderPlacedJpaTest {

    @Autowired
    OrderPlacedUseCase orderPlacedUseCase;

    @Test
    @DisplayName("order placed jpa test")
    void orderPlaced() {
        // given
        Order order = OrderStub.stub();
        // when
        final var placed = orderPlacedUseCase.placed(order);
        // then
        Assertions.assertThat(placed.total()).isEqualTo(order.total());
    }

}
