package com.mocomsys.mi.manager.service.api;

import com.mocomsys.mi.manager.controller.advice.exception.CommonException;
import com.mocomsys.mi.manager.entity.api.APIEntity;
import com.mocomsys.mi.manager.model.api.ModelParamAPI;
import com.mocomsys.mi.manager.repository.api.APIRepository;
import io.swagger.models.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class APIService {

    @Autowired
    private APIRepository apiRepository;

    public APIEntity getAPI(Long apiId) {
        return apiRepository.findById(apiId).orElseThrow(() ->
                new CommonException("EX"));
    }

    public List<APIEntity> getAPIList()
    {
        return apiRepository.findAll();
    }

    @Transactional
    public Long saveAPI(ModelParamAPI modelParamAPI) {
        APIEntity api = APIEntity.builder()
                .apiName(modelParamAPI.getApiName())
                .version(modelParamAPI.getVersion())
                .targetUrl(modelParamAPI.getTargetUrl())
                .description(modelParamAPI.getDescription())
                .build();

        return apiRepository.save(api).getApiId();
    }

    @Transactional
    public Long updateAPI(long apiId, ModelParamAPI modelParamAPI) {

        APIEntity api = getAPI(apiId);
        api.update(modelParamAPI.getApiName(), modelParamAPI.getVersion()
                ,modelParamAPI.getTargetUrl(), modelParamAPI.getDescription());
        return apiId;
    }

    @Transactional
    public boolean deleteAPI(long apiId) {
        APIEntity api = getAPI(apiId);
        if(api == null)
            return false;
        apiRepository.delete(api);
        return true;
    }
}