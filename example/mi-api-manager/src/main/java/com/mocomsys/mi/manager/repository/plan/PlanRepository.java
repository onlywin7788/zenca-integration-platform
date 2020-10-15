package com.mocomsys.mi.manager.repository.plan;

import com.mocomsys.mi.manager.entity.plan.PlanEntity;
import com.mocomsys.mi.manager.entity.product.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<PlanEntity, Long> {
}
