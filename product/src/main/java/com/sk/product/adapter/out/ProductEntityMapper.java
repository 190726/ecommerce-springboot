package com.sk.product.adapter.out;

import com.sk.product.domain.Product;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ProductEntityMapper implements Function<Product, ProductEntity> {
    @Override
    public ProductEntity apply(Product product) {
        if(product.getId() > 0L){
            return new ProductEntity(product.getId(), product.getName(), product.getPrice(), product.getAmount());
        }
        return new ProductEntity(product.getName(), product.getPrice(), product.getAmount());
    }
}
