package page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * PageObject for LinkedinLoginPage with methods and variables(WebElements)
 */

public class LinkedinLoginPage extends LinkedInBasePage {

    @FindBy(xpath = "//input[@id='login-email']")
    private WebElement userEmailField;
    @FindBy(xpath = "//input[@id='login-password']")
    private WebElement userPasswordField;
    @FindBy(xpath = "//input[@id='login-submit']")
    private WebElement signInButton;
    @FindBy(xpath = "//a[@class='link-forgot-password']")
    private WebElement forgotPasswordButton;

    /**
     * Constructor of LinkedinLoginPage class {
     * @param webDriver - current webDriver object
     */
    public LinkedinLoginPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
        }
//check if page is loaded. return true or false
    @Override
    public boolean isPageLoaded() {
        return signInButton.isDisplayed();
    }



    public LinkedInHomePage login (String userEmail, String userPassword) {
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        signInButton.click();
        return PageFactory.initElements(webDriver, LinkedInHomePage.class);
    }

    public LinkedinLoginSubmitPage loginWithInvalidData (String userEmail, String userPassword) {
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        signInButton.click();
        return new LinkedinLoginSubmitPage(webDriver); //the same as 35 string
    }


    public LinkedinPasswordResetPage clickOnForgotPasswordLink(){
        forgotPasswordButton.click();
        return new LinkedinPasswordResetPage(webDriver);
    }

    public boolean isSignInButtonDisplayed(){
        return signInButton.isDisplayed();
    }

}



