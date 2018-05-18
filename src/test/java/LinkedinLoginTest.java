import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LinkedinLoginTest  {

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
              /*  { "gor1362@gmail.com", "p0o9P)O("},
                { "GOR1362@gmail.com", "p0o9P)O(" },
                { " gor1362@gmail.com", "p0o9P)O("},
                { "gor1362@gmail.com ", "p0o9P)O(" },
                { "gor1362@gmail.com", " p0o9P)O("},*/
                { "gor1362@gmail.com", "p0o9P)O( " }
        };
    }

    @DataProvider
    public Object[][] InvalidDataProvider() {
        return new Object[][]{
                { "goooor1362@gmail.com", "p0o9P)O("},
                { "GOR1362@gmail.com", "q0o9P)O(" },
                { "GOR1362@gmail.com", "P0o9P)O(" },
                { "p0o9P)O(", "gor1362@gmail.com" }
        };
    }

    @DataProvider
    public Object[][] BlankDataProvider() {
        return new Object[][]{
                { "", ""},
                { "gor1362@gmail.com", "" },
                { "", "p0o9P)O("}
        };
    }

    @Test (dataProvider = "ValidDataProvider")
    public void successfulLoginTest(String userEmail, String userPassword){

        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage (webDriver);
        Assert.assertTrue(linkedinLoginPage.isPageLoaded(), "Login page is not loaded");
        linkedinLoginPage.login(userEmail, userPassword);

        LinkedInHomePage linkedInHomePage = new LinkedInHomePage(webDriver);
        Assert.assertTrue(linkedInHomePage.isPageLoaded(), "Home page is not loaded" );

        Assert.assertEquals(linkedInHomePage.getCurrentPageTitle(), "LinkedIn","Home Page Title is wrong");
    }

    @Test (dataProvider = "InvalidDataProvider")
    public void negativeInvalidCredentials(String userEmail, String userPasswords) {

        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage (webDriver);
        Assert.assertEquals(linkedinLoginPage.isPageLoaded(),
                "LinkedIn: Log In or Sign Up", "Login Page Title is wrong");
        linkedinLoginPage.login(userEmail, userPasswords );

        LinkedinLoginSubmit linkedinLoginSubmit = new LinkedinLoginSubmit (webDriver);
        Assert.assertEquals(linkedinLoginSubmit.getErrorMessageText(),
                "There were one or more errors in your submission. Please correct the marked fields below.");
    }

    @Test (dataProvider = "BlankDataProvider")
    public void negativeBlankFieldLoginTest (String userEmail, String userPassword){

        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage (webDriver);
        linkedinLoginPage.login(userEmail, userPassword );
        Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(), "Sign In button is missing");
    }
}

