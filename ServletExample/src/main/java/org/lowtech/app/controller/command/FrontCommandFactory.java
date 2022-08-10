package org.lowtech.app.controller.command;

import javax.servlet.http.HttpServletRequest;
import org.lowtech.app.controller.command.FrontCommand;
import org.lowtech.app.controller.command.UnknownCommand;

public class FrontCommandFactory {

    private static final String COMMAND = "command";
    private static final String COMMAND_IMPL_LOCATION = "org.lowtech.app.controller.command";

    public FrontCommand construct(HttpServletRequest req) {
        String commandParameter = "Index";
        if (req.getParameter("command") != null && !req.getParameter(COMMAND).isEmpty()) {
            commandParameter = req.getParameter(COMMAND);
        }
        try {
            Class commandClass = Class.forName(String.format(COMMAND_IMPL_LOCATION + ".%sCommand", commandParameter));
            return (FrontCommand) commandClass.asSubclass(FrontCommand.class).newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            return new UnknownCommand();
        }
    }

}
