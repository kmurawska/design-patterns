package com.kmurawska.designpatterns.builder.hierarchical_builder;

class Calzone extends Pizza {
    private final boolean sauceInside;

    private Calzone(Builder builder) {
        super(builder);
        this.sauceInside = builder.sauceInside;
    }

    static class Builder extends Pizza.Builder<Builder> {
        private boolean sauceInside = false;

        Builder sauceInside() {
            this.sauceInside = true;
            return this;
        }

        @Override
        Pizza build() {
            return new Calzone(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    @Override
    public String toString() {
        return "Calzone{" +
                "sauceInside=" + sauceInside +
                " " +
                super.toString() +
                '}';
    }
}
