package com.mocomsys.mi.manager.repository.api;

import com.mocomsys.mi.manager.entity.api.APIEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface APIRepository extends JpaRepository<APIEntity, Long> {
}
