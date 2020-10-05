package com.mocomsys.mi.manager.model.api;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ModelParamAPIPath {

    @ApiModelProperty(value = "methodName", required = true)
    private String methodName;

    @ApiModelProperty(value = "apiId", required = true)
    private long apiId;
}
