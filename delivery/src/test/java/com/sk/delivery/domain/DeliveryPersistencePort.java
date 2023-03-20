package com.sk.delivery.domain;

public interface DeliveryPersistencePort {
    Invoice save(Invoice invoice);
}
