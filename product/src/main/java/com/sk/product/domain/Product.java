package com.sk.product.domain;

import lombok.Getter;

@Getter
public
class Product {

    private long id;

    public void id(long id) {
        this.id = id;
    }
}
