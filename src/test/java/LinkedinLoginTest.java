import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class LinkedinLoginTest {

    @Test
    public void successfullogintest(){
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://www.linkedin.com");

        Assert.assertEquals(webDriver.getTitle(),
                "LinkedIn: Log In or Sign Up", "Wrong Result");

        WebElement userEmailField = webDriver.findElement(By.xpath("//input[@id='login-email']"));
        userEmailField.sendKeys("" );

        WebElement userPasswordField = webDriver.findElement(By.xpath("//input[@id='login-password']"));
        userPasswordField.sendKeys("" );

        WebElement signInButton = webDriver.findElement(By.xpath("//input[@id='login-submit']"));
        signInButton.sendKeys(Keys.RETURN);
    }
}
