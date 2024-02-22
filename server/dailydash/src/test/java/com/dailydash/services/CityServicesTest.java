package com.dailydash.services;

import com.dailydash.entity.City;
import com.dailydash.repository.CityRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CityServicesTest {

    @Mock
    private CityRepository cityRepository;

    @InjectMocks
    private CityServices cityServices;

    @Test
    public void CityServices_addCity_shouldAddCity(){
        //Creating a mock object
        City city = Mockito.mock(City.class);

        //Using Mockito when method that when the CityRepository.save that is
        // accepting a specific Mock City Object method is called, Then to return
        //a specific mock object..
        when(cityRepository.save(city)).thenReturn(city);
        //We are calling the cityServices add city method.. this method is the one we're testing..
        cityServices.addCity(city);
        //verify(mockObject, times(1)).methodToVerify(arguments);

        //verifying that the mockObject has been called one time.. with the save city method
        //and that it accepted a specific mock object
        verify(cityRepository, times(1)).save(city);

    }
}
