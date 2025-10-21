package com.github.souzafcharles.api.model.dto;

import jakarta.validation.constraints.NotBlank;

public record WeatherRequestDTO(
        @NotBlank(message = "The city name is mandatory.")
        String city
) {}
