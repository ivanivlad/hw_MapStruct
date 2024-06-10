package org.javaacademy.mapstruct_homework.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {
    private Country country;
    private String region;
    private String city;
    private String street;
    private String house;
    private String building;
    private String flat;
}
