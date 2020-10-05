package com.mocomsys.mi.manager.service.product;

import com.mocomsys.mi.manager.controller.advice.exception.CommonException;
import com.mocomsys.mi.manager.entity.product.ProductEntity;
import com.mocomsys.mi.manager.model.product.ModelParamProduct;
import com.mocomsys.mi.manager.repository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductEntity getProduct(Long id) {
        return productRepository.findById(id).orElseThrow(() ->
                new CommonException("EX"));
    }

    public List<ProductEntity> getProductList()
    {
        return productRepository.findAll();
    }

    @Transactional
    public Long saveProduct(ModelParamProduct modelParamProduct) {
        ProductEntity product = ProductEntity.builder()
                .productName(modelParamProduct.getProductName())
                .catalogId(modelParamProduct.getCatalogId())
                .description(modelParamProduct.getDescription())
                .build();

        return productRepository.save(product).getProductId();
    }

    @Transactional
    public Long updateProduct(long id, ModelParamProduct modelParamProduct) {

        ProductEntity product = getProduct(id);
        product.update(modelParamProduct.getProductName(), modelParamProduct.getCatalogId(), modelParamProduct.getDescription());
        return id;
    }

    @Transactional
    public boolean deleteProduct(long id) {
        ProductEntity product = getProduct(id);
        if(product == null)
            return false;
        productRepository.delete(product);
        return true;
    }
}