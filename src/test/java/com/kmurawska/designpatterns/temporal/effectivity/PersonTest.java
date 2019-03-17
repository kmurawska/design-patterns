package com.kmurawska.designpatterns.temporal.effectivity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PersonTest {
    private static final Company COMPANY_1 = new Company("COMPANY_1");
    private static final Company COMPANY_2 = new Company("COMPANY_2");
    private static final Company COMPANY_3 = new Company("COMPANY_3");
    private Person person;

    @BeforeEach
    void beforeEach() {
        person = new Person("NAME");
        person.addEmployment(COMPANY_1, LocalDate.of(1999, 12, 1));
        person.addEmployment(COMPANY_2, LocalDate.of(2000, 4, 1));
        person.getEmployments().get(0).end(LocalDate.of(2000, 5, 1));
    }

    @Test
    void testAdditive() {
        Employment currentEmployment = person.getCurrentEmployment();

        assertNotNull(currentEmployment);
        assertEquals(COMPANY_2, currentEmployment.getCompany());
    }

    @Test
    void testRetroactive() {
        person.getEmployments().get(1).setEffectivity(DateRange.since(LocalDate.of(2000, 6, 1)));
        person.addEmployment(new Employment(COMPANY_3, new DateRange(LocalDate.of(2000, 5, 1), LocalDate.of(2000, 5, 31))));

        Employment aprilEmployment = person.getEmploymentsEffectiveOn(LocalDate.of(2000, 4, 10)).get(0);

        assertNotNull(aprilEmployment);
        assertEquals(COMPANY_1, aprilEmployment.getCompany());

        Employment mayEmployment = person.getEmploymentsEffectiveOn(LocalDate.of(2000, 5, 10)).get(0);

        assertNotNull(mayEmployment);
        assertEquals(COMPANY_3, mayEmployment.getCompany());
    }
}