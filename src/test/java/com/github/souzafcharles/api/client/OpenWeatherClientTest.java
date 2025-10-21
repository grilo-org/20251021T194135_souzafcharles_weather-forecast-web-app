package com.github.souzafcharles.api.client;

import com.github.souzafcharles.api.model.dto.WeatherResponseDTO;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class OpenWeatherClientTest {

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Test
    void shouldReturnWeatherResponseWhenCityIsValid() {
        // Arrange
        WebClient webClientMock = mock(WebClient.class);
        WebClient.RequestHeadersUriSpec requestMock = mock(WebClient.RequestHeadersUriSpec.class);
        WebClient.RequestHeadersSpec headersMock = mock(WebClient.RequestHeadersSpec.class);
        WebClient.ResponseSpec responseMock = mock(WebClient.ResponseSpec.class);

        WeatherResponseDTO expectedResponse = new WeatherResponseDTO(
                "London",
                new WeatherResponseDTO.Sys("GB"),
                List.of(new WeatherResponseDTO.Weather(800, "clear sky")),
                new WeatherResponseDTO.Main(15.5, 70),
                new WeatherResponseDTO.Wind(5.2)
        );

        when(webClientMock.get()).thenReturn(requestMock);
        when(requestMock.uri((Function) any(Function.class))).thenReturn(headersMock);
        when(headersMock.retrieve()).thenReturn(responseMock);
        when(responseMock.bodyToMono(WeatherResponseDTO.class)).thenReturn(Mono.just(expectedResponse));

        OpenWeatherClient client = new OpenWeatherClient(webClientMock, "fakeApiKey");

        // Act
        WeatherResponseDTO response = client.getWeatherByCity("London");

        // Assert
        assertNotNull(response);
        assertEquals("London", response.name());
        assertEquals("GB", response.sys().country());
        assertEquals(15.5, response.main().temp());
        verify(webClientMock).get();
        verify(requestMock).uri(any(Function.class));
        verify(headersMock).retrieve();
    }
}