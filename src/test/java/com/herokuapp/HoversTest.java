package com.herokuapp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HoversTest {
    @Test
    public void hovers() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(chromeOptions);
            driver.get("http://the-internet.herokuapp.com/hovers");

            WebElement user1 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/img"));

            Actions actions = new Actions(driver);

            actions.moveToElement(user1).build().perform();
            WebElement name1 = driver.findElement(By.xpath("//h5"));
            String name1Text = name1.getText();
            Assert.assertEquals(name1Text,"name: user1");
            WebElement user1Ref = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/a"));
            actions.moveToElement(user1Ref).click(user1Ref).build().perform();
            String errorMessage = driver.findElement(By.cssSelector("h1")).getText();
            Assert.assertEquals(errorMessage, "");

            driver.quit();
    }
}
