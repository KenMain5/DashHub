package com.dailydash;


import com.dailydash.city.City;
import com.dailydash.city.CityServices;
import com.dailydash.login.DashUser;
import com.dailydash.login.DashUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class DailydashApplication {

	public static void main(String[] args) {
		SpringApplication.run(DailydashApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(CityServices cityServices) {
		return runner -> {

			testingMethods(cityServices);
		};
	}

		private void testingMethods(CityServices cityServices){

		}
}
