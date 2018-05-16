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
    @DataProvider
    public Object[][] ValidDataProvider() {
        return new Object[][]{
                { "gor1362@gmail.com", "p0o9P)O("},
                { "GOR1362@gmail.com", "p0o9P)O(" }
        };
    }

    @Test (dataProvider = "ValidDataProvider")
    public void successfullogintest(String userEmail, String userPassword){


        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage (webDriver);
        Assert.assertEquals(linkedinLoginPage.getCurrentPageTitle(),
                "LinkedIn: Log In or Sign Up", "Login Page Title is wrong");
        linkedinLoginPage.login(userEmail, userPassword );
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
    public void successfullCaseInsensitiveLogin() {

        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage (webDriver);
        Assert.assertEquals(linkedinLoginPage.getCurrentPageTitle(),
                "LinkedIn: Log In or Sign Up", "Login Page Title is wrong");
        linkedinLoginPage.login("GOR1362@gmail.com","p0o9P)O(" );
        LinkedInHomePage linkedInHomePage = new LinkedInHomePage(webDriver);

        Assert.assertTrue(linkedInHomePage.isProfileMenuDisplayed(), "Profile menu is not displayed" );
    }

    @Test
    public void negativeBlankPassword() {

        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        linkedinLoginPage.login("gor1362@gmail.com", "");
        Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(), "Sign In button is missing");
    }

    @Test
    public void negativeBlankUsername() {

            LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
            linkedinLoginPage.login("", "p0o9P)O(");
            Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(), "Sign In button is missing");
        }

    @Test
    public void negativeInvalidPasswordUpperCase() {

        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage (webDriver);
        Assert.assertEquals(linkedinLoginPage.getCurrentPageTitle(),
                "LinkedIn: Log In or Sign Up", "Login Page Title is wrong");
        linkedinLoginPage.login("gor1362@gmail.com","P0o9P)O(" );
        LinkedinLoginSubmit linkedinLoginSubmit = new LinkedinLoginSubmit (webDriver);
        Assert.assertEquals(linkedinLoginSubmit.getErrorMessageText(), "There were one or more errors in your submission. Please correct the marked fields below.");
    }

    @Test
    public void negativeInvalidUsername() {

        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage (webDriver);
        Assert.assertEquals(linkedinLoginPage.getCurrentPageTitle(),
                "LinkedIn: Log In or Sign Up", "Login Page Title is wrong");
        linkedinLoginPage.login("goooor1362@gmail.com","p0o9P)O(" );

        LinkedinLoginSubmit linkedinLoginSubmit = new LinkedinLoginSubmit (webDriver);

        Assert.assertEquals(linkedinLoginSubmit.getErrorMessageText(), "There were one or more errors in your submission. Please correct the marked fields below.");
    }

    @Test
    public void negativeSpaceBeforePassword() {

        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage (webDriver);
        Assert.assertEquals(linkedinLoginPage.getCurrentPageTitle(),
                "LinkedIn: Log In or Sign Up", "Login Page Title is wrong");
        linkedinLoginPage.login("gor1362@gmail.com"," p0o9P)O(" );
        LinkedInHomePage linkedInHomePage = new LinkedInHomePage(webDriver);

        Assert.assertTrue(linkedInHomePage.isProfileMenuDisplayed(), "Profile menu is not displayed" );
    }

    @Test
    public void negativeSpaceBeforeUsername() {

        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage (webDriver);
        Assert.assertEquals(linkedinLoginPage.getCurrentPageTitle(),
                "LinkedIn: Log In or Sign Up", "Login Page Title is wrong");
        linkedinLoginPage.login(" gor1362@gmail.com","p0o9P)O(" );
        LinkedInHomePage linkedInHomePage = new LinkedInHomePage(webDriver);

        Assert.assertTrue(linkedInHomePage.isProfileMenuDisplayed(), "Profile menu is not displayed" );
    }
    @Test
    public void negativeSpaceAfterPassword() {

        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage (webDriver);
        Assert.assertEquals(linkedinLoginPage.getCurrentPageTitle(),
                "LinkedIn: Log In or Sign Up", "Login Page Title is wrong");
        linkedinLoginPage.login("gor1362@gmail.com","p0o9P)O( " );
        LinkedInHomePage linkedInHomePage = new LinkedInHomePage(webDriver);

        Assert.assertTrue(linkedInHomePage.isProfileMenuDisplayed(), "Profile menu is not displayed" );
    }

    @Test
    public void negativeSpaceAfterUsername() {

        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage (webDriver);
        Assert.assertEquals(linkedinLoginPage.getCurrentPageTitle(),
                "LinkedIn: Log In or Sign Up", "Login Page Title is wrong");
        linkedinLoginPage.login("gor1362@gmail.com ","p0o9P)O(" );
        LinkedInHomePage linkedInHomePage = new LinkedInHomePage(webDriver);

        Assert.assertTrue(linkedInHomePage.isProfileMenuDisplayed(), "Profile menu is not displayed" );
    }

}

