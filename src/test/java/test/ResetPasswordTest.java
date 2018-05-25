package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.*;


public class ResetPasswordTest extends LinkedinBaseTest {


    @Test
    public void resetPassword()
    {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        Assert.assertTrue(linkedinLoginPage.isPageLoaded(), "Login page is not loaded");
        linkedinLoginPage.forget();
        LinkedinPasswordResetPage linkedinPasswordResetPage = new LinkedinPasswordResetPage(webDriver);
        Assert.assertTrue(linkedinPasswordResetPage.isPageLoaded(), "Request Password Page is not loaded");
        linkedinPasswordResetPage.submitEmail("gor1362@gmail.com");
        LinkedinPasswordResetSubmitPage linkedinPasswordResetSubmitPage = new LinkedinPasswordResetSubmitPage(webDriver);
        Assert.assertTrue(linkedinPasswordResetSubmitPage.isPageLoaded(), "Request Password Page is not loaded");

//get gmail link

        LinkedinNewPasswordRequestPage linkedinNewPasswordRequestPage = new LinkedinNewPasswordRequestPage(webDriver);
        Assert.assertTrue(linkedinNewPasswordRequestPage.isPageLoaded(), "New Password Request Page is not loaded" );
        linkedinNewPasswordRequestPage.createNewPassword("p0o9P)O(");

        LinkedinPasswordChangedPage linkedinPasswordChangedPage = new LinkedinPasswordChangedPage(webDriver);
        Assert.assertTrue(linkedinNewPasswordRequestPage.isPageLoaded(), "Password Page is not loaded" );
        linkedinPasswordChangedPage.tapGoToHomeButton();


    }




}
