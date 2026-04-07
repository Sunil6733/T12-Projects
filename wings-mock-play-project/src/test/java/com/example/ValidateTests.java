package com.example;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

import static org.testng.Assert.*;

public class ValidateTests {
    private WebDriver driver;
    private WebDriverWait wait;

    @Test(priority = 1)
    public void validateFromFieldExists() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("http://localhost:8000");
        
        WebElement fromField = wait.until(
            ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='From']"))
        );
        
        assertNotNull(fromField, "From field should exist");
        assertTrue(fromField.isDisplayed(), "From field should be displayed");
        
        driver.quit();
    }

    @Test(priority = 2)
    public void validateToFieldExists() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("http://localhost:8000");
        
        WebElement toField = wait.until(
            ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='To']"))
        );
        
        assertNotNull(toField, "To field should exist");
        assertTrue(toField.isDisplayed(), "To field should be displayed");
        
        driver.quit();
    }

    @Test(priority = 3)
    public void validateSearchButtonExists() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("http://localhost:8000");
        
        WebElement searchBtn = wait.until(
            ExpectedConditions.presenceOfElementLocated(
                By.xpath("//button[contains(text(), 'Search Flight')]")
            )
        );
        
        assertNotNull(searchBtn, "Search button should exist");
        assertTrue(searchBtn.isDisplayed(), "Search button should be displayed");
        assertEquals(searchBtn.getText(), "Search Flight", "Search button text");
        
        driver.quit();
    }

    @Test(priority = 4)
    public void validatePassengersCounterExists() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("http://localhost:8000");
        
        WebElement passengersField = wait.until(
            ExpectedConditions.presenceOfElementLocated(By.id("passengers"))
        );
        
        assertNotNull(passengersField, "Passengers field should exist");
        assertEquals(passengersField.getAttribute("value"), "1", "Default passengers should be 1");
        
        driver.quit();
    }

    @Test(priority = 5)
    public void validateDepartureDateExists() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("http://localhost:8000");
        
        WebElement dateField = wait.until(
            ExpectedConditions.presenceOfElementLocated(By.id("departureDate"))
        );
        
        assertNotNull(dateField, "Departure date field should exist");
        assertTrue(
            dateField.getAttribute("value").length() > 0,
            "Departure date should have default value"
        );
        
        driver.quit();
    }

    @Test(priority = 6)
    public void validateCurrencyDropdownExists() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("http://localhost:8000");
        
        WebElement currencyDropdown = wait.until(
            ExpectedConditions.presenceOfElementLocated(By.id("currency"))
        );
        
        assertNotNull(currencyDropdown, "Currency dropdown should exist");
        assertTrue(currencyDropdown.isDisplayed(), "Currency dropdown should be displayed");
        
        driver.quit();
    }

    @Test(priority = 7)
    public void validateCouponIframeExists() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("http://localhost:8000");
        
        WebElement iframe = wait.until(
            ExpectedConditions.presenceOfElementLocated(By.id("couponFrame"))
        );
        
        assertNotNull(iframe, "Coupon iframe should exist");
        assertTrue(iframe.isDisplayed(), "Coupon iframe should be displayed");
        
        driver.quit();
    }

    @Test(priority = 8)
    public void validateFormSubmissionWithValidData() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("http://localhost:8000");
        
        // Fill form
        WebElement fromField = wait.until(
            ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='From']"))
        );
        fromField.clear();
        fromField.sendKeys("Place 1");
        
        WebElement toField = driver.findElement(By.xpath("//input[@placeholder='To']"));
        toField.clear();
        toField.sendKeys("Place 2");
        
        // Submit form
        WebElement searchBtn = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(text(), 'Search Flight')]")
            )
        );
        searchBtn.click();
        
        // Verify success message appears
        WebElement successMsg = wait.until(
            ExpectedConditions.presenceOfElementLocated(By.id("successMessage"))
        );
        
        assertNotNull(successMsg, "Success message should appear");
        
        driver.quit();
    }

    @Test(priority = 9)
    public void validatePassengersCounterIncrement() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("http://localhost:8000");
        
        WebElement passengersField = wait.until(
            ExpectedConditions.presenceOfElementLocated(By.id("passengers"))
        );
        
        WebElement increaseBtn = driver.findElement(By.id("increasePassengers"));
        
        String initialValue = passengersField.getAttribute("value");
        increaseBtn.click();
        
        String newValue = passengersField.getAttribute("value");
        
        assertTrue(
            Integer.parseInt(newValue) > Integer.parseInt(initialValue),
            "Passengers should increment"
        );
        
        driver.quit();
    }
}
