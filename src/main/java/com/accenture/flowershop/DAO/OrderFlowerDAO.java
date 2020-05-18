package com.accenture.flowershop.DAO;

import com.accenture.flowershop.entity.OrderFlowerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderFlowerDAO extends JpaRepository<OrderFlowerEntity, Long> {
}
