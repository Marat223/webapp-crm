package org.lowtech.app.controller.command;

public class IndexCommand extends FrontCommand {

    @Override
    public void process() {
        //Domain specific logic
        forward("index");
    }

}
