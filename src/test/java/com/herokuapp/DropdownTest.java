package com.herokuapp;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropdownTest {

    @Link("allure-results")
    @Issue("JIRA-1")
    @TmsLink("TMS-1")
    @Test(description = "Take all the elements of the drop-down and check for their presence.")
    public void dropdownTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/dropdown");
        WebElement clickDropdown = driver.findElement(By.id("dropdown"));
        WebElement option1 = driver.findElement(By.cssSelector("[value='1']"));
        WebElement option2 = driver.findElement(By.cssSelector("[value='2']"));

        dropdownOption1(clickDropdown, option1);
        dropdownOption2(clickDropdown, option2);
        takeScreenshot(driver);

        driver.quit();
    }

    @Step("check option 1")
    public void dropdownOption1(WebElement clickDropdown, WebElement option1) {
        clickDropdown.click();
        option1.click();
        Assert.assertTrue(option1.isSelected());
    }

    @Step("check option 2")
    public void dropdownOption2(WebElement clickDropdown, WebElement option2) {
        clickDropdown.click();
        option2.click();
        Assert.assertTrue(option2.isSelected());
    }

    @Attachment(value = "screenshot", type = "image/png")
    public byte[] takeScreenshot(WebDriver driver){
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }
}
