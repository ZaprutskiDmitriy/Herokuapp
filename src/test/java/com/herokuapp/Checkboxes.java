package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Checkboxes {
    @Test
    public void checkboxes() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");

        System.setProperty("webdriver.chrome.driver", "D:/TeachMeSkills/WebDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        Thread.sleep(2000);

        WebElement checkbox1 = driver.findElement(By.cssSelector("[type=checkbox]"));
        checkbox1.click();
        Thread.sleep(2000);
        Assert.assertTrue(checkbox1.isSelected());

        WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
        Assert.assertTrue(checkbox2.isSelected());
        checkbox2.click();
        Thread.sleep(2000);
        Assert.assertFalse(checkbox2.isSelected());

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
