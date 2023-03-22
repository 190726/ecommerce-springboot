package com.sk.delivery.adapter.in;

import com.sk.delivery.application.usecase.DeliveryUseCase;
import com.sk.delivery.domain.Invoice;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class DeliveryController {
    private final DeliveryUseCase deliveryUseCase;
    public String delivery(DeliveryRequestDto request) {
        Invoice invoice = new Invoice("송장");
        deliveryUseCase.dispatch(invoice);
        return "success";
    }
    static class DeliveryRequestDto{

    }
}
