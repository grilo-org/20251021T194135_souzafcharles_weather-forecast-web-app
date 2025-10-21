package com.github.souzafcharles.api.util;

public final class WeatherIconUtils {

    private WeatherIconUtils() {}

    public static String getWeatherIcon(String description) {
        if (description == null || description.isBlank()) return "wi wi-na";

        String desc = description.toLowerCase();

        if (desc.contains("cloud")) return "wi wi-cloud";
        if (desc.contains("rain")) return "wi wi-rain";
        if (desc.contains("sun")) return "wi wi-day-sunny";
        if (desc.contains("storm")) return "wi wi-thunderstorm";
        if (desc.contains("snow")) return "wi wi-snow";
        return "wi wi-na";
    }
}
