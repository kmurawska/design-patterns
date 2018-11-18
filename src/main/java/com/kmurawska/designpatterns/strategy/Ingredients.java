package com.kmurawska.designpatterns.strategy;

import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.joining;

public class Ingredients {
    private final Map<Ingredient, Integer> ingredients = new HashMap<>();

    public void put(Ingredient ingredient, int amount) {
        ingredients.computeIfPresent(ingredient, (k, v) -> v + amount);
        ingredients.putIfAbsent(ingredient, amount);
    }

    public Integer get(Ingredient ingredient, int amount) {
        ingredients.computeIfAbsent(ingredient, (k) -> {
            throw new IllegalStateException("Lack of ingredient: " + ingredient);
        });

        ingredients.computeIfPresent(ingredient, (k, v) -> {
            if (v < amount)
                throw new IllegalStateException("Not enough amount of " + ingredient + ", collected " + v + " but needed " + amount);
            return v - amount;
        });

        return amount;
    }

    @Override
    public String toString() {
        return ingredients.entrySet().stream()
                .map(Map.Entry::toString)
                .collect(joining(";", "[", "]"));
    }
}