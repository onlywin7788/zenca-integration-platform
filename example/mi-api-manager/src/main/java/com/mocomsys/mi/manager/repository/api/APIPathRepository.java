package com.mocomsys.mi.manager.repository.api;

import com.mocomsys.mi.manager.entity.api.APIEntity;
import com.mocomsys.mi.manager.entity.api.APIPathEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface APIPathRepository extends JpaRepository<APIPathEntity, Long> {
    @Query(value = "SELECT * FROM API_PATH WHERE API_ID=?1", nativeQuery = true)
    List<APIPathEntity> getAPIPathListByApiId(Long apiId);

    @Query(value = "DELETE FROM API_PATH WHERE API_ID=?1", nativeQuery = true)
    void deleteAPIPathListByApiId(long apiId);
}
