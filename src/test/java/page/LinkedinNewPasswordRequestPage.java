package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LinkedinNewPasswordRequestPage extends LinkedInBasePage {

    @FindBy(xpath = "//input[@id='newpassword']")
    private WebElement newPasswordField;
    @FindBy(xpath = "//button[@id='confirmpassword']")
    private WebElement confirmPassField;
    @FindBy(xpath = "//button[@id='reset-password-submit-button']")
    private WebElement submitButton;

    public LinkedinNewPasswordRequestPage (WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }



    @Override
    public boolean isPageLoaded() {
        return newPasswordField.isDisplayed();
    }




    public LinkedinPasswordChangedPage createNewPassword(String newPass) {
            newPasswordField.sendKeys(newPass);
            confirmPassField.sendKeys(newPass);
            submitButton.click();
            return new LinkedinPasswordChangedPage(webDriver);
    }

}
