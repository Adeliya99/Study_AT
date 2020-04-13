import org.testng.annotations.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTest{
    @Test
    public void testTitle(){
        open("http://demo.guru99.com/test/newtours/");
        $(By.xpath("//*[@id=\"site-name\"]/a")).shouldHave(text("Demo Site"));
        System.out.println("test passed");
    }
}
