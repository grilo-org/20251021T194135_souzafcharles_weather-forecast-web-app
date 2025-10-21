package com.github.souzafcharles.api.model.mapper;

import com.github.souzafcharles.api.model.dto.WeatherResponseDTO;
import com.github.souzafcharles.api.model.entity.WeatherData;

public final class WeatherMapper {

    private WeatherMapper() {}

    public static WeatherData toEntity(WeatherResponseDTO dto) {
        var weather = dto.weather() != null && !dto.weather().isEmpty() ? dto.weather().getFirst() : null;

        return new WeatherData(
                dto.name(),
                dto.sys() != null ? dto.sys().country() : "",
                weather != null ? weather.description() : "",
                dto.main() != null ? dto.main().temp() : 0.0,
                dto.main() != null ? dto.main().humidity() : 0,
                dto.wind() != null ? dto.wind().speed() : 0.0
        );
    }
}
