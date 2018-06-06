package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * PageObject for LinkedinNewPasswordRequestPage
 */
public class LinkedinNewPasswordRequestPage extends LinkedInBasePage {

    @FindBy(xpath = "//input[@id='newPassword']")
    private WebElement newPasswordField;
    @FindBy(xpath = "//input[@id='confirmPassword']")
    private WebElement confirmPassField;
    @FindBy(xpath = "//button[@id='reset-password-submit-button']")
    private WebElement submitButton;

    /**
     * constructor for LinkedinNewPasswordRequestPage
     * @param webDriver - current webDriver object
     * variables are initialized, but assigns values at the time of the call
     *
     */
    public LinkedinNewPasswordRequestPage (WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }


    /**
     * checks that page is loaded. returns true or false
     *
     * Oveerride is annotation for abstract method
      */

    @Override
    public boolean isPageLoaded() {
        waitUntilElementIsClickable(newPasswordField, 90);
        return newPasswordField.isDisplayed();
    }



    /**
     * sends password text to according fields and clicks submit button
     */
    public LinkedinPasswordChangedPage createNewPassword(String newPass) {
            newPasswordField.sendKeys(newPass);
            confirmPassField.sendKeys(newPass);
            submitButton.click();
            return new LinkedinPasswordChangedPage(webDriver);
    }

}
