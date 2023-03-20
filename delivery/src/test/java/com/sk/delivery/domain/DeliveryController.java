package com.sk.delivery.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeliveryController {
    private final DeliveryUseCase deliveryUseCase;
    public String delivery(DeliveryRequestDto request) {
        Invoice invoice = new Invoice("송장");
        deliveryUseCase.dispatch(invoice);
        return "success";

    }
}
