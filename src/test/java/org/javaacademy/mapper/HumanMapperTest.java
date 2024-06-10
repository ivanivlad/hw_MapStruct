package org.javaacademy.mapper;

import org.javaacademy.mapstruct_homework.dto.PersonCreditDto;
import org.javaacademy.mapstruct_homework.dto.PersonDriverLicenceDto;
import org.javaacademy.mapstruct_homework.dto.PersonInsuranceDto;
import org.javaacademy.mapstruct_homework.entity.Address;
import org.javaacademy.mapstruct_homework.entity.Country;
import org.javaacademy.mapstruct_homework.entity.Currency;
import org.javaacademy.mapstruct_homework.entity.Human;
import org.javaacademy.mapstruct_homework.entity.Passport;
import org.javaacademy.mapstruct_homework.entity.Work;
import org.javaacademy.mapstruct_homework.mapper.HumanMapper;
import org.javaacademy.mapstruct_homework.mapper.HumanMapperImpl;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class HumanMapperTest {
    private final HumanMapper humanMapper = new HumanMapperImpl();

    @Test
    void convertFromHumanToPersonCredit() {
        Address address = Address.builder()
                .country(Country.FRANCE)
                .region("Paris province")
                .city("Paris")
                .street("Sharl de Gol")
                .house("15")
                .flat("201a")
                .build();
        Passport passport = Passport.builder()
                .country(Country.FRANCE)
                .issueDate(LocalDate.now())
                .series("4001")
                .number("220333")
                .build();
        Work work = Work.builder()
                .currency(Currency.EURO)
                .position("manager")
                .salary(BigDecimal.valueOf(10000))
                .build();

        Human human = Human.builder()
                .id(1)
                .firstName("Yuri")
                .lastName("Ivanov")
                .middleName("Petrovich")
                .birthDay(10)
                .birthMonth(5)
                .birthYear(1996)
                .livingAddress(address)
                .passport(passport)
                .work(work)
                .build();

        PersonCreditDto personCreditDto = humanMapper.convertToCreditDto(human);
        assertEquals(personCreditDto.getFirstName(), "Yuri");
        assertEquals(personCreditDto.getLastName(), "Ivanov");
        assertEquals(personCreditDto.getMiddleName(), "Petrovich");
        assertEquals(personCreditDto.getSalary(), "10000 EURO");
        assertEquals(personCreditDto.getFullAddress(), "Paris province Paris Sharl de Gol 15 201a");
        assertNull(personCreditDto.getId());
    }

    @Test
    void convertFromHumanToDriverLicence() {
        Passport passport = Passport.builder()
                .country(Country.KONGO)
                .issueDate(LocalDate.of(2010, 9, 8))
                .series("4001")
                .number("220333")
                .build();

        Human human = Human.builder()
                .id(1)
                .firstName("Yuri")
                .lastName("Ivanov")
                .middleName("Petrovich")
                .birthDay(10)
                .birthMonth(5)
                .birthYear(1996)
                .passport(passport)
                .build();

        PersonDriverLicenceDto personDriverLicenceDto = humanMapper.convertToDriverLicenceDto(human);
        assertEquals(personDriverLicenceDto.getFullName(), "Yuri Ivanov Petrovich");
        assertEquals(personDriverLicenceDto.getBirthDate(), "10.5.1996");
        assertEquals(personDriverLicenceDto.getFullPassportData(), "4001220333 8.9.2010");
    }

    @Test
    void convertFromHumanToInsuranceDto() {
        Address address = Address.builder()
                .country(Country.JAPAN)
                .city("Tokyo")
                .street("Minato")
                .house("7")
                .build();

        Passport passport = Passport.builder()
                .country(Country.KONGO)
                .issueDate(LocalDate.of(2010, 9, 8))
                .series("4001")
                .number("220333")
                .build();

        Human human = Human.builder()
                .id(1)
                .firstName("Tayki")
                .lastName("Hiragawa")
                .middleName("")
                .birthDay(10)
                .birthMonth(5)
                .birthYear(1996)
                .passport(passport)
                .livingAddress(address)
                .build();

        PersonInsuranceDto insuranceDto = humanMapper.convertToInsuranceDto(human);
        assertEquals(insuranceDto.getFullName(), "Tayki Hiragawa");
        assertEquals(insuranceDto.getFullAge(), 28);
        assertEquals(insuranceDto.getFullAddress(), "Tokyo Minato 7");
    }
}
