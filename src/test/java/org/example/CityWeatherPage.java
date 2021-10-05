package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public final class CityWeatherPage {
    private final WebDriver webDriver;

    CityWeatherPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public WebDriver webDriver() {
        return webDriver;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
     CityWeatherPage that = (CityWeatherPage) obj;
        return Objects.equals(this.webDriver, that.webDriver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(webDriver);
    }

    @Override
    public String toString() {
        return "CityWeatherPage[" +
                "webDriver=" + webDriver + ']';
    }

    private final static String ACTIVE_CITY_ClASS = "header-loc";

    public String getCurrentActiveCity() {
        return webDriver.findElement(By.className(ACTIVE_CITY_ClASS)).getText();
    }
}
