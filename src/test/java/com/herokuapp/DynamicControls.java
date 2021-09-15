package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DynamicControls {

    @Test
    public void dynamicControlsTest() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");

        System.setProperty("webdriver.chrome.driver", "D:/TeachMeSkills/WebDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver(chromeOptions);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement checkbox = driver.findElement(By.cssSelector("input[type='checkbox']"));
        checkbox.click();

        WebElement removeButton = driver.findElement(By.xpath("//*[@id=\"checkbox-example\"]/button"));
        removeButton.click();

        wait.until(ExpectedConditions.textToBe(By.cssSelector("p[id='message']"), "It's gone!"));
        wait.until(ExpectedConditions.invisibilityOf(checkbox));

        WebElement inputElement = driver.findElement(By.cssSelector("input[type='text']"));
        Assert.assertFalse(inputElement.isEnabled());

        WebElement enableButton = driver.findElement(By.xpath("//*[@id=\"input-example\"]/button"));
        enableButton.click();
        wait.until(ExpectedConditions.textToBe(By.cssSelector("p[id='message']"), "It's enabled!"));
        Assert.assertTrue(inputElement.isEnabled());

        driver.quit();
    }
}
