package com.github.souzafcharles.api.controller;

import com.github.souzafcharles.api.model.entity.WeatherData;
import com.github.souzafcharles.api.service.WeatherService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WeatherControllerTest {

    @Mock
    private WeatherService weatherService;

    @InjectMocks
    private WeatherController weatherController;

    @Test
    void shouldReturnWeatherDataWhenCityIsValid() {
        // Arrange
        var city = "London";
        var expectedData = new WeatherData(
                "London",
                "GB",
                "clear sky",
                15.0,
                80,
                5.0
        );

        when(weatherService.getWeather(city)).thenReturn(expectedData);

        // Act
        var result = weatherController.getWeather(city);

        // Assert
        assertEquals(expectedData.getCityName(), result.getCityName());
        assertEquals(expectedData.getCountry(), result.getCountry());
        assertEquals(expectedData.getDescription(), result.getDescription());
        assertEquals(expectedData.getTemperature(), result.getTemperature());
        assertEquals(expectedData.getHumidity(), result.getHumidity());
        assertEquals(expectedData.getWindSpeed(), result.getWindSpeed());

        verify(weatherService).getWeather(city);
    }
}