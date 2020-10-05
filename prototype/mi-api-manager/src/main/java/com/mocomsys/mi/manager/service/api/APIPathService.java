package com.mocomsys.mi.manager.service.api;

import com.mocomsys.mi.manager.controller.advice.exception.CommonException;
import com.mocomsys.mi.manager.entity.api.APIPathEntity;
import com.mocomsys.mi.manager.model.api.ModelParamAPIPath;
import com.mocomsys.mi.manager.repository.api.APIPathRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class APIPathService {

    @Autowired
    private APIPathRepository apiPathRepository;

    public APIPathEntity getAPIPath(Long id) {
        return apiPathRepository.findById(id).orElseThrow(() ->
                new CommonException("EX"));
    }

    public List<APIPathEntity> getAPIPathList()
    {
        return apiPathRepository.findAll();
    }

    @Transactional
    public Long saveAPIPath(ModelParamAPIPath modelParamAPIPath) {
        APIPathEntity apiPath = APIPathEntity.builder()
                .methodName(modelParamAPIPath.getMethodName())
                .apiId(modelParamAPIPath.getApiId())
                .build();

        return apiPathRepository.save(apiPath).getApiId();
    }

    @Transactional
    public Long updateAPI(long id, String methodName) {

        APIPathEntity apiPath = getAPIPath(id);
        apiPath.update(methodName);
        return id;
    }

    @Transactional
    public boolean deleteAPI(long id) {
        APIPathEntity apiPath = getAPIPath(id);
        if(apiPath == null)
            return false;
        apiPathRepository.delete(apiPath);
        return true;
    }
}