package com.kmurawska.designpatterns.decorator;

import org.junit.jupiter.api.Test;

class DecoratorShowcase {

    @Test
    void runClassicVersion() {
        Command createInvoiceCommand = new CreateInvoiceCommand();

        System.out.println("---Standard command");
        createInvoiceCommand.execute();

        System.out.println("---Transactional command");
        new TransactionalCommand(createInvoiceCommand).execute();

        System.out.println("---Secured command");
        new SecuredCommand(createInvoiceCommand).execute();

        System.out.println("---Secured transactional command");
        new SecuredCommand(new TransactionalCommand(createInvoiceCommand)).execute();
    }

    @Test
    void runFunctionalVersion() {
        Command createInvoiceCommand = new CreateInvoiceCommand();

        System.out.println("---Standard command");
        createInvoiceCommand.execute();

        System.out.println("---Transactional command");
        new CreateInvoiceCommand()
                .decorate(TransactionalCommand::new)
                .execute();

        System.out.println("---Secured command");
        new CreateInvoiceCommand()
                .decorate(SecuredCommand::new)
                .execute();

        System.out.println("---Secured transactional command");
        new CreateInvoiceCommand()
                .decorate(SecuredCommand::new)
                .decorate(TransactionalCommand::new)
                .execute();
    }
}