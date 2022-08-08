package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CountryCityPhone {

    WebDriver driver;

    @Test
    public void getCountryList() {
        List<String> actualListOfCountry = Arrays.asList("Estonia", "Spain", "Austria", "");
        CountryCityPhone ccp = new CountryCityPhone();
        List<String> expectedListOfCountry = new ArrayList<>();
        expectedListOfCountry.add("");
        for (country country : country.values()) {
            expectedListOfCountry.add(country.label);
        }

        Collections.sort(actualListOfCountry);
        Collections.sort(expectedListOfCountry);
        System.out.println("actual list: " + actualListOfCountry);
        System.out.println("expected list: " + expectedListOfCountry);
        Assert.assertEquals(actualListOfCountry, expectedListOfCountry);
    }

    ;

    @Test
    public void validateCitiesByCountry() {

        for (country c : country.values()) //Austria
        {
            if (c.label.equals("Austria")) {
                List<String> actualListOfCities = Arrays.asList("Innsbruck", "Salzburg", "", "Vienna");
                System.out.println("actual list" + actualListOfCities);
                List<String> expectedListOfCities = new ArrayList<>();
                expectedListOfCities.add("");
                expectedListOfCities.addAll(1, c.cities);
                Collections.sort(actualListOfCities);
                Collections.sort(expectedListOfCities);
//                System.out.println("actual sorted list"+actualListOfCities);
//                System.out.println("expected sorted list"+expectedListOfCities);
                Assert.assertEquals(actualListOfCities, expectedListOfCities);
            }

        }
    }

    @Test
    public WebDriver invokeBrowser(BrowserName b) {
        if (b == BrowserName.CHROME) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (b == BrowserName.FIREFOX) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        return driver;
    }

    @Test
    public void ChromeBrowser() {
        driver = invokeBrowser(BrowserName.CHROME);
        driver.get("https://www.google.co.in/");
        driver.quit();
    }

    @Test
    public void FirefoxBrowser() {
        driver = invokeBrowser(BrowserName.FIREFOX);
        driver.get("https://www.google.co.in/");
        driver.quit();
    }

    enum BrowserName {CHROME, FIREFOX}

    enum country {
        AT("Austria", 43, Arrays.asList("Vienna", "Salzburg", "Innsbruck")),
        EE("Estonia", 372, Arrays.asList("Tallinn", "Haapsalu", "Tartu")),
        ES("Spain", 34, Arrays.asList("Malaga", "Madrid", "Valencia", "Corralejo"));
        public final String label;
        public final int phonePrefixNumber;
        public final List<String> cities;

        country(String label, int phonePrefixNumber, List<String> cities) {
            this.label = label;
            this.phonePrefixNumber = phonePrefixNumber;
            this.cities = cities;
        }
    }
}
