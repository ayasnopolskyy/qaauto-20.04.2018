package page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LinkedinPasswordResetPage extends LinkedInBasePage {

    @FindBy(xpath = "//input[@id='username']")
    private WebElement userEmailField;
    @FindBy(xpath = "//button[@id='reset-password-submit-button']")
    private WebElement submitButton;


    public LinkedinPasswordResetPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Override
    public boolean isPageLoaded() {
        return userEmailField.isDisplayed();
    }



    public LinkedinPasswordResetSubmitPage submitEmail (String userEmail) {
        userEmailField.sendKeys(userEmail);
        submitButton.click();
        return new LinkedinPasswordResetSubmitPage(webDriver);
    }


}
