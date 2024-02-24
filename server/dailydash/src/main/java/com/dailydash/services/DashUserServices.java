package com.dailydash.services;

import com.dailydash.dto.LoginDTO;
import com.dailydash.dto.RegisterDTO;
import com.dailydash.entity.City;
import com.dailydash.entity.DashUser;
import com.dailydash.repository.DashUserRepository;
import jakarta.persistence.ManyToOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DashUserServices {

    private static final Logger logger = LoggerFactory.getLogger(DashUserServices.class);
    private final DashUserRepository dashUserRepository;
    private final CityServices cityServices;

    @Autowired
    public DashUserServices(DashUserRepository dashUserRepository, CityServices cityServices){
        this.dashUserRepository = dashUserRepository;
        this.cityServices = cityServices;
    }

    public boolean addUser(RegisterDTO registerDTO){
        logger.info("going to findcityinfo now");
        logger.info("This is the DTO CITY NAME GRAB" + registerDTO.getCityName());

        Optional<City> optionalCity = cityServices.findCityInfo(registerDTO.getCityName());
        logger.info("This is the Optional city" + optionalCity.get());
        if (optionalCity.isPresent()) {
            dashUserRepository.save(convertToDasher(registerDTO, optionalCity.get()));
            cityServices.addCity(optionalCity.get());
            return true;
        } else {
            return false;
        }
    }



    public DashUser convertToDasher(RegisterDTO registerDTO, City city){
        DashUser tempDashUser = new DashUser();
        tempDashUser.setFirstName(registerDTO.getFirstName());
        tempDashUser.setEmail(registerDTO.getEmail());
        tempDashUser.setPassword(registerDTO.getPassword());
        //tempDashUser.setCity(registerDTO.getCityName());
        return tempDashUser;
    }

    public boolean verifyUser(LoginDTO loginDTO){
        Optional<DashUser> optionalDashUser = dashUserRepository.findDashUserByEmailAndPassword(loginDTO.getEmail(), loginDTO.getPassword());
        if (optionalDashUser.isPresent()) {
            return true;
        } else {
            return false;
        }
    }

    public void deleteUser(Long id){
        Optional<DashUser> optionalDashUser = dashUserRepository.findById(id);
        if (optionalDashUser.isPresent()) {
            dashUserRepository.delete(optionalDashUser.get());
        } else {
            logger.info("the {} is not tied to a real user", id);
        }
    }
}
