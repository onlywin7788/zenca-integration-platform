package com.mocomsys.mi.manager.service.plan;

import com.mocomsys.mi.manager.controller.advice.exception.CommonException;
import com.mocomsys.mi.manager.entity.plan.PlanEntity;
import com.mocomsys.mi.manager.model.plan.ModelParamPlan;
import com.mocomsys.mi.manager.repository.plan.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class PlanService {

    @Autowired
    private PlanRepository planRepository;

    public PlanEntity getPlan(Long id) {
        return planRepository.findById(id).orElseThrow(() ->
                new CommonException("EX"));
    }

    public List<PlanEntity> getPlanList()
    {
        return planRepository.findAll();
    }

    @Transactional
    public Long savePlan(ModelParamPlan modelParamPlan) {
        PlanEntity plan = PlanEntity.builder()
                .planName(modelParamPlan.getPlanName())
                .productId(modelParamPlan.getProductId())
                .description(modelParamPlan.getDescription())
                .build();

        return planRepository.save(plan).getPlanId();
    }

    @Transactional
    public Long updatePlan(long id, ModelParamPlan modelParamPlan) {

        PlanEntity plan = getPlan(id);
        plan.update(modelParamPlan.getPlanName(), modelParamPlan.getProductId(), modelParamPlan.getDescription());
        return id;
    }

    @Transactional
    public boolean deletePlan(long id) {
        PlanEntity plan = getPlan(id);
        if(plan == null)
            return false;
        planRepository.delete(plan);
        return true;
    }
}