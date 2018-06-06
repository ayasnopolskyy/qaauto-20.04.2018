package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page object for LinkedinLoginSubmit Page
 */
public class LinkedinLoginSubmitPage extends LinkedInBasePage {

    @FindBy(xpath = "//div[@role='alert']")
    private WebElement errorMessageElement;


    /**
     * Constructor for LinledinLoginSubmitPage class
     * @param webDriver - current webDriver object
     *  variables are initialized, but assigns values at the time of the call
     */
    public LinkedinLoginSubmitPage (WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);

    }

    /**
     * checks that page is loaded, by searching errorMessageElement webelement
     * @return true or false
     */
    @Override
    boolean isPageLoaded() {
        waitUntilElementIsClickable(errorMessageElement, 40);
        return errorMessageElement.isDisplayed();
    }


    /**
     * @return gets error text from webelement for assert method
     */
    public String getErrorMessageText(){
        return errorMessageElement.getText();
    }

}
