package com.qaexample;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Path;
import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SeleniumTest {

    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeClass
    public static void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @AfterClass
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
public void shouldConvertINRtoEUR() {
    String appUrl = Path.of("src", "test", "resources", "webapp", "index.html")
            .toAbsolutePath().toUri().toString();
    driver.get(appUrl);

    new Select(driver.findElement(By.id("currency_from_find")))
            .selectByValue("INR");

    driver.findElement(By.id("given_amount")).clear();
    driver.findElement(By.id("given_amount")).sendKeys("67567");

    new Select(driver.findElement(By.id("currency_to_find")))
            .selectByValue("EUR");

    driver.findElement(By.id("convertBtn")).click();

    wait.until(d -> !driver.findElement(By.id("converted_amount"))
            .getAttribute("value").isEmpty());

    String result = driver.findElement(By.id("converted_amount"))
            .getAttribute("value");

    System.out.println("Conversion Result: " + result);

    assertEquals("785.40", result);
}

@Test
public void shouldRequireDateBeforeConversion() {
    String appUrl = Path.of("src", "test", "resources", "webapp", "index.html")
            .toAbsolutePath().toUri().toString();
    driver.get(appUrl);

    driver.findElement(By.id("given_amount")).clear();
    driver.findElement(By.id("given_amount")).sendKeys("100");

    driver.findElement(By.id("convert_date")).clear(); // remove date

    driver.findElement(By.id("convertBtn")).click();

    String result = driver.findElement(By.id("converted_amount"))
            .getAttribute("value");

    System.out.println("Validation Message: " + result);

    assertEquals("Please select a date", result);
}

}