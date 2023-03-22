package com.sk.delivery.adapter.in;

import com.sk.delivery.adapter.in.DeliveryController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DeliveryControllerTest {

    private DeliveryController deliveryController = new DeliveryController(iv->iv);

    @Test
    @DisplayName("배달테스트")
    void deliveryTest() {
        // given
        DeliveryController.DeliveryRequestDto request = new DeliveryController.DeliveryRequestDto();
        // when
        final var result = deliveryController.delivery(request);
        // then
        Assertions.assertThat(result).isEqualTo("success");
    }
}