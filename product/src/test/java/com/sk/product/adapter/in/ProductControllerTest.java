package com.sk.product.adapter.in;

import com.sk.product.adapter.in.ProductRegisterController.ProductRegisterRequest;
import com.sk.product.application.port.out.ProductRegisterPort;
import com.sk.product.domain.Product;
import com.sk.product.domain.ProductStub;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.transaction.Transactional;
import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItems;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    ProductRegisterPort registerPort;

    @BeforeEach
    void init(){
        RestAssured.port = port;
        
    }


    @Test
    @DisplayName("상품등록 api 호출 테스트")
    void productRegisterTest() {
        // given
        ProductRegisterRequest request = new ProductRegisterRequest("상품명", BigDecimal.ONE, 10L);
        // when
        final var response = RestAssured.given().log().all()
                .body(request)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when()
                .post("/product")
                .then().log().all().extract();
        // then
        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

    //@Transactional
    @Test
    @DisplayName("상품조회 api 호출 테스트")
    void productFetchTest() {
        // given
        final var save = registerPort.save(ProductStub.productStub());
        System.out.println(save);
        // when
        final var response = RestAssured.given().log().all()
                .get("/product/1")
                .then().log().all().extract();
        // then
        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
    }

}
