package com.dailydash.entity;

import com.dailydash.entity.City;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class DashUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String email;
    private String password;
    @ManyToOne
    private City city;


    public DashUser(){}

    public DashUser(String firstName, String email, String password, City city) {
        this.firstName = firstName;
        this.email = email;
        this.password = password;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        DashUser dashUser = (DashUser) o;
        return Objects.equals(id, dashUser.id) && Objects.equals(firstName, dashUser.firstName) && Objects.equals(email, dashUser.email) && Objects.equals(password, dashUser.password) && Objects.equals(city, dashUser.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, email, password, city);
    }

    @Override
    public String toString() {
        return "DashUser{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", city=" + city +
                '}';
    }
}
