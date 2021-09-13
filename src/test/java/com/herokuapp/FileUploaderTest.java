package com.herokuapp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class FileUploaderTest {
    @Test
    public void fileUploader() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(chromeOptions);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.get("http://the-internet.herokuapp.com/upload");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement inputFile = driver.findElement(By.cssSelector("#file-upload"));
        inputFile.sendKeys("D:/TeachMeSkills/herokuapp/src/test/java/com/herokuapp/file1.txt");

        WebElement buttonUpload = driver.findElement(By.cssSelector("#file-submit"));
        buttonUpload.click();

        String uploadedFileTitle = driver.findElement(By.cssSelector("#uploaded-files")).getText();
        Assert.assertEquals(uploadedFileTitle, "file1.txt");

        driver.quit();
    }
}
