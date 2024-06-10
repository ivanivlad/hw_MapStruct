package org.javaacademy.mapstruct_homework.mapper;

import org.javaacademy.mapstruct_homework.dto.PersonCreditDto;
import org.javaacademy.mapstruct_homework.dto.PersonDriverLicenceDto;
import org.javaacademy.mapstruct_homework.dto.PersonInsuranceDto;
import org.javaacademy.mapstruct_homework.entity.Human;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@Mapper
public interface HumanMapper {
    @Mapping(target = "passportNumber", source = ".", qualifiedByName = "getSeriesNumberPassport")
    @Mapping(target = "salary", source = ".", qualifiedByName = "getSalary")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "fullAddress", source = ".", qualifiedByName = "getFullAddress")
    PersonCreditDto convertToCreditDto(Human human);

    @Mapping(target = "fullName", source = ".", qualifiedByName = "getFullName")
    @Mapping(target = "fullPassportData", source = ".", qualifiedByName = "getFullPassportData")
    @Mapping(target = "birthDate", source = ".", qualifiedByName = "getBirthDate")
    PersonDriverLicenceDto convertToDriverLicenceDto(Human human);

    @Mapping(target = "fullName", source = ".", qualifiedByName = "getFullName")
    @Mapping(target = "fullAddress", source = ".", qualifiedByName = "getFullAddress")
    @Mapping(target = "fullAge", source = ".", qualifiedByName = "getFullAge")
    PersonInsuranceDto convertToInsuranceDto(Human human);

    @Named("getSalary")
    default String getSalary(Human human) {
        if (human.getWork() == null) {
            return "";
        }
        return "%s %s".formatted(human.getWork().getSalary(),
                human.getWork().getCurrency());
    }

    @Named("getSeriesNumberPassport")
    default String getSeriesNumberPassport(Human human) {
        if (human.getPassport() == null) {
            return "";
        }
        return "%s%s".formatted(human.getPassport().getSeries(),
                human.getPassport().getNumber());
    }

    @Named("getFullPassportData")
    default String getFullPassportData(Human human) {
        if (human.getPassport() == null || human.getPassport().getIssueDate() == null) {
            return "";
        }
        return "%s %s".formatted(getSeriesNumberPassport(human),
                human.getPassport().getIssueDate().format(DateTimeFormatter.ofPattern("d.M.yyyy")));

    }

    @Named("getFullAddress")
    default String getFullAddress(Human human) {
        if (human.getLivingAddress() == null) {
            return "";
        }
        String building = human.getLivingAddress().getBuilding();
        building = (building == null) ? "" : building;
        String house = human.getLivingAddress().getHouse();
        house = (house == null) ? "" : house;
        String region = human.getLivingAddress().getRegion();
        region = (region == null) ? "" : region;
        String city = human.getLivingAddress().getCity();
        city = (city == null) ? "" : city;
        String street = human.getLivingAddress().getStreet();
        street = (street == null) ? "" : street;
        String flat = human.getLivingAddress().getFlat();
        flat = (flat == null) ? "" : flat;
        return "%s ".repeat(5).formatted(
                region,
                city,
                street,
                building + house,
                flat).strip();
    }

    @Named("getFullName")
    default String getFullName(Human human) {
        return "%s %s %s".formatted(human.getFirstName(),
                human.getLastName(),
                human.getMiddleName()).strip();
    }

    @Named("getBirthDate")
    default String getBirthDate(Human human) {
        LocalDate birthDate = LocalDate.of(human.getBirthYear(),
                human.getBirthMonth(),
                human.getBirthDay());
        return birthDate.format(DateTimeFormatter.ofPattern("d.M.yyyy"));
    }

    @Named("getFullAge")
    default Integer getFullAge(Human human) {
        LocalDate birthDate = LocalDate.of(human.getBirthYear(),
                human.getBirthMonth(),
                human.getBirthDay());
        return Period.between(birthDate, LocalDate.now()).getYears();
    }
}
