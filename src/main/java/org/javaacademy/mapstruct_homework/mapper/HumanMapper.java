package org.javaacademy.mapstruct_homework.mapper;

import org.javaacademy.mapstruct_homework.dto.PersonCreditDto;
import org.javaacademy.mapstruct_homework.dto.PersonDriverLicenceDto;
import org.javaacademy.mapstruct_homework.dto.PersonInsuranceDto;
import org.javaacademy.mapstruct_homework.entity.Human;
import org.mapstruct.Mapper;

@Mapper
public interface HumanMapper {
    PersonCreditDto convertToCreditDto(Human human);
    PersonDriverLicenceDto convertToDriverLicenceDto(Human human);
    PersonInsuranceDto convertToInsuranceDto(Human human);

}
