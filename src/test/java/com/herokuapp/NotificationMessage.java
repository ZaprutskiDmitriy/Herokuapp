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
    public void notificationMessage() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");

        System.setProperty("webdriver.chrome.driver", "D:/TeachMeSkills/WebDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("http://the-internet.herokuapp.com/notification_message_rendered");
        Thread.sleep(2000);

        WebElement clickHereRef = driver.findElement(By.cssSelector("[href='/notification_message']"));
        clickHereRef.click();
        Thread.sleep(2000);

        WebElement confirmationMessageElement = driver.findElement(By.id("flash"));
        String confirmationMessage = confirmationMessageElement.getText();
        Assert.assertEquals(confirmationMessage, " Action successful ");

        try {
            Thread.sleep(3000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        finally {
            driver.quit();
        }
    }
}
