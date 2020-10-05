package com.mocomsys.mi.manager.entity.catalog;

import com.mocomsys.mi.manager.entity.common.CommonDateEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "catalog")
@Getter
@Setter
@NoArgsConstructor
public class CatalogEntity extends CommonDateEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long catalogId;

    @Column(length = 64)
    private String catalogName;

    @Column(length = 1048576)
    private String description;

    @Builder
    public CatalogEntity(String catalogName, String description) {

        this.catalogName = catalogName;
        this.description = description;
    }

    public void update(String catalogName, String description) {

        this.catalogName = catalogName;
        this.description = description;
    }

}