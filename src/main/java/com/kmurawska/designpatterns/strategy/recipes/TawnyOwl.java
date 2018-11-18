package com.kmurawska.designpatterns.strategy.recipes;

import com.kmurawska.designpatterns.strategy.Elixir;
import com.kmurawska.designpatterns.strategy.Ingredient;
import com.kmurawska.designpatterns.strategy.Ingredients;

import static com.kmurawska.designpatterns.strategy.Ingredient.ARACHAS_VENOM;
import static com.kmurawska.designpatterns.strategy.Ingredient.DWARVEN_SPIRIT;
import static com.kmurawska.designpatterns.strategy.Ingredient.VERBENA;

public class TawnyOwl implements ElixirRecipe {
    @Override
    public Elixir prepare(Ingredients ingredients) {
        int arachasVenom = ingredients.get(ARACHAS_VENOM, 1);
        int dwarvenSpirit = ingredients.get(DWARVEN_SPIRIT, 1);
        int verbena = ingredients.get(VERBENA, 2);

        System.out.println("Mixing: \n-ARACHAS VENOM x " + arachasVenom + "\n-DWARVEN SPIRIT x " + dwarvenSpirit + "\n-VERBENA x " + verbena);

        return new Elixir("Tawny Owl", "Accelerates stamina regeneration during combat.");
    }
}
