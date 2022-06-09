package com.desafio.movement.manual.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Data
@ToString
@Entity
@Table(name = "movimento_manual")
public class ManualMovementEntity {

    @EmbeddedId
    private ManualMovementPk id;

    @Column(name = "des_descricao", length = 50)
    private String description;

    @Column(name = "dat_movimento")
    private Date movementDate;

    @Column(name = "cod_usuario")
    private String userCode;

    @Column(name = "val_valor")
    private double amount;

    @ManyToOne
    @JoinColumn(name = "code", referencedColumnName = "cod_produto")
    private ProductEntity product;

}
