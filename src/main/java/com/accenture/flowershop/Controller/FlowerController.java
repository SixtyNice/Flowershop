package com.accenture.flowershop.Controller;


import com.accenture.flowershop.Services.FlowerService.FlowerServiceImpl;
import com.accenture.flowershop.entity.FlowerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/flowers")
public class FlowerController {

    @Autowired
    FlowerServiceImpl flowerService;

    @GetMapping(path = "/list", produces = "application/json")
    public List<FlowerEntity> getAllFlowers() {
        return flowerService.getAllFlowers();
    }

    @GetMapping(path = "/getflowerbyname/{name}", produces = "application/json")
    public FlowerEntity getFlowerByName(@PathParam("name") String name) {
        return flowerService.getFlowerByName(name);
    }

    @GetMapping(path = "/getflowerbyprice", produces = "application/json")
    public List<FlowerEntity> getFlowerByPrice(@RequestParam("pricefrom") Integer priceFrom, @RequestParam("priceto") Integer priceTo) {
        return flowerService.getFlowersByPrice(priceFrom, priceTo);

    }

}
