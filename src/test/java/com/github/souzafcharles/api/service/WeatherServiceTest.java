package com.github.souzafcharles.api.service;

import com.github.souzafcharles.api.client.OpenWeatherClient;
import com.github.souzafcharles.api.model.dto.WeatherResponseDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WeatherServiceTest {

    @Mock
    private OpenWeatherClient client;

    @InjectMocks
    private WeatherService service;

    @Test
    void shouldReturnWeatherDataWhenCityIsValid() {
        // Arrange
        var dto = new WeatherResponseDTO(
                "London",
                new WeatherResponseDTO.Sys("GB"),
                List.of(new WeatherResponseDTO.Weather(800, "clear sky")),
                new WeatherResponseDTO.Main(15.0, 80),
                new WeatherResponseDTO.Wind(5.0)
        );
        when(client.getWeatherByCity("London")).thenReturn(dto);

        // Act
        var result = service.getWeather("London");

        // Assert
        assertEquals("London", result.getCityName());
        assertEquals("GB", result.getCountry());
        assertEquals(15.0, result.getTemperature());
        verify(client).getWeatherByCity("London");
    }
}