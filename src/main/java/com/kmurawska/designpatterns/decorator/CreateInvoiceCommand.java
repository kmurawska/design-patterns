package com.kmurawska.designpatterns.decorator;

public class CreateInvoiceCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Create invoice.....");
    }
}
