package com.sk.delivery.application.port;

import com.sk.delivery.domain.Invoice;

public interface DeliveryPersistencePort {
    Invoice save(Invoice invoice);
}
