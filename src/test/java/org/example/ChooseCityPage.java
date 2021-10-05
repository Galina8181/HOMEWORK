package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;

public final class ChooseCityPage {
    private final WebDriver webDriver;

    ChooseCityPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public WebDriver webDriver() {
        return webDriver;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        ChooseCityPage that = (ChooseCityPage) obj;
        return Objects.equals(this.webDriver, that.webDriver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(webDriver);
    }

    @Override
    public String toString() {
        return "ChooseCityPage[" +
                "webDriver=" + webDriver + ']';
    }

    private static final String SEARCH_FIELD_CLASS = "search-input";
    private static final String ERROR_MESSAGE_CLASS = "no-results-text";

    public void start(String url) {
        webDriver.get(url);
    }

    public void searchCity(String city) {
        final WebElement searchInput = webDriver.findElement(By.className(SEARCH_FIELD_CLASS));
        searchInput.sendKeys(city, Keys.ENTER);
    }


   /* public String resultNotFound() {

        final WebElement searchInput = webDriver.findElement(By.className(SEARCH_FIELD_CLASS));
        searchInput.sendKeys(Keys.ENTER);
        return webDriver.findElement(By.className(ERROR_MESSAGE_CLASS)).getText();
    }*/
}
