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
    public void dropdown() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");

        System.setProperty("webdriver.chrome.driver", "D:/TeachMeSkills/WebDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("http://the-internet.herokuapp.com/dropdown");

        WebElement clickDropdown = driver.findElement(By.id("dropdown"));
        clickDropdown.click();

        WebElement option1 = driver.findElement(By.cssSelector("[value='1']"));
        option1.click();

        Assert.assertTrue(option1.isSelected());

        clickDropdown.click();

        WebElement option2 = driver.findElement(By.cssSelector("[value='2']"));
        option2.click();

        Assert.assertTrue(option2.isSelected());

        driver.quit();
    }
}
