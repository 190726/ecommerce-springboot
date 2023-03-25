package com.sk.product.adapter.out;

import com.sk.product.domain.Product;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ProductMapper implements Function<ProductEntity, Product> {
    @Override
    public Product apply(ProductEntity productEntity) {
        return new Product(productEntity.getId(),
                           productEntity.getName(),
                           productEntity.getPrice(),
                           productEntity.getAmount());
    }
}
