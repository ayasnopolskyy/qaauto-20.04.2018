import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedinLoginPage extends LinkedInBasePage {

    private WebElement userEmailField;
    private WebElement userPasswordField;
    private WebElement signInButton;
    private WebElement forgetPasswordButton;

    public LinkedinLoginPage(WebDriver webDriver) {
        super(webDriver);
        initElements();
    }

    @Override
    boolean isPageLoaded() {
        return signInButton.isDisplayed();
    }

    private void initElements(){
        userEmailField = webDriver.findElement(By.xpath("//input[@id='login-email']"));
        userPasswordField = webDriver.findElement(By.xpath("//input[@id='login-password']"));
        signInButton = webDriver.findElement(By.xpath("//input[@id='login-submit']"));
        forgetPasswordButton = webDriver.findElement(By.xpath("//a[@class='link-forgot-password']"));
    }

    public void login (String userEmail, String userPassword) {
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        signInButton.click();

    }
    public void forget(){forgetPasswordButton.click();}

    public boolean isSignInButtonDisplayed(){
        return signInButton.isDisplayed();
    }

}





//request-password-reset-submit element (is loaded)  - xpath    h2 class="form__subtitle"
