package com.mocomsys.mi.manager.controller.api.v1.plan;

import com.mocomsys.mi.manager.entity.plan.PlanEntity;
import com.mocomsys.mi.manager.model.plan.ModelParamPlan;
import com.mocomsys.mi.manager.model.response.CommonResult;
import com.mocomsys.mi.manager.model.response.ListResult;
import com.mocomsys.mi.manager.model.response.SingleResult;
import com.mocomsys.mi.manager.service.plan.PlanService;
import com.mocomsys.mi.manager.service.response.ResponseService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"PLAN"})
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1")
public class PlanRestController {

    @Autowired
    private PlanService planService;
    @Autowired
    private ResponseService responseService;

    @GetMapping(value = "/plan/{id}")
    public SingleResult<PlanEntity> getPlan(@PathVariable long id) {
        return responseService.getSingleResult(planService.getPlan(id));
    }

    @GetMapping(value = "/plan")
    public ListResult<PlanEntity> getPlanList() {
        return responseService.getListResult(planService.getPlanList());
    }

    @PostMapping(value = "/plan")
    public void insertPlan(@RequestBody ModelParamPlan modelParamPlan) {
        planService.savePlan(modelParamPlan);
    }

    @PutMapping(value = "/plan/{id}")
    public Long updatePlan(@PathVariable long id, @RequestBody ModelParamPlan modelParamPlan) {
        return planService.updatePlan(id, modelParamPlan);
    }

    @DeleteMapping(value = "/plan/{id}")
    public CommonResult deletePlan(@PathVariable long id) {
        boolean ret = planService.deletePlan(id);
        return responseService.getResult(ret);
    }
}