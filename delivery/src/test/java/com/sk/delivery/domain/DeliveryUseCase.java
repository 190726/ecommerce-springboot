package com.sk.delivery.domain;

public interface DeliveryUseCase {
    void dispatch(Invoice invoice);
}
