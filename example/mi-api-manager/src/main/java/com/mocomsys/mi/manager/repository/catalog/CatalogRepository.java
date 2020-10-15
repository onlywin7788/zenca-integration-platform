package com.mocomsys.mi.manager.repository.catalog;

import com.mocomsys.mi.manager.entity.catalog.CatalogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogRepository extends JpaRepository<CatalogEntity, Long> {
}
