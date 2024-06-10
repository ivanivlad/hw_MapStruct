package org.javaacademy.mapstruct_homework.entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Passport {
    private String series;
    private String number;
    private LocalDate issueDate;
    private Country country;
}
