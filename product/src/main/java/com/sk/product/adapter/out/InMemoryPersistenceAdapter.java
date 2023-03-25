package com.sk.product.adapter.out;

import com.sk.product.application.ProductFetchPort;
import com.sk.product.domain.Product;
import com.sk.product.application.port.out.ProductRegisterPort;

import java.util.HashMap;
import java.util.Map;

public class InMemoryPersistenceAdapter implements ProductRegisterPort, ProductFetchPort {
    Map<Long, Product> persistenceMap = new HashMap<>();
    private long sequence = 0L;

    @Override
    public Product save(Product product) {
        persistenceMap.put(++sequence, product);
        product.id(sequence);
        return product;
    }

    @Override
    public Product findBy(long id) {
        return persistenceMap.get(id);
    }
}
