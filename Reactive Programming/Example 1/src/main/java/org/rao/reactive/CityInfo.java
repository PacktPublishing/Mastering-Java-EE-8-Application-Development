package org.rao.reactive;

public class CityInfo {
    public final String cityName;
    public final double temperature;

    public CityInfo(String cityName, double temperature) {
        this.cityName = cityName;
        this.temperature = temperature;
    }

    public static CityInfo fetch(String cityName) {

        return new CityInfo(cityName, OpenWeather.getTemperature(cityName));
    }

    @Override
    public String toString() {
        return String.format("%s : %f", cityName, temperature);
    }
}
