package com.sk.product.adapter.out;

import com.sk.product.domain.Product;
import com.sk.product.domain.ProductPersistencePort;

import java.util.HashMap;
import java.util.Map;

public class InMemoryPersistenceAdapter implements ProductPersistencePort {
    Map<Long, Product> persistenceMap = new HashMap<>();
    private long sequence = 0L;

    @Override
    public Product save(Product product) {
        persistenceMap.put(++sequence, product);
        product.id(sequence);
        return product;
    }
}
