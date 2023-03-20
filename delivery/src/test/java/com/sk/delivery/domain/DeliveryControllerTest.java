package com.sk.delivery.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DeliveryControllerTest {

    private DeliveryController deliveryController = new DeliveryController(iv->iv);

    @Test
    @DisplayName("배달테스트")
    void deliveryTest() {
        // given
        DeliveryRequestDto request = new DeliveryRequestDto();
        // when
        final var result = deliveryController.delivery(request);
        // then
        Assertions.assertThat(result).isEqualTo("success");
    }
}