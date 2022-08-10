package org.lowtech.app.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(filterName = "Static rescouce filter",
        urlPatterns = {"/style/*"})
public class StaticResourceFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String staticResourcePath = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
        request.getRequestDispatcher("/WEB-INF" + staticResourcePath).forward(request, response);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }

}
