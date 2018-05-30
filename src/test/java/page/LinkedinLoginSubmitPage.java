package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinLoginSubmitPage extends LinkedInBasePage {

    @FindBy(xpath = "//div[@role='alert']")
    private WebElement errorMessageElement;


    public LinkedinLoginSubmitPage (WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);

    }

    @Override
    boolean isPageLoaded() {
        return errorMessageElement.isDisplayed();
    }


    public String getErrorMessageText(){
        return errorMessageElement.getText();
    }

}
