package com.kmurawska.designpatterns.strategy;

public class Elixir {
    private final String name, effect;

    public Elixir(String name, String effect) {
        this.name = name;
        this.effect = effect;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Elixir{" +
                "name='" + name + '\'' +
                ", effect='" + effect + '\'' +
                '}';
    }
}
