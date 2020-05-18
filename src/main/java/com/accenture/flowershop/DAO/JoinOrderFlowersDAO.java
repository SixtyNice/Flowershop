package com.accenture.flowershop.DAO;

import com.accenture.flowershop.entity.JoinOrderFlowersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JoinOrderFlowersDAO extends JpaRepository<JoinOrderFlowersEntity,Long> {
}
