package com.desafio.movement.manual.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class MovementDto implements Serializable {

    private int month;
    private int year;
    private long release;
    private String productCode;
    private String cosifCode;

    private String description;
    private Date movementDate;
    private String userCode;
    private double amount;

    private String productDescription;
}
