package com.accenture.flowershop.Controller;

import com.accenture.flowershop.Model.RegistrationService.RegistrationServiceImpl;
import com.accenture.flowershop.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    RegistrationServiceImpl registrationService;

    @PostMapping(path = "/", consumes = "application/json", produces = "application/json")
    public Map<String, Boolean> createUser(@RequestBody UserEntity user) {
        Map<String, Boolean> response = new HashMap<>();

        response.put("response", registrationService.createUser(user));
        return response;
    }

}
