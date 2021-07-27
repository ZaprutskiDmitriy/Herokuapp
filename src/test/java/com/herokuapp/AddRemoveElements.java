package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class AddRemoveElements {

    @Test
    public void addRemoveElements() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");

        System.setProperty("webdriver.chrome.driver", "D:/TeachMeSkills/WebDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        Thread.sleep(5000);

        WebElement addElementButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div/button"));
        addElementButton.click();
        addElementButton.click();
        WebElement deleteElementButton = driver.findElement(By.xpath("//*[@id=\"elements\"]/button"));
        deleteElementButton.click();

        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        finally {
            driver.quit();
        }
    }
}
