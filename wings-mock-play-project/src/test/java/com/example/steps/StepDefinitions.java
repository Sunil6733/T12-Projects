package com.example.steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class StepDefinitions {
    private WebDriver driver;
    private WebDriverWait wait;

    @Given("User is on the flight booking page")
    public void user_on_flight_booking_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://localhost:8000");
        driver.manage().window().maximize();
    }

    @When("User enters from location {string}")
    public void user_enters_from_location(String location) {
        WebElement fromField = wait.until(
            ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='From']"))
        );
        fromField.clear();
        fromField.sendKeys(location);
    }

    @And("User enters to location {string}")
    public void user_enters_to_location(String location) {
        WebElement toField = wait.until(
            ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='To']"))
        );
        toField.clear();
        toField.sendKeys(location);
    }

    @And("User sets departure date to {string}")
    public void user_sets_departure_date(String date) {
        WebElement dateField = wait.until(
            ExpectedConditions.presenceOfElementLocated(By.id("departureDate"))
        );
        dateField.clear();
        dateField.sendKeys(date);
    }

    @And("User selects {int} passengers")
    public void user_selects_passengers(int count) {
        WebElement passengersField = wait.until(
            ExpectedConditions.presenceOfElementLocated(By.id("passengers"))
        );
        int currentCount = Integer.parseInt(passengersField.getAttribute("value"));
        
        WebElement increaseBtn = driver.findElement(By.id("increasePassengers"));
        for (int i = currentCount; i < count; i++) {
            increaseBtn.click();
        }
    }

    @And("User selects {string} as passenger category")
    public void user_selects_category(String category) {
        String categoryId = category.toLowerCase().replace(" ", "").replace(".", "");
        WebElement categoryRadio = wait.until(
            ExpectedConditions.presenceOfElementLocated(By.id(categoryId))
        );
        categoryRadio.click();
    }

    @And("User clicks search flight button")
    public void user_clicks_search_flight() {
        WebElement searchBtn = wait.until(
            ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Search Flight')]"))
        );
        searchBtn.click();
    }

    @Then("User should see success message")
    public void user_sees_success_message() {
        WebElement successMsg = wait.until(
            ExpectedConditions.presenceOfElementLocated(By.id("successMessage"))
        );
        String displayStyle = successMsg.getAttribute("style");
        System.out.println("Success message displayed: " + successMsg.getText());
    }

    @And("User closes the browser")
    public void user_closes_browser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
