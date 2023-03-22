package com.sk.delivery.application;

import com.sk.delivery.application.port.DeliveryPersistencePort;
import com.sk.delivery.application.usecase.DeliveryUseCase;
import com.sk.delivery.domain.Invoice;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class DeliveryService implements DeliveryUseCase {

    private final DeliveryPersistencePort persistencePort;

    @Override
    public Invoice dispatch(Invoice invoice) {
        return persistencePort.save(invoice);
    }
}