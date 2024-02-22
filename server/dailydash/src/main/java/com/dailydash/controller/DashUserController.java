package com.dailydash.controller;

import com.dailydash.entity.City;
import com.dailydash.services.DashUserServices;
import com.dailydash.services.CityServices;
import com.dailydash.entity.DashUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class DashUserController {

    private final CityServices cityServices;
    private final DashUserServices dashUserServices;

    @Autowired
    public DashUserController(DashUserServices dashUserServices, CityServices cityServices){
        this.dashUserServices = dashUserServices;
        this.cityServices = cityServices;
    }

    @GetMapping("/signIn")
    public void verifyUser(String username, String password){
        dashUserServices.verifyUser(username, password);
        //OAuth 2.0 Token
        System.out.println("user is verified");
    }

    @PostMapping("/addUser")
    public void registerUser(@RequestBody DashUser tempDashUser){
        Optional<City> optionalCity = cityServices
                .findCityInfo(tempDashUser.getCity().getCityName());
        if (optionalCity.isPresent()) {
            dashUserServices.addUser(tempDashUser);
            cityServices.addCity(optionalCity.get());
        } //else statement??

    }
}
