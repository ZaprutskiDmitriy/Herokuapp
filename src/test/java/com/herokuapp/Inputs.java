package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Inputs {

    public void inputs() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");

        System.setProperty("webdriver.chrome.driver", "D:/TeachMeSkills/WebDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("http://the-internet.herokuapp.com/inputs");
        Thread.sleep(2000);

        WebElement numberInput = driver.findElement(By.tagName("input"));
        numberInput.sendKeys("123");

        WebElement elementB = driver.findElement(By.id("page-footer"));
        elementB.click();


/*
        String actualInput = numberInput.getText();
        Assert.assertEquals(actualInput, "123");
*/

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
