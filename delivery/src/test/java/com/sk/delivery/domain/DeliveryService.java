package com.sk.delivery.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeliveryService implements DeliveryUseCase {

    private final DeliveryPersistencePort persistencePort;

    @Override
    public Invoice dispatch(Invoice invoice) {
        return persistencePort.save(invoice);
    }
}