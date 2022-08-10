package org.lowtech.app.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.lowtech.app.controller.command.FrontCommand;
import org.lowtech.app.controller.command.FrontCommandFactory;

public class FrontController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) {
        FrontCommand command = new FrontCommandFactory().construct(req);
        command.init(req, resp, getServletContext());
        command.process();
    }
}
