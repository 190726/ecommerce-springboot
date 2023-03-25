package com.sk.product.adapter.in;

import com.sk.product.application.usecase.ProductRegisterUseCase;
import com.sk.product.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
class ProductRegisterController {

    private final ProductRegisterUseCase productRegisterUseCase;

    @PostMapping("/product")
    public ResponseEntity<Void> register(@RequestBody ProductRegisterRequest request) {
        productRegisterUseCase.register(new Product(request.name(), request.price(), request.amount()));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    static record ProductRegisterRequest(String name, BigDecimal price, long amount) {
    }
}
