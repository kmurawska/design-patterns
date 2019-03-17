package com.kmurawska.designpatterns.temporal.effectivity;

import java.time.LocalDate;

import static java.time.LocalDate.MAX;
import static java.time.LocalDate.MIN;

class DateRange implements Comparable {
    private static DateRange EMPTY = new DateRange(MAX, MIN);
    private static final LocalDate FAR_FUTURE = MAX;
    private static final LocalDate FAR_PAST = MIN;
    private final LocalDate since, until;

    DateRange(LocalDate since, LocalDate until) {
        this.since = since;
        this.until = until;
    }

    static DateRange since(LocalDate since) {
        return new DateRange(since, FAR_FUTURE);
    }

    static DateRange sinceFarPastUntil(LocalDate until) {
        return new DateRange(FAR_PAST, until);
    }

    DateRange until(LocalDate until) {
        return new DateRange(since, until);
    }

    boolean includes(LocalDate date) {
        return !date.isBefore(since) && !date.isAfter(until);
    }

    boolean overlaps(DateRange dateRange) {
        return dateRange.includes(since) || dateRange.includes(until) || this.includes(dateRange);
    }

    boolean includes(DateRange dateRange) {
        return this.includes(dateRange.since) && this.includes(dateRange.until);
    }

    boolean abuts(DateRange arg) {
        return !this.overlaps(arg) && this.gap(arg).isEmpty();
    }

    private DateRange gap(DateRange dateRange) {
        if (this.overlaps(dateRange)) return DateRange.EMPTY;
        DateRange lower, higher;
        if (this.compareTo(dateRange) < 0) {
            lower = this;
            higher = dateRange;
        } else {
            lower = dateRange;
            higher = this;
        }
        return new DateRange(lower.until.plusDays(1), higher.since.minusDays(1));
    }

    boolean isEmpty() {
        return since.isAfter(until);
    }

    @Override
    public int compareTo(Object obj) {
        DateRange dateRange = (DateRange) obj;
        if (!since.equals(dateRange.since)) return since.compareTo(dateRange.since);
        return until.compareTo(dateRange.until);
    }
}
