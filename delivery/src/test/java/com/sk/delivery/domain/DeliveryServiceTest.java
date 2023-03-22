package com.sk.delivery.domain;

import com.sk.delivery.application.DeliveryService;
import com.sk.delivery.application.usecase.DeliveryUseCase;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DeliveryServiceTest {

    private DeliveryUseCase service = new DeliveryService(iv -> iv);

    @Test
    @DisplayName("배달서비스 테스트")
    void deliveryServiceTest() {
        // given
        final var invoice = new Invoice("송장1");
        // when
        final var dispatch = service.dispatch(invoice);

        // then
        Assertions.assertThat(dispatch.getName()).isEqualTo(invoice.getName());
    }
}
