package org.javaacademy.mapstruct_homework.entity;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class Work {
    private String position;
    private BigDecimal salary;
    private Currency currency;
}
