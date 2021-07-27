package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Dropdown {
    @Test
    public void dropdown() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");

        System.setProperty("webdriver.chrome.driver", "D:/TeachMeSkills/WebDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("http://the-internet.herokuapp.com/dropdown");
        Thread.sleep(2000);

        WebElement clickDropdown = driver.findElement(By.id("dropdown"));
        clickDropdown.click();
        Thread.sleep(2000);

        WebElement option1 = driver.findElement(By.cssSelector("[value='1']"));
        option1.click();
        Thread.sleep(2000);
        Assert.assertTrue(option1.isSelected());

        clickDropdown.click();
        Thread.sleep(2000);

        WebElement option2 = driver.findElement(By.cssSelector("[value='2']"));
        option2.click();
        Thread.sleep(2000);
        Assert.assertTrue(option2.isSelected());

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
