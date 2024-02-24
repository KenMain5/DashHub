package com.dailydash.controller;

import com.dailydash.dto.LoginDTO;
import com.dailydash.dto.RegisterDTO;
import com.dailydash.entity.City;
import com.dailydash.services.DashUserServices;
import com.dailydash.services.CityServices;
import com.dailydash.entity.DashUser;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class DashUserController {

    private final CityServices cityServices;
    private final DashUserServices dashUserServices;
    private Logger logger = LoggerFactory.getLogger(DashUserController.class);

    @Autowired
    public DashUserController(DashUserServices dashUserServices, CityServices cityServices){
        this.dashUserServices = dashUserServices;
        this.cityServices = cityServices;
    }

    @PostMapping("/login")
    public ResponseEntity<String> verifyUser(@RequestBody LoginDTO loginDTO){
        boolean isVerified = dashUserServices.verifyUser(loginDTO);
        if (isVerified) {
            return ResponseEntity.ok().body("User verification successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed: User is not in the database");
        }
    }


    @PostMapping("/addUser")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<String> registerUser(@RequestBody RegisterDTO registerDTO){
        logger.info("this is the registerDTO name" + registerDTO.getFirstName());
        logger.info("this is the registerDTO email" + registerDTO.getEmail());
        logger.info("this is the registerDTO pass" + registerDTO.getPassword());
        logger.info("this is the registerDTO citynanme" + registerDTO.getCityName());
        boolean isUserAdded =  dashUserServices.addUser(registerDTO);
        if (isUserAdded) {
            return ResponseEntity.ok().body("User account creation is successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed: User is not in the database");
        }
    }
}
