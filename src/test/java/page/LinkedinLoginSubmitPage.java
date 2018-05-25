package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import page.LinkedInBasePage;

public class LinkedinLoginSubmitPage extends LinkedInBasePage {

    private WebElement errorMessageElement;

    public LinkedinLoginSubmitPage (WebDriver webDriver) {
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
