import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import static java.lang.Thread.sleep;


public class LinkedinLoginTest {

    WebDriver webDriver;

    @BeforeMethod
    public void before(){
        webDriver = new FirefoxDriver();
        webDriver.get("https://www.linkedin.com");

    }

    @AfterMethod
    public void after () {
        webDriver.close();

    }
    @Test
    public void successfulogintest(){

        Assert.assertEquals(webDriver.getTitle(),
                "LinkedIn: Log In or Sign Up", "Wrong Result");

        WebElement userEmailField = webDriver.findElement(By.xpath("//input[@id='login-email']"));
        userEmailField.sendKeys("gor1362@gmail.com" );

        WebElement userPasswordField = webDriver.findElement(By.xpath("//input[@id='login-password']"));
        userPasswordField.sendKeys("p0o9P)O(" );

        WebElement signInButton = webDriver.findElement(By.xpath("//input[@id='login-submit']"));
        signInButton.click();

        Assert.assertEquals(webDriver.getTitle(),
                "LinkedIn", "Wrong Result");
    }
    @Test
    public void negativeLoginTest () throws InterruptedException {
        WebElement signInButton = webDriver.findElement(By.xpath("//input[@id='login-submit']"));

        Assert.assertTrue(signInButton.isDisplayed(), "Sign In button is missing");

        WebElement userEmailField = webDriver.findElement(By.xpath("//input[@id='login-email']"));
        userEmailField.sendKeys("" );
        WebElement userPasswordField = webDriver.findElement(By.xpath("//input[@id='login-password']"));
        userPasswordField.sendKeys("" );
        signInButton.click();
        sleep (3000);
        Assert.assertTrue(signInButton.isDisplayed(), "Sign In button is missing");
    }

}
