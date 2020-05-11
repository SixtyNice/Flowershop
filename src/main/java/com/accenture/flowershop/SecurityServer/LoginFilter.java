package com.accenture.flowershop.SecurityServer;

import com.accenture.flowershop.entity.UserEntity;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest, servletResponse);

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);
        UserEntity user = (UserEntity) session.getAttribute("User");
        if (session.getAttribute("User") != null) {
            response.sendRedirect(request.getContextPath() + "/home/" + user.getLogin());
            filterChain.doFilter(servletRequest, servletResponse);
        } else if (session.getAttribute("Admin") != null) {
            response.sendRedirect(request.getContextPath() + "/" + user.getLogin());
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
