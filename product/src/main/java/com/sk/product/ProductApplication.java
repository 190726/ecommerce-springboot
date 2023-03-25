package com.sk.product;

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



    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }


}