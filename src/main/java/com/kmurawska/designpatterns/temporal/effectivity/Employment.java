package com.kmurawska.designpatterns.temporal.effectivity;

import java.time.LocalDate;

class Employment {
    private final Company company;
    private DateRange effective;

    Employment(Company company, LocalDate since) {
        this.company = company;
        this.effective = DateRange.since(since);
    }

    Employment(Company company, DateRange effective) {
        this.company = company;
        this.effective = effective;
    }

    Company getCompany() {
        return company;
    }

    boolean isEffectiveOn(LocalDate date) {
        return effective.includes(date);
    }

    void end(LocalDate end) {
        effective = effective.until(end);
    }

    void setEffectivity(DateRange effective) {
        this.effective = effective;
    }
}
