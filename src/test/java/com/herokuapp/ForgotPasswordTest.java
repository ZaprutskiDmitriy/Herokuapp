package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ForgotPasswordTest {

    private WebDriver driver;

/*
    @BeforeClass
    public static void setupClass(){
    }
*/

    @Test
    public void retrievePassword(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("div")));

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");

        System.setProperty("webdriver.chrome.driver", "D:/TeachMeSkills/WebDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver(chromeOptions);
//        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/forgot_password");

        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.clear();
        emailInput.sendKeys("test@test.com");
        emailInput.submit();

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

/*
    @AfterClass
    public void teardown(){
        if (driver != null){
            driver.quit();
        }
    }
*/
    @Test
    public void dragAndDrop() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");

        System.setProperty("webdriver.chrome.driver", "D:/TeachMeSkills/WebDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver(chromeOptions);
        try {
        driver.get("https://crossbrowsertesting.github.io/drag-and-drop.html");
        Thread.sleep(2000);

        WebElement elementA = driver.findElement(By.id("droppable"));
        WebElement elementB = driver.findElement(By.id("draggable"));

        Actions actions = new Actions(driver);

        actions.moveToElement(elementB).pause(200).clickAndHold().pause(200).moveToElement(elementA).pause(200).release().build().perform();

        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        finally {
            Thread.sleep(3000);
            driver.quit();
        }
    }


    @Test
    public void dragAndDrop2() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");

        System.setProperty("webdriver.chrome.driver", "D:/TeachMeSkills/WebDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver(chromeOptions);
        try {
            driver.get("http://the-internet.herokuapp.com/drag_and_drop");
            Thread.sleep(10000);

            WebElement elementA = driver.findElement(By.id("column-a"));
            WebElement elementB = driver.findElement(By.id("column-b"));

            Actions actions = new Actions(driver);

            actions.moveToElement(elementA).clickAndHold().moveToElement(elementB).release().build().perform();
//            actions.dragAndDrop(elementB, elementA);

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