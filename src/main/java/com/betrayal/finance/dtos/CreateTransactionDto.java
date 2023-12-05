package com.betrayal.finance.dtos;

import lombok.Data;

import java.sql.Date;

@Data
public class CreateTransactionDto {
    private Integer bankId;
    private Integer categoryId;
    private Double money;
    private Boolean isConsumption;
    private Date date;
    private String comment;
}
