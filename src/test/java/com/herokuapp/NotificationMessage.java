package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NotificationMessage {
    @Test
    public void notificationMessage() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");

        System.setProperty("webdriver.chrome.driver", "D:/TeachMeSkills/WebDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("http://the-internet.herokuapp.com/notification_message_rendered");

        WebElement clickHereRef = driver.findElement(By.cssSelector("[href='/notification_message']"));
        clickHereRef.click();

        WebElement confirmationMessageElement = driver.findElement(By.xpath("//div//div[@id='flash']"));
        String confirmationMessage = confirmationMessageElement.getText();
        Assert.assertEquals(confirmationMessage, "Action successful\n×");

        driver.quit();
    }
}
