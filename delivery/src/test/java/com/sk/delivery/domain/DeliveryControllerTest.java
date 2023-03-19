package com.sk.delivery.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DeliveryControllerTest {

    private DeliveryController deliveryController = new DeliveryController();

    @Test
    @DisplayName("배달테스트")
    void deliveryTest() {
        // given

        // when
        DeliveryRequestDto request = new DeliveryRequestDto();
        deliveryController.delivery(request);
        // then
    }
}
