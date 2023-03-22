package com.sk.delivery.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(AccessLevel.PRIVATE)
public class Invoice {
    private String name;
    private Long id;

    public Invoice(String name) {
        this.name = name;
    }

    public void id(Long id) {
        this.id = id;
    }
}
