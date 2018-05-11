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


        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage (webDriver);
        Assert.assertEquals(linkedinLoginPage.getCurrentPageTitle(),
                "LinkedIn: Log In or Sign Up", "Login Page Title is wrong");
        linkedinLoginPage.login("gor1362@gmail.com","p0o9P)O(" );
        LinkedInHomePage linkedInHomePage = new LinkedInHomePage(webDriver);

        Assert.assertTrue(linkedInHomePage.isProfileMenuDisplayed(), "Profile menu is not displayed" );

    }
    @Test
    public void negativeLoginTest (){
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage (webDriver);
        linkedinLoginPage.login("","" );
        Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(), "Sign In button is missing");
    }

    @Test
    public void successfulCaseInsensitiveLogin() {

        Assert.assertEquals(webDriver.getTitle(),
                "LinkedIn: Log In or Sign Up", "Wrong Result");

        WebElement userEmailField = webDriver.findElement(By.xpath("//input[@id='login-email']"));
        userEmailField.sendKeys("GOR1362@Gmail.com");

        WebElement userPasswordField = webDriver.findElement(By.xpath("//input[@id='login-password']"));
        userPasswordField.sendKeys("p0o9P)O(");

        WebElement signInButton = webDriver.findElement(By.xpath("//input[@id='login-submit']"));
        signInButton.click();

        Assert.assertEquals(webDriver.getTitle(),
                "LinkedIn", "8");
    }

    @Test
    public void negativeBlankPassword() {

        Assert.assertEquals(webDriver.getTitle(),
                "LinkedIn: Log In or Sign Up", "Wrong Result");

        WebElement userEmailField = webDriver.findElement(By.xpath("//input[@id='login-email']"));
        userEmailField.sendKeys("gor1362@gmail.com");

        WebElement userPasswordField = webDriver.findElement(By.xpath("//input[@id='login-password']"));
        userPasswordField.sendKeys("");

        WebElement signInButton = webDriver.findElement(By.xpath("//input[@id='login-submit']"));
        signInButton.click();


        Assert.assertTrue(signInButton.isDisplayed(), "Sign In button is missing");
    }

    @Test
    public void negativeBlankUsername() {

        Assert.assertEquals(webDriver.getTitle(),
                "LinkedIn: Log In or Sign Up", "Wrong Result");

        WebElement userEmailField = webDriver.findElement(By.xpath("//input[@id='login-email']"));
        userEmailField.sendKeys("");

        WebElement userPasswordField = webDriver.findElement(By.xpath("//input[@id='login-password']"));
        userPasswordField.sendKeys("p0o9P)O(");

        WebElement signInButton = webDriver.findElement(By.xpath("//input[@id='login-submit']"));
        signInButton.click();


        Assert.assertTrue(signInButton.isDisplayed(), "Sign In button is missing");
    }

    @Test
    public void negativeInvalidPasswordUpperCase() {

        Assert.assertEquals(webDriver.getTitle(),
                "LinkedIn: Log In or Sign Up", "Wrong Result");

        WebElement userEmailField = webDriver.findElement(By.xpath("//input[@id='login-email']"));
        userEmailField.sendKeys("gor1362@gmail.com");

        WebElement userPasswordField = webDriver.findElement(By.xpath("//input[@id='login-password']"));
        userPasswordField.sendKeys("P0o9P)O(");

        WebElement signInButton = webDriver.findElement(By.xpath("//input[@id='login-submit']"));
        signInButton.click();


        Assert.assertTrue(signInButton.isDisplayed(), "There were one or more errors in your submission. Please correct the marked fields below.");
    }

    @Test
    public void negativeInvalidUsername() {

        Assert.assertEquals(webDriver.getTitle(),
                "LinkedIn: Log In or Sign Up", "Wrong Result");

        WebElement userEmailField = webDriver.findElement(By.xpath("//input[@id='login-email']"));
        userEmailField.sendKeys("goooor1362@gmail.com");

        WebElement userPasswordField = webDriver.findElement(By.xpath("//input[@id='login-password']"));
        userPasswordField.sendKeys("p0o9P)O(");

        WebElement signInButton = webDriver.findElement(By.xpath("//input[@id='login-submit']"));
        signInButton.click();

        Assert.assertTrue(signInButton.isDisplayed(), "There were one or more errors in your submission. Please correct the marked fields below.");
    }
    @Test
    public void negativeSpaceBeforePassword() {

        Assert.assertEquals(webDriver.getTitle(),
                "LinkedIn: Log In or Sign Up", "Wrong Result");

        WebElement userEmailField = webDriver.findElement(By.xpath("//input[@id='login-email']"));
        userEmailField.sendKeys("gor1362@gmail.com");

        WebElement userPasswordField = webDriver.findElement(By.xpath("//input[@id='login-password']"));
        userPasswordField.sendKeys(" p0o9P)O(");

        WebElement signInButton = webDriver.findElement(By.xpath("//input[@id='login-submit']"));
        signInButton.click();

        Assert.assertEquals(webDriver.getTitle(),
                "LinkedIn", "Wrong Result");
    }

    @Test
    public void negativeSpaceBeforeUsername() {

        Assert.assertEquals(webDriver.getTitle(),
                "LinkedIn: Log In or Sign Up", "Wrong Result");

        WebElement userEmailField = webDriver.findElement(By.xpath("//input[@id='login-email']"));
        userEmailField.sendKeys(" gor1362@gmail.com");

        WebElement userPasswordField = webDriver.findElement(By.xpath("//input[@id='login-password']"));
        userPasswordField.sendKeys("p0o9P)O(");

        WebElement signInButton = webDriver.findElement(By.xpath("//input[@id='login-submit']"));
        signInButton.click();

        Assert.assertEquals(webDriver.getTitle(),
                "LinkedIn", "Wrong Result");
    }
    @Test
    public void negativeSpaceAfterPassword() {

        Assert.assertEquals(webDriver.getTitle(),
                "LinkedIn: Log In or Sign Up", "Wrong Result");

        WebElement userEmailField = webDriver.findElement(By.xpath("//input[@id='login-email']"));
        userEmailField.sendKeys("gor1362@gmail.com");

        WebElement userPasswordField = webDriver.findElement(By.xpath("//input[@id='login-password']"));
        userPasswordField.sendKeys(" p0o9P)O( ");

        WebElement signInButton = webDriver.findElement(By.xpath("//input[@id='login-submit']"));
        signInButton.click();

        Assert.assertEquals(webDriver.getTitle(),
                "LinkedIn", "Wrong Result");
    }

    @Test
    public void negativeSpaceAfterUsername() {

        Assert.assertEquals(webDriver.getTitle(),
                "LinkedIn: Log In or Sign Up", "Wrong Result");

        WebElement userEmailField = webDriver.findElement(By.xpath("//input[@id='login-email']"));
        userEmailField.sendKeys("gor1362@gmail.com ");

        WebElement userPasswordField = webDriver.findElement(By.xpath("//input[@id='login-password']"));
        userPasswordField.sendKeys("p0o9P)O(");

        WebElement signInButton = webDriver.findElement(By.xpath("//input[@id='login-submit']"));
        signInButton.click();

        Assert.assertEquals(webDriver.getTitle(),
                "LinkedIn", "Wrong Result");
    }

}

