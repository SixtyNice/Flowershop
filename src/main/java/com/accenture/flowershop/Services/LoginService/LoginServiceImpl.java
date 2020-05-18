package com.accenture.flowershop.Services.LoginService;

import com.accenture.flowershop.DAO.UserDAO;
import com.accenture.flowershop.Enum.Role;
import com.accenture.flowershop.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public boolean login(long userId, String password, HttpServletRequest request) {
        Optional<UserEntity> user = userDAO.findById(userId);
        if (user.isPresent()) {
            if (user.get().getPassword().equals(password)) {
                HttpSession session = request.getSession(true);
                if (user.get().getRole().equals(Role.ADMIN)) {
                    session.setAttribute("role", Role.ADMIN);
                } else {
                    session.setAttribute("role", Role.USER);
                    session.setAttribute("User", user.get());
                }
                return true;
            }
        }
        return false;
    }

}