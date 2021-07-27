package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Typos {
    @Test
    public void typos() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");

        System.setProperty("webdriver.chrome.driver", "D:/TeachMeSkills/WebDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("http://the-internet.herokuapp.com/typos");
        Thread.sleep(2000);

        WebElement string1 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/p[1]/text()"));
        String string1Text = string1.getText();
        Assert.assertEquals(string1Text, "This example demonstrates a typo being introduced. It does it randomly on each page load.");

        WebElement string2 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/p[2]"));
        String string2Text = string2.getText();
        Assert.assertEquals(string2Text, "Sometimes you'll see a typo, other times you won't.");

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
