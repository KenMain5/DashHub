package com.dailydash.weather;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;



@Configuration
public class WeatherConfig {

    @Bean
    public WebClient.Builder webClientBuilder(){
        return WebClient.builder();
    }

}
