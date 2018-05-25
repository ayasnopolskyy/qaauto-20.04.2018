package page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinLoginPage extends LinkedInBasePage {

    @FindBy(xpath = "//input[@id='login-email']")
    private WebElement userEmailField;
    @FindBy(xpath = "//input[@id='login-password']")
    private WebElement userPasswordField;
    @FindBy(xpath = "//input[@id='login-submit']")
    private WebElement signInButton;
    @FindBy(xpath = "//a[@class='link-forgot-password']")
    private WebElement forgetPasswordButton;

    public LinkedinLoginPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
        }

    @Override
    public boolean isPageLoaded() {
        return signInButton.isDisplayed();
    }



    public LinkedInHomePage login (String userEmail, String userPassword) {
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        signInButton.click();
        //return new LinkedInHomePage(webDriver);
        return PageFactory.initElements(webDriver, LinkedInHomePage.class);
    }

    public LinkedinLoginSubmitPage loginWithInvadlidData (String userEmail, String userPassword) {
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        signInButton.click();
        return new LinkedinLoginSubmitPage(webDriver);
    }







    public void forget(){forgetPasswordButton.click();}

    public boolean isSignInButtonDisplayed(){
        return signInButton.isDisplayed();
    }

}





//request-password-reset-submit element (is loaded)  - xpath    h2 class="form__subtitle"
