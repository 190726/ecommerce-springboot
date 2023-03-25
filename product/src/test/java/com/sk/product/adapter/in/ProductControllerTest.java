package com.sk.product.adapter.in;

import com.sk.product.adapter.in.ProductRegisterController.ProductRegisterRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class ProductControllerTest {


    private ProductRegisterController productController = new ProductRegisterController(product -> product);

    @Test
    @DisplayName("ProductControllerTest")
    void controllerTest() {
        // given
        ProductRegisterRequest request = new ProductRegisterRequest("상품명", BigDecimal.ONE, 10L);
        productController.register(request);
        // when
        
        // then
    }

}
