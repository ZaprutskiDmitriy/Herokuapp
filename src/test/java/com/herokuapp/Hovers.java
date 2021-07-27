package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Hovers {
    @Test
    public void hovers() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");

        System.setProperty("webdriver.chrome.driver", "D:/TeachMeSkills/WebDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver(chromeOptions);
        try {
            driver.get("http://the-internet.herokuapp.com/hovers");
            Thread.sleep(2000);

            WebElement user1 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/img"));
            WebElement user2 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/img"));
            WebElement user3 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/img"));

            Actions actions = new Actions(driver);

            actions.moveToElement(user1).build().perform();
            WebElement name1 = driver.findElement(By.xpath("//h5"));
            String name1Text = name1.getText();
            Assert.assertEquals(name1Text,"name: user1");
            WebElement user1Ref = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/a"));
            actions.moveToElement(user1Ref).click(user1Ref).build().perform();
            Thread.sleep(2000);

            driver.get("http://the-internet.herokuapp.com/hovers");

            Thread.sleep(2000);

            actions.moveToElement(user2).build().perform();
            WebElement name2 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/h5"));
            String name2Text = name2.getText();
            Assert.assertEquals(name2Text,"name: user2");
            WebElement user2Ref = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/a"));
            actions.moveToElement(user2Ref).click(user2Ref).build().perform();
            Thread.sleep(2000);

            driver.get("http://the-internet.herokuapp.com/hovers");

            Thread.sleep(2000);

            actions.moveToElement(user3).build().perform();
            WebElement name3 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/div/h5"));
            String name3Text = name3.getText();
            Assert.assertEquals(name3Text,"name: user3");
            WebElement user3Ref = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/div/a"));
            actions.moveToElement(user3Ref).click(user3Ref).build().perform();
            Thread.sleep(2000);

        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        finally {
            Thread.sleep(3000);
            driver.quit();
        }
    }
}
