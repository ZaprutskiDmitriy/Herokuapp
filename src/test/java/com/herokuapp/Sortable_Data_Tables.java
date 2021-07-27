package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Sortable_Data_Tables {
    @Test
    public void sortableDataTables() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");

        System.setProperty("webdriver.chrome.driver", "D:/TeachMeSkills/WebDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("http://the-internet.herokuapp.com/tables");
        Thread.sleep(2000);

        WebElement cellFirst = driver.findElement(By.xpath("//table//tr[1]//td[1]"));
        String cellFirstContent = cellFirst.getText();
        Assert.assertEquals(cellFirstContent,"Smith");

        WebElement cellSecond = driver.findElement(By.xpath("//table//tr[2]//td[3]"));
        String cellSecondContent = cellSecond.getText();
        Assert.assertEquals(cellSecondContent,"fbach@yahoo.com");

        WebElement cellThird = driver.findElement(By.xpath("//table//tr[2]//td[2]"));
        String cellThirdContent = cellThird.getText();
        Assert.assertEquals(cellThirdContent,"Frank");


        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        finally {
            driver.quit();
        }
    }
}
