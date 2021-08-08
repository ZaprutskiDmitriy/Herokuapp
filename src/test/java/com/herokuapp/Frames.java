package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Frames {

    @Test
    public void frames() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");

        System.setProperty("webdriver.chrome.driver", "D:/TeachMeSkills/WebDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("http://the-internet.herokuapp.com/iframe");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement iFrameElement = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iFrameElement);

        WebElement iFrameBody = driver.findElement(By.tagName("body"));
        String iFrameBodyText = iFrameBody.getText();
        Assert.assertEquals(iFrameBodyText, "Your content goes here.");

        driver.switchTo().defaultContent();

        driver.quit();
    }
}
