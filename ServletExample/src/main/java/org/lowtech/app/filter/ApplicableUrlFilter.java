package org.lowtech.app.filter;

import java.io.IOException;
import java.util.Set;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(filterName = "Applicable URL filter", urlPatterns = {"/*"})
public class ApplicableUrlFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String contextPath = ((HttpServletRequest) request).getContextPath();
        String requestURI = ((HttpServletRequest) request).getRequestURI();
        boolean uriExists = false;
        for (String endPoint : (Set<String>) request.getServletContext().getAttribute("endPoint")) {
            if ((contextPath + "/").equals(requestURI) || (contextPath + endPoint).equals(requestURI)) {
                uriExists = true;
            }
        }
        if (uriExists) {
            chain.doFilter(request, response);
        } else {
            request.getRequestDispatcher("/WEB-INF/jsp/404.jsp").forward(request, response);
        }
    }

    @Override
    public void destroy() {
    }

}
