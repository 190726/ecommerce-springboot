package com.sk.delivery.domain;

import java.util.HashMap;
import java.util.Map;

public class DeliveryInMemoryPersistenceAdapter implements DeliveryPersistencePort {

    Map<Long, Invoice> persistenceMap = new HashMap<>();
    static Long sequence = 0L;
    @Override
    public Invoice save(Invoice invoice) {
        persistenceMap.put(++sequence, invoice);
        invoice.id(sequence);
        return invoice;
    }
}
