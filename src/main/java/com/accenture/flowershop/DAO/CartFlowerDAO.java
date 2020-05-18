package com.accenture.flowershop.DAO;

import com.accenture.flowershop.entity.CartFlowerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartFlowerDAO extends JpaRepository<CartFlowerEntity, Long> {

}
