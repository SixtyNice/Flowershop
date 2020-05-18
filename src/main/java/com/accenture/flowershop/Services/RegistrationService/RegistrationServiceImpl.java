package com.accenture.flowershop.Services.RegistrationService;

import com.accenture.flowershop.DAO.UserDAO;
import com.accenture.flowershop.Enum.Role;
import com.accenture.flowershop.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    @Autowired
    private UserDAO userDAO;

    @Override
    public boolean createUser(UserEntity user, HttpServletRequest request) {
        if (checkExistLogin(user.getId())) {
            return false;
        }
        HttpSession session = request.getSession(true);
        user.setBalance(new BigDecimal(2000));
        session.setAttribute("role", Role.USER);
        session.setAttribute("User", user);
        userDAO.save(user);
        return true;
    }

    @Override
    public boolean checkExistLogin(long login) {
        return userDAO.findById(login).isPresent();
    }
}
