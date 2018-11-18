package com.kmurawska.designpatterns.strategy;

import com.kmurawska.designpatterns.strategy.recipes.ElixirRecipe;

import java.util.function.Function;

public class Geralt {
    private Ingredients ingredients = new Ingredients();

    void collectIngredient(Ingredient ingredient, int amount) {
        ingredients.put(ingredient, amount);
    }

    Elixir makeElixir(ElixirRecipe elixirRecipe) {
        return elixirRecipe.prepare(ingredients);
    }

    Elixir makeElixir(Function<Ingredients, Elixir> elixirRecipe) {
        return elixirRecipe.apply(ingredients);
    }

    void drink(Elixir elixir) {
        System.out.println("Drinking: " + elixir.getName());
        System.out.println("Waiting for effect....");
        System.out.println(elixir.toString());
    }

    @Override
    public String toString() {
        return "Geralt{" +
                "ingredients=" + ingredients +
                '}';
    }
}