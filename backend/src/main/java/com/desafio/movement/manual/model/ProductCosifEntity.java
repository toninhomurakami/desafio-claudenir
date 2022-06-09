package com.desafio.movement.manual.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@ToString
@Entity
@Table(name = "produto_cosif")
public class ProductCosifEntity {

    @EmbeddedId
    private ProductCosifPk id;

    @Column(name = "cod_classificacao", length = 6)
    private String classification;

    @Column(name = "sta_status")
    private boolean status;

}
