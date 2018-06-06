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
     * Constructor of LinkedinLoginPage class
     * @param webDriver - current webDriver object
     * variables are initialized, but assigns values at the time of the call
     */
    public LinkedinLoginPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
        }

    /**
     * check if page is loaded. returns true or false
     */

    @Override
    public boolean isPageLoaded() {
       // waitUntilElementIsClickable(signInButton, 10);
        return signInButton.isDisplayed();
    }


    /**
     * Method that sends credentials to according field and clicks Login button
     * @param userEmail - variable with user Email
     * @param userPassword- variable with user Pass
     * @return - redirect to Home page after succesfull login
     */
    public LinkedInHomePage login (String userEmail, String userPassword) {
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        signInButton.click();
        return PageFactory.initElements(webDriver, LinkedInHomePage.class);
    }

    /**
     * Method that sends invalid credentials to open Login Submit page
     */
    public LinkedinLoginSubmitPage loginWithInvalidData (String userEmail, String userPassword) {
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        signInButton.click();
        return new LinkedinLoginSubmitPage(webDriver); //the same as 35 string
    }


    /**
     * Method that clicks on Forgot Password link
     * @return redirects to Password reset Page
     */
    public LinkedinPasswordResetPage clickOnForgotPasswordLink(){
        forgotPasswordButton.click();
        return new LinkedinPasswordResetPage(webDriver);
    }

    /**
     * checking that Sign IN Button is displayed
     * @return true or false
     */
    public boolean isSignInButtonDisplayed(){
        return signInButton.isDisplayed();
    }

}



