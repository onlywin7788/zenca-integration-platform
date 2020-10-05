package com.mocomsys.mi.manager.controller.api.v1.api;

import com.mocomsys.mi.manager.entity.api.APIPathEntity;
import com.mocomsys.mi.manager.model.api.ModelParamAPIPath;
import com.mocomsys.mi.manager.model.response.CommonResult;
import com.mocomsys.mi.manager.model.response.ListResult;
import com.mocomsys.mi.manager.model.response.SingleResult;
import com.mocomsys.mi.manager.service.api.APIPathService;
import com.mocomsys.mi.manager.service.response.ResponseService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"API-PATH"})
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1")
public class APIPathRestController {

    private final APIPathService apiPathService;
    private final ResponseService responseService;

    @GetMapping(value = "/api-path/{id}")
    public SingleResult<APIPathEntity> getAPIPath(@PathVariable long id) {
        return responseService.getSingleResult(apiPathService.getAPIPath(id));
    }

    @GetMapping(value = "/api-path")
    public ListResult<APIPathEntity> getAPIPathList() {
        return responseService.getListResult(apiPathService.getAPIPathList());
    }

    @PostMapping(value = "/api-path")
    public void insertAPI(@RequestBody ModelParamAPIPath param) {
        apiPathService.saveAPIPath(param);
    }

    @PostMapping(value = "/api-path/{id}")
    public Long updateAPIPath(@PathVariable long id, @RequestParam(required = true) String methodName) {
        return apiPathService.updateAPI(id, methodName);
    }

    @DeleteMapping(value = "/api-path/{id}")
    public CommonResult deleteAPIPath(@PathVariable long id) {
        boolean ret = apiPathService.deleteAPI(id);
        return responseService.getResult(ret);
    }
}