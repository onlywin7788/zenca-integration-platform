package com.mocomsys.mi.manager.controller.api.v1.api;

import com.mocomsys.mi.manager.entity.api.APIEntity;
import com.mocomsys.mi.manager.model.api.ModelParamAPI;
import com.mocomsys.mi.manager.model.response.CommonResult;
import com.mocomsys.mi.manager.model.response.ListResult;
import com.mocomsys.mi.manager.model.response.SingleResult;
import com.mocomsys.mi.manager.service.api.APIService;
import com.mocomsys.mi.manager.service.response.ResponseService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"API"})
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1")
public class APIRestController {

    private final APIService apiService;
    private final ResponseService responseService;

    @GetMapping(value = "/api/{id}")
    public SingleResult<APIEntity> getAPI(@PathVariable long id) {
        return responseService.getSingleResult(apiService.getAPI(id));
    }

    @GetMapping(value = "/api")
    public ListResult<APIEntity> getAPIList() {
        return responseService.getListResult(apiService.getAPIList());
    }

    @PostMapping(value = "/api")
    public void insertAPI(@RequestBody ModelParamAPI modelParamAPI) {
        apiService.saveAPI(modelParamAPI);
    }

    @PostMapping(value = "/api/{id}")
    public Long updateAPI(@PathVariable long id, @RequestBody ModelParamAPI modelParamAPI) {
        return apiService.updateAPI(id, modelParamAPI);
    }

    @DeleteMapping(value = "/api/{id}")
    public CommonResult deleteAPI(@PathVariable long id) {
        boolean ret = apiService.deleteAPI(id);
        return responseService.getResult(ret);
    }
}