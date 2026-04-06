package com.qaexample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Path;
import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ValidateTest {

    private WebDriver driver;
    private WebDriverWait wait;

    private String getAppUrl() {
        return Path.of("src", "test", "resources", "webapp", "index.html")
                .toAbsolutePath().toUri().toString();
    }

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get(getAppUrl());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // ✅ Scenario 1: UI Elements Visibility
    @Test
    public void shouldShowCurrencyInputFields() {

        assertTrue(driver.findElement(By.id("given_amount")).isDisplayed());
        assertTrue(driver.findElement(By.id("currency_from_find")).isDisplayed());
        assertTrue(driver.findElement(By.id("currency_to_find")).isDisplayed());
        assertTrue(driver.findElement(By.id("convert_date")).isDisplayed());
        assertTrue(driver.findElement(By.id("converted_amount")).isDisplayed());
    }

    // ✅ Scenario 2: Validate Date Required
    @Test
    public void shouldShowErrorWhenDateNotSelected() {

        driver.findElement(By.id("given_amount")).clear();
        driver.findElement(By.id("given_amount")).sendKeys("100");

        // Clear date field
        driver.findElement(By.id("convert_date")).clear();

        driver.findElement(By.id("convertBtn")).click();

        String result = wait.until(d ->
                driver.findElement(By.id("converted_amount"))
                        .getAttribute("value")
        );

        System.out.println("Validation Message: " + result);

        assertEquals("Please select a date", result);
    }

    // ✅ Scenario 3: Validate Invalid Amount
    @Test
    public void shouldShowErrorForInvalidAmount() {

        driver.findElement(By.id("given_amount")).clear();
        driver.findElement(By.id("given_amount")).sendKeys("0");

        driver.findElement(By.id("convertBtn")).click();

        String result = wait.until(d ->
                driver.findElement(By.id("converted_amount"))
                        .getAttribute("value")
        );

        System.out.println("Validation Message: " + result);

        assertEquals("Please enter a valid amount", result);
    }
}