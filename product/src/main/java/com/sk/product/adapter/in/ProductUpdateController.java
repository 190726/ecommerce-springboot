package com.sk.product.adapter.in;

import com.sk.product.application.usecase.ProductRegisterUseCase;
import com.sk.product.application.usecase.ProductUpdateUseCase;
import com.sk.product.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
class ProductUpdateController {

    private final ProductRegisterUseCase productRegisterUseCase;
    private final ProductUpdateUseCase productUpdateUseCase;

    @PostMapping("/product")
    public ResponseEntity<Void> register(@RequestBody @Valid ProductRegisterRequest request) {

        productRegisterUseCase.register(new Product(request.name(), request.price(), request.amount()));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/product")
    public ResponseEntity<Void> update(@RequestBody @Valid ProductUpdateRequest request) {

        productUpdateUseCase.update(new Product(request.id(), request.name(), request.price(), request.amount()));
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    static record ProductRegisterRequest(
            @NotBlank(message = "상품명 파라미터는 필수입니다.") String name,
            @DecimalMin(value = "0.0", inclusive = false, message = "가격 파라미터는 0을 초과해야 합니다.") BigDecimal price,
            @Min(value = 1L, message = "수량의 최소값은 1입니다.") long amount) {
    }

    static record ProductUpdateRequest(
            Long id,
            @NotBlank(message = "상품명 파라미터는 필수입니다.") String name,
            @DecimalMin(value = "0.0", inclusive = false, message = "가격 파라미터는 0을 초과해야 합니다.") BigDecimal price,
            @Min(value = 1L, message = "수량의 최소값은 1입니다.") long amount) {
    }
}
