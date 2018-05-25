import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedinPasswordResetPage extends LinkedInBasePage {

    private WebElement userEmailField;
    private WebElement submitButton;


    public LinkedinPasswordResetPage(WebDriver webDriver) {
        super(webDriver);
        initElements();
    }

    @Override
    boolean isPageLoaded() {
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
