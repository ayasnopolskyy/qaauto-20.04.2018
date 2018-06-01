package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.GMailService;

/**
 * Page object for LinkedinPasswordResetSubmitPage
 */
public class LinkedinPasswordResetSubmitPage extends LinkedInBasePage {



    @FindBy(xpath = "//button[@id='resend-url']")
    WebElement resendButton;

    /**
     * constructor for LinkedinNewPasswordRequestPage
     * @param webDriver - current webDriver object
     *
     *
     */
    public LinkedinPasswordResetSubmitPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
        }

    /**
     * method for reading last email from Linkedin
     * return LinkedinNewPasswordRequestPage after clicking the email link
     * variables are initialized, but assigns values at the time of the call
     */
    public LinkedinNewPasswordRequestPage navigateToLinkFromEmail (){
        String messageSubject = "here's the link to reset your password";
        String messageTo = "gor1362@gmail.com";
        String messageFrom = "security-noreply@linkedin.com";
        String message = gMailService.waitMessage(messageSubject, messageTo, messageFrom, 300);
        System.out.println("Content: " + message);


        return new LinkedinNewPasswordRequestPage(webDriver);
    }


    /**
     *  checks that page is loaded
     *  @return true or false
     */
    public boolean isPageLoaded() {
        waitUntilElementIsClickable(resendButton, 90);
        return resendButton.isDisplayed();

    }
}
