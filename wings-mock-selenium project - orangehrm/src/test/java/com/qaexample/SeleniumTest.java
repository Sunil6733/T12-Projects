package com.qaexample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SeleniumTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void loginTest() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys("Admin");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys("admin123");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']"))).click();

        WebElement dashboardHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h6")));
        assertEquals("Dashboard", dashboardHeader.getText());
    }

    @Test
    public void windowHandleTest() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[3]/div[2]/p[2]/a"))).click();
        String originalWindow = driver.getWindowHandle();
        wait.until(d -> d.getWindowHandles().size() > 1);

        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
        String headerText = header.getText().replaceAll("\\s+", " ").trim();
        assertTrue(headerText.contains("Streamline All Your HR Needs on One Intuitive Platform"));
    }
}
