package com.dailydash.login;

import com.dailydash.city.CityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DashUserServices {

    private static final Logger logger = LoggerFactory.getLogger(DashUserServices.class);
    private final DashUserRepository dashUserRepository;

    @Autowired
    public DashUserServices(DashUserRepository dashUserRepository){
        this.dashUserRepository = dashUserRepository;
    }

    public void addUser(DashUser user){
        dashUserRepository.save(user);

    }

    public boolean verifyUser(String userName, String password){
        Optional<DashUser> optionalDashUser = dashUserRepository.findDashUserByUsernameAndPassword(userName, password);
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
