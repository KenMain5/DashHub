package com.dailydash.weather;

import com.dailydash.city.City;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

@Entity
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String condition;

    private double temperature;

    private LocalDateTime dateTime;

    @OneToOne
    private City city;

    public Weather(){

    }

    public Weather(String condition, double temperature, LocalDateTime dateTime){
        this.condition = condition;
        this.temperature = temperature;
        this.dateTime = dateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weather weather = (Weather) o;
        return Double.compare(temperature, weather.temperature) == 0 && Objects.equals(id, weather.id) && Objects.equals(condition, weather.condition) && Objects.equals(dateTime, weather.dateTime) && Objects.equals(city, weather.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, condition, temperature, dateTime, city);
    }

    @Override
    public String toString() {
        return "Weather{" +
                "id=" + id +
                ", condition='" + condition + '\'' +
                ", temperature=" + temperature +
                ", dateTime=" + dateTime +
                ", city=" + city +
                '}';
    }
}
