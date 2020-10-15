package com.mocomsys.mi.manager.controller.api.v1.product;

import com.mocomsys.mi.manager.entity.product.ProductEntity;
import com.mocomsys.mi.manager.model.product.ModelParamProduct;
import com.mocomsys.mi.manager.model.response.CommonResult;
import com.mocomsys.mi.manager.model.response.ListResult;
import com.mocomsys.mi.manager.model.response.SingleResult;
import com.mocomsys.mi.manager.service.product.ProductService;
import com.mocomsys.mi.manager.service.response.ResponseService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"PRODUCT"})
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1")
public class ProductRestController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ResponseService responseService;

    @GetMapping(value = "/product/{id}")
    public SingleResult<ProductEntity> getProduct(@PathVariable long id) {
        return responseService.getSingleResult(productService.getProduct(id));
    }

    @GetMapping(value = "/product")
    public ListResult<ProductEntity> getProductList() {
        return responseService.getListResult(productService.getProductList());
    }

    @PostMapping(value = "/product")
    public void insertProduct(@RequestBody ModelParamProduct modelParamProduct) {
        productService.saveProduct(modelParamProduct);
    }

    @PutMapping(value = "/product/{id}")
    public Long updateProduct(@PathVariable long id, @RequestBody ModelParamProduct modelParamProduct) {
        return productService.updateProduct(id, modelParamProduct);
    }

    @DeleteMapping(value = "/product/{id}")
    public CommonResult deleteProduct(@PathVariable long id) {
        boolean ret = productService.deleteProduct(id);
        return responseService.getResult(ret);
    }
}