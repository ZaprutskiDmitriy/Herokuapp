package com.herokuapp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddRemoveElements {

    @Test
    public void addRemoveElements() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

        WebElement addElementButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div/button"));
        addElementButton.click();
        addElementButton.click();
        WebElement deleteElementButton = driver.findElement(By.xpath("//*[@id=\"elements\"]/button"));
        deleteElementButton.click();
        WebElement countObjects = driver.findElement(By.id("elements"));
        String countObjectsText = countObjects.getText();
        Assert.assertEquals(countObjectsText, "Delete");

        driver.quit();
    }
}
