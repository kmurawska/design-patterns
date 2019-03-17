package com.kmurawska.designpatterns.temporal.effectivity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Person {
    private final String name;
    private final List<Employment> employments;

    Person(String name) {
        this.name = name;
        this.employments = new ArrayList<>();
    }

    void addEmployment(Company company, LocalDate since) {
        employments.add(new Employment(company, since));
    }

    void addEmployment(Employment arg) {
        employments.add(arg);
    }

    Employment getCurrentEmployment() {
        LocalDate now = LocalDate.now();
        return employments.stream()
                .filter(e -> e.isEffectiveOn(now))
                .findFirst()
                .orElseThrow(IllegalStateException::new);
    }

    List<Employment> getEmployments() {
        return employments;
    }

    List<Employment> getEmploymentsEffectiveOn(LocalDate date) {
        return employments.stream()
                .filter(e -> e.isEffectiveOn(date))
                .collect(Collectors.toList());
    }
}
