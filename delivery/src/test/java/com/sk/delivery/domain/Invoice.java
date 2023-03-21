package com.sk.delivery.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(AccessLevel.PRIVATE)
@AllArgsConstructor
public class Invoice {
    private String name;
    private Long id;

    public void id(Long id) {
        this.id = id;
    }
}
