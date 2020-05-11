package com.accenture.flowershop.Services.HomeService;

import com.accenture.flowershop.DAO.UserDAO;
import com.accenture.flowershop.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class HomeServiceImpl implements HomeService {
    @Autowired
    UserDAO userDAO;

    public UserEntity getUser(String login, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        UserEntity user = userDAO.findUserByLogin(login);
        if (user.equals(session.getAttribute("User")) || session.getAttribute("Admin") != null) {
            return user;
        }
        return null;

    }
}
