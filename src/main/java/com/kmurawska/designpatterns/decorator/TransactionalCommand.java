package com.kmurawska.designpatterns.decorator;

public class TransactionalCommand implements Command {
    private final Command command;

    TransactionalCommand(Command command) {
        this.command = command;
    }

    @Override
    public void execute() {
        System.out.println("Start transaction......");
        command.execute();
        System.out.println("End transaction......");
    }
}
