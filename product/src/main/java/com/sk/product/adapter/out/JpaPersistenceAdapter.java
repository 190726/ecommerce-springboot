package com.sk.product.adapter.out;

import com.sk.product.application.port.out.ProductFetchPort;
import com.sk.product.application.ProductNotExistException;
import com.sk.product.application.port.out.ProductRegisterPort;
import com.sk.product.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class JpaPersistenceAdapter implements ProductRegisterPort, ProductFetchPort {

    private final ProductJpaRepository productJpaRepository;
    private final ProductMapper productMapper;
    private final ProductEntityMapper productEntityMapper;

    @Override
    public Product findBy(long id) {
        return productJpaRepository.findById(id).map(productMapper)
                .orElseThrow(()->new ProductNotExistException("not exist product, id is " + id));
    }

    @Override
    public Product save(Product product) {
        return productMapper.apply(
            productJpaRepository.save(productEntityMapper.apply(product))
        );
    }
}
