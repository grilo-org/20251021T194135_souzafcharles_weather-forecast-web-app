package com.github.souzafcharles.api.client;

import com.github.souzafcharles.api.model.dto.WeatherResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Component
public class OpenWeatherClient {

    private final WebClient webClient;
    private final String apiKey;

    public OpenWeatherClient(WebClient webClient,
                             @Value("${api.key}") String apiKey) {
        this.webClient = webClient;
        this.apiKey = apiKey;
    }

    public WeatherResponseDTO getWeatherByCity(String city) {
        try {
            return webClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .scheme("https")
                            .host("api.openweathermap.org")
                            .path("/data/2.5/weather")
                            .queryParam("q", city)
                            .queryParam("appid", apiKey)
                            .queryParam("units", "metric")
                            .queryParam("lang", "en")
                            .build())
                    .retrieve()
                    .bodyToMono(WeatherResponseDTO.class)
                    .block();
        } catch (WebClientResponseException e) {
            throw new RuntimeException("Error calling OpenWeather API: " + e.getStatusCode(), e);
        }
    }
}