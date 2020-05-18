package com.accenture.flowershop.SecurityServer;

import com.accenture.flowershop.Enum.Role;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);

        boolean loggedIn = (session != null && session.getAttribute("User") != null);
        boolean loggedInAdmin = (session != null && session.getAttribute("role").equals(Role.ADMIN));

        if (loggedIn || loggedInAdmin) {

            filterChain.doFilter(request, response);


        } else {
            response.sendRedirect(request.getContextPath() + "/login.html");
        }

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Init filter");
    }

    @Override
    public void destroy() {
        System.out.println("Destroy filter");
    }
}
