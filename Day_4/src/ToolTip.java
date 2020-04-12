package ru.technoserv.atmaven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ToolTip {
    String baseUrl = "http://demo.guru99.com/test/social-icon.html";
    WebDriver driver = new ChromeDriver();

    @BeforeTest
            public void openSite() {driver.get(baseUrl);}

    @Test
            public void toolTip() {
        String expectedTooltip = "Github";
        // Find the Github icon at the top right of the header
        WebElement github = driver.findElement(By.xpath(".//*[@class='soc-ico show-round']/a[4]"));
        //get the value of the "title" attribute of the github icon
        String actualTooltip = github.getAttribute("title");
        //Assert the tooltip's value is as expected
        Assert.assertEquals(actualTooltip, expectedTooltip);
    }

    @AfterTest
            public void closeSite() {driver.quit();}

}