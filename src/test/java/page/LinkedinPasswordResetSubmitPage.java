package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import page.LinkedInBasePage;

public class LinkedinPasswordResetSubmitPage extends LinkedInBasePage {

    WebElement resendButton;

    public LinkedinPasswordResetSubmitPage(WebDriver webDriver) {
        super(webDriver);
        initElements();
    }
    private void initElements() {
        resendButton = webDriver.findElement(By.xpath("//button[@id='resend-ur']"));

    }

    public boolean isPageLoaded() {
        return resendButton.isDisplayed();

    }
}
