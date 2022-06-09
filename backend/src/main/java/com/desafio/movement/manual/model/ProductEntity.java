package com.desafio.movement.manual.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString
@Entity
@Table(name = "produto")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "cod_produto", length = 4)
    private String code;

    @Column(name = "des_produto", length = 30)
    private String description;

    @Column(name = "sta_status")
    private boolean status;

}
