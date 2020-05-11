package com.accenture.flowershop.Services.LogoutService;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class LogoutServiceImpl implements LogoutService {
    @Override
    public void logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session.getAttribute("User") != null) {
            session.removeAttribute("User");
        } else if (session.getAttribute("Admin") != null) {
            session.removeAttribute("Admin");
        }

    }
}
