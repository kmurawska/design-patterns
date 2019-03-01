package com.kmurawska.designpatterns.builder.hierarchical_builder;

import java.util.Objects;

class NyPizza extends Pizza {
    private final Size size;

    private NyPizza(Builder builder) {
        super(builder);
        this.size = builder.size;
    }

    static class Builder extends Pizza.Builder<Builder> {
        private final Size size;

        Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }

        @Override
        NyPizza build() {
            return new NyPizza(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    @Override
    public String toString() {
        return "NyPizza{" +
                "size=" + size +
                super.toString() +
                " " +
                '}';
    }
}
