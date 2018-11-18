package com.kmurawska.designpatterns.strategy.recipes;

import com.kmurawska.designpatterns.strategy.Elixir;
import com.kmurawska.designpatterns.strategy.Ingredients;

public interface ElixirRecipe {
    Elixir prepare(Ingredients ingredients);
}