package org.lowtech.app.controller.command;

import java.io.IOException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class FrontCommand {

    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected ServletContext context;

    public void init(HttpServletRequest req, HttpServletResponse resp, ServletContext sc) {
        this.request = req;
        this.response = resp;
        this.context = sc;
        response.setContentType("text/html");
    }

    public abstract void process();

    protected void forward(String target) {
        target = String.format("/WEB-INF/jsp/%s.jsp", target);
        RequestDispatcher dispatcher = context.getRequestDispatcher(target);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException ex) {
            try {
                response.sendRedirect(request.getContextPath() + "fatal_error"); //TODO Add redirect filter and page to this point
                Logger.getLogger(FrontCommand.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException fatalException) {
                Logger.getLogger(FrontCommand.class.getName()).log(Level.SEVERE, null, fatalException);
            }
        }
    }
}
