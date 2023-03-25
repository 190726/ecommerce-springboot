package com.sk.product.adapter.out;

import com.sk.product.application.port.out.ProductFetchPort;
import com.sk.product.application.port.out.ProductRegisterPort;
import com.sk.product.domain.Product;
import com.sk.product.domain.ProductStub;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JpaPersistenceAdapterTest {

    @Autowired
    ProductRegisterPort registerPort;

    @Autowired
    ProductFetchPort productFetchPort;

    @Transactional
    @Test
    @DisplayName("저장후조회")
    void saveAndFindById() {
        // given
        // when
        final var save = registerPort.save(ProductStub.productStub());
        final var find = productFetchPort.findBy(save.getId());
        Assertions.assertThat(find.getName()).isEqualTo(save.getName());
        // then
    }

}