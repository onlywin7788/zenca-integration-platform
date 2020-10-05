package com.mocomsys.mi.manager.controller.api.v1.catalog;

import com.mocomsys.mi.manager.entity.catalog.CatalogEntity;
import com.mocomsys.mi.manager.model.catalog.ModelParamCatalog;
import com.mocomsys.mi.manager.model.response.CommonResult;
import com.mocomsys.mi.manager.model.response.ListResult;
import com.mocomsys.mi.manager.model.response.SingleResult;
import com.mocomsys.mi.manager.service.catalog.CatalogService;
import com.mocomsys.mi.manager.service.response.ResponseService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"CATALOG"})
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1")
public class CatalogRestController {

    private final CatalogService catalogService;
    private final ResponseService responseService;

    @GetMapping(value = "/catalog/{id}")
    public SingleResult<CatalogEntity> getCatalog(@PathVariable long id) {
        return responseService.getSingleResult(catalogService.getCatalog(id));
    }

    @GetMapping(value = "/catalog")
    public ListResult<CatalogEntity> getCatalogList() {
        return responseService.getListResult(catalogService.getCatalogList());
    }

    @PostMapping(value = "/catalog")
    public void insertCatalog(@RequestBody ModelParamCatalog modelParamCatalog) {
        catalogService.saveCatalog(modelParamCatalog);
    }

    @PostMapping(value = "/catalog/{id}")
    public Long updateCatalog(@PathVariable long id, @RequestBody ModelParamCatalog modelParamCatalog) {
        return catalogService.updateCatalog(id, modelParamCatalog);
    }

    @DeleteMapping(value = "/catalog/{id}")
    public CommonResult deleteCatalog(@PathVariable long id) {
        boolean ret = catalogService.deleteCatalog(id);
        return responseService.getResult(ret);
    }
}