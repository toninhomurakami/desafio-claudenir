package com.desafio.movement.manual.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class ProductCosifPk implements Serializable {

    @Column(name = "cod_produto", length = 4)
    private String productCode;

    @Column(name = "cod_cosif", length = 11)
    private String cosifCode;
}
