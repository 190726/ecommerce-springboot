package com.sk.product;

import com.sk.product.adapter.out.InMemoryPersistenceAdapter;
import com.sk.product.adapter.out.JpaPersistenceAdapter;
import com.sk.product.application.port.out.ProductFetchPort;
import com.sk.product.application.port.out.ProductRegisterPort;
import com.sk.product.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class ProductApplication {

    @Autowired
    private ProductRegisterPort registerPort;

    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }

    @Bean
    ApplicationRunner applicationRunner(){
        return args -> {
            registerPort.save(new Product("상품1", BigDecimal.ONE, 10L));
        };
    }

}