package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.*;

public class StepDefinitions {
    static final WebDriver webDriver;
    private static final ChooseCityPage chooseCityPage;
    public static final CityWeatherPage cityWeatherPage;

    static {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Alexey\\Desktop\\Учеба IT\\QAJA_m35_selenium-waitings-main\\cc-scenario\\src\\test\\resources\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.manage().window().maximize();
        chooseCityPage = new ChooseCityPage(webDriver);
        cityWeatherPage = new CityWeatherPage(webDriver);

    }

    @Given("url {string}")
    public void url(String url) {
        chooseCityPage.start(url);
    }

    @Then("search a city {string}")
    public void search_a_city(String city) {
        chooseCityPage.searchCity(city);
    }

   /* @Then("click on first link")
    public void click_on_first_link() {
       webDriver.findElements(By.className("locations-list")).get(0).click();

    }*/

    @Then("assert that chosen city is {string}")
    public void assert_that_chosen_city_is(String expectedCity) {
        final String currentActiveCity = cityWeatherPage.getCurrentActiveCity();
        assertEquals(expectedCity, currentActiveCity);

    }


    @Then("search a city  {string}")
    public void search_incorrect_city (String city) {
        chooseCityPage.searchCity(city);
    }

  /*  @Then("assert that a message appears {string}")

        public void assert_that_message_appears (String errorMessage) {
            final String resultNotFound = chooseCityPage.resultNotFound();
            assertEquals(errorMessage, resultNotFound);
        }*/

    }


