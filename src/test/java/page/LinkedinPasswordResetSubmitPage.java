package page;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


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
        String message = gMailService.waitMessage(messageSubject, messageTo, messageFrom, 100);
        String resetPasswordLink = StringUtils.substringBetween(message, "To change your LinkedIn password, click <a href=\"", "\" style").replace("&amp;","&");
        System.out.println("Content: " + resetPasswordLink);
        webDriver.navigate().to(resetPasswordLink);
        return new LinkedinNewPasswordRequestPage(webDriver);
    }


    /**
     *  checks that page is loaded
     *  @return true or false
     */
    public boolean isPageLoaded() {
        waitUntilElementIsClickable(resendButton, 40);
        return resendButton.isDisplayed();

    }
}
