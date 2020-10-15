package com.mocomsys.mi.manager.controller.api.v1.api;

import com.mocomsys.mi.manager.controller.api.v1.common.DataLastID;
import com.mocomsys.mi.manager.entity.api.APIEntity;
import com.mocomsys.mi.manager.model.api.ModelParamAPI;
import com.mocomsys.mi.manager.model.response.CommonResult;
import com.mocomsys.mi.manager.model.response.ListResult;
import com.mocomsys.mi.manager.model.response.SingleResult;
import com.mocomsys.mi.manager.service.api.APIService;
import com.mocomsys.mi.manager.service.response.ResponseService;
import io.swagger.annotations.Api;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sound.sampled.DataLine;
import java.util.List;

@Api(tags = {"API"})
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1")
public class APIRestController {

    @Autowired
    private APIService apiService;
    @Autowired
    private ResponseService responseService;

    @GetMapping(value = "/api/{id}")
    public SingleResult<APIEntity> getAPI(@PathVariable long id) {
        return responseService.getSingleResult(apiService.getAPI(id));
    }

    @GetMapping(value = "/api")
    public ListResult<APIEntity> getAPIList() {
        return responseService.getListResult(apiService.getAPIList());
    }

    @PostMapping(value = "/api")
    public SingleResult<APIEntity> insertAPI(@RequestBody ModelParamAPI modelParamAPI) {
        return responseService.getSingleResult(apiService.saveAPI(modelParamAPI));
    }

    @PutMapping(value = "/api/{id}")
    public Long updateAPI(@PathVariable long id, @RequestBody ModelParamAPI modelParamAPI) {
        return apiService.updateAPI(id, modelParamAPI);
    }

    @DeleteMapping(value = "/api/{id}")
    public CommonResult deleteAPI(@PathVariable long id) {
        boolean ret = apiService.deleteAPI(id);
        return responseService.getResult(ret);
    }
}