package com.github.souzafcharles.api.service;

import com.github.souzafcharles.api.client.OpenWeatherClient;
import com.github.souzafcharles.api.model.entity.WeatherData;
import com.github.souzafcharles.api.model.mapper.WeatherMapper;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    private final OpenWeatherClient client;

    public WeatherService(OpenWeatherClient client) {
        this.client = client;
    }

    public WeatherData getWeather(String city) {
        var dto = client.getWeatherByCity(city);
        return WeatherMapper.toEntity(dto);
    }
}
