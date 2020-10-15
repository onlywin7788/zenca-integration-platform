package com.mocomsys.mi.manager.model.api;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
public class ModelParamAPIPath {

    @ApiModelProperty(value = "apiId", required = true)
    private long apiId;

    @ApiModelProperty(value = "apiMethodId", required = true)
    private Long apiMethodId;

    @ApiModelProperty(value = "sourceUri", required = true)
    private String sourceUri;

    @ApiModelProperty(value = "targetUri", required = true)
    private String targetUri;

    @ApiModelProperty(value = "description", required = false)
    private String description;


}
