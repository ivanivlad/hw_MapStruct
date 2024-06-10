package org.javaacademy.mapstruct_homework.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Human {
    private Integer id;
    private String firstName;
    private String lastName;
    private String middleName;
    private Integer birthYear;
    private Integer birthDay;
    private Integer birthMonth;
    private Passport passport;
    private Work work;
    private Address livingAddress;
}
