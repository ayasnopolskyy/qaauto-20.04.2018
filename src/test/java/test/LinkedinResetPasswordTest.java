package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.*;


/**
 * Class with reset password flow
 *
 */
public class LinkedinResetPasswordTest extends LinkedinBaseTest {


    /**
     * reset password method
     * redirecting between reset password flow pages
     *  uses clickOnForgotPasswordLink, submitEmail, isPageLoaded, tapGoToHomeButton methods
     */
    @Test
    public void resetPassword()
    {

        Assert.assertTrue(linkedinLoginPage.isPageLoaded(), "Login page is not loaded");
        LinkedinPasswordResetPage linkedinPasswordResetPage = linkedinLoginPage.clickOnForgotPasswordLink();
        Assert.assertTrue(linkedinPasswordResetPage.isPageLoaded(), "Request Password Page is not loaded");

        LinkedinPasswordResetSubmitPage linkedinPasswordResetSubmitPage = linkedinPasswordResetPage.submitEmail("gor1362@gmail.com");
        Assert.assertTrue(linkedinPasswordResetSubmitPage.isPageLoaded(), "Request Password Page is not loaded");

        LinkedinNewPasswordRequestPage linkedinNewPasswordRequestPage = linkedinPasswordResetSubmitPage.navigateToLinkFromEmail();
        Assert.assertTrue(linkedinNewPasswordRequestPage.isPageLoaded(), "New Password Request Page is not loaded" );
        LinkedinPasswordChangedPage linkedinPasswordChangedPage = linkedinNewPasswordRequestPage.createNewPassword("p0o9P)O(");

        Assert.assertTrue(linkedinNewPasswordRequestPage.isPageLoaded(), "Password Page is not loaded" );
        linkedinPasswordChangedPage.tapGoToHomeButton();
        Assert.assertTrue(linkedinPasswordResetPage.isPageLoaded(), "Request Password Page is not loaded");


    }




}
