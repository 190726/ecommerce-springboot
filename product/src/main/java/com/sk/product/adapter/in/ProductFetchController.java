package com.sk.product.adapter.in;

import com.sk.product.application.ProductNotExistException;
import com.sk.product.application.usecase.ProductFetchQuery;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
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

    @ExceptionHandler(ProductNotExistException.class)
    public ResponseEntity<ProductFetchErrorResponse> productNotException(ProductNotExistException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ProductFetchErrorResponse(404, ex.getMessage()));
    }

    static record ProductFetchErrorResponse(long id, String message){
    }
}
