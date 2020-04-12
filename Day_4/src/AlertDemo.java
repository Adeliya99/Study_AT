package ru.technoserv.atmaven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AlertDemo {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 20);

        @BeforeTest
                public void openSite() {
                // Alert Message handling
                driver.get("http://demo.guru99.com/test/delete_customer.php");
        }

        @Test
                public void AlertMessage() {
                driver.findElement(By.name("cusid")).sendKeys("53920");
                driver.findElement(By.name("submit")).click();

                wait.until(ExpectedConditions.alertIsPresent());
                // Switching to Alert
                Alert alert = driver.switchTo().alert();
                // Capturing alert message.
                String alertMessage = alert.getText();
                // Accepting alert
                alert.accept();
                Assert.assertEquals(alertMessage, "Do you really want to delete this Customer?");
        }

        @Test
                public void AlertMessage2() {
                wait.until(ExpectedConditions.alertIsPresent());
                // Switching to Alert
                Alert alert2 = driver.switchTo().alert();
                // Capturing alert message.
                String alertMessage2 = driver.switchTo().alert().getText();
                Assert.assertEquals(alertMessage2, "Customer Successfully Delete!");
        }

        @AfterTest
                public void closeSite() {driver.quit();}
}