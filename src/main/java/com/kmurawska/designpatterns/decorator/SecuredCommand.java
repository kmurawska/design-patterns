package com.kmurawska.designpatterns.decorator;

public class SecuredCommand implements Command {
    private final Command command;

    SecuredCommand(Command command) {
        this.command = command;
    }

    @Override
    public void execute() {
        System.out.println("Perform security check......");
        command.execute();
    }
}
