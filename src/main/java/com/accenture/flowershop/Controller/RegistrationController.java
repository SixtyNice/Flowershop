package com.accenture.flowershop.Controller;

import com.accenture.flowershop.Services.RegistrationService.RegistrationServiceImpl;
import com.accenture.flowershop.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    RegistrationServiceImpl registrationService;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user,
                                                 HttpServletRequest request) {

        UserEntity userEntity = registrationService.createUser(user, request);
        if (userEntity != null) {
            return new ResponseEntity<>(userEntity, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

    }

}
