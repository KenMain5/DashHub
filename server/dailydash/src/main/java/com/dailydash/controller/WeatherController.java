package com.dailydash.controller;

import com.dailydash.services.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService){
        this.weatherService = weatherService;
    }

    @GetMapping("/getWeather")
    public Mono<String> getPhiladelphiaWeather(){
        double lat = 39.9526;
        double lon = -75.1652;
        return weatherService.getWeather(lat, lon);
    }
}
