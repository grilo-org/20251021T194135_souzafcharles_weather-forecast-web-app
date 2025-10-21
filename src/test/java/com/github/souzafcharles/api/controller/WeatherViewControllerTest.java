package com.github.souzafcharles.api.controller;

import com.github.souzafcharles.api.model.entity.WeatherData;
import com.github.souzafcharles.api.service.WeatherService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class WeatherViewControllerTest {

    @Mock
    private WeatherService weatherService;

    @Mock
    private Model model;

    @InjectMocks
    private WeatherViewController controller;

    private WeatherData mockWeatherData;

    @BeforeEach
    void setUp() {
        mockWeatherData = new WeatherData();
        mockWeatherData.setCityName("London");
        mockWeatherData.setCountry("GB");
        mockWeatherData.setDescription("clear sky");
        mockWeatherData.setTemperature(15.0);
        mockWeatherData.setHumidity(70);
        mockWeatherData.setWindSpeed(5.5);
    }

    @Test
    void shouldReturnIndexViewOnHomeEndpoint() {
        // Act
        String viewName = controller.home();

        // Assert
        assertEquals("index", viewName);
    }

    @Test
    void shouldDisplayWeatherViewWhenCityIsValid() {
        // Arrange
        when(weatherService.getWeather("London")).thenReturn(mockWeatherData);

        // Act
        String viewName = controller.displayWeather("London", model);

        // Assert
        assertEquals("weather", viewName);
        verify(model).addAttribute("city", "London");
        verify(model).addAttribute("country", "GB");
        verify(model).addAttribute("weatherDescription", "clear sky");
        verify(model).addAttribute("temperature", 15.0);
        verify(model).addAttribute("humidity", 70);
        verify(model).addAttribute("windSpeed", 5.5);
        verify(model).addAttribute(eq("weatherIcon"), any());
    }

    @Test
    void shouldHandleExceptionAndReturnErrorView() {
        // Arrange
        when(weatherService.getWeather("UnknownCity"))
                .thenThrow(new RuntimeException("API error"));

        // Act
        String viewName = controller.displayWeather("UnknownCity", model);

        // Assert
        assertEquals("weather", viewName);
        verify(model).addAttribute("error", "City not found or an API error occurred.");
    }
}