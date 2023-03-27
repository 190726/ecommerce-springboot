package com.sk.product.adapter.in;

import com.sk.product.application.usecase.ProductFetchQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RequiredArgsConstructor
@RestController
public class ProductFetchController {
    private final ProductFetchQuery productFetchQuery;

    @GetMapping("/product/{id}")
    public ProductFetchResponse product(@PathVariable long id){
        final var find = productFetchQuery.findBy(id);
        return new ProductFetchResponse(find.getName(), find.getPrice(), find.getAmount());
    }

    static record ProductFetchResponse(String name, BigDecimal price, long amount){
    }
}
