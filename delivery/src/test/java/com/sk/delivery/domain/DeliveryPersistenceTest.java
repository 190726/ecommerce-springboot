package com.sk.delivery.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DeliveryPersistenceTest {

    private DeliveryPersistencePort deliveryPersistencePort = new DeliveryPersistenceAdapter();


    @Test
    @DisplayName("배달 DB 연결")
    void deliverTest() {
        Invoice invoice = new Invoice("송장");
        final var save = deliveryPersistencePort.save(invoice);
        Assertions.assertThat(save.getName()).isEqualTo(invoice.getName());
    }
}
