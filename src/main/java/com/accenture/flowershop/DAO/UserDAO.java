package com.accenture.flowershop.DAO;

import com.accenture.flowershop.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserDAO extends JpaRepository<UserEntity, UUID> {
    UserEntity findUserByLogin(String login);

}
