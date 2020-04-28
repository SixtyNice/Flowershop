package com.accenture.flowershop.DAO;

import com.accenture.flowershop.entity.FlowerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlowerDAO extends JpaRepository<FlowerEntity, Long> {

    FlowerEntity findFlowerByName(String name);

    @Query(value = "SELECT * FROM FLOWERS WHERE price>=?1 AND price<=?2", nativeQuery = true)
    List<FlowerEntity> findFlowersByPriceRange(int priceFrom, int priceTo);
}
