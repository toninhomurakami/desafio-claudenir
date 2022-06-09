package com.desafio.movement.manual.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Embeddable
public class ManualMovementPk implements Serializable {

    @Column(name = "dat_mes")
    private int month;

    @Column(name = "dat_ano")
    private int year;

    @Column(name = "num_lancamento")
    private long release;

    @Column(name = "cod_produto", length = 4)
    private String productCode;

    @Column(name = "cod_cosif", length = 11)
    private String cosifCode;

}
