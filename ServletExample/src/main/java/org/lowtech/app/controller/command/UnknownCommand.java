package org.lowtech.app.controller.command;

public class UnknownCommand extends FrontCommand {

    @Override
    public void process() {
        //Domain specific logic
        forward("error");
    }

}
