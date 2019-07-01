package com.kmurawska.designpatterns.decorator;

import java.util.function.Function;

public interface Command {
    void execute();

    default Command decorate(Function<? super Command, ? extends Command> decorator) {
        return decorator.apply(this);
    }
}
