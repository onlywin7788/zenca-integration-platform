package com.mocomsys.mi.manager.repository.product;

import com.mocomsys.mi.manager.entity.product.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
