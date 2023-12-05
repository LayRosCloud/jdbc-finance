package com.betrayal.finance.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class TransactionEntity {
    private Integer id;
    private Integer bankId;
    private Integer categoryId;
    private Double money;
    private Boolean isConsumption;
    private Date date;
    private String comment;
}
