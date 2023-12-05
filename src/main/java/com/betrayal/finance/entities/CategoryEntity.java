package com.betrayal.finance.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class CategoryEntity {
    private Integer id;
    private String name;
}
