package com.dailydash.login;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashUserController {

    @GetMapping("/addUser")
    public void verifyUser(){

    }

    @PostMapping("/addUser")
    public void registerUser(){

    }
}
