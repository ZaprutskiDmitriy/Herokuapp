package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Inputs {

    @Test
    public void inputs() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");

        System.setProperty("webdriver.chrome.driver", "D:/TeachMeSkills/WebDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("http://the-internet.herokuapp.com/inputs");

        WebElement input = driver.findElement(By.tagName("input"));
        input.sendKeys(Keys.ARROW_DOWN);
        input.clear();
        input.sendKeys(Keys.ARROW_UP);
        input.sendKeys(Keys.ARROW_UP);

            driver.quit();
    }
}
