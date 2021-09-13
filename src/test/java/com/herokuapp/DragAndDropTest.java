package com.herokuapp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragAndDropTest {

    @Test
    public void dragAndDrop1() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://crossbrowsertesting.github.io/drag-and-drop.html");
        Thread.sleep(2000);

        WebElement elementA = driver.findElement(By.id("droppable"));
        WebElement elementB = driver.findElement(By.id("draggable"));

        Actions actions = new Actions(driver);

        actions.moveToElement(elementB).pause(200).clickAndHold().pause(200).moveToElement(elementA).pause(200).release().build().perform();

        driver.quit();
    }

    @Test
    public void dragAndDrop2() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");

        System.setProperty("webdriver.chrome.driver", "D:/TeachMeSkills/WebDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("http://the-internet.herokuapp.com/drag_and_drop");
        Thread.sleep(10000);

        WebElement elementA = driver.findElement(By.id("column-a"));
        WebElement elementB = driver.findElement(By.id("column-b"));

        Actions actions = new Actions(driver);

        actions.moveToElement(elementA).clickAndHold().moveToElement(elementB).release().build().perform();

        driver.quit();

    }
}

