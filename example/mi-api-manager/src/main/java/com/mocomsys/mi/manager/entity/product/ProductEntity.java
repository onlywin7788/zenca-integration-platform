package com.mocomsys.mi.manager.entity.product;

import com.mocomsys.mi.manager.entity.common.CommonDateEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
public class ProductEntity extends CommonDateEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(name ="catalog_id")
    private Long catalogId;

    @Column(length = 64)
    private String productName;

    @Column(length = 1048576)
    private String description;

    @Builder
    public ProductEntity(String productName, Long catalogId, String description) {
        this.productName = productName;
        this.catalogId = catalogId;
        this.description = description;
    }

    public void update(String productName, Long catalogId, String description) {
        this.productName = productName;
        this.catalogId = catalogId;
        this.description = description;
    }

}