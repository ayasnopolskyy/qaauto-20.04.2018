package test;

import org.testng.Assert;
import org.testng.annotations.*;
import page.LinkedInHomePage;
import page.LinkedinLoginSubmitPage;


public class LinkedinLoginTest extends LinkedinBaseTest {



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
              /*  { "goooor1362@gmail.com", "p0o9P)O("},
                { "GOR1362@gmail.com", "q0o9P)O(" },
                { "GOR1362@gmail.com", "P0o9P)O(" },*/
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


        Assert.assertTrue(linkedinLoginPage.isPageLoaded(), "Login page is not loaded");
        LinkedInHomePage linkedInHomePage = linkedinLoginPage.login(userEmail, userPassword);

        Assert.assertTrue(linkedInHomePage.isPageLoaded(), "Home page is not loaded" );

        Assert.assertEquals(linkedInHomePage.getCurrentPageTitle(), "LinkedIn","Home Page Title is wrong");
    }

    @Test (dataProvider = "InvalidDataProvider")
    public void negativeInvalidCredentials(String userEmail, String userPasswords) {

        Assert.assertTrue(linkedinLoginPage.isPageLoaded(),
                "LinkedIn: Log In or Sign Up");
        LinkedinLoginSubmitPage linkedinLoginSubmit = linkedinLoginPage.loginWithInvalidData(userEmail, userPasswords );

                Assert.assertEquals(linkedinLoginSubmit.getErrorMessageText(),
                "There were one or more errors in your submission. Please correct the marked fields below.");
    }

    @Test (dataProvider = "BlankDataProvider")
    public void negativeBlankFieldLoginTest (String userEmail, String userPassword){

        linkedinLoginPage.login(userEmail, userPassword );
        Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(), "Sign In button is missing");
    }
}

