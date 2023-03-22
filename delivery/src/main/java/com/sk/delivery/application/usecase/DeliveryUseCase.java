package com.sk.delivery.application.usecase;

import com.sk.delivery.domain.Invoice;

public interface DeliveryUseCase {
    Invoice dispatch(Invoice invoice);
}
