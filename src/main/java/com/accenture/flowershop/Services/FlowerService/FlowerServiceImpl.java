package com.accenture.flowershop.Services.FlowerService;

import com.accenture.flowershop.DAO.FlowerDAO;
import com.accenture.flowershop.entity.FlowerEntity;
import com.accenture.flowershop.entity.FlowerFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlowerServiceImpl implements FlowerService {

    @Autowired
    private FlowerDAO flowerDAO;

    public List<FlowerEntity> getAllFlowers() {
        return flowerDAO.findAll();
    }

    public FlowerEntity getFlowerByName(FlowerFilter flowerFilter) {
        return flowerDAO.findFlowerByName(flowerFilter.getName());
    }

    public List<FlowerEntity> getFlowersByPrice(FlowerFilter flowerFilter) {
        List<FlowerEntity> flowers = flowerDAO.findFlowersByPriceRange(flowerFilter.getFromPrice(), flowerFilter.getToPrice());
        if (flowers.size() > 0) {
            return flowers;
        } else {
            return new ArrayList<>();
        }

    }

    @Override
    public void increaseFlowersStockSize(int count) {
        List<FlowerEntity> flowers = getAllFlowers();
        flowers.forEach(flower -> {
                    flower.setAmount(flower.getAmount() + count);
                    flowerDAO.save(flower);
                }
        );
    }

}
