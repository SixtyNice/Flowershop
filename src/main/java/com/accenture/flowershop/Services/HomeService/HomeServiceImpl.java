package com.accenture.flowershop.Services.HomeService;

import com.accenture.flowershop.DAO.UserDAO;
import com.accenture.flowershop.DTO.UserDTO;
import com.accenture.flowershop.Enum.Role;
import com.accenture.flowershop.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDTO getUser(long userId, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        Optional<UserEntity> user = userDAO.findById(userId);
        if (user.isPresent()) {
            if (user.equals(session.getAttribute("userId")) || session.getAttribute("role").equals(Role.USER)) {
                return new UserDTO(user.get());
            }
        }
        return null;

    }
}
