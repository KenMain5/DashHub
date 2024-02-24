//package com.dailydash.repository;
//
//import com.dailydash.entity.City;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//@DataJpaTest
//@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
//public class CityRepositoryTest {
//
//    @Autowired
//    private CityRepository cityRepository;
//
//    @Test
//    public void CityRepository_SaveOne_ShouldSaveCityWithDetails(){
//        //Arrange
//        City city = new City("Philadelphia", 5.33, 10.00);
//
//        //Act
//        City savedCity = cityRepository.save(city);
//
//        //Assert
//        Assertions.assertThat(savedCity.getCityName()).isEqualTo("Philadelphia");
//        Assertions.assertThat(savedCity.getLatitude()).isEqualTo(5.33);
//        Assertions.assertThat(savedCity.getLongitude()).isEqualTo(10.00);
//    }
//
//}
