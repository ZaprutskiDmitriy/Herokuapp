package com.herokuapp;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class FileDownloaderTest {
    @Test
    public void fileUploader() {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("http://the-internet.herokuapp.com/download");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement file = driver.findElement(By.cssSelector("a[href='download/euro.pdf']"));
        file.click();

        driver.quit();
    }
}
