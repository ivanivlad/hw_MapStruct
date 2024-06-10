package org.javaacademy.mapstruct_homework.dto;

import lombok.Data;

@Data
public class PersonDriverLicenceDto {
    private String fullName; //ФИО
    private String fullPassportData; //серия + номер + дата выпуска паспорта через пробел
    private String birthDate;//дата рождения формата dd.mm.yyyy
}
