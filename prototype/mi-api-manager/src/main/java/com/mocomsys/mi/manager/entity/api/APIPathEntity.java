package com.mocomsys.mi.manager.entity.api;

import com.mocomsys.mi.manager.entity.common.CommonDateEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "api_path")
@Getter
@Setter
@NoArgsConstructor
public class APIPathEntity extends CommonDateEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long apiPathId;

    @Column(length = 64)
    private String methodName;

    private long apiId;

    @Builder
    public APIPathEntity(String methodName, long apiId) {
        this.methodName = methodName;
        this.apiId = apiId;
    }

    public void update(String methodName) {
        this.methodName = methodName;
    }

}