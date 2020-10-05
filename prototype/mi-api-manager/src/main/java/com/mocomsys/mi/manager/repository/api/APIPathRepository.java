package com.mocomsys.mi.manager.repository.api;

import com.mocomsys.mi.manager.entity.api.APIEntity;
import com.mocomsys.mi.manager.entity.api.APIPathEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface APIPathRepository extends JpaRepository<APIPathEntity, Long> {
}
