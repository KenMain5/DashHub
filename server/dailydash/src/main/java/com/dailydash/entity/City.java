package com.dailydash.entity;

import com.opencsv.bean.CsvBindByName;
import jakarta.persistence.*;

import java.util.Objects;


@Entity
public class City {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @CsvBindByName(column = "city")
    private String cityName;

    @CsvBindByName(column = "lat")
    private double latitude;

    @CsvBindByName(column = "lng")
    private double longitude;

    @OneToOne(mappedBy="city")
    private Weather weather;

    public City(){

    }

    public City(String cityName, double latitude, double longitude){
        this.cityName = cityName;
        this.latitude = latitude;
        this.longitude = longitude;
    }


    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getCityName(){
        return this.cityName;
    }

    public void setCityName(String cityName){
        this.cityName = cityName;
    }

    public double getLatitude(){
        return this.latitude;
    }

    public void setLatitude(double latitude){
        this.latitude = latitude;
    }

    public double getLongitude(){
        return this.longitude;
    }

    public void setLongitude(double longitude){
        this.longitude = longitude;
    }

    public Weather getWeather(){
        return this.weather;
    }

    public void setWeather(Weather weather){
        this.weather = weather;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Double.compare(latitude, city.latitude) == 0 && Double.compare(longitude, city.longitude) == 0 && Objects.equals(id, city.id) && Objects.equals(cityName, city.cityName) && Objects.equals(weather, city.weather);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cityName, latitude, longitude, weather);
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", cityName='" + cityName + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", weather=" + weather +
                '}';
    }
}
