package com.kmurawska.designpatterns.builder.hierarchical_builder;

import org.junit.jupiter.api.Test;

import static com.kmurawska.designpatterns.builder.hierarchical_builder.Topping.*;

class PizzaTest {
    @Test
    void calzonePizzaBuilder() {
        Pizza calzone = new Calzone.Builder()
                .addTopping(HAM)
                .addTopping(MUSHROOM)
                .sauceInside()
                .build();

        System.out.println(calzone.toString());
    }

    @Test
    void nyPizzaBuilder() {
        Pizza nyPizza = new NyPizza.Builder(Size.SMALL)
                .addTopping(ONION)
                .addTopping(Topping.PEPPER)
                .build();

        System.out.println(nyPizza.toString());
    }
}