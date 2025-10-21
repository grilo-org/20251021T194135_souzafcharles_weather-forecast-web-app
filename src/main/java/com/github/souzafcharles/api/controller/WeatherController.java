package com.github.souzafcharles.api.controller;

import com.github.souzafcharles.api.model.entity.WeatherData;
import com.github.souzafcharles.api.service.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    private final WeatherService service;

    public WeatherController(WeatherService service) {
        this.service = service;
    }

    @GetMapping
    public WeatherData getWeather(@RequestParam String city) {
        return service.getWeather(city);
    }
}