package com.kmurawska.designpatterns.strategy;

import com.kmurawska.designpatterns.strategy.recipes.BlackBloodRecipe;
import com.kmurawska.designpatterns.strategy.recipes.SwallowRecipe;
import com.kmurawska.designpatterns.strategy.recipes.TawnyOwl;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static com.kmurawska.designpatterns.strategy.Ingredient.*;

class StrategyShowcase {
    private Geralt geralt = new Geralt();

    @Test
    void runClassicVersion() {
        collectIngredientForSwallowElixir();

        Elixir swallow = geralt.makeElixir(new SwallowRecipe());
        geralt.drink(swallow);

        System.out.println(geralt);

        collectIngredientForTawnyOwlElixir();

        Elixir tawnyOwl = geralt.makeElixir(new TawnyOwl());
        geralt.drink(tawnyOwl);

        System.out.println(geralt);
    }

    @Test
    void runFunctionalVersion() {
        collectIngredientForBlackBloodElixir();

        Elixir blackBlood = geralt.makeElixir(new BlackBloodRecipe());
        geralt.drink(blackBlood);

        System.out.println(geralt);

        collectIngredientForBlizzardElixir();

        Elixir blizzard = geralt.makeElixir((Function<Ingredients, Elixir>) ingredients -> {
            int dwarvenSpirit = ingredients.get(DWARVEN_SPIRIT, 1);
            int whiteMyrtlePetals = ingredients.get(WHITE_MYRTLE_PETALS, 5);
            int golemsHeart = ingredients.get(GOLEMS_HEART, 1);

            System.out.println("Mixing: \n-DWARVEN SPIRIT x " + dwarvenSpirit + "\n-WHITE MYRTLE PETALS x " + whiteMyrtlePetals + "\n-GOLEM'S HEART x " + golemsHeart);

            return new Elixir("Blizzard", "\tImproves reflexes and prolongs reaction time.");
        });

        geralt.drink(blizzard);

        System.out.println(geralt);
    }

    private void collectIngredientForSwallowElixir() {
        geralt.collectIngredient(CELANDINE, 4);
        geralt.collectIngredient(DROWNER_BRAIN, 1);
        geralt.collectIngredient(DWARVEN_SPIRIT, 1);
        geralt.collectIngredient(CELANDINE, 1);
    }

    private void collectIngredientForTawnyOwlElixir() {
        geralt.collectIngredient(CELANDINE, 4);
        geralt.collectIngredient(DROWNER_BRAIN, 1);
        geralt.collectIngredient(DWARVEN_SPIRIT, 1);
        geralt.collectIngredient(CELANDINE, 1);
    }

    private void collectIngredientForBlackBloodElixir() {
        geralt.collectIngredient(DWARVEN_SPIRIT, 1);
        geralt.collectIngredient(SEWANT_MUSHROOMS, 2);
        geralt.collectIngredient(GHOULS_BLOOD, 4);
    }

    private void collectIngredientForBlizzardElixir() {
        geralt.collectIngredient(DWARVEN_SPIRIT, 1);
        geralt.collectIngredient(WHITE_MYRTLE_PETALS, 5);
        geralt.collectIngredient(GOLEMS_HEART, 1);
    }
}
