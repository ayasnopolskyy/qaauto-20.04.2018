package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import page.LinkedInBasePage;

public class LinkedinPasswordResetPage extends LinkedInBasePage {

    private WebElement userEmailField;
    private WebElement submitButton;


    public LinkedinPasswordResetPage(WebDriver webDriver) {
        super(webDriver);
        initElements();
    }

    @Override
    public boolean isPageLoaded() {
        return userEmailField.isDisplayed();
    }


    private void initElements() {
        userEmailField = webDriver.findElement(By.xpath("//input[@id='username']"));
        submitButton = webDriver.findElement(By.xpath( "//button[@id='reset-password-submit-button']"));
    }


    public void submitEmail (String userEmail) {
        userEmailField.sendKeys(userEmail);
        submitButton.click();
    }


}
