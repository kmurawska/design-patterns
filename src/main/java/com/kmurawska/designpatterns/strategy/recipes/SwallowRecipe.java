package com.kmurawska.designpatterns.strategy.recipes;

import com.kmurawska.designpatterns.strategy.Elixir;
import com.kmurawska.designpatterns.strategy.Ingredients;

import static com.kmurawska.designpatterns.strategy.Ingredient.CELANDINE;
import static com.kmurawska.designpatterns.strategy.Ingredient.DROWNER_BRAIN;
import static com.kmurawska.designpatterns.strategy.Ingredient.DWARVEN_SPIRIT;

public class SwallowRecipe implements ElixirRecipe {

    @Override
    public Elixir prepare(Ingredients ingredients) {
        int celandine = ingredients.get(CELANDINE, 5);
        int drownerBrain = ingredients.get(DROWNER_BRAIN, 1);
        int dwarvenSpirit = ingredients.get(DWARVEN_SPIRIT, 1);

        System.out.println("Mixing: \n-CELANDINE x " + celandine + "\n-DROWNER BRAIN x " + drownerBrain + "\n-DWARVEN SPIRIT x " + dwarvenSpirit);

        return new Elixir("Swallow", "Accelerates vitality regeneration. Vitality regeneration pauses for 2 seconds upon receiving damage.");
    }
}
