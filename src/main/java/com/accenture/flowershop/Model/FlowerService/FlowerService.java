package com.accenture.flowershop.Model.FlowerService;

import com.accenture.flowershop.DAO.FlowerDAO;
import com.accenture.flowershop.entity.FlowerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlowerService {

    @Autowired
    FlowerDAO flowerDAO;

    public List<FlowerEntity> getAllFlowers() {
        return flowerDAO.findAll();
    }

    public FlowerEntity getFlowerByName(String name) {
        return flowerDAO.findFlowerByName(name);
    }

    public List<FlowerEntity> getFlowersByPrice(int priceFrom, int priceTo) {
        List<FlowerEntity> flowers = flowerDAO.findFlowersByPriceRange(priceFrom, priceTo);
        if (flowers.size() > 0) {
            return flowers;
        } else {
            return new ArrayList<>();
        }

    }

}
