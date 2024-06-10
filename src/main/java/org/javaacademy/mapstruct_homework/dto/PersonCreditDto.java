package org.javaacademy.mapstruct_homework.dto;

import lombok.Data;

@Data
public class PersonCreditDto {
    private String firstName;
    private String lastName;
    private String middleName;
    private String passportNumber; //серия + номер паспорта
    private String salary;// зарплата с указанием валюты
    private String id; //НЕ ЗАПОЛНЯТЬ
    private String fullAddress; //Полный адрес проживания человека
}
