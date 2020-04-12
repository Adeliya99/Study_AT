package ru.technoserv.atmaven;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ValidationDemo {
    String baseUrl = "http://demo.guru99.com/V1/index.php";
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, 20);

    @BeforeTest
            public void openSite() {driver.get(baseUrl);}

    @Test
            public void validation() {
        WebElement usernameControl = driver.findElement(By.name("uid"));
        WebElement passwordControl = driver.findElement(By.name("password"));
        WebElement misc = driver.findElement(By.cssSelector("body"));
        WebElement userValidationMessage = driver.findElement(By.id("message23"));
        WebElement passwordValidationMessage = driver.findElement(By.id("message18"));
        Assert.assertEquals(userValidationMessage.getAttribute("style"), "");
        Assert.assertEquals(passwordValidationMessage.getAttribute("style"), "");

        usernameControl.click();
        passwordControl.click();
        misc.click();
        Assert.assertEquals(userValidationMessage.getAttribute("style"), "visibility: visible;");
        Assert.assertEquals(passwordValidationMessage.getAttribute("style"), "visibility: visible;");

        usernameControl.sendKeys("a");
        passwordControl.sendKeys("a");
        Assert.assertEquals(userValidationMessage.getAttribute("style"), "visibility: hidden;");
        Assert.assertEquals(passwordValidationMessage.getAttribute("style"), "visibility: hidden;");
    }

    @AfterTest
            public void closeSite() {driver.quit();}
}
