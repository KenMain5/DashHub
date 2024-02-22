package com.dailydash.services;

import com.dailydash.entity.City;
import com.dailydash.repository.CityRepository;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.Optional;

@Service
public class CityServices {

    private final CityRepository cityRepository;

    @Autowired
    public CityServices(CityRepository cityRepository){
        this.cityRepository = cityRepository;
    }

    public void addCity(City city){
        cityRepository.save(city);
    }






    public Optional<City> findCityInfo(String cityToFind) {
        Resource resource = new ClassPathResource("data/citiesData.csv");

        try (Reader reader = new InputStreamReader(resource.getInputStream())) {
            List<City> cities = new CsvToBeanBuilder<City>(reader)
                    .withType(City.class)
                    .build()
                    .parse();

            return cities.stream()
                    .filter(cityInfo -> cityInfo.getCityName() != null && cityInfo.getCityName().equalsIgnoreCase(cityToFind))
                    .findFirst();

        } catch (Exception e) {
            e.printStackTrace();
            return Optional.ofNullable(null);
        }
    }
}
