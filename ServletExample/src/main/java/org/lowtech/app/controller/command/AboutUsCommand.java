package org.lowtech.app.controller.command;

import org.lowtech.app.domain.ShowUser;

public class AboutUsCommand extends FrontCommand {

    @Override
    public void process() {
        
        ShowUser showUser = new ShowUser();
        request.setAttribute("user", showUser.ReadUserById());
        forward("contact");
    }

}
