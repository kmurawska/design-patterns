package com.kmurawska.designpatterns.builder.hierarchical_builder;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

import static java.util.stream.Collectors.joining;

abstract class Pizza {
    final Set<Topping> toppings;

    Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone();
    }

    abstract static class Builder<T extends Builder<T>> {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        //Subclasses must override this method to return "this"
        protected abstract T self();

        abstract Pizza build();
    }

    @Override
    public String toString() {
        return "toppings: " + toppings.stream().map(Topping::name).collect(joining(";"));
    }
}