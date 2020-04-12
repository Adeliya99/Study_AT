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

public class Sample3 {

        String baseUrl = "http://demo.guru99.com/test/upload/";
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        @BeforeTest
                public void launchBrowser() {
            driver.get(baseUrl);
        }

        @Test
                public void sendFile() {
            Assert.assertTrue(driver.findElement(By.id("uploadfile_0")).isDisplayed(), "uploadElement is displayed");
            WebElement uploadElement = driver.findElement(By.id("uploadfile_0"));
            // enter the file path onto the file-selection input field
            uploadElement.sendKeys("C:\\Testtext.txt");


            // check the "I accept the terms of service" check box
            driver.findElement(By.id("terms")).click();

            WebElement resultElement = driver.findElement(By.cssSelector("#res"));
            WebElement resultText = driver.findElement(By.cssSelector("#res > center"));

            // click the "UploadFile" button
            driver.findElement(By.name("send")).click();
            wait.until(ExpectedConditions.attributeContains(resultElement, "style", "display: block"));
            Assert.assertTrue(resultText.getText().contains(" successfully"));
        }

        @AfterTest
                public void closeDriver() {
            driver.quit();
        }
}