package com.accenture.flowershop.SecurityServer;

import com.accenture.flowershop.Enum.Role;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@Component
//@WebFilter(urlPatterns = "/admin/")
public class AdminFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);

        boolean loggedIn = (session != null && session.getAttribute("role").equals(Role.ADMIN));

        if (loggedIn) {
            filterChain.doFilter(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/login.html");

        }
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Admin Filter init");
    }

    @Override
    public void destroy() {
        System.out.println("Admin filter destroy");
    }
}
