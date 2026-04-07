package com.example;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

public class SeleniumTests {
    private WebDriver driver;
    private WebDriverWait wait;

    public void setupDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void navigateToApplication(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    public WebElement findElementByXPath(String xpath) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }

    public WebElement findClickableElement(String xpath) {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }

    public void switchToFrame(WebElement frame) {
        driver.switchTo().frame(frame);
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public void fillTextInput(String xpath, String value) {
        WebElement element = findElementByXPath(xpath);
        element.clear();
        element.sendKeys(value);
    }

    public void clickElement(String xpath) {
        WebElement element = findClickableElement(xpath);
        element.click();
    }

    public String getElementText(String xpath) {
        return findElementByXPath(xpath).getText();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }
}
