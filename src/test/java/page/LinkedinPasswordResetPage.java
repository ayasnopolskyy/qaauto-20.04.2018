package page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



/**
 * Page Object for LinkedinPasswordResetPage
 */
public class LinkedinPasswordResetPage extends LinkedInBasePage {

    @FindBy(xpath = "//input[@id='username']")
    private WebElement userEmailField;
    @FindBy(xpath = "//button[@id='reset-password-submit-button']")
    private WebElement submitButton;


    /**
     * constructor for LinkedinPasswordResetPage
     * @param webDriver - current webDriver object
     * variables are initialized, but assigns values at the time of the call
     */
    public LinkedinPasswordResetPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    /**
     * checks tat page is loaded by searching user email field webelement
     */
    @Override
    public boolean isPageLoaded() {
        waitUntilElementIsClickable(userEmailField, 180);
        return userEmailField.isDisplayed();
    }


    /**
     * method sends email to according field and clicks submit button
     */
    public LinkedinPasswordResetSubmitPage submitEmail (String userEmail) {
        gMailService.connect();
        userEmailField.sendKeys(userEmail);
        submitButton.click();
        return new LinkedinPasswordResetSubmitPage(webDriver);
    }


}
