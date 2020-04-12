import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;


public class Sample2 extends Assert {
    WebDriver driver = new ChromeDriver();
    String baseUrl = "http://demo.guru99.com/test/login.html";

    @BeforeTest
        public void launchBrowser() {

        driver.get(baseUrl);
    }


    @Test
            public void sendLogin() {
        // Get the WebElement corresponding to the Email Address(TextField)
        Assert.assertTrue(driver.findElement(By.id("email")).isDisplayed());
        WebElement email = driver.findElement(By.id("email"));

        // Get the WebElement corresponding to the Password Field
        Assert.assertTrue(driver.findElement(By.name("passwd")).isDisplayed());
        WebElement password = driver.findElement(By.name("passwd"));

        email.sendKeys("abcd@gmail.com");
        password.sendKeys("abcdefghlkjl");
        System.out.println("Text Field Set");

        // Deleting values in the text box
        email.clear();
        password.clear();
        System.out.println("Text Field Cleared");

        // Find the submit button
        Assert.assertTrue(driver.findElement(By.id("SubmitLogin")).isDisplayed());
        WebElement login = driver.findElement(By.id("SubmitLogin"));

        // Using click method to submit form
        email.sendKeys("abcd@gmail.com");
        password.sendKeys("abcdefghlkjl");
        login.click();
        System.out.println("Login Done with Click");

        //using submit method to submit the form. Submit used on password field
        driver.get(baseUrl);
        Assert.assertTrue(driver.findElement(By.id("email")).isDisplayed());
        driver.findElement(By.id("email")).sendKeys("abcd@gmail.com");
        Assert.assertTrue(driver.findElement(By.name("passwd")).isDisplayed());
        driver.findElement(By.name("passwd")).sendKeys("abcdefghlkjl");
        Assert.assertTrue(driver.findElement(By.id("SubmitLogin")).isDisplayed());
        driver.findElement(By.id("SubmitLogin")).submit();
        System.out.println("Login Done with Submit");
    }


    @AfterTest
            public void closeDriver() {
        driver.close();
    }
}