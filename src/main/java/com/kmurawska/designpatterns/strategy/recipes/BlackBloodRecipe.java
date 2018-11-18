package com.kmurawska.designpatterns.strategy.recipes;

import com.kmurawska.designpatterns.strategy.Elixir;
import com.kmurawska.designpatterns.strategy.Ingredients;

import java.util.function.Function;

import static com.kmurawska.designpatterns.strategy.Ingredient.*;

public class BlackBloodRecipe implements Function<Ingredients, Elixir> {
    @Override
    public Elixir apply(Ingredients ingredients) {
        int dwarvenSpirit = ingredients.get(DWARVEN_SPIRIT, 1);
        int sewantMushrooms = ingredients.get(SEWANT_MUSHROOMS, 2);
        int ghoulsBlood = ingredients.get(GHOULS_BLOOD, 4);

        System.out.println("Mixing: \n-DWARVEN SPIRIT x " + dwarvenSpirit + "\n-SEWANT MUSHROOMS x " + sewantMushrooms + "\n-GHOULS BLOOD x " + ghoulsBlood);

        return new Elixir("Black Blood", "Witcher's blood injures Vampires and Necrophages when they wound him.");
    }
}