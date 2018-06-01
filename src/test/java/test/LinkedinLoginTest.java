package test;

import org.testng.Assert;
import org.testng.annotations.*;
import page.LinkedInHomePage;
import page.LinkedinLoginSubmitPage;


/**
 * class with 3 login tests
 */
public class LinkedinLoginTest extends LinkedinBaseTest {


    /**
     * data provider with valid data
     */
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
    /**
     * data provider with invalid data
     */
    @DataProvider
    public Object[][] InvalidDataProvider() {
        return new Object[][]{
              /*  { "goooor1362@gmail.com", "p0o9P)O("},
                { "GOR1362@gmail.com", "q0o9P)O(" },
                { "GOR1362@gmail.com", "P0o9P)O(" },*/
                { "p0o9P)O(", "gor1362@gmail.com" }
        };
    }
    /**
     * data provider with not full creds data
     */
    @DataProvider
    public Object[][] BlankDataProvider() {
        return new Object[][]{
                { "", ""},
                { "gor1362@gmail.com", "" },
                { "", "p0o9P)O("}
        };
    }

    /**
     * method that checks successful login flow, uses login, isPageLoaded, getCurrentPageTitle methods
     * redirects to LinkedInHomePage
     */
    @Test (dataProvider = "ValidDataProvider")
    public void successfulLoginTest(String userEmail, String userPassword){


        Assert.assertTrue(linkedinLoginPage.isPageLoaded(), "Login page is not loaded");
        LinkedInHomePage linkedInHomePage = linkedinLoginPage.login(userEmail, userPassword);

        Assert.assertTrue(linkedInHomePage.isPageLoaded(), "Home page is not loaded" );

        Assert.assertEquals(linkedInHomePage.getCurrentPageTitle(), "LinkedIn","Home Page Title is wrong");
    }


    /**
     * method that checks negative login flow, uses loginWithInvalidData, isPageLoaded, getCurrentPageTitle methods
     *redirects to LinkedinLogonSubmit page
     */
    @Test (dataProvider = "InvalidDataProvider")
    public void negativeInvalidCredentials(String userEmail, String userPasswords) {

        Assert.assertTrue(linkedinLoginPage.isPageLoaded(),
                "LinkedIn: Log In or Sign Up");
        LinkedinLoginSubmitPage linkedinLoginSubmit = linkedinLoginPage.loginWithInvalidData(userEmail, userPasswords );

                Assert.assertEquals(linkedinLoginSubmit.getErrorMessageText(),
                "There were one or more errors in your submission. Please correct the marked fields below.");
    }

    /**
     * method that checks  login flow with not full creds, uses loginWithInvalidData, isPageLoaded, getCurrentPageTitle methods
     * not redirects to another page
     */
    @Test (dataProvider = "BlankDataProvider")
    public void negativeBlankFieldLoginTest (String userEmail, String userPassword){

        linkedinLoginPage.login(userEmail, userPassword );
        Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(), "Sign In button is missing");
    }
}

