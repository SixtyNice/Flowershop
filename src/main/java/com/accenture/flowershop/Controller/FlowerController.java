package com.accenture.flowershop.Controller;


import com.accenture.flowershop.Services.FlowerService.FlowerServiceImpl;
import com.accenture.flowershop.entity.FlowerEntity;
import com.accenture.flowershop.entity.FlowerFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/flowers")
public class FlowerController {

    @Autowired
    private FlowerServiceImpl flowerService;

    @GetMapping(produces = "application/json")
    public List<FlowerEntity> getAllFlowers() {
        return flowerService.getAllFlowers();
    }

    @GetMapping(path = "/getflowerbyname/{name}", produces = "application/json")
    public ResponseEntity<FlowerEntity> getFlowerByName(@RequestBody FlowerFilter flowerFilter) {
        FlowerEntity flowerEntity = flowerService.getFlowerByName(flowerFilter);
        if (flowerEntity != null) {
            return new ResponseEntity<>(flowerEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/getflowerbyprice", produces = "application/json")
    public ResponseEntity<List<FlowerEntity>> getFlowerByPrice(@RequestBody FlowerFilter flowerFilter) {
        List<FlowerEntity> flowerEntityList = flowerService.getFlowersByPrice(flowerFilter);
        if (flowerEntityList.size() != 0) {
            return new ResponseEntity<>(flowerEntityList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}
