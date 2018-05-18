import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedinLoginSubmit extends LinkedInBasePage {

    private WebElement errorMessageElement;

    public LinkedinLoginSubmit(WebDriver webDriver) {
        super(webDriver);
        initElements();
    }

    @Override
    boolean isPageLoaded() {
        return errorMessageElement.isDisplayed();
    }

    private void initElements()   {
        errorMessageElement = webDriver.findElement(By.xpath("//div[@role='alert']"));
    }

    public String getErrorMessageText(){
        return errorMessageElement.getText();
    }

}
