package com.dailydash.weather.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class WeatherEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;


}
