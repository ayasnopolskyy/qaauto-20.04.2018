package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import page.LinkedInBasePage;

public class LinkedinNewPasswordRequestPage extends LinkedInBasePage {


    private WebElement newPasswordField;
    private WebElement confirmPassField;
    private WebElement submitButton;

    public LinkedinNewPasswordRequestPage (WebDriver webDriver) {
        super(webDriver);
        initElements();
    }



    @Override
    public boolean isPageLoaded() {
        return newPasswordField.isDisplayed();
    }


    private void initElements() {
        newPasswordField = webDriver.findElement(By.xpath("//input[@id='newpassword']"));
        confirmPassField = webDriver.findElement(By.xpath( "//button[@id='confirmpassword']"));
        submitButton = webDriver.findElement(By.xpath( "//button[@id='reset-password-submit-button']"));
    }



    public void createNewPassword(String newPass) {
            newPasswordField.sendKeys(newPass);
            confirmPassField.sendKeys(newPass);
            submitButton.click();
    }

}
