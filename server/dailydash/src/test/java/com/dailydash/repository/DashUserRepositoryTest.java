//package com.dailydash.repository;
//import com.dailydash.entity.City;
//import com.dailydash.entity.DashUser;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//import java.util.List;
//import java.util.Optional;
//
//@DataJpaTest
//@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
//public class DashUserRepositoryTest {
//
//    @Autowired
//    private DashUserRepository dashUserRepository;
//
//    @Autowired
//    private CityRepository cityRepository;
//
//    @Test
//    public void DashUserRepository_SAVE_shouldSaveUser(){
//        City city = new City("Eureka",40.7943,-124.1564);
//        DashUser dashUser = new DashUser("username", "password", city);
//
//        DashUser savedDashUser= dashUserRepository.save(dashUser);
//
//        Assertions.assertThat(savedDashUser).isNotNull();
//    }
//
//    @Test
//    public void DashUserRepository_SAVE_shouldDeleteUser(){
//        City city = new City("Eureka",40.7943,-124.1564);
//        city = cityRepository.save(city);
//        DashUser dashUser = new DashUser("username", "password", city);
//        DashUser savedDashUser= dashUserRepository.save(dashUser);
//
//        dashUserRepository.delete(savedDashUser);
//
//        Assertions.assertThat(dashUserRepository.existsByUsername("username")).isFalse();
//    }
//
//    @Test
//    public void DashUserRepository_existsByUsername_shouldReturnTrue(){
//        City city = new City("Eureka",40.7943,-124.1564);
//        city = cityRepository.save(city);
//        DashUser dashUser = new DashUser("username", "password", city);
//        dashUserRepository.save(dashUser);
//
//        Boolean exists = dashUserRepository.existsByUsername(dashUser.getUsername());
//
//        Assertions.assertThat(exists).isTrue();
//    }
//
//    @Test
//    public void DashUserRepository_existsByUsername_shouldReturnFalse(){
//        Boolean exists = dashUserRepository.existsByUsername("Non-ExistentUser");
//
//        Assertions.assertThat(exists).isFalse();
//    }
//
//    @Test
//    public void DashUserRepository_SAVE_shouldSaveUserInfo(){
//        City city = new City("Eureka",40.7943,-124.1564);
//        DashUser dashUser = new DashUser("username", "password", city);
//
//        DashUser savedDashUser= dashUserRepository.save(dashUser);
//
//        Assertions.assertThat(savedDashUser.getUsername()).isEqualTo("username");
//        Assertions.assertThat(savedDashUser.getPassword()).isEqualTo("password");
//        Assertions.assertThat(savedDashUser.getCity().getLatitude()).isEqualTo(40.7943);
//        Assertions.assertThat(savedDashUser.getCity().getCityName()).isEqualTo("Eureka");
//        Assertions.assertThat(savedDashUser.getCity().getLongitude()).isEqualTo(-124.1564);
//    }
//
//    @Test
//    public void DashUserRepository_findById_shouldFindUserByID(){
//        City city1 = new City("Eureka",40.7943,-124.1564);
//        DashUser dashUser1 = new DashUser("username", "password", city1);
//        City city2 = new City("Troy",40.0437,-84.2186);
//        DashUser dashUser2 = new DashUser("username1", "password1", city2);
//
//        DashUser savedDashUser1= dashUserRepository.save(dashUser1);
//        DashUser savedDashUser2= dashUserRepository.save(dashUser2);
//
//        //Assertion
//        Optional<DashUser> savedUser = dashUserRepository.findById(savedDashUser2.getId());
//        Assertions.assertThat(savedUser.isPresent());
//        savedUser.ifPresent(user -> {
//            Assertions.assertThat(user.getUsername()).isEqualTo(savedDashUser2.getUsername());
//            Assertions.assertThat(user.getPassword()).isEqualTo(savedDashUser2.getPassword());
//            Assertions.assertThat(user.getCity().getCityName()).isEqualTo(savedDashUser2.getCity().getCityName());
//        });
//    }
//
//    @Test
//    public void DashUserRepository_findUsernameByUsernameAndPassword_shouldReturnCorrectUser(){
//        City city = new City("Troy",40.0437,-84.2186);
//        cityRepository.save(city);
//        DashUser unsavedDashUser = new DashUser("username1", "password1", city);
//        DashUser savedDashUser = dashUserRepository.save(unsavedDashUser);
//
//        Optional<DashUser> foundUser= dashUserRepository.findDashUserByUsernameAndPassword(savedDashUser.getUsername(), savedDashUser.getPassword());
//
//        Assertions.assertThat(foundUser.isPresent()).isTrue();
//            foundUser.ifPresent(user -> {
//                Assertions.assertThat(foundUser.get().getUsername()).isEqualTo(unsavedDashUser.getUsername());
//                Assertions.assertThat(foundUser.get().getPassword()).isEqualTo(unsavedDashUser.getPassword());
//                Assertions.assertThat(foundUser.get().getCity().getCityName()).isEqualTo(unsavedDashUser.getCity().getCityName());
//            });
//    }
//}
